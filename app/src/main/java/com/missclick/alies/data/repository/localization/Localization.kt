package com.missclick.alies.data.repository.localization

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.missclick.alies.R
import com.missclick.alies.data.models.Language
import java.util.Locale


class Localization(val context: Context) : ILocalization {

    private val localizationPref = "localization"

    private val sharedPreferences = context.getSharedPreferences("pref",0)
    override fun getCurrent(): Language {

        val savedLanguageIso = sharedPreferences.getString(localizationPref, null)
        val languageDictionary = getIsoLanguageDictionary()

        if (savedLanguageIso != null){
            return languageDictionary[savedLanguageIso] ?: languageDictionary["en"]!!
        }
        val locale = Locale.getDefault().language
        if (locale in languageDictionary.keys){
            sharedPreferences.edit().putString(localizationPref, locale).apply()
            return languageDictionary[locale] ?: languageDictionary["en"]!!
        }
        return languageDictionary["en"]!!
    }

    override fun getAll(): List<Language> {
        val languageDictionary = getIsoLanguageDictionary()
        val currentLanguage = getCurrent()
        val languageList = languageDictionary.values.toMutableList()
        languageList.remove(currentLanguage)
        languageList.add(0, currentLanguage)
        return languageList
    }

    override fun setNewLanguage(language: String) {
        val languageDictionary = getIsoLanguageDictionary()

        val isoCode = languageDictionary.filter { it.value.name == language }.keys.first()
        println("set new lang $isoCode")
        println(language)
        sharedPreferences.edit().putString(localizationPref, isoCode).apply()
        val locale = Locale(isoCode)
        Locale.setDefault(locale)
        val resources: Resources = context.resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    private fun getIsoLanguageDictionary() : Map<String, Language>{
        return mapOf(
            "en" to Language(name = "English", image = R.drawable.english_lang, isoCode = "en"),
            "uk" to Language(name = "Українська", image = R.drawable.ukraine_lang, isoCode = "uk"),
            "ru" to Language(name = "Русский", image = R.drawable.russian_lang, isoCode = "ru"),
            "es" to Language(name = "Español", image = R.drawable.spanish_lang, isoCode = "es"),
        )
    }




}