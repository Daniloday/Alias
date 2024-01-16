package com.missclick.alies.data.repository.team

import android.annotation.SuppressLint
import android.content.Context
import com.missclick.alies.R
import com.missclick.alies.data.models.Team

class LocalTeams(val context : Context) : ILocalTeams {
    @SuppressLint("ResourceType")
    override fun getAll(): List<Team> {
        return listOf(
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),

        )
    }
}