package com.vishnu.workshopone.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vishnu.core.utils.Constants.INT_8

fun Modifier.allPadding(padding: Int = INT_8) = this.padding(padding.dp)

fun Modifier.horPadding(padding: Int = INT_8) = this.padding(horizontal = padding.dp)

fun Modifier.verPadding(padding: Int = INT_8) = this.padding(vertical = padding.dp)
