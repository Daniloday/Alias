package com.missclick.alies.data.repository.team

import com.missclick.alies.data.models.Team

interface ILocalTeams {

    fun getAll() : List<Team>
}