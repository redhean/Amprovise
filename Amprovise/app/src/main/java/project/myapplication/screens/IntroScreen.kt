package project.myapplication.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import kotlinx.coroutines.delay
import project.myapplication.Activity.MainActivity
import project.myapplication.R
import project.myapplication.components.IntroScreenComponent
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen

@Composable
fun IntroScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        IntroScreenComponent(painterResource(id = R.drawable.amprovise_logo_off))

        LaunchedEffect(key1 = Unit) {
            delay(2000)
            AppRouter.navigateTo(Screen.LoginScreen)
        }
    }
}

