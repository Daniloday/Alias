package com.missclick.alies.data.sharedStates.gameProcess

import com.missclick.alies.data.models.Team


data class GameProcessState(
    val teams : List<TeamsScore> = listOf(),
    val stackWords : List<String> = listOf(),
    val showedWords : List<ShowedWords> = listOf(),
    val step : Team? = null
)