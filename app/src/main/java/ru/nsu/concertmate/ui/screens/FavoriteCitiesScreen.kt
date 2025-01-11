package ru.nsu.concertmate.ui.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.approachLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.components.BottomBar
import ru.nsu.concertmate.ui.components.DefaultTextViewModifier
import ru.nsu.concertmate.ui.components.TextFieldViewWithIcon
import ru.nsu.concertmate.ui.components.TopBar
import ru.nsu.concertmate.ui.theme.FontRubik

@Composable
fun TextWithIcon(text: String,
                   onClick: () -> Unit,
                   modifier: Modifier = Modifier){


    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(8.dp)
            )
            .height(40.dp)

    ) {
        Text(
            text,
            color = Color(0xFF1E1E1E),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontRubik,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .width(25.dp)
                .height(30.dp)
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        ){
            Image(
                painter = painterResource(id = R.mipmap.trash_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Composable
fun FavoriteCitiesScreen(){

    val cities = remember { mutableStateListOf<String>() }
    val city = remember { mutableStateOf("") }

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
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF5DC199), Color(0xFF2C5B48)),
                        start = Offset(Float.POSITIVE_INFINITY, 0F),
                        end = Offset.Infinite,
                    )
                )
        ) {
            TopBar(text = "Избранные города",
                hasLeftIcon = true,
                onLeftIconPressed = {},
                modifier = Modifier.fillMaxHeight(0.065f)
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .padding(start = 6.dp, end = 6.dp, top = 16.dp)
            ) {
                item{
                    TextFieldViewWithIcon(value = city.value,
                        placeholder = "Введите название города",
                        onClick = {cities.add(city.value)},
                        onValueChange = {str -> city.value = str},
                        modifier = DefaultTextViewModifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 10.dp)
                            .fillMaxWidth()
                            .height(36.dp)
                    )
                }
                item{
                    Spacer(modifier = Modifier.height(48.dp))
                }
                items(cities){ str ->
                    TextWithIcon(text = str, onClick = {cities.remove(str)})
                }

            }
            BottomBar(modifier = Modifier.fillMaxHeight(1f))
        }
    }
}

@Preview
@Composable
fun FavoriteCitiesScreenPreview(){
    FavoriteCitiesScreen()
}