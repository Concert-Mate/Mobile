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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ConcertCard
import ru.nsu.concertmate.ui.components.ConcertInfo
import ru.nsu.concertmate.ui.components.TopBar

@Composable
fun MainScreen() {
    val concerts = remember { mutableStateListOf<Int>() }

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
            TopBar(text = "Главное меню",
                hasRightIcon = true,
                onRightIconPressed = {concerts.add(1)},
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .padding(horizontal = 20.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                items(concerts){ item: Int ->
                    ConcertCard(
                        ConcertInfo("Король и Шут",
                        "Цифровая сказка",
                        "16 января, 20:00",
                        "Новосибирск",
                        1000,
                        false
                    ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
            BottomBar(modifier = Modifier.fillMaxHeight(1f))
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}