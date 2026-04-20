package com.pdm0126.taller1_00098122

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pdm0126.taller1_00098122.questions.*

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
    QuestionHeader(
      currentQuestionNumber = currentQuestionNumber,
      totalQuestions = totalQuestions,
      currentScore = currentScore
    )
    
    QuestionCard(question = question)
    
    OptionButtons(
      options = question.options,
      correctAnswer = question.correctAnswer,
      selectedOptionIndex = selectedOptionIndex,
      answerLocked = answerLocked,
      onOptionSelected = onOptionSelected
    )
    
    if (showFunFact) {
      FunFactCard(question = question)
    }
    
    if (answerLocked) {
      NextButton(
        currentQuestionNumber = currentQuestionNumber,
        totalQuestions = totalQuestions,
        onClick = onNextQuestion
      )
    }
  }
}