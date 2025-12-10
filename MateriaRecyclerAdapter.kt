package com.example.materiasapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MateriaRecyclerAdapter(private val lista: ArrayList<Materia>) : RecyclerView.Adapter<MateriaRecyclerAdapter.MateriaViewHolder>() {

    class MateriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIcono: ImageView = itemView.findViewById(R.id.imgIcono)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvProfesor: TextView = itemView.findViewById(R.id.tvProfesor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_materia, parent, false)
        return MateriaViewHolder(view)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: MateriaViewHolder, position: Int) {
        val materia = lista[position]
        holder.imgIcono.setImageResource(materia.icono)
        holder.tvNombre.text = materia.nombre
        holder.tvProfesor.text = materia.profesor

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Materia: ${materia.nombre}", Toast.LENGTH_SHORT).show()
        }
    }
}
