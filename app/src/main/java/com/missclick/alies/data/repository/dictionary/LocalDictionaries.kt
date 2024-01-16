package com.missclick.alies.data.repository.dictionary

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.missclick.alies.R
import com.missclick.alies.data.repository.entity.DictionariesEntity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class LocalDictionaries(val context: Context) : ILocalDictionaries {
    override fun getNames(): List<String> {
//        val convert = convertStringToJson()
//        val names = mutableListOf<String>()
//        convert.dictionaries.forEach {
////            names.add(it.dictionary)
//        }
        return listOf()
    }

    override fun getWordsByNames(names: List<String>): List<String> {
        return listOf()
    }

//    private fun convertStringToJson() : DictionariesEntity{
//        val dataString = loadJSONFromAsset()
//        return gson.fromJson(dataString,  object : TypeToken<Map<String, Any>>() {}.type)
//    }
//
//    private fun loadJSONFromAsset(): String? {
//        var json: String? = null
//        json = try {
//            val file: InputStream = context.resources.openRawResource(R.raw.en)
//            val size = file.available()
//            val buffer = ByteArray(size)
//            file.read(buffer)
//            file.close()
//            String(buffer, charset("UTF-8"))
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            return null
//        }
//        return json
//    }


}