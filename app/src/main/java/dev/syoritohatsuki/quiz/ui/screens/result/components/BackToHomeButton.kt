package dev.syoritohatsuki.quiz.ui.screens.result.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BackToHomeButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(
            size = 16.dp
        )
    ) {
        Text(
            text = "Back to home",
            fontSize = 48.sp,
            lineHeight = 48.sp
        )
    }
}