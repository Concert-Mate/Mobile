package ru.nsu.concertmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.nsu.concertmate.ui.screens.FavoriteCitiesScreen

class FavoriteCitiesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FavoriteCitiesScreen(activity = this)
        }
    }
}