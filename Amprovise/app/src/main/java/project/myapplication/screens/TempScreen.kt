package project.myapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen
import project.myapplication.navigation.SystemBackButtonHandler

@Composable
fun TempScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Temp Screen",
            textAlign = TextAlign.Center
        )
    }


    // Navigation과 함께 사용할 경우 충돌이 일어날 수 있으니 주의
    /*SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.LoginScreen)
    }*/
}