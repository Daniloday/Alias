package com.missclick.alies.ui.screens.teamResultScreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.models.Team
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessShared
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreEvent
import com.missclick.alies.ui.screens.teamResultScreen.models.TeamResultScoreState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TeamResultScreenViewModel(
    private val gameProcessShared: GameProcessShared,
    private val gameSettings: GameSettings
) : ViewModel(), EventHandler<TeamResultScoreEvent> {

    private val _state: MutableStateFlow<TeamResultScoreState> =
        MutableStateFlow(TeamResultScoreState())
    val state: StateFlow<TeamResultScoreState> = _state

    init {
        _state.value = state.value.copy(
            teams = gameProcessShared.state.value.teams,
            winner = null
        )
        checkEndGame()
    }

    override fun obtainEvent(event: TeamResultScoreEvent) {
        when (event) {
            is TeamResultScoreEvent.Next -> {
                next(event.navController)
            }
            is TeamResultScoreEvent.NewGame->{
                newGame(event.navController)
            }
        }
    }

    private fun newGame(navController: NavController){
        gameProcessShared.state.value = gameProcessShared.state.value.copy(
            step = null,
        )
        navController.navigate(NavigationTree.MENU.name)
    }

    private fun next(navController: NavController) {
        val currentStepIndex = gameProcessShared.state.value.teams.indexOfFirst {
            it.teamName == gameProcessShared.state.value.step?.name
        }
        val nextStepIndex = (currentStepIndex + 1) % gameProcessShared.state.value.teams.size
        val nextTeam = gameProcessShared.state.value.teams[nextStepIndex]
        gameProcessShared.state.value = gameProcessShared.state.value.copy(
            step = Team(name = nextTeam.teamName, image = nextTeam.image),
            showedWords = listOf(),
        )
        navController.navigate(NavigationTree.TAP_TO_START.name)
    }
    private fun checkEndGame(){
        if(gameProcessShared.state.value.step?.name == gameProcessShared.state.value.teams.last().teamName){
            var maxIndex = -1
            state.value.teams.forEachIndexed { index, teamsScore ->
                if(teamsScore.score>=gameSettings.state.value.goal){
                    if(maxIndex==-1){
                        maxIndex = index
                    }else{
                        if(state.value.teams[maxIndex].score<state.value.teams[index].score){
                            maxIndex = index
                        }
                    }
                }
            }
            if(maxIndex != -1){
                _state.value = state.value.copy(
                    winner = state.value.teams[maxIndex]
                )
            }
        }
    }

}