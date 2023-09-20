package project.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import project.myapplication.components.BigLocationBox
import project.myapplication.components.LocationList
import project.myapplication.components.SmallLocationBox
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen
import project.myapplication.ui.theme.LightGray
import project.myapplication.viewModel.HomeViewModel


@Composable
fun LocationScreen(homeViewModel: HomeViewModel = viewModel()){


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        LocationList(locationItemList = homeViewModel.LocationItemList)
    }
}