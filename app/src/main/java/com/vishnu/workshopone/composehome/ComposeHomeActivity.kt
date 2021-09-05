package com.vishnu.workshopone.composehome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vishnu.workshopone.ui.theme.AppTheme
import com.vishnu.workshopone.ui.theme.Text
import com.vishnu.workshopone.ui.theme.Title
import com.vishnu.workshopone.ui.theme.allPadding
import com.vishnu.workshopone.ui.theme.horPadding

class ComposeHomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = Color.LightGray)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Title(title = "Hello world!", modifier = Modifier.allPadding())
                        Text(
                            text = "This is sample text content under a headline. This sample project trying to design some basic compose UI.",
                            modifier = Modifier.horPadding()
                        )
                    }
                }
            }
        }
    }
}
