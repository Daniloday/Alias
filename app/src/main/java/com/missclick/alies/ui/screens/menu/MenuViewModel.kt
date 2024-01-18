package com.missclick.alies.ui.screens.menu

import androidx.lifecycle.ViewModel
import com.missclick.alies.common.EventHandler

import com.missclick.alies.data.repository.Repository
import com.missclick.alies.ui.screens.gameSettingsScreen.models.GameSettingsEvent
import com.missclick.alies.ui.screens.gameSettingsScreen.models.GameSettingsTeamState
import com.missclick.alies.ui.screens.menu.models.MenuScreenEvent
import com.missclick.alies.ui.screens.menu.models.MenuScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MenuViewModel(
    val repository: Repository
) : ViewModel(), EventHandler<MenuScreenEvent> {


    private val _state: MutableStateFlow<MenuScreenState> =
        MutableStateFlow(MenuScreenState())
    val state: StateFlow<MenuScreenState> = _state


    init {

    }

    override fun obtainEvent(event: MenuScreenEvent) {
        when (event) {
            is MenuScreenEvent.changeLanguages -> {
                MenuScreenEvent.changeLanguages(event.languageName)
            }
        }
    }

    private fun changeLanguages(languages: String) {

    }
}