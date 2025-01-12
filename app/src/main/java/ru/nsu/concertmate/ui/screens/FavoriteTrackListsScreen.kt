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
import ru.nsu.concertmate.MainActivity
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.FavoriteTrackListsColumn
import ru.nsu.concertmate.ui.components.TopBar

@Composable
fun FavoriteTrackListsScreen(activity: Activity?){

    val trackLists = remember { mutableStateListOf<String>() }

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
        ) {
            TopBar(text = "Избранные треклисты",
                activity = activity,
                hasLeftIcon = true,
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            FavoriteTrackListsColumn(
                trackLists,
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
                modifier = Modifier.fillMaxHeight(1f))
        }
    }
}