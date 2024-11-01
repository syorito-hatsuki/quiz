package dev.syoritohatsuki.quiz

sealed class Screens(val route: String) {
    data object Home : Screens("home")
    data object Question : Screens("question")
    data object Result : Screens("result")
}