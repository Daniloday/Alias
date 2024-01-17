package com.missclick.alies.ui.screens.tapToStart.models

import androidx.navigation.NavController

sealed class TapToStartEvent {

    class Start(val navController: NavController) : TapToStartEvent()

}