package project.myapplication.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import project.myapplication.R
import project.myapplication.components.*
import project.myapplication.viewModel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()){

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            // 공간 종류
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ContentButton(value = "공연장", onClick = {

                    })

                    Spacer(modifier = Modifier.width(8.dp))

                    ContentButton(value = "작업실", onClick = {

                    })
                    Spacer(modifier = Modifier.width(8.dp))

                    ContentButton(value = "연습실", onClick = {

                    })
                }
            }

            // 광고
            item{
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    item{
                        homeViewModel.advertisementItemsList.forEach{item ->
                            AdvertiseBox(image = painterResource(id = item.image))
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                    }
                }
            }

            item{Spacer(modifier = Modifier.height(16.dp))}

            // 예정된 콘서트
            item{
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp),
                    text = stringResource(id = R.string.concert),
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.Black
                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    item{

                        homeViewModel.concertItemsList.forEach{item ->
                            var isFavorite by rememberSaveable {
                                mutableStateOf(false)
                            }
                            ConcertBox(isFavorite = isFavorite,
                                onTabFavorite = {
                                    favorite ->
                                    isFavorite = favorite
                                    item.isFavorite = !item.isFavorite
                                    Log.i("test", item.isFavorite.toString())
                            },
                                item = item
                            )
                        }
                    }
                }
            }

            item{Spacer(modifier = Modifier.height(16.dp))}

            // 지금 내 주변은
            item{
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp),
                    text = stringResource(id = R.string.my_neighbor),
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.Black
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, bottom = 8.dp),
                    text = stringResource(id = R.string.star_rank),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.Black
                )

                homeViewModel.spaceItemsList.forEachIndexed {index, item ->
                    MyNeighborBox(item = item, index = index + 1 )
                }
            }
        }
    }
}