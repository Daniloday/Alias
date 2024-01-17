package com.missclick.alies.ui.screens.chooseVocabulary

import androidx.lifecycle.ViewModel
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.repository.Repository
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyEvent
import com.missclick.alies.ui.screens.chooseVocabulary.models.ChooseVocabularyState
import com.missclick.alies.ui.screens.chooseVocabulary.models.Vocabulary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChooseVocabularyViewModel(
    repository: Repository,
    private val gameSettings: GameSettings
) : ViewModel(), EventHandler<ChooseVocabularyEvent> {

    private val _state : MutableStateFlow<ChooseVocabularyState>
        = MutableStateFlow(ChooseVocabularyState())
    val state : StateFlow<ChooseVocabularyState> = _state


    init {
        val names = repository.getDictionariesNames()
        val vocabularyList = mutableListOf<Vocabulary>()
        names.forEach {
            vocabularyList.add(
                Vocabulary(
                it
            )
            )
        }
        _state.value = state.value.copy(
            vocabularyList = vocabularyList
        )
    }

    override fun obtainEvent(event: ChooseVocabularyEvent) {
        when(event){
            is ChooseVocabularyEvent.Next -> { next() }
            is ChooseVocabularyEvent.ClickVocabulary -> {clickVocabulary(event.vocabulary)}
        }
    }

    private fun next(){
        val vocabularies = mutableListOf<String>()
        state.value.vocabularyList.forEach {
            if (it.isSelected) vocabularies.add(it.name)
        }
        gameSettings.state.value = gameSettings.state.value.copy(
            chooseDictionaries = vocabularies
        )
    }

    private fun clickVocabulary(vocabulary: Vocabulary) {
        val newVocabularyList = mutableListOf<Vocabulary>()

        state.value.vocabularyList.forEach {
            if (it != vocabulary){
                newVocabularyList.add(it)
            }else{
                newVocabularyList.add(
                    Vocabulary(name = it.name, isSelected = !it.isSelected)
                )
            }
        }

        _state.value = state.value.copy(
            vocabularyList = newVocabularyList
        )
    }


}