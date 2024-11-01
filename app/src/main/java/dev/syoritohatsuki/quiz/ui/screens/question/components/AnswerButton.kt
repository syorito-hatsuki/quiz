package dev.syoritohatsuki.quiz.ui.screens.question.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnswerButton(answer: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.aspectRatio(
            ratio = 1f
        ),
        shape = RoundedCornerShape(
            size = 16.dp
        ),
        onClick = onClick
    ) {
        Text(
            text = answer,
            fontSize = 24.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}