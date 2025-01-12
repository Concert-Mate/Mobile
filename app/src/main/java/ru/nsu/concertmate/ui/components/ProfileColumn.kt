package ru.nsu.concertmate.ui.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.nsu.concertmate.FAQActivity
import ru.nsu.concertmate.FavoriteCitiesActivity
import ru.nsu.concertmate.FavoriteTrackListsActivity
import ru.nsu.concertmate.MainActivity
import ru.nsu.concertmate.ui.screens.ButtonWithText

@Composable
fun ProfileColumn(activity: Activity?, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFB1BFCF), Color(0xFF596069)),
                    start = Offset(Float.POSITIVE_INFINITY, 0F),
                    end = Offset.Infinite,
                )
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(start = 6.dp, end = 6.dp, top = 16.dp)
        ) {
            ButtonWithText(text = "Избранные города", onClick = {
                val intent = Intent(activity, FavoriteCitiesActivity::class.java)
                activity?.startActivity(intent)
            })
            ButtonWithText(text = "Избранные треклисты", onClick = {
                val intent = Intent(activity, FavoriteTrackListsActivity::class.java)
                activity?.startActivity(intent)
            })
            ButtonWithText(text = "Часто задаваемые вопросы", onClick = {
                val intent = Intent(activity, FAQActivity::class.java)
                activity?.startActivity(intent)
            })
            ButtonWithText(text = "Выйти из аккаунта", onClick = {
                val intent = Intent(activity, MainActivity::class.java)
                activity?.startActivity(intent)
                activity?.finish()
            })
        }
    }
}