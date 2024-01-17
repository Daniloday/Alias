package com.missclick.alies.ui.screens.teamResultScreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.models.Team
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessShared
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.prepareForGame.models.PrepareForGameEvent
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreEvent
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TeamResultScreenViewModel(
    private val gameProcessShared: GameProcessShared
) : ViewModel(), EventHandler<TeamResultScoreEvent> {

    private val _state : MutableStateFlow<TeamResultScoreState>
            = MutableStateFlow(TeamResultScoreState())
    val state : StateFlow<TeamResultScoreState> = _state

    init {
        _state.value = state.value.copy(
            teams = gameProcessShared.state.value.teams)
    }

    override fun obtainEvent(event: TeamResultScoreEvent) {
        when(event){
            is TeamResultScoreEvent.Next -> {next(event.navController)}
        }
    }

    private fun next(navController: NavController){
        val list = mutableListOf<String>()
        for(i in gameProcessShared.state.value.teams){
            list.add(i.teamName)
        }

        for(i in list.indices){
            if(list[i]==gameProcessShared.state.value.step?.name){
                val nextImage = gameProcessShared.state.value.teams[i+1].image
                val nextTeamName = gameProcessShared.state.value.teams[i+1].teamName
                gameProcessShared.state.value = gameProcessShared.state.value.copy(
                    step = Team(nextTeamName,nextImage)
                )

                break
            }
        }

        navController.navigate(NavigationTree.TAP_TO_START.name)
    }


}