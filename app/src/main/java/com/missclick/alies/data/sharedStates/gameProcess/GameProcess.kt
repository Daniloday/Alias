package com.missclick.alies.data.sharedStates.gameProcess

import kotlinx.coroutines.flow.MutableStateFlow

class GameProcessShared {

    var state = MutableStateFlow(GameProcessState())

}