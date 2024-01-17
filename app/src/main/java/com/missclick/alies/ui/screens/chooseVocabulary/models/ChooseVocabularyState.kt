package com.missclick.alies.ui.screens.chooseVocabulary.models

import com.missclick.alies.data.models.Team
import com.missclick.alies.ui.screens.chooseVocabulary.models.Vocabulary

data class ChooseVocabularyState(
    val vocabularyList : List<Vocabulary> = listOf(),
)