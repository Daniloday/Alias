package com.missclick.alies.ui.screens.gameSettingsScreen.models


data class GameSettingsTeamState(
    val timeGameSettings : Int = 30,
    val goalGameSettings : Int = 100,
    val timeBooleanLess : Boolean = false,
    val timeBooleanMore : Boolean = true,
    val goalBooleanLess : Boolean = true,
    val goalBooleanMore : Boolean = true
)