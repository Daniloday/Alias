package com.missclick.alies.di


import com.google.gson.Gson
import com.missclick.alies.data.repository.Repository
import com.missclick.alies.data.repository.dictionary.LocalDictionaries
import com.missclick.alies.data.repository.team.LocalTeams
import com.missclick.alies.data.sharedStates.GameSettings
import org.koin.dsl.module

val dataModule = module {

    single { Gson() }
    single { LocalTeams(get()) }
    single { LocalDictionaries(get(), get()) }
    single { Repository(get(), get()) }
    single { GameSettings() }
}