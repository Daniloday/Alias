package com.missclick.alies.data.repository.dictionary



interface ILocalDictionaries {

    fun getNames() : List<String>

    fun getWordsByNames(names : List<String>) : List<String>

}