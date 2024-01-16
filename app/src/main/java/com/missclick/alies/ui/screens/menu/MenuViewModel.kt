package com.missclick.alies.ui.screens.menu

import androidx.lifecycle.ViewModel
import com.missclick.alies.data.repository.IRepository
import com.missclick.alies.data.repository.Repository

class MenuViewModel(val repository: Repository) : ViewModel() {


    init {
        println("init")
        println(repository.getAllTeams())
        println(repository.getDictionariesNames())
        println(repository.getWordsByDictionariesName(listOf("medium","hard")))
    }




}