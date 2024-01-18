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
                if (state.value.timeGameSettings < 120)
                    _state.value = state.value.copy(
                        timeGameSettings = state.value.timeGameSettings + 10
                    )
            }

            false -> {
                if (state.value.timeGameSettings > 30) {
                    _state.value = state.value.copy(
                        timeGameSettings = state.value.timeGameSettings - 10
                    )
                }
            }
        }
    }

    private fun changeGoal(up: Boolean) {
        when (up) {
            true -> {
                if (state.value.goalGameSettings < 240)
                    _state.value = state.value.copy(
                        goalGameSettings = state.value.goalGameSettings + 10
                    )
            }

            false -> {
                if (state.value.goalGameSettings > 30) {
                    _state.value = state.value.copy(
                        goalGameSettings = state.value.goalGameSettings - 10
                    )
                }
            }
        }
    }

}