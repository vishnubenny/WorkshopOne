package com.vishnu.workshopone.ui.theme

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.vishnu.core.utils.Constants.INT_16
import com.vishnu.core.utils.Constants.INT_18

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier,
    fontSize: Int = INT_18,
    textColor: Color = DarkGrayText
) {
    Text(
        text = title,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Center,
        modifier = modifier,
        color = textColor
    )
}

@Composable
fun Text(text: String, modifier: Modifier = Modifier, fontSize: Int = INT_16) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}
