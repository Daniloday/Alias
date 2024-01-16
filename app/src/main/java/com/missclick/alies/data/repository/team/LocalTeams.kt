package com.missclick.alies.data.repository.team

import android.annotation.SuppressLint
import android.content.Context
import com.missclick.alies.R
import com.missclick.alies.data.models.Team

class LocalTeams(private val context : Context) : ILocalTeams {
    @SuppressLint("ResourceType")
    override fun getAll(): List<Team> {
        return listOf(
            Team(name = context.getString(R.string.lions), image = R.drawable.lion),
            Team(name = context.getString(R.string.lions), image = R.drawable.agama),
            Team(name = context.getString(R.string.lions), image = R.drawable.capybara),
            Team(name = context.getString(R.string.lions), image = R.drawable.giraffe),
            Team(name = context.getString(R.string.lions), image = R.drawable.hare),
            Team(name = context.getString(R.string.lions), image = R.drawable.hedgehog),
            Team(name = context.getString(R.string.lions), image = R.drawable.owl),
            Team(name = context.getString(R.string.lions), image = R.drawable.rhino),
            Team(name = context.getString(R.string.lions), image = R.drawable.tiger),
            Team(name = context.getString(R.string.lions), image = R.drawable.wolf),

        )
    }
}