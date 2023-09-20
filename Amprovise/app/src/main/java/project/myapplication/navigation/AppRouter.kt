package project.myapplication.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(){

    object IntroScreen : Screen()
    object LoginScreen : Screen()
    object SignUpScreen : Screen()
    object TempScreen : Screen()
    object MainScreen : Screen()
    object HomeScreen : Screen()
    object LocationScreen : Screen()
    object FavoriteScreen : Screen()
    object ProfileScreen : Screen()
}

object AppRouter {
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.IntroScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }
}