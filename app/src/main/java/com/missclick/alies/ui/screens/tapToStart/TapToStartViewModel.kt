package com.missclick.alies.ui.screens.tapToStart

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.models.Team
import com.missclick.alies.data.repository.Repository
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessShared
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessState
import com.missclick.alies.data.sharedStates.gameProcess.TeamsScore
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.tapToStart.models.TapToStartEvent
import com.missclick.alies.ui.screens.tapToStart.models.TapToStartState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TapToStartViewModel(
    private var repository: Repository,
    private val gameSettings: GameSettings,
    private val gameProcessShared: GameProcessShared
) : ViewModel(), EventHandler<TapToStartEvent> {

    private val _state : MutableStateFlow<TapToStartState>
            = MutableStateFlow(TapToStartState())
    val state : StateFlow<TapToStartState> = _state

    init {

        _state.value = state.value.copy(
            step = gameSettings.state.value.chooseTeams.first()
        )


//        if (gameProcessShared.state.value.step == null){
//            _state.value = state.value.copy(
//                step = gameSettings.state.value.chooseTeams.first()
//            )
//        }else{
//            _state.value = state.value.copy(
////                step = gameProcessShared.state.value.step
//            )
//        }

    }

    override fun obtainEvent(event: TapToStartEvent) {
        when(event){
            is TapToStartEvent.Start -> {start(event.navController)}
        }
    }

    private fun start(navController: NavController) {
        val newTeams = mutableListOf<TeamsScore>()
        val teamNames = mutableListOf<String>()
        gameSettings.state.value.chooseTeams.forEach {
            newTeams.add(TeamsScore(teamName = it.name, score = 0, image = it.image))
            teamNames.add(it.name)
        }
        gameProcessShared.state.value = gameProcessShared.state.value.copy(
            teams = newTeams,
            stackWords = repository.getWordsByDictionariesName(teamNames),
            showedWords = listOf(),
            step = Team(name = newTeams.first().teamName, image = newTeams.first().image)

        )
        navController.navigate(NavigationTree.GAME_SCREEN.name)
    }


}