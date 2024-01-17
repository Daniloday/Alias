package com.missclick.alies.ui.screens.gameScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessShared
import com.missclick.alies.data.sharedStates.gameProcess.ShowedWords
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.gameScreen.models.GameEvent
import com.missclick.alies.ui.screens.gameScreen.models.GameState
import com.missclick.alies.ui.screens.tapToStart.models.TapToStartState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel(
    gameSettings: GameSettings,
    private val gameProcessShared: GameProcessShared
) : ViewModel(), EventHandler<GameEvent> {


    private val _state : MutableStateFlow<GameState>
            = MutableStateFlow(GameState())
    val state : StateFlow<GameState> = _state


    init {
        println(gameProcessShared.state.value.stackWords)
        _state.value = state.value.copy(
            leftTime = gameSettings.state.value.time,
            showedWord = gameProcessShared.state.value.stackWords.first(),
            imageTeam = gameProcessShared.state.value.step?.image
        )

        viewModelScope.launch(Dispatchers.Main) {
            while (true){
                _state.value = state.value.copy(
                    leftTime = state.value.leftTime - 1
                )
                delay(1000)
                if (state.value.leftTime == 0){
                    break
                }
            }

        }
    }

    override fun obtainEvent(event: GameEvent) {
        when(event){
            is GameEvent.Guessed -> {guessed(true, event.navController)}
            is GameEvent.Skip -> {guessed(false, event.navController)}
        }
    }

    private fun guessed(guessed : Boolean, navController: NavController){
        val showed = gameProcessShared.state.value.showedWords.toMutableList()
        val stack = gameProcessShared.state.value.stackWords.toMutableList().drop(1)
        showed.add(
            ShowedWords(word = gameProcessShared.state.value.stackWords.first(),
                guessed = guessed,
            ))
        gameProcessShared.state.value = gameProcessShared.state.value.copy(
            showedWords = showed,
            stackWords = stack
        )
        _state.value = state.value.copy(
            score = state.value.score + if (guessed) 1 else -1,
            showedWord = gameProcessShared.state.value.stackWords.first()
        )
        if (state.value.leftTime == 0){
            navController.navigate(NavigationTree.ROUND_RESULT_SCREEN.name)
        }
    }




}