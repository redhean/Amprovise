package project.myapplication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.SolidColor
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen
import project.myapplication.ui.theme.LightGray


@Composable
fun BigLocationBox(value : String, isSelected : Boolean, onClick : () -> Unit) {

    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .border(1.dp, if (!isSelected) Color.LightGray else Color.White)
            .background(if (!isSelected) LightGray else Color.White)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = value,
            style = TextStyle(
              fontSize = 15.sp,
              fontWeight = if(!isSelected) FontWeight.Normal else FontWeight.Bold,
              fontStyle =  FontStyle.Normal
            ),
            color = Color.Black
        )
    }
}

@Composable
fun SmallLocationBox(value : String, onClick: () -> Unit) {

    Box(
      modifier = Modifier
          .heightIn(min = 60.dp, max = 80.dp)
          .fillMaxWidth()
          .background(Color.White)
          .clickable(onClick = onClick)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = value,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun LocationList(locationItemList : List<List<String>>){
    var selectedLocationIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn(
            modifier = Modifier.weight(0.3f)
        ) {
            items(locationItemList.size) { index ->
                val value = locationItemList[index][0]
                val isSelected = (index == selectedLocationIndex)

                BigLocationBox(
                    value = value,
                    onClick = {
                        selectedLocationIndex = index
                    },
                    isSelected = isSelected
                )
            }
        }

        LazyColumn(
            modifier = Modifier.weight(0.7f)
        ) {
            item{
                for (i in 1 until locationItemList[selectedLocationIndex].size) {
                    SmallLocationBox(value = locationItemList[selectedLocationIndex][i]) {
                        //AppRouter.navigateTo(Screen.TempScreen)
                    }

                    Divider(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(4.dp),
                        color = LightGray,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}

