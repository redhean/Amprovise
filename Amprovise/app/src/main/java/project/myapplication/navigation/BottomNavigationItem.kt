package project.myapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val route : String, val label : String, val icon : ImageVector) {
    object Home : BottomItem("home", "홈", Icons.Default.Home)
    object Favorites : BottomItem("favorites", "찜", Icons.Default.Favorite)
    object Profile : BottomItem("profile", "마이", Icons.Default.Person)
    object Location : BottomItem("location", "지역", Icons.Default.LocationOn)
    object Neighbor : BottomItem("neighbor", "내주변", Icons.Default.Send)
}