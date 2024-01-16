package com.missclick.alies.ui.screens.chooseTeam.models

import com.missclick.alies.data.models.Team

data class ChooseTeamState(
    val choseTeamList : List<Team> = listOf(),
    val teamList : List<Team> = listOf()
)