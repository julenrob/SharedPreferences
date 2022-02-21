package com.julenrob.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AlertDialog

class Preferencias(context: Context) {
    val PREF_NOMBRE = "MisDatos"
    val PREF_USUARIO = "default"
    val PREF_COLOR = "color"

    val pref : SharedPreferences = context.getSharedPreferences(PREF_NOMBRE, Context.MODE_PRIVATE)

    fun guardarDatos(nombre : String){
        pref.edit().putString(PREF_USUARIO, nombre).apply()
    }

    fun convertColor(color: String) : String? {

        val colores = mapOf<String, String>(
            "azul" to "#2196F3",
            "verde" to "#4CAF50",
            "rojo" to "#FFD11222",
            "amarillo" to "#FFFFEB3B",
            "negro" to "#FF000000"
        )

        if (color in colores){
            println(colores[color])
            println("Me has pasado $color y aparece en la lista, $colores.get($color)")
            return colores[color]
        } else {
            // Rosita
            return "#FFF109E5"
        }
        return "Error"
    }

    fun guardarColor(color : String){
        pref.edit().putString(PREF_COLOR, color).apply()
    }

    fun getNombre() : String {
        return pref.getString(PREF_USUARIO, "Sin datos.")!!
    }

    fun getColor() : String? {
        var col = pref.getString(PREF_COLOR, "Sin color.")
        var color = col?.let { convertColor(it) }
        return color
        //return pref.getString(PREF_COLOR, "Sin color.")!!
    }

    fun borrarValor() {
        pref.edit().remove(PREF_USUARIO).apply()
    }


}