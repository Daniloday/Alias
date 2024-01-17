package com.missclick.alies.ui.screens.prepareForGame

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.repository.Repository
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameEvent
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PrepareForGameViewModel(
    private val gameSettings: GameSettings
): ViewModel(), EventHandler<PrepareForGameEvent> {


    private val _state : MutableStateFlow<PrepareForGameState> = MutableStateFlow(PrepareForGameState())
    val state : StateFlow<PrepareForGameState> = _state

    init {
        _state.value = state.value.copy(
            selectedTime = gameSettings.state.value.time,
            selectedGoal = gameSettings.state.value.goal,
            selectedTeams = gameSettings.state.value.chooseTeams
        )
    }

    override fun obtainEvent(event: PrepareForGameEvent) {
        when(event){
            is PrepareForGameEvent.Next -> {next(event.navController)}
        }
    }

    private fun next(navController: NavController){
        navController.navigate(NavigationTree.TAP_TO_START.name)
    }

}