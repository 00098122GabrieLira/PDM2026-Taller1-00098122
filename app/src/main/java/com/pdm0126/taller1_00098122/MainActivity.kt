package com.pdm0126.taller1_00098122

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pdm0126.taller1_00098122.ui.theme.AndroidPediaByLiraTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AndroidPediaByLiraTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          QuizApp(
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}