package com.missclick.alies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.missclick.alies.ui.navigation.Navigation
import com.missclick.alies.ui.theme.AliesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AliesTheme {
                Navigation()
            }
        }
    }


}

