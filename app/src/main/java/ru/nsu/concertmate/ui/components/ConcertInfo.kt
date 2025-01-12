package ru.nsu.concertmate.ui.components

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.App
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.theme.FontRubik

@Composable
fun ConcertInfo(concertInfo: ConcertInfoDto, modifier: Modifier = Modifier) {

    val isStarred = remember { mutableStateOf(concertInfo.isStarred) }
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 10.dp)
        ) {
            Text(
                concertInfo.groupName,
                color = Color(0xFF1E1E1E),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontRubik,
                modifier = Modifier
            )
            Text(
                concertInfo.title,
                color = Color(0xFF757575),
                fontSize = 16.sp,
                fontFamily = FontRubik,
                modifier = Modifier
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(end = 30.dp)
            ) {
                Text(
                    "${concertInfo.time} в городе ${concertInfo.city} произойдёт гранзиозный концерт исполнителя ${concertInfo.groupName} в ${concertInfo.place}",
                    color = Color(0xFF1E1E1E),
                    fontSize = 16.sp,
                    fontFamily = FontRubik,
                )
                if (concertInfo.address != null)
                    Text(
                        "Не знаешь где это? Не проблема! Концерт пройдёт в ${concertInfo.address}",
                        color = Color(0xFF1E1E1E),
                        fontSize = 16.sp,
                        fontFamily = FontRubik,
                    )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Минимальная стоимость — ${concertInfo.price} ₽",
                color = Color(0xFF1E1E1E),
                fontFamily = FontRubik,
                fontSize = 16.sp,
            )
            Button(
                onClick = {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(concertInfo.buyLink))
                    browserIntent.setFlags(FLAG_ACTIVITY_NEW_TASK)
                    App.context?.startActivity(browserIntent)
                },
                border = BorderStroke(0.dp, Color.Transparent),
                colors = ButtonDefaults.outlinedButtonColors(Color.Transparent),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(
                        color = Color(0xFFF56456),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth(0.9f)
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        "Приобрести билет!",
                        color = Color(0xFFFFFFFF),
                        fontFamily = FontRubik,
                        fontSize = 16.sp,
                        modifier = Modifier
                    )
                }
            }
        }
        IconButton(
            onClick = { isStarred.value = !isStarred.value },
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            LazyColumn {
                item(isStarred) {

                    if (isStarred.value)
                        Image(
                            painter = painterResource(id = R.mipmap.star_filled_icon_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp)
                        )
                    else
                        Image(
                            painter = painterResource(id = R.mipmap.star_icon_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp)
                        )
                }
            }

        }
    }
}

@Preview
@Composable
private fun ConcertInfoPreview() {
    ConcertInfo(
        exampleConcertInfoDto,
        modifier = Modifier.fillMaxWidth()
    )
}