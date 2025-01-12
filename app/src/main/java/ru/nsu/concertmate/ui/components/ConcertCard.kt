package ru.nsu.concertmate.ui.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.ConcertInfoActivity
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.theme.FontRubik
import java.io.Serializable


data class ConcertInfoDto(
    val groupName: String,
    val title: String,
    val time: String,
    val city: String,
    val price: Int,
    val isStarred: Boolean,
    val place: String,
    val address: String? = null,
    val buyLink: String?,
) :Serializable

val exampleConcertInfoDto = ConcertInfoDto(
    "Король и Шут",
    "Цифровая сказка",
    "16 января, 20:00",
    "Новосибирск",
    1000,
    false,
    "Клуб Подземка",
    buyLink = "https://afisha.yandex.ru/novosibirsk/concert/aleksandr-pushnoi-2025-03?source=rubric"
)


@Composable
fun ConcertCard(
    activity: Activity?,
    concertInfo: ConcertInfoDto,
    isFavoriteScreen: Boolean,
    modifier: Modifier = Modifier,
    onRemoveClick: () -> Unit
) {

    val isStarred = remember { mutableStateOf(concertInfo.isStarred) }

    Box(
        modifier = Modifier
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                val intent = Intent(activity, ConcertInfoActivity::class.java)
                intent.putExtra("dto", concertInfo)
                activity?.startActivity(intent)
            }
    ) {
        Box {
            Column(
                modifier = modifier
                    .padding(all = 10.dp)
                    .align(AbsoluteAlignment.TopLeft)
            ) {
                Column(
                    modifier = Modifier

                        .padding(top = 3.dp, bottom = 32.dp, start = 2.dp, end = 2.dp)
                ) {
                    Text(
                        concertInfo.groupName,
                        color = Color(0xFF000000),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontRubik,
                        modifier = Modifier
                            .padding(bottom = 14.dp)
                    )
                    Text(
                        concertInfo.title,
                        color = Color(0xFF757575),
                        fontSize = 16.sp,
                        fontFamily = FontRubik,
                        modifier = Modifier
                            .padding(bottom = 17.dp)
                    )
                    Text(
                        concertInfo.time,
                        color = Color(0xFF757575),
                        fontSize = 14.sp,
                        fontFamily = FontRubik,
                        modifier = Modifier
                            .padding(bottom = 2.dp)
                    )
                    Text(
                        concertInfo.city,
                        color = Color(0xFF1E1E1E),
                        fontSize = 16.sp,
                        fontFamily = FontRubik,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Text(
                "От " + concertInfo.price + " ₽",
                color = Color(0xFF1E1E1E),
                fontSize = 16.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 15.dp, end = 40.dp)
            )
        }
        IconButton(
            onClick = {
                if (!isFavoriteScreen) {
                    isStarred.value = !isStarred.value
                } else {
                    onRemoveClick()
                }
                      },
            modifier = Modifier
                .padding(top = 10.dp, end = 5.dp)
                .width(36.dp)
                .height(36.dp)
                .align(Alignment.TopEnd)
        ) {
            LazyColumn {
                item(isStarred) {

                    if (isFavoriteScreen)
                        Image(
                            painter = painterResource(id = R.mipmap.trash_icon_foreground),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(36.dp)
                                .height(36.dp)
                        )
                    else if (isStarred.value)
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
fun ConcertCardPreview() {
    /*ConcertCard( null,
        exampleConcertInfoDto, false, modifier = Modifier.fillMaxWidth()
    )*/
}