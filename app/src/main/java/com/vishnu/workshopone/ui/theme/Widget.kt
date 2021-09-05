package com.vishnu.workshopone.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishnu.core.utils.Constants.INT_16
import com.vishnu.core.utils.Constants.INT_18
import com.vishnu.core.utils.Constants.INT_8

@Composable
fun Title(title: String, fontSize: Int = INT_18, padding: Int = INT_8) {
    Text(
        text = title,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(padding.dp)
    )
}

@Composable
fun Text(text: String, fontSize: Int = INT_16, padding: Int = INT_8) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(padding.dp)
    )
}
