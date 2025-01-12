package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
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
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import ru.nsu.concertmate.App
import ru.nsu.concertmate.CodeLoginActivity
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ConcertCard
import ru.nsu.concertmate.ui.components.ConcertCardColumn
import ru.nsu.concertmate.ui.components.ConcertInfoColumn
import ru.nsu.concertmate.ui.components.TopBar
import ru.nsu.concertmate.ui.components.exampleConcertInfoDto


enum class MainScreenState{
    MAIN,
    PROFILE,
    //todo
    //FAVORITE_CONCERTS,
}


@Composable
fun MainScreen(activity: Activity?) {
    val concerts = remember { mutableStateListOf<Int>() }
    val state = remember {
        mutableStateOf(MainScreenState.MAIN)
    }

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
            TopBar(text = "Главное меню", activity,
                hasRightIcon = true,
                onRightIconPressed = {/* todo make request*/},
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            ConcertCardColumn(concerts,
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
fun MainScreenPreview(){
    MainScreen(null)
}