package com.missclick.alies.ui.screens.menu.models

sealed class MenuScreenEvent {
    class ChangeLanguages(val languageName : String) : MenuScreenEvent()
    object OpenCloseCard : MenuScreenEvent()
}