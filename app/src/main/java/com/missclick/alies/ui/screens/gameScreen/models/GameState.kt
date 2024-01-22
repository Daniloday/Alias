package com.missclick.alies.ui.screens.gameScreen.models

data class GameState(
    val leftTime : Int = 100,
    val showedWord : String = "",
    val score : Int = 0,
    val imageTeam : Int? = null,
    val isPaused : Boolean = false,
)