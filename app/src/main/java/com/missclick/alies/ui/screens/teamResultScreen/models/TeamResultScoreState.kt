package com.missclick.alies.ui.screens.teamResultScreen.models

import com.missclick.alies.data.sharedStates.gameProcess.TeamsScore

data class TeamResultScoreState(
    val teams : List<TeamsScore> = listOf(),
    val winner : TeamsScore? = null
)