package com.missclick.alies.ui.theme


import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


data class Typography(
    val bigLetter : TextStyle
)


val typography = Typography(
    bigLetter = TextStyle(
        fontSize = 39.sp
    )
)

val LocalTypographyProvider = staticCompositionLocalOf<Typography> {
    error("No typography")
}