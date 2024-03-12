package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class AT1 : AppCompatActivity() {

    private lateinit var btnOpenAT2: Button
    private lateinit var btnChangeLanguagePt: Button
    private lateinit var btnChangeLanguageEn: Button

    private var language = true // Flag para controlar o estado do idioma

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_at1)

        btnOpenAT2 = findViewById(R.id.btnOpenAT2)
        btnChangeLanguagePt = findViewById(R.id.btnChangeLanguagePt)
        btnChangeLanguageEn = findViewById(R.id.btnChangeLanguageEn)

        btnOpenAT2.setOnClickListener {
            val intent = Intent(this, AT2::class.java)
            startActivity(intent)
        }

        btnChangeLanguagePt.setOnClickListener {
            setLanguage("pt")
        }

        btnChangeLanguageEn.setOnClickListener {
            setLanguage("en")
        }
    }

    private fun setLanguage(languageCode: String) {
        language = (languageCode == "pt")
        setAppLocale(languageCode)
    }

    private fun setAppLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val configuration = resources.configuration
        configuration.setLocale(locale)

        @Suppress("DEPRECATION")
        baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
    }
}