package ru.nsu.concertmate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ConcertInfo
import ru.nsu.concertmate.ui.components.TopBar
import ru.nsu.concertmate.ui.components.exampleConcertInfoDto

@Composable
fun ConcertInfoScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    )
    { innerPadding ->
        Column (
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
            TopBar(text = "О концерте",
                hasLeftIcon = true,
                onLeftIconPressed = {},
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            Column(modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxHeight(0.9f)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                ConcertInfo(
                    concertInfo = exampleConcertInfoDto,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            BottomBar(modifier = Modifier.fillMaxHeight(1f))
        }
    }
}

@Preview
@Composable
fun ConcertInfoScreenPreview(){
    ConcertInfoScreen()
}