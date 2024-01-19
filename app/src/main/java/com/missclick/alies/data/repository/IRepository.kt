package com.missclick.alies.data.repository


import com.missclick.alies.data.models.Language
import com.missclick.alies.data.models.Team

interface IRepository {

    //teams
    fun getAllTeams() : List<Team>


    //words
    fun getDictionariesNames(languageIso: String) : List<String>

    fun getWordsByDictionariesName(names : List<String>, languageIso: String) : List<String>


    //localization
    fun getCurrentLanguage() : Language

    fun getAllLanguages() : List<Language>

    fun setNewLanguage(language: String)

}