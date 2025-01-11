package ru.nsu.concertmate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.theme.FontRubik

val DefaultTextViewModifier = Modifier
    .clip(shape = RoundedCornerShape(8.dp))
    .background(
        color = Color.White,
        shape = RoundedCornerShape(8.dp)
    )

val DefaultTextViewTextStyle = TextStyle(
    color = Color(0xFFB3B3B3),
    fontSize = 16.sp,
    fontFamily = FontRubik
)

@Composable
fun TextFieldView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    placeholder: String = "placeholder",
    textStyle: TextStyle = DefaultTextViewTextStyle
) {
    BasicTextField(
        singleLine = true,
        decorationBox = {
            Box(Modifier
                .fillMaxWidth()
                .zIndex(-1f)
            )
            {
                Text(text = value.ifEmpty { placeholder },
                    color = Color.Gray,
                    fontSize = textStyle.fontSize,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier
    )
}


@Composable
fun TextFieldViewWithIcon(
    value: String,
    onClick: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    placeholder: String = "placeholder",
    textStyle: TextStyle = DefaultTextViewTextStyle
) {
    BasicTextField(
        singleLine = true,
        decorationBox = {
            Box(Modifier
                .fillMaxWidth()
                .zIndex(-1f)
            )
            {
                Text(text = value.ifEmpty { placeholder },
                    color = Color.Gray,
                    fontSize = textStyle.fontSize,
                    modifier = Modifier.align(Alignment.CenterStart)
                        .padding(start = 10.dp)
                )
                IconButton(
                    onClick = onClick,
                    modifier = Modifier
                        .width(25.dp)
                        .height(30.dp)
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp)
                ){
                    Image(
                        painter = painterResource(id = R.mipmap.check_icon_foreground),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        },
        value = value,
        onValueChange = onValueChange,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = modifier
    )
}

@Preview()
@Composable
fun TextFieldPreview() {
    TextFieldView("text",
        onValueChange = { str -> println(str) },
        modifier = DefaultTextViewModifier,
        textStyle = DefaultTextViewTextStyle,
    )
}

@Preview()
@Composable
fun TextFieldWishIconPreview() {
    TextFieldViewWithIcon("text",
        onValueChange = { str -> println(str) },
        onClick = {},
        modifier = DefaultTextViewModifier,
        textStyle = DefaultTextViewTextStyle,
    )
}