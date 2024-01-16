package com.missclick.alies.data.sharedStates

import kotlinx.coroutines.flow.MutableStateFlow

class GameSettings {

    val state = MutableStateFlow(GameSettingsState())

}