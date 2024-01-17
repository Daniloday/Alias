package com.missclick.alies.ui.screens.roundResultScreen.models

import androidx.navigation.NavController
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameEvent

sealed class RoundResultScreenEvent {

    class Next(val navController: NavController) : RoundResultScreenEvent()
    object ChangeTick : RoundResultScreenEvent()
}