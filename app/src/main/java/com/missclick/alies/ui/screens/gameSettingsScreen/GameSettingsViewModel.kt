package com.missclick.alies.ui.screens.gameSettingsScreen

import androidx.lifecycle.ViewModel
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.ui.screens.gameSettingsScreen.models.GameSettingsEvent
import com.missclick.alies.ui.screens.gameSettingsScreen.models.GameSettingsTeamState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameSettingsViewModel(
    private val gameSettings: GameSettings
) : ViewModel(), EventHandler<GameSettingsEvent> {

    private val _state: MutableStateFlow<GameSettingsTeamState> =
        MutableStateFlow(GameSettingsTeamState())
    val state: StateFlow<GameSettingsTeamState> = _state

    override fun obtainEvent(event: GameSettingsEvent) {
        when (event) {
            is GameSettingsEvent.Next -> {
                next()
            }

            is GameSettingsEvent.ChangeTime -> {
                changeTime(event.up)
            }

            is GameSettingsEvent.ChangeGoal -> {
                changeGoal(event.up)
            }
        }
    }

    private fun next() {
        gameSettings.state.value = gameSettings.state.value.copy(
            time = state.value.timeGameSettings,
            goal = state.value.goalGameSettings
        )
    }

    private fun changeTime(up: Boolean) {
        when (up) {
            true -> {
                if (state.value.timeGameSettings < 110){
                    _state.value = state.value.copy(
                        timeGameSettings = state.value.timeGameSettings + 10,
                        timeBooleanLess = true,
                        timeBooleanMore = true
                    )
                }
                else if(state.value.timeGameSettings==110){
                    _state.value = state.value.copy(
                        timeGameSettings = state.value.timeGameSettings + 10,
                        timeBooleanMore = false
                    )
                }
            }

            false -> {
                if (state.value.timeGameSettings > 40) {
                    _state.value = state.value.copy(
                        timeGameSettings = state.value.timeGameSettings - 10,
                        timeBooleanMore = true,
                        timeBooleanLess = true
                    )
                }
                else if(state.value.timeGameSettings == 40){
                    _state.value = state.value.copy(
                        timeGameSettings = state.value.timeGameSettings - 10,
                        timeBooleanLess = false
                    )
                }
            }
        }
    }

    private fun changeGoal(up: Boolean) {
        when (up) {
            true -> {
                if (state.value.goalGameSettings < 230){
                    _state.value = state.value.copy(
                        goalGameSettings = state.value.goalGameSettings + 10,
                        goalBooleanLess = true,
                        goalBooleanMore = true
                    )
                }
                else if(state.value.goalGameSettings == 230){
                    _state.value = state.value.copy(
                        goalGameSettings = state.value.goalGameSettings + 10,
                        goalBooleanMore = false
                    )
                }
            }

            false -> {
                if (state.value.goalGameSettings > 40) {
                    _state.value = state.value.copy(
                        goalGameSettings = state.value.goalGameSettings - 10,
                        goalBooleanMore = true,
                        goalBooleanLess = true
                    )
                }
                else if (state.value.goalGameSettings==40){
                    _state.value = state.value.copy(
                        goalGameSettings = state.value.goalGameSettings - 10,
                        goalBooleanLess = false
                    )
                }
            }
        }
    }

}