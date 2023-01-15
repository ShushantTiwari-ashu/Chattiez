package com.shushant.common.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shushant.common.compose.theme.GradientEnd
import com.shushant.common.compose.theme.GradientStart
import com.shushant.common.compose.theme.Typography
import com.shushant.resource.ChatIcons

@Composable
fun GradientButton(buttonText: String, icon: ChatIcons, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        GradientStart, GradientEnd
                    ), tileMode = TileMode.Mirror
                ), shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .height(50.dp)
            .clickable { onClick.invoke() }
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon.drawable),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(color = Color.White)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = buttonText,
                style = Typography.bodyLarge,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}