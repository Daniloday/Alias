package com.missclick.alies.ui.screens.roundResultScreen.models

import androidx.navigation.NavController

sealed class RoundResultScreenEvent {

    class Next(val navController: NavController) : RoundResultScreenEvent()
    class ChangeTick(val indexOfWord: Int) : RoundResultScreenEvent()
}