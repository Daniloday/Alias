package com.missclick.alies.data.repository.localization

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.missclick.alies.R
import com.missclick.alies.data.models.Language
import java.util.Locale


class Localization(val context: Context) : ILocalization {

    private val localizationPref = "localization"

    private val sharedPreferences by lazy { context.getSharedPreferences("pref",0) }
    override fun getCurrent(): Language {

        val savedLanguageIso = sharedPreferences.getString(localizationPref, null)

        if (savedLanguageIso != null){
            return languages[savedLanguageIso] ?: languages["en"]!!
        }

        val locale = Locale.getDefault().language
        if (locale in languages.keys){
            sharedPreferences.edit().putString(localizationPref, locale).apply()
            return languages[locale] ?: languages["en"]!!
        }
        return languages["en"]!!
    }

    override fun getAll(): List<Language> {
        val currentLanguage = getCurrent()
        return languages.values.sortedBy { it.isoCode == currentLanguage.isoCode }.reversed()
    }

    override fun setNewLanguage(language: String) {

        val isoCode = languages.filter { it.value.name == language }.keys.first()

        sharedPreferences.edit().putString(localizationPref, isoCode).apply()

        val locale = Locale(isoCode)
        Locale.setDefault(locale)
        val resources: Resources = context.resources
        val config: Configuration = context.resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }


    private val languages by lazy{
        mapOf(
            "en" to Language(name = "English", image = R.drawable.english_lang, isoCode = "en"),
            "uk" to Language(name = "Українська", image = R.drawable.ukraine_lang, isoCode = "uk"),
            "ru" to Language(name = "Русский", image = R.drawable.russian_lang, isoCode = "ru"),
            "es" to Language(name = "Español", image = R.drawable.spanish_lang, isoCode = "es"),
        )
    }






}