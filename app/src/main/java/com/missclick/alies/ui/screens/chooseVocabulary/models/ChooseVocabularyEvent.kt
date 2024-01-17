package com.missclick.alies.ui.screens.chooseVocabulary.models

sealed class ChooseVocabularyEvent{
    object Next : ChooseVocabularyEvent()
    class ClickVocabulary(val vocabulary : Vocabulary) : ChooseVocabularyEvent()

}

