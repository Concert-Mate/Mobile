package ru.nsu.concertmate.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.theme.FontRubik

data class AccordionDataItem(
    val title: String,
    val content: String
)

@Composable
fun AccordionList(accordionDataItems: List<AccordionDataItem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(accordionDataItems) {
            item -> AccordionItem(title = item.title, content = item.content)
        }
    }
}

@Composable
fun AccordionItem(title: String, content: String) {

    var expanded by remember { mutableStateOf(false) }

    val img = if(!expanded) painterResource(id = R.drawable.angle_down) else painterResource(id = R.drawable.angle_up)

    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
            .border(BorderStroke(1.dp, Color(0xFFB9B9B9)))
            .clickable { expanded = !expanded }

        ) {
            Column {
                Row(
                    modifier = Modifier.padding(PaddingValues(16.dp, 16.dp, 16.dp, 16.dp)),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = title,
                        color = Color(0xFF1E1E1E),
                        fontSize = 16.sp,
                        fontFamily = FontRubik,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )

                    Image(
                        painter = img,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(PaddingValues(start = 16.dp, top = 6.dp))

                    )

                }
                AnimatedVisibility(visible = expanded) {
                    Text(
                        text = content,
                        color = Color(0xFF1E1E1E),
                        fontSize = 16.sp,
                        fontFamily = FontRubik,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(
                            PaddingValues(
                                start = 16.dp,
                                end = 16.dp,
                                bottom = 16.dp
                            )
                        )
                    )
                }

            }

        }
    }
}