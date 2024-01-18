package com.missclick.alies.ui.screens.roundResultScreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessShared
import com.missclick.alies.data.sharedStates.gameProcess.ShowedWords
import com.missclick.alies.data.sharedStates.gameProcess.TeamsScore
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.roundResultScreen.models.RoundResultScreenEvent
import com.missclick.alies.ui.screens.roundResultScreen.models.RoundResultScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RoundResultScreenViewModel(
    private val gameProcess: GameProcessShared
) : ViewModel(), EventHandler<RoundResultScreenEvent> {

    private val _state: MutableStateFlow<RoundResultScreenState> = MutableStateFlow(
        RoundResultScreenState()
    )
    val state: StateFlow<RoundResultScreenState> = _state

    init {

        _state.value = state.value.copy(
            roundScore = gameProcess.state.value.showedWords.count { it.guessed },
            roundWords = gameProcess.state.value.showedWords
        )
    }

    override fun obtainEvent(event: RoundResultScreenEvent) {
        when (event) {
            is RoundResultScreenEvent.Next -> {
                next(event.navController)
            }

            is RoundResultScreenEvent.ChangeTick -> {
                changeTick(event.indexOfWord)
            }
        }
    }

    private fun next(navController: NavController){

        val newTeams = gameProcess.state.value.teams.map {
            if (it.teamName == gameProcess.state.value.step!!.name){
                TeamsScore(teamName = it.teamName, score = it.score + state.value.roundScore, image = it.image)
            }else{
                it
            }
        }

        gameProcess.state.value = gameProcess.state.value.copy(
            teams = newTeams
        )

        navController.navigate(NavigationTree.TEAM_RESULT_SCREEN.name)
    }

    private fun changeTick(indexOfWord: Int) {

        val listOfWords = state.value.roundWords

        listOfWords[indexOfWord].guessed = !listOfWords[indexOfWord].guessed

        _state.value = state.value.copy(
            roundWords = listOfWords,
            roundScore = gameProcess.state.value.showedWords.count { it.guessed },
        )
    }


}