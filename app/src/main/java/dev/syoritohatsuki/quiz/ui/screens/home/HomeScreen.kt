package dev.syoritohatsuki.quiz.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import dev.syoritohatsuki.quiz.Screens
import dev.syoritohatsuki.quiz.ui.screens.home.components.StartButton

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StartButton {
            navController.navigate(Screens.Question.route)
        }
    }
}