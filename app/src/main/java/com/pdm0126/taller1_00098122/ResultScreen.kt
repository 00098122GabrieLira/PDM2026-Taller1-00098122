package com.pdm0126.taller1_00098122

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(
  modifier: Modifier = Modifier,
  score: Int,
  totalQuestions: Int,
  onRestartQuiz: () -> Unit
) {
  val message = when (score) {
    0, 1 -> stringResource(R.string.Resultado1)
    2 -> stringResource(R.string.Resultado2)
    3 -> stringResource(R.string.Resultado3)
    else -> "Resultado obtenido"
  }
  
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White)
      .verticalScroll(rememberScrollState()),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(30.dp, alignment = Alignment.CenterVertically)
  ) {
    Text(
      text = "Resultado final",
      fontSize = 32.sp,
      fontWeight = FontWeight.Bold,
      color = Color.Black
    )
    
    Card(
      modifier = Modifier
        .width(300.dp),
      shape = RoundedCornerShape(24.dp),
      colors = CardDefaults.cardColors(
        containerColor = Color(0xFFF5F5F5)
      ),
      elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
      Column(
        modifier = Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = "Obtuviste $score de $totalQuestions",
          fontSize = 28.sp,
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.Center,
          color = Color.Black
        )
        
        Text(
          text = message,
          fontSize = 18.sp,
          textAlign = TextAlign.Center,
          color = Color.DarkGray,
          modifier = Modifier.padding(top = 24.dp)
        )
      }
    }
    
    Button(
      onClick = onRestartQuiz,
      modifier = Modifier.width(280.dp),
      shape = RoundedCornerShape(12.dp),
      colors = ButtonDefaults.buttonColors(
        containerColor = Color.Black,
        contentColor = Color.White
      )
    ) {
      Text(
        text = "Reiniciar Quiz",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
      )
    }
  }
}