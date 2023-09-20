package project.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import project.myapplication.components.TopBar
import project.myapplication.navigation.Screen
import project.myapplication.viewModel.HomeViewModel


@Composable
fun FavoriteScreen(homeViewModel: HomeViewModel = viewModel()){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(homeViewModel.concertItemsList)
    }
}