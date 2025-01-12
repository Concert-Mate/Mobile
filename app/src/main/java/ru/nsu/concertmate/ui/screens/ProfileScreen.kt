package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.FavoriteConcertsActivity
import ru.nsu.concertmate.MainWindowActivity
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ProfileColumn
import ru.nsu.concertmate.ui.components.TopBar
import ru.nsu.concertmate.ui.theme.FontRubik


@Composable
fun ButtonWithText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(8.dp)
            )
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                color = Color(0xFF1E1E1E),
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontRubik
            )
        }

    }
}


@Composable
fun ProfileScreen(activity: Activity?) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    )
    { innerPadding ->
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFB1BFCF), Color(0xFF596069)),
                        start = Offset(Float.POSITIVE_INFINITY, 0F),
                        end = Offset.Infinite,
                    )
                )
        ) {
            TopBar(
                text = "Профиль",
                activity = activity,
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            ProfileColumn(
                activity = activity,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            )
            BottomBar(
                onMidIconPressed = {
                    val intent = Intent(activity, MainWindowActivity::class.java)
                    activity?.startActivity(intent)
                },
                onRightIconPressed = {
                    val intent = Intent(activity, FavoriteConcertsActivity::class.java)
                    activity?.startActivity(intent)
                },
                modifier = Modifier.fillMaxHeight(1f)
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(null)
}