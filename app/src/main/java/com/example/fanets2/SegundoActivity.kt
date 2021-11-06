package com.example.fanets2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SegundoActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        val recycler : RecyclerView = findViewById(R.id.rvLista)
        val adapter : RecyclerViewAdapter = RecyclerViewAdapter()


        adapter.RecyclerViewAdapter(articulos(),this)

        recycler.hasFixedSize()
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

}

    private fun articulos(): MutableList<ArticuloModel> {
        var articulosModel : MutableList<ArticuloModel> = ArrayList()
        articulosModel.add(ArticuloModel("Mochila ETS 2", "Mochila de tirantes Con el logo del juego"))
        articulosModel.add(ArticuloModel("Volvo FH 13","Mochila de tirantes Con el logo del juego "))
        articulosModel.add(ArticuloModel("Palanca Cambios","Mochila de tirantes Con el logo del juego "))
        articulosModel.add(ArticuloModel("Volante Scania","Mochila de tirantes Con el logo del juego "))
        articulosModel.add(ArticuloModel("Scania clasic","Mochila de tirantes Con el logo del juego "))
        articulosModel.add(ArticuloModel("Volante G29","Mochila de tirantes Con el logo del juego "))

        return articulosModel
    }

    }
