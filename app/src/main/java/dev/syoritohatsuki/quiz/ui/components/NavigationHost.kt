package dev.syoritohatsuki.quiz.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.syoritohatsuki.quiz.Screens
import dev.syoritohatsuki.quiz.ui.screens.home.HomeScreen
import dev.syoritohatsuki.quiz.ui.screens.question.QuestionScreen
import dev.syoritohatsuki.quiz.ui.screens.result.ResultScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = Screens.Result.route + "/{time}/{correct}",
            arguments = listOf(
                navArgument("time") { type = NavType.IntType },
                navArgument("correct") { type = NavType.IntType }
            )
        ) {
            ResultScreen(navController)
        }
        composable(Screens.Question.route) {
            QuestionScreen(navController)
        }
    }
}