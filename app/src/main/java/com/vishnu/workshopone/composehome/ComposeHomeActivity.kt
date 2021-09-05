package com.vishnu.workshopone.composehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

//Sample Compose Activity
class ComposeHomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.background(color = Color.Cyan).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SetHeader(header = "Hello world!")
                SetHeader(header = "Hello world! Hello world")
            }
        }
    }
}

@Composable
fun SetHeader(header: String) {
    Text(text = header, fontSize = 30.sp, textAlign = TextAlign.Center)
}
