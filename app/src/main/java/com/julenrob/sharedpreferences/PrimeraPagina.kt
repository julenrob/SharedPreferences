package com.julenrob.sharedpreferences

import android.app.Application

class PrimeraPagina : Application() {
    companion object {
        lateinit var prefs: Preferencias
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Preferencias(applicationContext)
    }
}