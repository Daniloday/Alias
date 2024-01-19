package com.missclick.alies

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.missclick.alies.di.appModule
import com.missclick.alies.di.dataModule
import com.missclick.alies.ui.navigation.Navigation
import com.missclick.alies.ui.theme.AliesTheme
import com.missclick.alies.ui.theme.AppTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import java.util.Locale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(appModule, dataModule)
        }

        setContent {
            AliesTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppTheme.colors.primaryBackground)
                ) {
                    Navigation()
                }
            }
        }
    }


}

