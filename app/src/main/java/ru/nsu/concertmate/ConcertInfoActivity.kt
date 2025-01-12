package ru.nsu.concertmate

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import ru.nsu.concertmate.ui.components.ConcertInfoDto
import ru.nsu.concertmate.ui.screens.ConcertInfoScreen

class ConcertInfoActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val concertInfoDto : ConcertInfoDto? =
            this.intent.getSerializableExtra("dto",  ConcertInfoDto::class.java)
        enableEdgeToEdge()
        setContent {
            if (concertInfoDto != null) {
                ConcertInfoScreen(concertInfoDto, activity = this)
            }
        }
    }
}
