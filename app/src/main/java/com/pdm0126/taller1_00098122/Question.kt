package com.pdm0126.taller1_00098122

data class Question(
  val id: Int,
  val question: String,
  val options: List<String>,
  val correctAnswer: Int,
  val funfact: String
)