package com.missclick.alies.data.repository.dictionary

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.missclick.alies.R
import java.io.IOException
import java.io.InputStream
import java.util.Random

class LocalDictionaries(private val context: Context, private val gson: Gson) : ILocalDictionaries {
    override fun getNames(): List<String> {
        val map = convertJsonToMap()
        val names = mutableListOf<String>()
        map.keys.forEach {
            names.add(it)
        }
        return names
    }

    override fun getWordsByNames(names: List<String>): List<String> {
        val map = convertJsonToMap()
        val words = mutableListOf<String>()
        map.forEach {
            if (it.key in names){
                words.addAll(it.value)
            }
        }
        return words.shuffled(Random(System.currentTimeMillis()))
    }

    private fun convertJsonToMap() : Map<String, List<String>> {
        val dataString = loadJSONFromAsset()
        return gson.fromJson(dataString,  object : TypeToken<Map<String, List<String>>>() {}.type)
    }

    private fun loadJSONFromAsset(): String? {
        val json: String? = try {
            val file: InputStream = context.resources.openRawResource(R.raw.en)
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