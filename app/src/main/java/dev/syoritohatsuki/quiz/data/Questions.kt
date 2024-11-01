package dev.syoritohatsuki.quiz.data

import dev.syoritohatsuki.quiz.dto.Answer

fun questions(): Map<String, Set<Answer>> = mapOf(
    "With language used for make native Android Applications" to setOf(
        Answer("Kotlin", true),
        Answer("Java", true),
        Answer("Python", false),
        Answer("Rust", false),
    ),
    "2 + 2 x 2" to setOf(
        Answer("4", false),
        Answer("6", true),
        Answer("8", false),
        Answer("10", false),
    ),
    "What is the capital of France?" to setOf(
        Answer("Paris", true),
        Answer("London", false),
        Answer("Berlin", false),
        Answer("Madrid", false),
    ),
    "Which planet is known as the Red Planet?" to setOf(
        Answer("Mars", true),
        Answer("Jupiter", false),
        Answer("Venus", false),
        Answer("Saturn", false),
    ),
    "What is the largest mammal in the world?" to setOf(
        Answer("Blue Whale", true),
        Answer("Elephant", false),
        Answer("Giraffe", false),
        Answer("Great White Shark", false),
    )
)