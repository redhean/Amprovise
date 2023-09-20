package project.myapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import project.myapplication.R
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.BottomItem
import project.myapplication.navigation.Screen
import project.myapplication.ui.theme.LightGray
import project.myapplication.viewModel.NavigationItem

@Composable
fun AppToolbar(navigationIconClicked : () -> Unit) {
    val scrollState = rememberScrollState()

    TopAppBar(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = AppBarDefaults.TopAppBarElevation,
        modifier = Modifier
            .padding(bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            IconButton(onClick = {
                navigationIconClicked.invoke()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }

            SearchBox()

            Spacer(modifier = Modifier.width(14.dp))

            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )

            Spacer(modifier = Modifier.width(14.dp))

        }
    }
}

@Composable
fun AppToolbar2(value : String, imageVector: ImageVector) {
    val scrollState = rememberScrollState()

    TopAppBar(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = AppBarDefaults.TopAppBarElevation,
        modifier = Modifier
            .padding(bottom = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = value,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                ),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = imageVector,
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp),
                tint = Color.Black
            )
        }
    }
}



@Composable
fun NavigationDrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(97.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ){
                HeadingTextComponentWithLogo(
                    image = painterResource(id = R.drawable.amprovise_logo_off3),
                    value = stringResource(id = R.string.amprovise)
                )
            }
            Divider(modifier = Modifier
                .fillMaxWidth(),
                color = Color.Black,
                thickness = 1.dp
            )
        }

    }
}

@Composable
fun NavigationDrawerBody(navigationDrawerItems : List<NavigationItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(navigationDrawerItems){
            NavigationItemRow(item = it, onItemClick = {
                if(it.title == "마이페이지") {
                    //AppRouter.navigateTo(Screen.ProfileScreen)
                }
                else if(it.title == "내 예약") {
                    //AppRouter.navigateTo(Screen.TempScreen)
                }
                else if(it.title == "찜 목록") {
                    //AppRouter.navigateTo(Screen.FavoriteScreen)
                }
                else if(it.title == "환경설정") {
                    //AppRouter.navigateTo(Screen.TempScreen)
                }
            })
        }
    }
}

@Composable
fun NavigationItemRow(item : NavigationItem, onItemClick : () -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = onItemClick)
        .padding(all = 16.dp)
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.description
        )

        Spacer(modifier = Modifier.width(20.dp))
        NormalTextComponentNoCenter(value = item.title, color = Color.Black)
    }

    Divider(modifier = Modifier
        .fillMaxWidth(),
        color = Color.Black,
        thickness = 1.dp
    )
}

@Composable
fun BottomNavigationbar(navController : NavHostController) {
    val items = listOf(
        BottomItem.Location,
        BottomItem.Neighbor,
        BottomItem.Home,
        BottomItem.Favorites,
        BottomItem.Profile
    )

    BottomNavigation(
        modifier = Modifier
            .navigationBarsPadding(),
        backgroundColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                            val iconColor = if (currentRoute == screen.route) {
                                Color.Red
                            } else {
                                Color.Black
                            }
                            Icon(imageVector = screen.icon, contentDescription = null, tint = iconColor)
                       },
                label = {
                            val iconColor = if (currentRoute == screen.route) {
                                Color.Red
                            } else {
                                Color.Black
                            }
                            Text(text = screen.label, color = iconColor)
                        },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun SearchBox(){
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(40.dp)
            .background(
                shape = RoundedCornerShape(20.dp),
                color = Color.White
            )
            .border(1.dp, Color.Gray, RoundedCornerShape(20.dp))
            .clickable {
                //AppRouter.navigateTo(Screen.TempScreen)
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(color = Color.White)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "앰프를 켜 볼까요?",
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
            )

            Spacer(modifier = Modifier.width(130.dp))

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription =  "",
                modifier = Modifier
                    .size(30.dp),
                tint = Color.Black
            )

        }
    }
}

@Preview
@Composable
fun SearchBoxPreview(){
    SearchBox()
}
