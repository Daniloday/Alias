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
            Team(name = context.getString(R.string.agama), image = R.drawable.agama),
            Team(name = context.getString(R.string.capybaras), image = R.drawable.capybara),
            Team(name = context.getString(R.string.giraffes), image = R.drawable.giraffe),
            Team(name = context.getString(R.string.rabbit), image = R.drawable.hare),
            Team(name = context.getString(R.string.hedgehogs), image = R.drawable.hedgehog),
            Team(name = context.getString(R.string.owls), image = R.drawable.owl),
            Team(name = context.getString(R.string.rhinos), image = R.drawable.rhino),
            Team(name = context.getString(R.string.tigers), image = R.drawable.tiger),
            Team(name = context.getString(R.string.wolves), image = R.drawable.wolf),

        )
    }
}