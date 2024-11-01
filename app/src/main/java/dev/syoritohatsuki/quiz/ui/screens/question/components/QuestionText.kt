package dev.syoritohatsuki.quiz.ui.screens.question.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun QuestionText(index: Int, text: String) {
    Text(
        text = "Question ${index + 1}",
        fontSize = 20.sp,
        lineHeight = 20.sp,
        textAlign = TextAlign.Center
    )
    Text(
        text = text,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        textAlign = TextAlign.Center
    )
}