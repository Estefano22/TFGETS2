package com.example.fanets2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CarritoActivity : AppCompatActivity() {
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


        val bundle = intent.extras
        bundle?.let {
            val imagen = bundle.getInt("imagen")
            val nombre = bundle.getString("nombre")
            val descripcion = bundle.getString("descripcion")
            val precio = bundle.getInt("precio")

            nombre?.let { it1 -> descripcion?.let { it2 ->
                var articulo = ArticuloModel(imagen, it1, it2, precio)

                var myAdapter = RecyclerViewAdapter(listOf(articulo))

                myAdapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(this@CarritoActivity, "Clicked!", Toast.LENGTH_LONG).show()
                    }


                })
                recycler.adapter = myAdapter

            } }

        }



    }
}