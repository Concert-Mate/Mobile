package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.nsu.concertmate.MainActivity
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.FavoriteCitiesColumn
import ru.nsu.concertmate.ui.components.TopBar


@Composable
fun FavoriteCitiesScreen(activity: Activity?) {

    val cities = remember { mutableStateListOf<String>() }

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
        ) {
            TopBar(
                text = "Избранные города",
                activity = activity,
                hasLeftIcon = true,
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            FavoriteCitiesColumn(
                cities,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(),
                activity
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
fun FavoriteCitiesScreenPreview() {
    FavoriteCitiesScreen(null)
}