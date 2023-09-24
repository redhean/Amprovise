package project.myapplication.components

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun LocationApp() {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }
    var locationText by remember { mutableStateOf("Fetching location...") }
    var googleMap: GoogleMap? by remember { mutableStateOf(null) }

    val permissionGranted = ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    var currentLatLng = LatLng(37.5665, 126.9780) // 서울
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(currentLatLng, 15f)
    }

    // 권한이 있으면 위치 정보 가져오기
    if (permissionGranted) {
        LaunchedEffect(Unit) {
            locationText = fetchLocation(fusedLocationClient, context)
            val parts = locationText.split(",")
            if (parts.size >= 2) {
                val latitude = parts[0].toDoubleOrNull()
                val longitude = parts[1].toDoubleOrNull()

                Log.i("test", latitude.toString())
                Log.i("test", longitude.toString())

                if (latitude != null && longitude != null) {
                    currentLatLng = LatLng(latitude, longitude)
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(currentLatLng, 15f)
                }
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                if (permissionGranted) {
                    GoogleMap(
                      modifier = Modifier
                          .fillMaxSize()
                          .padding(innerPadding),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = MarkerState(position = currentLatLng)
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Location Permission Required")
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                scope.launch {
                                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                                    requestLocationPermission(context)
                                }
                            }
                        ) {
                            Text("Request Permission")
                        }
                    }
                }
            }
        }
    )
}

suspend fun fetchLocation(client: FusedLocationProviderClient, context: android.content.Context): String {
    return withContext(Dispatchers.IO) {
        // 권한 확인
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return@withContext "Location permission not granted"
        }

        try {
            val locationTask: Task<Location> = client.lastLocation
            val location: android.location.Location? = Tasks.await(locationTask)

            if (location != null) {
                "${location.latitude},${location.longitude}"
            } else {
                "Location data not available"
            }
        } catch (e: Exception) {
            "Error fetching location"
        }
    }
}

fun requestLocationPermission(context: android.content.Context) {
    ActivityCompat.requestPermissions(
        context as android.app.Activity,
        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
        123 // 요청 코드, 필요에 따라 변경
    )
}

