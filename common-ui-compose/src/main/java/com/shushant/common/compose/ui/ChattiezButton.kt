package com.shushant.common.compose.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.shushant.common.compose.theme.Typography
import com.shushant.common.compose.theme.buttonColor
import com.shushant.common.compose.theme.textColor

@Composable
fun ChattiezButton(color: Color = buttonColor, buttonText: String, onClickAction: () -> Unit) {
    TextButton(
        onClick = { onClickAction.invoke() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = buttonText,
            style = Typography.bodyLarge,
            color = textColor,
            textAlign = TextAlign.Center
        )
    }
}