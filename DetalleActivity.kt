package com.example.materiasapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val nombre = intent.getStringExtra("nombre")
        val profesor = intent.getStringExtra("profesor")

        val tvDetalle = findViewById<TextView>(R.id.tvDetalle)
        tvDetalle.text = "Bienvenido a la materia de $nombre, dictada por el profesor $profesor."

        val btnCerrar = findViewById<Button>(R.id.btnCerrar)
        btnCerrar.setOnClickListener {
            val data = intent
            data.putExtra("respuesta", "Has visto la materia de $nombre")
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}
