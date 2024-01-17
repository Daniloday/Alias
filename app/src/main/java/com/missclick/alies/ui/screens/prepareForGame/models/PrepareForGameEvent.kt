package com.missclick.alies.ui.screens.prepareForGame.models

import androidx.navigation.NavController

sealed class PrepareForGameEvent {
    class Next(val navController: NavController) : PrepareForGameEvent()
}