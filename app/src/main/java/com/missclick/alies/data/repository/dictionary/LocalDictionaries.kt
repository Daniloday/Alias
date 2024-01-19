package com.missclick.alies.data.repository.dictionary

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.missclick.alies.R
import org.intellij.lang.annotations.Language
import java.io.IOException
import java.io.InputStream
import java.util.Random

class LocalDictionaries(private val context: Context, private val gson: Gson) : ILocalDictionaries {
    override fun getNames(languageIso: String): List<String> {
        val map = convertJsonToMap(languageIso)
        return map.map { it.key }
    }

    override fun getWordsByNames(names: List<String>, languageIso: String): List<String> {
        val map = convertJsonToMap(languageIso)
        val words = mutableListOf<String>()
        map.forEach {
            if (it.key in names){
                words.addAll(it.value)
            }
        }
        return words.shuffled(Random(System.currentTimeMillis()))
    }

    private fun convertJsonToMap(languageIso: String) : Map<String, List<String>> {
        val fileName = when(languageIso){
            "ru" -> R.raw.ru
            "es" -> R.raw.es
            "uk" -> R.raw.uk
            else -> R.raw.en
        }
        val dataString = loadJSONFromAsset(fileName)
        return gson.fromJson(dataString,  object : TypeToken<Map<String, List<String>>>() {}.type)
    }

    private fun loadJSONFromAsset(fileName : Int): String? {
        val json: String? = try {
            val file: InputStream = context.resources.openRawResource(fileName)
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }


}