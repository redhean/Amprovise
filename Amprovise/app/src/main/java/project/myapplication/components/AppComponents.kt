package project.myapplication.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.myapplication.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import project.myapplication.navigation.AppRouter
import project.myapplication.navigation.Screen
import project.myapplication.ui.theme.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.filled.*



// Default = White
@Composable
fun NormalTextComponent(value : String, color : Color = Color.White){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 20.sp,
            // 글자 두께
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        // color = colorResource(id = R.color.colorText)와 같다
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
fun NormalTextComponentNoCenter(value : String, color : Color = Color.White){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 20.sp,
            // 글자 두께
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        // color = colorResource(id = R.color.colorText)와 같다
        color = color,
    )
}

// Default = White
@Composable
fun HeadingTextComponent(value : String, color : Color = Color.White){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            // 글자 두께
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        // color = colorResource(id = R.color.colorText)와 같다
        color = color,
        textAlign = TextAlign.Center
    )
}


@Composable
fun HeadingTextComponentWithLogo(image : Painter, value : String){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Image(image, contentDescription = "")
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = value,
            style = TextStyle(
                fontSize = 36.sp,
                // 글자 두께
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            // color = colorResource(id = R.color.colorText)와 같다
            color = Color.Black,
        )
    }
}

@Composable
fun TextFieldComponent(labelValue: String, image: ImageVector, onValueChanged : (String) -> Unit){
    val localFocusManager = LocalFocusManager.current

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        /*.border(
            BorderStroke(1.dp, GrayColor),
            shape = RoundedCornerShape(50)
        ),*/
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Red,
            focusedLabelColor = Red,
            cursorColor = Red,
            backgroundColor = White
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onValueChanged(it)
        },
        leadingIcon = {
            Icon(imageVector = image, contentDescription = "")
        }
    )
}

@Composable
fun PasswordTextFieldComponent(labelValue: String, image: ImageVector, onValueChanged: (String) -> Unit){

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Red,
            focusedLabelColor = Red,
            cursorColor = Red,
            backgroundColor = White
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        value = password.value,
        onValueChange = {
            password.value = it
            onValueChanged(it)
        },
        leadingIcon = {
            Icon(imageVector = image, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                // gradle에 icon_extented 적어야 함
                Icons.Filled.Visibility
            } else{
                Icons.Filled.VisibilityOff
            }

            var description = if(passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },

        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun ComboBoxComponent(labelValue: String, image: ImageVector, items : List<String>, onValueChanged: (String) -> Unit) {
    val localFocusManager = LocalFocusManager.current

    val textValue = remember {
        mutableStateOf("")
    }

    val comboBoxVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        /*.border(
            BorderStroke(1.dp, GrayColor),
            shape = RoundedCornerShape(50)
        ),*/
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Red,
            focusedLabelColor = Red,
            cursorColor = Red,
            backgroundColor = White
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        readOnly = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onValueChanged(it)
        },
        leadingIcon = {
            Icon(imageVector = image, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(comboBoxVisible.value){
                // gradle에 icon_extented 적어야 함
                Icons.Filled.ArrowUpward
            } else{
                Icons.Filled.ArrowDownward
            }

            IconButton(onClick = {
                comboBoxVisible.value = !comboBoxVisible.value
            }) {
                Icon(imageVector = iconImage, contentDescription = "")
            }
        }
    )
    DropdownMenu(
        expanded = comboBoxVisible.value,
        onDismissRequest = { comboBoxVisible.value = false },
        modifier = Modifier
            .background(Color.White)
            .border(1.dp, Color.Black)
    ) {
        items.forEach { item ->
            DropdownMenuItem(
                onClick = {
                    textValue.value = item
                    comboBoxVisible.value = false
                },
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(text = item)
            }
        }
    }
}

@Composable
fun CheckboxComponent(value : String, onValueChanged: (Boolean) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checkedState = remember {
            mutableStateOf<Boolean>(false)
        }

        val CheckboxColors = CheckboxDefaults.colors(
            checkedColor = Color.Red,      // 선택된 상태의 색상
            uncheckedColor = Color.Black     // 선택되지 않은 상태의 색상
        )

        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onValueChanged(it)
            },
            colors = CheckboxColors
        )
        Text(
            text = value,
            color = Color.Black
        )
    }
}

@Composable
fun ButtonComponent(value: String, onClick : () -> Unit){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Color.Black, Color.Black)),
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ClickableTextComponent(value : String, onTextSelected : (String) -> Unit){

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.DarkGray)){
            pushStringAnnotation(tag = value, annotation = value)
            append(value)
        }

    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.item}}")

                    if ((span.item == value)) {
                        onTextSelected(span.item)
                    }
                }
        }
    )
}

@Composable
fun DividerTextComponent(){
    Row(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.DarkGray,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = R.string.or),
            fontSize = 16.sp,
            color = Color.Black
        )

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.DarkGray,
            thickness = 1.dp
        )
    }
}

@Composable
fun ExtraLoginButton(image : Painter, backgroundColor : Color){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(60.dp)
            .heightIn(60.dp),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(Color.Transparent)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(60.dp)
                .background(
                    shape = RoundedCornerShape(20.dp),
                    color = backgroundColor
                ),
            contentAlignment = Alignment.Center
        ){
            Image(painter = image, contentDescription = "")
        }
    }
}

@Composable
fun TermsAndConditionsComponent(value : String, onValueChanged: (Boolean) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checkedState = remember {
            mutableStateOf<Boolean>(false)
        }

        val CheckboxColors = CheckboxDefaults.colors(
            checkedColor = Color.Red,      // 선택된 상태의 색상
            uncheckedColor = Color.Black     // 선택되지 않은 상태의 색상
        )

        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onValueChanged(it)
            },
            colors = CheckboxColors
        )
        Text(text = "다음 ")
        ClickableTextComponent(value = value, onTextSelected = {
            AppRouter.navigateTo(Screen.TempScreen)
        } )
        Text(text = "에 동의하십니까?")
    }
}