package com.example.materiasapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Materia(
    val nombre: String,
    val profesor: String,
    val icono: Int
) : Parcelable
