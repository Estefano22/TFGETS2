package com.example.fanets2

import com.google.gson.Gson

data class ArticuloModel(var imageView: Int, var tvTitulo:String, var tvDescripcion: String, var TVPrecio: String ) {

    companion object {
        fun fromJson(json : String): ArticuloModel {
            val gson = Gson()
            return gson.fromJson(json, ArticuloModel::class.java)
        }
    }

    fun toJson() : String {
        val gson = Gson()
        return gson.toJson(this)
    }
}
