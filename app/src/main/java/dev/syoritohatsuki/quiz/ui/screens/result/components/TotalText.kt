package dev.syoritohatsuki.quiz.ui.screens.result.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TotalText(value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Total: ",
            fontSize = 32.sp,
            lineHeight = 32.sp
        )
        Text(
            text = value,
            fontSize = 32.sp,
            lineHeight = 32.sp
        )
    }
}