package dev.syoritohatsuki.quiz.ui.screens.question.viewmodel

import androidx.lifecycle.ViewModel
import dev.syoritohatsuki.quiz.data.questions
import dev.syoritohatsuki.quiz.dto.Answer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class QuestionViewModel : ViewModel() {
    private val _questions = MutableStateFlow(
        questions().map {
            it.key to it.value.shuffled().toSet()
        }.shuffled().toMap()
    )

    fun getQuestion(index: Int): Flow<Pair<String, Set<Answer>>> = flow {
        _questions.value.entries.elementAtOrNull(index)?.let {
            emit(it.toPair())
        }
    }

    fun total(): Int = _questions.value.size
}
