package com.missclick.alies.di


import com.missclick.alies.data.Repository
import org.koin.dsl.module
import java.util.Dictionary

val dataModule = module {
    single { Repository() }
}