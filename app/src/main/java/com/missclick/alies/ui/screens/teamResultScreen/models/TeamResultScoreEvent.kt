package com.missclick.alies.ui.screens.teamResultScreen.models

import androidx.navigation.NavController
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameEvent

sealed class TeamResultScoreEvent {
    class Next(val navController: NavController) : TeamResultScoreEvent()
}