package ru.nsu.concertmate.ui.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
fun TopBar(
    text: String,
    activity: Activity?,
    modifier: Modifier = Modifier,
    hasLeftIcon: Boolean = false,
    hasRightIcon: Boolean = false,
    onRightIconPressed: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(49.dp)
            .background(
                color = Color(0xFFFFFFFF),
            )
            .padding(start = 16.dp, end = 16.dp)
    ) {
        IconButton(
            onClick = {
                activity?.finish()
            },
            enabled = hasLeftIcon,
            modifier = Modifier
                .width(14.dp)
                .height(14.dp)
                .alpha(if (hasLeftIcon) 1f else 0f)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.back_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text,
            color = Color(0xFF1E1E1E),
            fontSize = 24.sp,
            fontFamily = FontRobotoSlab,
            modifier = Modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = onRightIconPressed,
            enabled = hasRightIcon,
            modifier = Modifier
                .width(26.dp)
                .height(26.dp)
                .alpha(if (hasRightIcon) 1f else 0f)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.refresh_icon_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }

}

@Preview
@Composable
fun TopBarPreview() {
    TopBar("Главное меню", null)
}