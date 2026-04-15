package com.pdm0126.taller1_00098122

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionScreen(
  modifier: Modifier = Modifier,
  question: Question,
  currentQuestionNumber: Int,
  totalQuestions: Int,
  currentScore: Int,
  selectedOptionIndex: Int?,
  showFunFact: Boolean,
  answerLocked: Boolean,
  onOptionSelected: (Int) -> Unit,
  onNextQuestion: () -> Unit
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White)
      .verticalScroll(rememberScrollState())
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(30.dp)
  ) {
    // Header con progreso y puntaje
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
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
    
    // Barra de progreso
    LinearProgressIndicator(
      progress = { currentQuestionNumber.toFloat() / totalQuestions },
      modifier = Modifier
        .fillMaxWidth()
        .height(8.dp),
      color = Color.Blue,
      trackColor = Color.LightGray
    )
    
    // Tarjeta de la pregunta
    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(16.dp),
      colors = CardDefaults.cardColors(
        containerColor = Color(0xFFF5F5F5)
      ),
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
    
    // Botones de opciones
    Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      question.options.forEachIndexed { index, option ->
        val buttonColor = when {
          !answerLocked -> Color(0xFFE0E0E0)
          index == question.correctAnswer && index == selectedOptionIndex -> Color(0xFF4CAF50)
          index == selectedOptionIndex -> Color(0xFFF44336)
          else -> Color(0xFFE0E0E0)
        }
        
        val textColor = when {
          !answerLocked -> Color.Black
          (index == question.correctAnswer && index == selectedOptionIndex) ||
                  (index == selectedOptionIndex) -> Color.White
          else -> Color.Black
        }
        
        Button(
          onClick = { onOptionSelected(index) },
          modifier = Modifier.width(280.dp),
          shape = RoundedCornerShape(12.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            disabledContainerColor = buttonColor
          ),
          enabled = !answerLocked
        ) {
          Text(
            text = option,
            color = textColor,
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp
          )
        }
      }
    }
    
    // Dato curioso
    if (showFunFact) {
      Card(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
          containerColor = Color(0xFFE3F2FD)
        )
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
    
    // Botón Siguiente
    if (answerLocked) {
      Button(
        onClick = onNextQuestion,
        modifier = Modifier
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
  }
}