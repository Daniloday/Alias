package com.missclick.alies.data.repository.localization

import com.missclick.alies.data.models.Language

interface ILocalization {

    fun getCurrent() : Language

    fun getAll() : List<Language>

    fun setNewLanguage(language: String)
}