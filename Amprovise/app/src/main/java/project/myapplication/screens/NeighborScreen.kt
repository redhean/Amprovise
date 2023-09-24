package project.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import project.myapplication.components.LocationApp
import project.myapplication.viewModel.HomeViewModel


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NeighborScreen(homeViewModel: HomeViewModel = viewModel()) {
    LocationApp()
}
