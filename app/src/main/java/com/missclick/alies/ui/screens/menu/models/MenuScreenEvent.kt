package com.missclick.alies.ui.screens.menu.models

sealed class MenuScreenEvent {
    class changeLanguages(val languageName : String) : MenuScreenEvent()
}