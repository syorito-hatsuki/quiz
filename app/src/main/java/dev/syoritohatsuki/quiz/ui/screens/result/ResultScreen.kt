package dev.syoritohatsuki.quiz.ui.screens.result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.syoritohatsuki.quiz.ui.screens.result.components.BackToHomeButton
import dev.syoritohatsuki.quiz.ui.screens.result.components.ResultText
import dev.syoritohatsuki.quiz.ui.screens.result.components.TotalText

@Composable
fun ResultScreen(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val correct: Int = navBackStackEntry?.arguments?.getInt("correct") ?: 0
    val time: Int = navBackStackEntry?.arguments?.getInt("time") ?: 0

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Text(text = "Result Screen", fontSize = 48.sp, fontWeight = FontWeight.Bold)
            }
            item {
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            }
            item {
                ResultText(name = "Correct answers:", value = (correct * 100).toString())
            }
            item {
                ResultText(name = "Time penalty:", value = (time * 10).toString())
            }
            item {
                TotalText(value = "${(correct * 100) - (time * 10)}")
            }
        }
        BackToHomeButton {
            navController.popBackStack()
        }
    }
}