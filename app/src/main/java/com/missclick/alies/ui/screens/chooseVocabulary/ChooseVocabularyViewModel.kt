package com.missclick.alies.ui.screens.chooseVocabulary

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.repository.Repository
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyEvent
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyState
import com.missclick.alies.ui.screens.chooseVocabulary.models.Vocabulary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChooseVocabularyViewModel(
    repository: Repository,
    private val gameSettings: GameSettings
) : ViewModel(), EventHandler<ChooseVocabularyEvent> {

    private val _state: MutableStateFlow<ChooseVocabularyState> =
        MutableStateFlow(ChooseVocabularyState())
    val state: StateFlow<ChooseVocabularyState> = _state


    init {
        val names = repository.getDictionariesNames()
        val vocabularyList = names.map {
            Vocabulary(name = it)
        }
        _state.value = state.value.copy(
            vocabularyList = vocabularyList
        )
    }

    override fun obtainEvent(event: ChooseVocabularyEvent) {
        when (event) {
            is ChooseVocabularyEvent.Next -> {
                next(navController = event.navController, context = event.context)
            }

            is ChooseVocabularyEvent.ClickVocabulary -> {
                clickVocabulary(event.vocabulary)
            }
        }
    }

    private fun next(navController : NavController, context: Context) {

        val vocabularySelected = state.value.vocabularyList.filter {
            it.isSelected
        }.map {
            it.name
        }

        if (vocabularySelected.isEmpty()){
            Toast.makeText(context, context.getString(R.string.no_chose_vocabulary), Toast.LENGTH_SHORT).show()
        }else{
            gameSettings.state.value = gameSettings.state.value.copy(
                chooseDictionaries = vocabularySelected
            )

            navController.navigate(NavigationTree.GAME_SETTINGS.name)
        }

    }

    private fun clickVocabulary(vocabulary: Vocabulary) {

        val newVocabularyList = state.value.vocabularyList.map {
            if (it != vocabulary) {
                it
            } else {
                Vocabulary(name = it.name, isSelected = !it.isSelected)
            }
        }

        _state.value = state.value.copy(
            vocabularyList = newVocabularyList
        )

    }


}