package ru.nsu.concertmate.ui.components

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ConcertCardColumn(activity: Activity?, concerts: SnapshotStateList<Int>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF60A2F2), Color(0xFF375D8C)),
                    start = Offset(Float.POSITIVE_INFINITY, 0F),
                    end = Offset.Infinite
                )
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(concerts) { item: Int ->
                ConcertCard(activity,
                    exampleConcertInfoDto,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ConcertCardColumnPreview() {
    ConcertCardColumn(null, SnapshotStateList())
}