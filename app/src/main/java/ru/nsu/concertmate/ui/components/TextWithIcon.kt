package ru.nsu.concertmate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun TextWithIcon(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {


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
        ) {
            Image(
                painter = painterResource(id = R.mipmap.trash_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}