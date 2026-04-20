package com.pdm0126.taller1_00098122.questions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.taller1_00098122.Question

@Composable
fun FunFactCard(
  question: Question,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Text(
        text = "Dato curioso:",
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Color.Black
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = question.funfact,
        fontSize = 14.sp,
        color = Color.DarkGray
      )
    }
  }
}