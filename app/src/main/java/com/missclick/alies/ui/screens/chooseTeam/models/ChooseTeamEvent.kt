package com.missclick.alies.ui.screens.chooseTeam.models

import com.missclick.alies.data.models.Team
import java.util.Objects

sealed class ChooseTeamEvent{
    object Next : ChooseTeamEvent()
    class TeamClick(val item : Team) : ChooseTeamEvent()
}
