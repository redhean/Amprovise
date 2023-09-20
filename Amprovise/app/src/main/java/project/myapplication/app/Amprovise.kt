package project.myapplication.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen
import project.myapplication.screens.*


@Composable
fun Amprovise(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when(currentState.value){
                is Screen.IntroScreen -> {
                    IntroScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TempScreen -> {
                    TempScreen()
                }
                is Screen.MainScreen -> {
                    MainScreen()
                }
                is Screen.HomeScreen -> {
                    HomeScreen()
                }
                is Screen.LocationScreen -> {
                    LocationScreen()
                }
                is Screen.FavoriteScreen -> {
                    FavoriteScreen()
                }
                is Screen.ProfileScreen -> {
                    ProfileScreen()
                }
            }

        }
    }
}