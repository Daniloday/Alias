package com.missclick.alies.data.repository


import com.missclick.alies.data.models.Language
import com.missclick.alies.data.models.Team
import com.missclick.alies.data.repository.dictionary.LocalDictionaries
import com.missclick.alies.data.repository.localization.Localization
import com.missclick.alies.data.repository.team.LocalTeams

class Repository(
    private val localDictionaries: LocalDictionaries,
    private val localTeams: LocalTeams,
    private val localization: Localization
) : IRepository {

    override fun getAllTeams(): List<Team> {
        val s = setOf<String>("")
        return localTeams.getAll()
    }

    override fun getDictionariesNames(): List<String> {
        return localDictionaries.getNames()
    }

    override fun getWordsByDictionariesName(names: List<String>): List<String> {
        return localDictionaries.getWordsByNames(names)
    }

    override fun getCurrentLanguage(): Language {
        return localization.getCurrent()
    }

    override fun getAllLanguages(): List<Language> {
        return localization.getAll()
    }

    override fun setNewLanguage(language: String) {
        localization.setNewLanguage(language)
    }


}