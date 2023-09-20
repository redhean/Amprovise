package project.myapplication.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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

@Composable
fun LoginScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            // 상단 로고
            HeadingTextComponentWithLogo(
                image = painterResource(id = R.drawable.amprovise_logo_off2),
                value = stringResource(id = R.string.amprovise),
            )

            Spacer(modifier = Modifier.height(40.dp))

            var id = ""
            var password = ""
            var stay_login = false

            // ID
            TextFieldComponent(labelValue = stringResource(id = R.string.id) , image = Icons.Default.Person) { newValue ->
                id = newValue
            }

            // Password
            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), image = Icons.Default.Lock) { newValue ->
                password = newValue
            }

            // 로그인 유지
            CheckboxComponent(value = stringResource(id = R.string.stay_signed_in)) { newValue ->
                stay_login = newValue
            }

            // 로그인 버튼
            ButtonComponent(value = stringResource(id = R.string.login), onClick = {
                if(id == "redhean" && password =="1234"){
                    AppRouter.navigateTo(Screen.MainScreen)
                }
            })

            Spacer(modifier = Modifier.height(16.dp))

            // 비밀번호 찾기 | 아이디 찾기 | 회원가입
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                ClickableTextComponent(value = stringResource(id = R.string.find_password), onTextSelected ={
                    AppRouter.navigateTo(Screen.TempScreen)
                })
                Text(text = "   |   ", color = Color.DarkGray)
                ClickableTextComponent(value = stringResource(id = R.string.find_ID), onTextSelected ={
                    AppRouter.navigateTo(Screen.TempScreen)
                })
                Text(text = "   |   ", color = Color.DarkGray)
                ClickableTextComponent(value = stringResource(id = R.string.register), onTextSelected ={
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }
    }
}