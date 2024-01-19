package com.missclick.alies.data.repository.dictionary



interface ILocalDictionaries {

    fun getNames(languageIso: String) : List<String>

    fun getWordsByNames(names : List<String>, languageIso: String) : List<String>

}