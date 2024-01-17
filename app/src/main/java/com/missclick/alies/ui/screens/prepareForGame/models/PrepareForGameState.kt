package com.missclick.alies.ui.screens.prepareForGame.models

import com.missclick.alies.data.models.Team

data class PrepareForGameState(
    val selectedTime : Int = 0,
    val selectedGoal : Int = 0,
    val selectedTeams : List<Team> = listOf()
)