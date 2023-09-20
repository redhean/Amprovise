package project.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.myapplication.R


@Composable
fun MyProfile(){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(80.dp),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.White
                ),
        ){
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .weight(0.2f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "redhean",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                    ),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                  verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "내 정보 관리",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                        ),
                        color = Color.Black
                    )

                    Icon(
                        imageVector = Icons.Default.ArrowForwardIos,
                        contentDescription = "",
                        modifier = Modifier
                            .size(15.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, Color.Blue, RoundedCornerShape(4.dp))
                        .padding(8.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Text(
                        text = "My 혜택",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        color = Color.Blue,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.width(32.dp))
        }
    }
}

@Composable
fun ProfileComponent(image : Painter, value : String, modifier : Modifier, float : Float){
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.White
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp)
                    .weight(float)
                    .heightIn(min = 25.dp),
            )

            Text(
                text = value,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = Color.Black,
                modifier = Modifier
                    .weight(0.6f)
            )

            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "",
                modifier = Modifier
                    .size(15.dp)
                    .weight(float)
            )
        }
    }
}

@Composable
fun ProfileComponent2(value : String, modifier: Modifier, float: Float){
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(
                    shape = RoundedCornerShape(4.dp),
                    color = Color.White
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = value,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = Color.Black,
                modifier = Modifier
                    .weight(0.8f)
            )

            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "",
                modifier = Modifier
                    .size(15.dp)
                    .weight(float)
            )
        }
    }
}

@Composable
fun DivideComponent(){
    Box(
        modifier = Modifier
            .height(90.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(4.dp),
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.amprovise_logo_off_final),
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
