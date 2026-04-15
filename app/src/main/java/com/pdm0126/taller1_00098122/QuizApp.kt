package com.pdm0126.taller1_00098122

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun QuizApp(modifier: Modifier = Modifier) {
  var quizStarted by rememberSaveable { mutableStateOf(false) }
  var currentQuestionIndex by rememberSaveable { mutableIntStateOf(0) }
  var score by rememberSaveable { mutableIntStateOf(0) }
  var selectedOptionIndex by rememberSaveable { mutableStateOf<Int?>(null) }
  var showFunFact by rememberSaveable { mutableStateOf(false) }
  var answerLocked by rememberSaveable { mutableStateOf(false) }
  var showResults by rememberSaveable { mutableStateOf(false) }
  
  fun resetQuiz() {
    quizStarted = true
    currentQuestionIndex = 0
    score = 0
    selectedOptionIndex = null
    showFunFact = false
    answerLocked = false
    showResults = false
  }
  
  fun startQuiz() {
    quizStarted = true
    currentQuestionIndex = 0
    score = 0
    selectedOptionIndex = null
    showFunFact = false
    answerLocked = false
    showResults = false
  }
  
  fun nextQuestion() {
    if (currentQuestionIndex < QuizQuestions.size - 1) {
      currentQuestionIndex++
      selectedOptionIndex = null
      showFunFact = false
      answerLocked = false
    } else {
      showResults = true
    }
  }
  
  fun checkAnswer(optionIndex: Int) {
    if (!answerLocked) {
      selectedOptionIndex = optionIndex
      answerLocked = true
      showFunFact = true
      
      if (optionIndex == QuizQuestions[currentQuestionIndex].correctAnswer) {
        score++
      }
    }
  }
  
  if (!quizStarted) {
    WelcomeScreen(
      modifier = modifier,
      onStartQuiz = { startQuiz() }
    )
  } else if (showResults) {
    ResultScreen(
      modifier = modifier,
      score = score,
      totalQuestions = QuizQuestions.size,
      onRestartQuiz = { resetQuiz() }
    )
  } else {
    QuestionScreen(
      modifier = modifier,
      question = QuizQuestions[currentQuestionIndex],
      currentQuestionNumber = currentQuestionIndex + 1,
      totalQuestions = QuizQuestions.size,
      currentScore = score,
      selectedOptionIndex = selectedOptionIndex,
      showFunFact = showFunFact,
      answerLocked = answerLocked,
      onOptionSelected = { checkAnswer(it) },
      onNextQuestion = { nextQuestion() }
    )
  }
}