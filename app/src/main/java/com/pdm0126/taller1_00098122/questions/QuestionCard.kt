package com.pdm0126.taller1_00098122.questions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.taller1_00098122.Question

@Composable
fun QuestionCard(
  question: Question,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier.fillMaxWidth(),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Text(
      text = question.question,
      modifier = Modifier.padding(24.dp),
      fontSize = 20.sp,
      fontWeight = FontWeight.Medium,
      textAlign = TextAlign.Center,
      color = Color.Black
    )
  }
}