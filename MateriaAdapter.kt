package com.example.materiasapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MateriaAdapter(private val context: Context, private val lista: ArrayList<Materia>) : BaseAdapter() {

    override fun getCount(): Int = lista.size
    override fun getItem(position: Int): Any = lista[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_materia, parent, false)
        val materia = lista[position]

        val imgIcono = view.findViewById<ImageView>(R.id.imgIcono)
        val tvNombre = view.findViewById<TextView>(R.id.tvNombre)
        val tvProfesor = view.findViewById<TextView>(R.id.tvProfesor)

        imgIcono.setImageResource(materia.icono)
        tvNombre.text = materia.nombre
        tvProfesor.text = materia.profesor

        return view
    }
}
