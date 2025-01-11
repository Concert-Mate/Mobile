package ru.nsu.concertmate.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.concertmate.R
import ru.nsu.concertmate.ui.theme.FontRobotoSlab

@Composable
fun BottomBar(modifier: Modifier = Modifier,
           onLeftIconPressed: () -> Unit = {},
           onMidIconPressed: () -> Unit = {},
           onRightIconPressed: () -> Unit = {})
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        IconButton(
            onClick = onLeftIconPressed,
            modifier = Modifier
                .fillMaxHeight(0.8f)
        ){
            Image(
                painter = painterResource(id = R.mipmap.profile_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        IconButton(
            onClick = onMidIconPressed,
            modifier = Modifier
                .fillMaxHeight(0.8f)
        ){
            Image(
                painter = painterResource(id = R.mipmap.tiket_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        IconButton(
            onClick = onRightIconPressed,
            modifier = Modifier
                .fillMaxHeight(0.8f)
        ){
            Image(
                painter = painterResource(id = R.mipmap.star_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

}

@Preview
@Composable
fun BottomBarPreview(){
    BottomBar()
}