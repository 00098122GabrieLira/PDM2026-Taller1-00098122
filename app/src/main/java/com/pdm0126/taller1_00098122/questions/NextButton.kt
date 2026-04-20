package com.pdm0126.taller1_00098122.questions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NextButton(
  currentQuestionNumber: Int,
  totalQuestions: Int,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Button(
    onClick = onClick,
    modifier = modifier
        .fillMaxWidth()
        .height(52.dp),
    shape = RoundedCornerShape(12.dp),
    colors = ButtonDefaults.buttonColors(
      containerColor = Color.Black,
      contentColor = Color.White
    )
  ) {
    Text(
      text = if (currentQuestionNumber == totalQuestions) "Ver Resultado" else "Siguiente",
      fontSize = 16.sp,
      fontWeight = FontWeight.Bold
    )
  }
}