package com.julenrob.sharedpreferences

import android.app.AlertDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.julenrob.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var pref: Preferencias

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var view = binding.root
        pref = Preferencias(applicationContext)

        binding.buttonGuardar.setOnClickListener {
            guardarDatos()
        }
        binding.buttonMostrar.setOnClickListener {
            mostrarValor(pref.getNombre())
            mostrarColor(pref.getColor(), binding.root)
        }
        binding.buttonBorrar.setOnClickListener {
            pref.borrarValor()
        }
    }

    private fun mostrarColor(color: String?, view: View) {
        var colorColor : Int = Color.parseColor(color)
        view.setBackgroundColor(colorColor)
    }


    private fun guardarDatos() {
        if (binding.et1.text.toString().isNotEmpty()) {
            pref.guardarDatos(binding.et1.text.toString())
        }

        if (binding.et2.text.toString().isNotEmpty()) {
            pref.guardarColor(binding.et2.text.toString())
        }
    }

    private fun mostrarValor(message: String){
        val alerta = AlertDialog.Builder(this)
        alerta.setTitle(pref.PREF_NOMBRE)
        alerta.setMessage(message)
        val dialogo = alerta.create()
        dialogo.show()
    }
}