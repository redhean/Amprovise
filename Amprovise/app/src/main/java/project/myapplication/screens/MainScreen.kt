package project.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import project.myapplication.R
import project.myapplication.components.*
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.BottomItem
import project.myapplication.navigation.Screen
import project.myapplication.viewModel.HomeViewModel

@Composable
fun MainScreen(homeViewModel: HomeViewModel = viewModel()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        val currentScreen = remember { mutableStateOf<String>(BottomItem.Home.route) }


        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                when(currentScreen.value){
                    BottomItem.Home.route -> {
                        AppToolbar(
                            navigationIconClicked = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    }

                    BottomItem.Location.route -> {
                        AppToolbar2(stringResource(id = R.string.location), Icons.Default.Search)
                    }

                    BottomItem.Neighbor.route -> {
                        AppToolbar2(stringResource(id = R.string.neighbor), Icons.Default.Search)
                    }

                    BottomItem.Favorites.route -> {
                        AppToolbar2(value = stringResource(id = R.string.favorites), imageVector = Icons.Default.ShoppingCart)
                    }

                    BottomItem.Profile.route -> {
                        AppToolbar2(value = stringResource(id = R.string.profile), imageVector = Icons.Default.ShoppingCart)
                    }
                }
            },
            bottomBar = {
                BottomNavigationbar(navController)
            },
            drawerContent = {
                NavigationDrawerHeader()
                NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList)
            },
            content = { innerPadding ->
                val contentPadding = PaddingValues(0.dp)
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(contentPadding)
                ) {
                    // 하단 바 위의 화면 내용을 구성
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        // 내용 구성
                        NavHost(navController, startDestination = BottomItem.Home.route) {
                            composable(BottomItem.Location.route) {
                                currentScreen.value = BottomItem.Location.route
                                LocationScreen()
                            }
                            composable(BottomItem.Neighbor.route) {
                                currentScreen.value = BottomItem.Neighbor.route
                                NeighborScreen()
                            }
                            composable(BottomItem.Home.route) {
                                currentScreen.value = BottomItem.Home.route
                                HomeScreen()
                            }
                            composable(BottomItem.Favorites.route) {
                                currentScreen.value = BottomItem.Favorites.route
                                FavoriteScreen()
                            }
                            composable(BottomItem.Profile.route) {
                                currentScreen.value = BottomItem.Profile.route
                                ProfileScreen()
                            }
                        }
                    }
                }
            }
        )
    }
}

