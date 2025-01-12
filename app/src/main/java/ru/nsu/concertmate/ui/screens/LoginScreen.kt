package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.nsu.concertmate.CodeLoginActivity
import ru.nsu.concertmate.MainWindowActivity
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.components.DefaultTextViewModifier
import ru.nsu.concertmate.ui.components.TextFieldView
import ru.nsu.concertmate.ui.theme.FontMontserrat
import ru.nsu.concertmate.ui.theme.FontRobotoSlab

@Composable
fun LoginScreen(activity: Activity?, isCodeEnter: Boolean) {
    val buttonText = if (isCodeEnter) "Подтвердить" else "Вход"
    val inputFieldText = if (isCodeEnter) "Введите код подтверждения" else "Введите E-mail"
    val inputKeyboardType = if (isCodeEnter) KeyboardType.Number else KeyboardType.Email
    val systemUiController = rememberSystemUiController()
    val codeFieldText = remember { mutableStateOf("") }
    systemUiController.setSystemBarsColor(Color.Green)
    systemUiController.setNavigationBarColor(Color.Yellow)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFF8E5E5), Color(0xFFFCAEAE)),
                        start = Offset(Float.POSITIVE_INFINITY, 0F),
                        end = Offset.Infinite,
                    )
                )
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.mipmap.logo_image_foreground),
                        "logo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .align(Alignment.CenterHorizontally)

                    )

                }
                Text(
                    "Concert Mate",
                    color = Color(0xFF000000),
                    fontSize = 40.sp,
                    fontFamily = FontMontserrat,
                    modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .padding(bottom = 10.dp)
                )
            }
            Text(
                "Вход",
                color = Color(0xFF000000),
                fontSize = 32.sp,
                fontFamily = FontRobotoSlab,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(vertical = 20.dp)

            )
            TextFieldView(
                codeFieldText.value,
                placeholder = inputFieldText,
                onValueChange = { newText -> codeFieldText.value = newText },
                keyboardType = inputKeyboardType,
                modifier = DefaultTextViewModifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.85f)
                    .height(35.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {
                    if (!isCodeEnter) {
                        val intent = Intent(activity, CodeLoginActivity::class.java)
                        activity?.startActivity(intent)
                    } else {
                        val intent = Intent(activity, MainWindowActivity::class.java)
                        activity?.startActivity(intent)
                    }
                    activity?.finish()
                },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.65f)
                    .background(
                        color = Color(0xFFFFE7E7),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .height(40.dp)
            ) {
                Text(
                    buttonText,
                    color = Color(0xFF1E1E1E),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(null, true)
}