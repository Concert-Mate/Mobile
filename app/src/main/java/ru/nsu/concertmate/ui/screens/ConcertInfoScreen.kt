package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.nsu.concertmate.MainActivity
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ConcertInfoColumn
import ru.nsu.concertmate.ui.components.ConcertInfoDto
import ru.nsu.concertmate.ui.components.TopBar
import ru.nsu.concertmate.ui.components.exampleConcertInfoDto

@Composable
fun ConcertInfoScreen(concertInfoDto: ConcertInfoDto, activity: Activity?) {

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
                        colors = listOf(Color(0xFF60A2F2), Color(0xFF375D8C)),
                        start = Offset(Float.POSITIVE_INFINITY, 0F),
                        end = Offset.Infinite,
                    )
                )
        ) {
            TopBar(
                text = "О концерте",
                activity = activity,
                hasLeftIcon = true,
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            ConcertInfoColumn(
                concertInfo = concertInfoDto,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth()
            )
            BottomBar(
                onMidIconPressed = {
                    val intent = Intent(activity, MainActivity::class.java)
                    activity?.startActivity(intent)
                },
                onLeftIconPressed = {
                    val intent = Intent(activity, ProfileActivity::class.java)
                    activity?.startActivity(intent)
                },
                modifier = Modifier.fillMaxHeight(1f)
            )
        }
    }
}

@Preview
@Composable
fun ConcertInfoScreenPreview() {
    ConcertInfoScreen(exampleConcertInfoDto, null)
}