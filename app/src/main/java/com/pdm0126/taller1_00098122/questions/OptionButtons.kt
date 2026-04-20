package com.pdm0126.taller1_00098122.questions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionButtons(
  options: List<String>,
  correctAnswer: Int,
  selectedOptionIndex: Int?,
  answerLocked: Boolean,
  onOptionSelected: (Int) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    options.forEachIndexed { index, option ->
      val buttonColor = when {
        !answerLocked -> Color(0xFFE0E0E0)
        index == correctAnswer && index == selectedOptionIndex -> Color(0xFF4CAF50)
        index == selectedOptionIndex -> Color(0xFFF44336)
        else -> Color(0xFFE0E0E0)
      }
      
      val textColor = when {
        !answerLocked -> Color.Black
        (index == correctAnswer && index == selectedOptionIndex) ||
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
}