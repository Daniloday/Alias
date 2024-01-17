package com.missclick.alies.data.repository


import com.missclick.alies.data.models.Team

interface IRepository {

    fun getAllTeams() : List<Team>
    fun getDictionariesNames() : List<String>

    fun getWordsByDictionariesName(names : List<String>) : List<String>

}