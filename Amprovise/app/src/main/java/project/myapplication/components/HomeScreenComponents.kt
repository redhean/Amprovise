package project.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.distinctUntilChanged
import project.myapplication.R
import project.myapplication.viewModel.ConcertItem
import project.myapplication.viewModel.SpaceItem


@Composable
fun ContentButton(value: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.amp_dial_big),
                contentDescription = ""
            )
            Text(
                text = value,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun AdvertiseBox(image : Painter){
    Box(
        modifier = Modifier
            .height(120.dp)
            .width(350.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .background(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.White
                )
        )
    }
}

@Composable
fun MyNeighborBox(item : SpaceItem, index : Int){
    Box(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                shape = RoundedCornerShape(4.dp),
                color = Color.White
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // 사진과 순서
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .background(
                        shape = RoundedCornerShape(4.dp),
                        color = Color.White
                    ),
            ) {

                // 사진
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.description,
                    modifier = Modifier
                        .background(
                            shape = RoundedCornerShape(4.dp),
                            color = Color.White
                        )
                )

                // 순서
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .background(
                            shape = RoundedCornerShape(8.dp),
                            color = Color.Black
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = index.toString(),
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // 이름과 별점
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Top
                ) {
                    // 이름
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.Black,
                    )

                    // 별점
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "",
                            tint = Color.Yellow
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = item.star.toString(),
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Normal
                            ),
                            color = Color.Black,
                        )
                    }
                }
            }

            // 가격
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 10.dp, bottom = 30.dp),
                contentAlignment = Alignment.BottomEnd
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = item.min_price_per_hour,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.Black
                    )

                    Text(
                        text = "원",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun ConcertBox(
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit,
    item : ConcertItem
){
    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
    ) {
        Box(
            modifier = Modifier.height(185.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.description,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                IconButton(onClick = {
                    onTabFavorite(!isFavorite)
                }) {
                    Icon(
                        imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

