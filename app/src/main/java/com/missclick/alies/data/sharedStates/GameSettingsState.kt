package com.missclick.alies.data.sharedStates

import com.missclick.alies.data.models.Team

data class GameSettingsState(
    val chooseTeams : List<Team> = listOf(),
    val chooseDictionaries : List<String> = listOf(),
    val time : Int = 30,
    val goal : Int = 30,
)