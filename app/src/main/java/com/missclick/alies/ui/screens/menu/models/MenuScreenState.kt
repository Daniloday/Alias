package com.missclick.alies.ui.screens.menu.models

import com.missclick.alies.R
import com.missclick.alies.data.models.Language

data class MenuScreenState(
    val cardClose: Boolean = true,
    val currentLanguage: Language = Language("English", R.drawable.english_lang, "EN"),
    val allLanguages: List<Language> = listOf<Language>()
)