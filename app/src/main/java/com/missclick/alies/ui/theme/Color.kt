package com.missclick.alies.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color



data class Colors (
    val primaryBackground : Color
)


val darkColorPalette = Colors(
    primaryBackground = Color(0xFFFFFFFF)
)


val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No colors")
}

