package com.missclick.alies.ui.screens.teamResultScreen.models

import androidx.navigation.NavController

sealed class TeamResultScoreEvent {
    class Next(val navController: NavController) : TeamResultScoreEvent()
}