package com.missclick.alies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.missclick.alies.ui.navigation.Navigation
import com.missclick.alies.ui.theme.AliesTheme
import com.missclick.alies.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AliesTheme {
                Box(modifier = Modifier.fillMaxSize().background(AppTheme.colors.primaryBackground)){
                    Navigation()
                }
            }
        }
    }


}

