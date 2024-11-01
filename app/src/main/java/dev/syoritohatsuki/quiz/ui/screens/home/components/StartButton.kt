package dev.syoritohatsuki.quiz.ui.screens.home.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .aspectRatio(
                ratio = 1f
            )
            .padding(
                all = 96.dp
            ),
        shape = RoundedCornerShape(
            size = 16.dp
        )
    ) {
        Text(
            text = "Start",
            fontSize = 64.sp,
            lineHeight = 64.sp
        )
    }
}