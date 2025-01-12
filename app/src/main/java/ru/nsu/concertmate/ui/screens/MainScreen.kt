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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ConcertCardColumn
import ru.nsu.concertmate.ui.components.TopBar




@Composable
fun MainScreen(activity: Activity?) {
    val concerts = remember { mutableStateListOf<Int>() }

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
                text = "Главное меню", activity,
                hasRightIcon = true,
                onRightIconPressed = {/* todo make request*/ },
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            ConcertCardColumn(
                concerts,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
            )
            BottomBar(
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
fun MainScreenPreview() {
    MainScreen(null)
}