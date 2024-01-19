package com.missclick.alies.ui.screens.menu

import androidx.lifecycle.ViewModel
import com.missclick.alies.common.EventHandler

import com.missclick.alies.data.repository.Repository
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
        _state.value = state.value.copy(
            currentLanguage = repository.getCurrentLanguage(),
            allLanguages = repository.getAllLanguages(),
        )

    }

    override fun obtainEvent(event: MenuScreenEvent) {
        when (event) {
            is MenuScreenEvent.ChangeLanguages -> {
                changeLanguages(event.languageName)
            }
            is MenuScreenEvent.OpenCloseCard -> {
                openCloseCard()
            }
        }
    }

    private fun changeLanguages(language: String) {
        repository.setNewLanguage(language)
        _state.value = state.value.copy(
            currentLanguage = repository.getCurrentLanguage(),
            allLanguages = repository.getAllLanguages()
        )
        openCloseCard()
    }

    private fun openCloseCard(){
        _state.value = state.value.copy(
             cardClose = !state.value.cardClose
        )
    }
}