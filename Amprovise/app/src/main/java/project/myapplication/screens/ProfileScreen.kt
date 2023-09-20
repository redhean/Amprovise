package project.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.myapplication.components.*
import project.myapplication.R


@Composable
fun ProfileScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        LazyColumn(
           modifier = Modifier
               .fillMaxSize()
               .background(Color.White)
               .padding(16.dp)
        ) {
            item{
                MyProfile()

                Spacer(modifier = Modifier.height(16.dp))

                ProfileComponent(image = painterResource(id = R.drawable.point), value = "포인트", modifier = Modifier.fillMaxWidth(), 0.1f)
                ProfileComponent(image = painterResource(id = R.drawable.coupon), value = "쿠폰함", modifier = Modifier.fillMaxWidth(), 0.1f)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ProfileComponent(image = painterResource(id = R.drawable.comment), value = "나의 후기", modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f), 0.3f)
                    ProfileComponent(image = painterResource(id = R.drawable.heart_black), value = "찜", modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f), 0.3f)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "예약 내역",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    ),
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(16.dp))

                ProfileComponent2(value = "악기 연습실 / 댄스 연습실 / 보컬 연습실", modifier = Modifier.fillMaxWidth(), 0.1f)
                ProfileComponent2(value = "녹음실 / 작업실", modifier = Modifier.fillMaxWidth(), 0.1f)
                ProfileComponent2(value = "공연장", modifier = Modifier.fillMaxWidth(), 0.1f)

                Spacer(modifier = Modifier.height(8.dp))

                DivideComponent()

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ProfileComponent2(value = "자주 묻는 질문 FAQ", modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f), 0.3f)
                    ProfileComponent2(value = "공지사항", modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f), 0.3f)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ProfileComponent2(value = "Amporvise 정보", modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f), 0.3f)
                    ProfileComponent2(value = "설정", modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f), 0.3f)
                }
            }
        }
    }
}