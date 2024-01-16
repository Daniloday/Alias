package com.missclick.alies.data.repository.dictionary

import android.provider.UserDictionary

interface ILocalDictionaries {

    fun getNames() : List<String>

    fun getWordsByNames(names : List<String>) : List<String>

}