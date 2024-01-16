package com.missclick.alies.di


import com.missclick.alies.data.repository.Repository
import org.koin.dsl.module

val dataModule = module {
    single { Repository() }
}