package com.missclick.alies.ui.screens.chooseTeam.models

import android.content.Context
import androidx.navigation.NavController
import com.missclick.alies.data.models.Team

sealed class ChooseTeamEvent{
    class Next(val navController: NavController) : ChooseTeamEvent()
    class TeamAllClick(val item : Team) : ChooseTeamEvent()
    class TeamChoseClick(val item : Team) : ChooseTeamEvent()
}

