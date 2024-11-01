package dev.syoritohatsuki.quiz.ui.screens.question

import android.os.SystemClock
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import dev.syoritohatsuki.quiz.Screens
import dev.syoritohatsuki.quiz.ui.screens.question.components.AnswerButton
import dev.syoritohatsuki.quiz.ui.screens.question.components.QuestionText
import dev.syoritohatsuki.quiz.ui.screens.question.viewmodel.QuestionViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun QuestionScreen(
    navController: NavHostController, questionViewModel: QuestionViewModel = viewModel()
) {
    val index = remember { mutableIntStateOf(0) }
    val correctCount = remember { mutableIntStateOf(0) }
    val startTime = remember { SystemClock.elapsedRealtime() }
    var elapsedSeconds by remember { mutableIntStateOf(0) }

    val scope = rememberCoroutineScope()

    val question by questionViewModel.getQuestion(index.intValue)
        .collectAsState(Pair("", emptySet()))

    LaunchedEffect(Unit) {
        scope.launch {
            while (true) {
                val newElapsedSeconds = ((SystemClock.elapsedRealtime() - startTime) / 1000).toInt()
                if (newElapsedSeconds != elapsedSeconds) elapsedSeconds = newElapsedSeconds
                delay(1000)
            }
        }
    }

    LaunchedEffect(index.intValue) {
        if (index.intValue >= questionViewModel.total()) {
            navController.popBackStack()
            navController.navigate(Screens.Result.route + "/${elapsedSeconds}/${correctCount.intValue}")
        }
    }

    if (index.intValue < questionViewModel.total()) Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        QuestionText(
            index = index.intValue,
            text = question.first
        )
        Spacer(modifier = Modifier.weight(1f))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            question.second.forEach {
                item {
                    AnswerButton(answer = it.text) {
                        if (it.correct) correctCount.value += 1
                        index.value += 1
                    }
                }
            }
        }
    }
}