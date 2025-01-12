package ru.nsu.concertmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.nsu.concertmate.ui.screens.LoginScreen

class CodeLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email = this.intent.getStringExtra("email")
        enableEdgeToEdge()
        setContent {
            if (email != null) {
                LoginScreen(email,this, isCodeEnter = true)
            }
        }
    }
}