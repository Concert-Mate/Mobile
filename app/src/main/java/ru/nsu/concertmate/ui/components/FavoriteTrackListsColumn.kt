package ru.nsu.concertmate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteTrackListsColumn(trackLists: SnapshotStateList<String>, modifier: Modifier = Modifier) {
    val city = remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFF5DC199), Color(0xFF2C5B48)),
                    start = Offset(Float.POSITIVE_INFINITY, 0F),
                    end = Offset.Infinite,
                )
            )
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(start = 6.dp, end = 6.dp, top = 16.dp)
        ) {
            item {
                TextFieldViewWithIcon(
                    value = city.value,
                    placeholder = "Введите ссылку на треклист",
                    onClick = { trackLists.add(city.value) },
                    keyboardType = KeyboardType.Text,
                    onValueChange = { str -> city.value = str },
                    modifier = DefaultTextViewModifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 10.dp)
                        .fillMaxWidth()
                        .height(36.dp)
                )
            }
            item {
                Spacer(modifier = Modifier.height(48.dp))
            }
            items(trackLists) { str ->
                TextWithIcon(text = str, onClick = { trackLists.remove(str) })
            }

        }
    }

}