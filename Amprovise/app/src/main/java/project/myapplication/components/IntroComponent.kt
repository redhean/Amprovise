package project.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import project.myapplication.R

@Composable
fun IntroScreenComponent(image : Painter){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(image, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(16.dp))
            NormalTextComponent(value = stringResource(id = R.string.turn_amp))
            HeadingTextComponent(value = stringResource(id = R.string.amprovise))
        }
    }
}

@Preview
@Composable
fun IntroScreenPreview(){
    IntroScreenComponent(painterResource(id = R.drawable.amprovise_logo_off))
}