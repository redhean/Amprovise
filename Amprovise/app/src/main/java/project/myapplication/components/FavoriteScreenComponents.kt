package project.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import project.myapplication.viewModel.ConcertItem
import project.myapplication.R


@Composable
fun TopBar(list : List<ConcertItem>){
    var selectedFavorite by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = "공연",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = if(selectedFavorite == 0)FontWeight.Bold else FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = if(selectedFavorite == 0)Color.Black else Color.Gray,
                modifier = Modifier
                    .clickable(onClick = {
                        selectedFavorite = 0
                    })
                    .weight(0.5f),
                textAlign = TextAlign.Center
            )

            Text(
                text = "공간",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = if(selectedFavorite == 1)FontWeight.Bold else FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = if(selectedFavorite == 1)Color.Black else Color.Gray,
                modifier = Modifier
                    .clickable(onClick = {
                        selectedFavorite = 1
                    })
                    .weight(0.5f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Divider(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
                color = if(selectedFavorite == 0)Color.Black else Color.Gray,
                thickness = if(selectedFavorite == 0) 3.dp else 1.dp
            )

            Divider(modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
                color = if(selectedFavorite == 1)Color.Black else Color.Gray,
                thickness = if(selectedFavorite == 1) 3.dp else 1.dp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if(selectedFavorite == 0)
            ConcertList(list = list)
        else
            EmptyCase()
    }
}

@Composable
fun FavoriteConcertBox(item: ConcertItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Image(painterResource(id = item.image), contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(110.dp))
                ButtonComponent(value = stringResource(id = R.string.reserve)) {
                    /*TODO*/
                }
            }
        }
    }
}


@Composable
fun ConcertList(list : List<ConcertItem>){
    
    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    ) {
        item{
            list.forEach {item ->
                if(item.isFavorite){
                    FavoriteConcertBox(item = item)
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

@Composable
fun EmptyCase(){
    Box(
      modifier = Modifier
          .fillMaxSize()
          .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painterResource(id = R.drawable.heart), contentDescription = "")
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "찜한 상품이 없습니다.",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}