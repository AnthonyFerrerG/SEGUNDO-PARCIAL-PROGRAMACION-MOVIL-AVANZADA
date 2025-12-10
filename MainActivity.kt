package com.example.materiasapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listaMaterias: ArrayList<Materia>
    private lateinit var listView: ListView

    private val detalleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val mensaje = result.data?.getStringExtra("respuesta")
            mensaje?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listViewMaterias)
        listaMaterias = arrayListOf(
            Materia("Matemáticas", "Juan Pérez", R.drawable.icon_math),
            Materia("Física", "María Gómez", R.drawable.icon_fisica),
            Materia("Química", "Carlos López", R.drawable.icon_quimica),
            Materia("Historia", "Ana Torres", R.drawable.icon_historia),
            Materia("Informática", "Luis Martínez", R.drawable.icon_informatica)
        )

        val adapter = MateriaAdapter(this, listaMaterias)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val materia = listaMaterias[position]
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("nombre", materia.nombre)
            intent.putExtra("profesor", materia.profesor)
            detalleLauncher.launch(intent)
        }

        val btnRecycler = findViewById<Button>(R.id.btnRecycler)
        btnRecycler.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            intent.putParcelableArrayListExtra("materias", listaMaterias)
            startActivity(intent)
        }
    }
}
