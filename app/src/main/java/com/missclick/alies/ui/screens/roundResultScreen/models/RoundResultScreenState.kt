package com.missclick.alies.ui.screens.roundResultScreen.models


import com.missclick.alies.data.sharedStates.gameProcess.ShowedWords

data class RoundResultScreenState(
    val roundScore : Int = 0,
    val roundWords : List<ShowedWords> = listOf(),
    val step : String = ""
)