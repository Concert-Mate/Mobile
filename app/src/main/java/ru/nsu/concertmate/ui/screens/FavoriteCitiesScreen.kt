package ru.nsu.concertmate.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.MainActivity
import ru.nsu.concertmate.ProfileActivity
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.ConcertInfoColumn
import ru.nsu.concertmate.ui.components.DefaultTextViewModifier
import ru.nsu.concertmate.ui.components.FavoriteCitiesColumn
import ru.nsu.concertmate.ui.components.TextFieldViewWithIcon
import ru.nsu.concertmate.ui.components.TopBar
import ru.nsu.concertmate.ui.components.exampleConcertInfoDto
import ru.nsu.concertmate.ui.theme.FontRubik
import kotlin.math.acos


@Composable
fun FavoriteCitiesScreen(activity: Activity?){

    val cities = remember { mutableStateListOf<String>() }

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
            TopBar(text = "Избранные города",
                activity = activity,
                hasLeftIcon = true,
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            FavoriteCitiesColumn(
                cities,
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

@Preview
@Composable
fun FavoriteCitiesScreenPreview(){
    FavoriteCitiesScreen(null)
}