package com.example.togglecard

import android.R.attr.fontWeight
import android.graphics.Color.blue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.togglecard.ui.theme.ToggleCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToggleCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    ToggleCard()
                }
            }
        }
    }
}

// ToggleCard: A clickable card that toggles its content.
@Composable
fun ToggleCard() {
    var toggled by rememberSaveable { mutableStateOf(false) }

    val message = if (toggled) {
        "Kotlin was created by JetBrains!"
    } else {
        "Tap to see a fun fact!"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(72.dp)
            .background(Color.Black)
            .clickable { toggled = !toggled },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            color = Color.White,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            modifier = Modifier.padding(32.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ToggleCardPreview() {
    ToggleCardTheme {
        ToggleCard()
    }
}