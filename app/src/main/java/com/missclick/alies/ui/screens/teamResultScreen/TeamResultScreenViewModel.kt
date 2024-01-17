package com.missclick.alies.ui.screens.teamResultScreen

import androidx.lifecycle.ViewModel
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameEvent
import com.missclick.alies.ui.screens.tapToStart.models.TapToStartState
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TeamResultScreenViewModel(
    private val gameSettings: GameSettings
) : ViewModel(), EventHandler<PrepareForGameEvent> {

    private val _state : MutableStateFlow<TeamResultScoreState>
            = MutableStateFlow(TeamResultScoreState())
    val state : StateFlow<TeamResultScoreState> = _state


    override fun obtainEvent(event: PrepareForGameEvent) {



    }


}