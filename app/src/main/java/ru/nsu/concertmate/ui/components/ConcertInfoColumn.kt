package ru.nsu.concertmate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ConcertInfoColumn(concertInfo: ConcertInfoDto, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF60A2F2), Color(0xFF375D8C)),
                    start = Offset(Float.POSITIVE_INFINITY, 0F),
                    end = Offset.Infinite,
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            ConcertInfo(
                concertInfo = concertInfo,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}