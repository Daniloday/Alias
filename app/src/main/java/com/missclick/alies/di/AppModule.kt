package com.missclick.alies.di


import com.missclick.alies.ui.screens.chooseTeam.ChooseTeamViewModel
import com.missclick.alies.ui.screens.chooseVocabulary.ChooseVocabularyViewModel
import com.missclick.alies.ui.screens.gameScreen.GameViewModel
import com.missclick.alies.ui.screens.gameSettingsScreen.GameSettingsViewModel
import com.missclick.alies.ui.screens.menu.MenuViewModel
import com.missclick.alies.ui.screens.prepareForGame.PrepareForGameViewModel
import com.missclick.alies.ui.screens.roundResultScreen.RoundResultScreenViewModel
import com.missclick.alies.ui.screens.tapToStart.TapToStartViewModel
import com.missclick.alies.ui.screens.teamResultScreen.TeamResultScreenViewModel
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
    viewModel {
        PrepareForGameViewModel(get())
    }
    viewModel{
        GameSettingsViewModel(get())
    }
    viewModel {
        TapToStartViewModel(get(), get(), get())
    }
    viewModel {
        TeamResultScreenViewModel(get())
    }
    viewModel {
        RoundResultScreenViewModel(get())
    }
    viewModel{
        GameViewModel(get(),get())
    }

}

