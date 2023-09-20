package project.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import project.myapplication.R
import project.myapplication.components.*
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen
import project.myapplication.navigation.SystemBackButtonHandler


@Composable
fun SignUpScreen(){
    val itemsList = listOf(1, 2)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ){
            item{
                Spacer(modifier = Modifier.height(16.dp))
                // 상단 로고
                HeadingTextComponentWithLogo(
                    image = painterResource(id = R.drawable.amprovise_logo_off2),
                    value = stringResource(id = R.string.amprovise),
                )

                Spacer(modifier = Modifier.height(40.dp))

                var id = ""
                var password = ""
                var email = ""
                var name = ""
                var birth = ""
                var mobile_carrier = ""
                var phone_number = ""
                var terms_and_conditions = false

                // ID
                TextFieldComponent(labelValue = stringResource(id = R.string.id) , image = Icons.Default.Person) { newValue ->
                    id = newValue
                }

                // Password
                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), image = Icons.Default.Lock) { newValue ->
                    password = newValue
                }

                // 이메일
                TextFieldComponent(labelValue = stringResource(id = R.string.email) , image = Icons.Default.Mail) {newValue ->
                    email = newValue
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 이름
                TextFieldComponent(labelValue = stringResource(id = R.string.name) , image = Icons.Default.Person) {newValue ->
                    name = newValue
                }

                // 생년월일
                TextFieldComponent(labelValue = stringResource(id = R.string.birthday) , image = Icons.Default.CalendarMonth) { newValue ->
                    birth = newValue
                }
                
                // 통신사
                val items = listOf("SKT", "KT", "LG U+", "SKT 알뜰폰", "KT 알뜰폰", "LG U+ 알뜰폰")
                ComboBoxComponent(labelValue = stringResource(id = R.string.mobile_carrier), image = Icons.Default.SpeakerPhone, items = items) { newValue ->
                    mobile_carrier = newValue
                }

                // 핸드폰 번호
                TextFieldComponent(labelValue = stringResource(id = R.string.phonenumber) , image = Icons.Default.Phone) {newValue ->
                    phone_number = newValue
                }

                // 약관 동의
                TermsAndConditionsComponent(value = stringResource(id = R.string.terms_and_condition)) {newValue ->
                    terms_and_conditions = newValue
                }

                // 회원가입 버튼
                ButtonComponent(value = stringResource(id = R.string.register), onClick = {
                    AppRouter.navigateTo(Screen.LoginScreen)
                })

                // 구분선
                DividerTextComponent()

                // 다음으로 로그인
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ExtraLoginButton(painterResource(id = R.drawable.google), Color.White)
                    Spacer(modifier = Modifier.width(16.dp))
                    ExtraLoginButton(painterResource(id = R.drawable.facebook), Color.White)
                    Spacer(modifier = Modifier.width(16.dp))
                    ExtraLoginButton(painterResource(id = R.drawable.kakao), Color.Yellow)
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.LoginScreen)
    }
}
