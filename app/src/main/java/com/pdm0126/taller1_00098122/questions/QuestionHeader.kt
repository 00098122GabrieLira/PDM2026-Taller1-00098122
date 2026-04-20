package com.pdm0126.taller1_00098122.questions

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionHeader(
  currentQuestionNumber: Int,
  totalQuestions: Int,
  currentScore: Int,
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
  ) {
    Text(
      text = "Pregunta $currentQuestionNumber de $totalQuestions",
      fontSize = 16.sp,
      fontWeight = FontWeight.Medium,
      color = Color.Black
    )
    Text(
      text = "Puntaje: $currentScore / $totalQuestions",
      fontSize = 16.sp,
      fontWeight = FontWeight.Bold,
      color = Color.Black
    )
  }
  
  LinearProgressIndicator(
    progress = { currentQuestionNumber.toFloat() / totalQuestions },
    modifier = Modifier
      .fillMaxWidth()
      .height(8.dp),
    color = Color.Blue,
    trackColor = Color.LightGray
  )
}