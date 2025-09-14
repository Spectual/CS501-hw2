package com.example.colorcard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colorcard.ui.theme.ColorCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColorCardScreen()
                }
            }
        }
    }
}

// A reusable color card composable
@Composable
fun ColorCard(
    color: Color,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(color = color, shape = RoundedCornerShape(16.dp))
            .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            color = Color.White,
        )
    }
}

// The main screen with 3 color cards with 3 different combinations of modifiers
@Composable
fun ColorCardScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ColorCard(
            color = Color(0xFF6C63FF),
            label = "Indigo",
            modifier = Modifier
                .size(140.dp)
                .padding(4.dp)
        )

        ColorCard(
            color = Color(0xFFFF6B6B),
            label = "Coral",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .size(160.dp)
                .border(4.dp, Color.DarkGray, RoundedCornerShape(16.dp))
        )
        ColorCard(
            color = Color(0xFF20C997),
            label = "Mint",
            modifier = Modifier
                .size(160.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColorCardTheme {
        ColorCardScreen()
    }
}