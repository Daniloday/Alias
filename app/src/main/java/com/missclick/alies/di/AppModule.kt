package com.missclick.alies.di


import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamViewModel
import com.missclick.alies.ui.screens.chooseVocabulary.ChooseVocabularyViewModel
import com.missclick.alies.ui.screens.menu.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MenuViewModel(get())
    }
    viewModel {
        ChooseTeamViewModel(get(),get())
    }
    viewModel {
        ChooseVocabularyViewModel(get(), get())
    }

}

