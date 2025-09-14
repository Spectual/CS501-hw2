package com.example.kotlinpractice

import android.R.id.input
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinpractice.ui.theme.KotlinPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KotlinPracticeScreen()
                }
            }
        }
    }
}


@Composable
fun KotlinPracticeScreen() {
    Column(modifier = Modifier.padding(32.dp)) {
        // when expression based on an input string
        val input = "cat"
        val result = when (input) {
            "cat" -> "You chose Cat 🐱"
            "dog" -> "You chose Dog 🐶"
            "fish" -> "You chose Fish 🐟"
            else -> "Unknown animal"
        }
        Text(text = result)

        // A message only if a nullable string is not null
        val nullableMessage: String? = "Hello from nullable string"
        nullableMessage?.let { nonNullValue ->
            Text(text = "Message: $nonNullValue")
        }

        // Counter no less than 5
        var count by remember { mutableStateOf(0) }
        Text(text = "Count: $count")

        Button(onClick = {
            if (count < 5) {
                count++
            }
        }) {
            Text("Increment")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinPracticeTheme {
        KotlinPracticeScreen()
    }
}