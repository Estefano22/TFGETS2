package com.example.fanets2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class CarritoActivity : AppCompatActivity() {

    var lista = mutableListOf<ArticuloModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carritocompra)

        val pagar = findViewById<Button>(R.id.pagar)
        val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this)

        pagar.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/es/home"))
            startActivity(i)
        }

        leerLista()


        val bundle = intent.extras
        bundle?.let {
            val imagen = bundle.getInt("imagen")
            val nombre = bundle.getString("nombre")
            val descripcion = bundle.getString("descripcion")
            val precio = bundle.getString("precio")

            nombre?.let { nombreNoNull ->
                descripcion?.let { descripcionNoNull ->
                    precio?.let {
                        var articuloRecibido = ArticuloModel(imagen, nombreNoNull, descripcionNoNull, it)
                        lista.add(articuloRecibido)
                    }
                }
            }

        }

        val myAdapter = RecyclerViewAdapter(lista)

        myAdapter.setOnItemClickListener(object :
            RecyclerViewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@CarritoActivity, "Clicked!", Toast.LENGTH_LONG)
                    .show()
            }
        })
        recycler.adapter = myAdapter
    }


    override fun onStop() {
        super.onStop()
        guardarLista()
    }

    fun guardarLista() {

        val listaString = mutableListOf<String>()
        lista.forEach {
            listaString.add(it.toJson())
        }
        with(getSharedPreferences("Prefs", Context.MODE_PRIVATE).edit()) {
            val gson = Gson()
            putString("TAG",gson.toJson(listaString))
            commit()
        }
    }

    fun leerLista(){
        val sharedPreferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
        val text = sharedPreferences.getString("TAG", "")
        val gson = Gson()
        var aaa = gson.fromJson(text, MutableList::class.java)
        aaa?.forEach {
            lista.add(ArticuloModel.fromJson(it.toString()))
        }

    }
}