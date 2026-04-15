package com.pdm0126.taller1_00098122

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
  modifier: Modifier = Modifier,
  onStartQuiz: () -> Unit,
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(
      20.dp,
      alignment = Alignment.CenterVertically
    )
  ) {
    Text(
      text = "AndroidPedia",
      fontSize = 42.sp,
      fontWeight = FontWeight.Bold,
      color = Color.Black
    )
    
    Text(
      text = "¿Cuánto sabes de Android?",
      fontSize = 20.sp,
      color = Color.Gray
    )
    
    Card(
      modifier = Modifier.padding(16.dp),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(
        containerColor = Color(0xFF6AF1E6)
      )
    ) {
      Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "Gabriel Alexander Lira Andrade",
          fontSize = 18.sp,
          color = Color.Black,
          fontWeight = FontWeight.Bold
        )
        
        Text(
          text = "Carnet: 00098122",
          fontSize = 16.sp,
          color = Color.Black
        )
      }
    }
    
    Button(
      onClick = onStartQuiz,
      modifier = Modifier.padding(horizontal = 32.dp),
      shape = RoundedCornerShape(12.dp),
      colors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White
      )
    ) {
      Text(
        text = "Comenzar Quiz",
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
      )
    }
  }
}