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
    private val gamestate: GameProcessShared
) : ViewModel(), EventHandler<RoundResultScreenEvent> {

    private val _state: MutableStateFlow<RoundResultScreenState> = MutableStateFlow(
        RoundResultScreenState()
    )
    val state: StateFlow<RoundResultScreenState> = _state

    init {
        //todo discus
//        _state.value = state.value.copy(
//            roundScore = 0,
//            roundWords = gamestate.state.value.showedWords
//        )

        _state.value = state.value.copy(
            roundScore = gamestate.state.value.showedWords.count { it.guessed },
            roundWords = gamestate.state.value.showedWords
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

        val newTeams = gamestate.state.value.teams.map {
            if (it.teamName == gamestate.state.value.step!!.name){
                TeamsScore(teamName = it.teamName, score = it.score + state.value.roundScore, image = it.image)
            }else{
                it
            }
        }

        gamestate.state.value = gamestate.state.value.copy(
            teams = newTeams
        )

        navController.navigate(NavigationTree.TEAM_RESULT_SCREEN.name)
    }

    //todo discus

//    private fun next(navController: NavController) {
//
//        var indexOfTeam = -1
//
//        var teams = gamestate.state.value.teams
//
//        for (i in 0 until gamestate.state.value.teams.size) {
//            if (gamestate.state.value.teams[i].teamName == gamestate.state.value.step?.name) {
//                indexOfTeam = i
//            }
//        }
//
//        val changedTeams = mutableListOf<TeamsScore>()
//
//        val oldTeamScore = changedTeams[indexOfTeam].score
//
//        val newTeamScore = oldTeamScore + state.value.roundScore
//
//
//        gamestate.state.value.teams.forEachIndexed() { index, _ ->
//            if (index == indexOfTeam) {
//                changedTeams.add(
//                    TeamsScore(
//                        teams[indexOfTeam].teamName,
//                        newTeamScore,
//                        teams[indexOfTeam].image
//                    )
//                )
//            } else {
//                changedTeams.add(gamestate.state.value.teams[index])
//            }
//        }
//
//
//        gamestate.state.value = gamestate.state.value.copy(
//            teams = changedTeams
//        )
//
//        navController.navigate(NavigationTree.TAP_TO_START.name)
//    }
//


    private fun calculateScore(listOfWords: List<ShowedWords>): Int {
        var score = 0

        listOfWords.forEach {
            if (it.guessed) score += 1
        }
        return score
    }
    private fun changeTick(indexOfWord: Int) {

        val listOfWords = state.value.roundWords

        listOfWords[indexOfWord].guessed = !listOfWords[indexOfWord].guessed

        _state.value = state.value.copy(
            roundWords = listOfWords,
            roundScore = calculateScore(listOfWords)
        )
    }


}