package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.unit.dp
import ru.nsu.concertmate.MainActivity
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.ui.components.AccordionDataItem
import ru.nsu.concertmate.ui.components.AccordionList
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.TopBar

val accordionsData = listOf(
    AccordionDataItem("Какие стримминговые сервисы поддерживаются?", "На данный момент поддерживается только Яндекс-Музыка"),
    AccordionDataItem("Как связаться с разработчиком?", "Наш E-mail: YourConcertMate@gmail.com"),
    AccordionDataItem("Какие города поддерживаются?", "На данный момент поддерживается только города на территории РФ, численностью населения свыше 10 000 человек"),
    AccordionDataItem("Как поддержать разработчика?", "Мы рады, что вы заинтересовались данной информацией, но мы работаем за идею")
)

@Composable
fun FAQScreen(activity: Activity?) {

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
                text = "Помощь",
                activity = activity,
                hasLeftIcon = true,
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            FAQAccordionsColumns(
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

@Composable
fun FAQAccordionsColumns(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFB1BFCF), Color(0xFF5A6169)),
                    start = Offset(Float.POSITIVE_INFINITY, 0F),
                    end = Offset.Infinite,
                )
            )
    ) {
        AccordionList(
            modifier = Modifier.padding(PaddingValues(8.dp, 16.dp, 8.dp, 16.dp)),
            accordionDataItems = accordionsData
        )
    }
}

@Preview
@Composable
fun FAQScreen() {
    FAQScreen(null)
}