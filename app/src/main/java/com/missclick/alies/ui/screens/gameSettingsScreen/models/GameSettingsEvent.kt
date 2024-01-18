package com.missclick.alies.ui.screens.gameSettingsScreen.models



sealed class GameSettingsEvent{
    object Next : GameSettingsEvent()
    class ChangeTime(val up : Boolean) : GameSettingsEvent()
    class ChangeGoal(val up : Boolean) : GameSettingsEvent()
}