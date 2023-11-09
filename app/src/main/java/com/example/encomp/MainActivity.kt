package com.example.encomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.encomp.ui.screens.home.HomeScreen
import com.example.encomp.ui.theme.DogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogAppTheme {
                HomeScreen()
            }
        }
    }
}