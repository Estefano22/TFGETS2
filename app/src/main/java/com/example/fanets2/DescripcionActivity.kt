package com.example.fanets2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DescripcionActivity: AppCompatActivity() {

    var imagen : Int? = null
    var nombre : String? = null
    var descripcion : String? = null
    var precio : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)

        val imagenDescripcion: ImageView = findViewById(R.id.imgItem)
        val nombreDescripcion: TextView = findViewById(R.id.DSTitulo)
        val descripcionDescripcion: TextView = findViewById(R.id.DSDescripcion)
        val precioDescripcion: TextView = findViewById(R.id.TVPrecio)
        val botonAniadirCarrito: Button = findViewById(R.id.Añadir_Carrito)
        var newArrayList: ArrayList<ArticuloModel> = arrayListOf()



        val bundle = intent.extras
        bundle?.let {
            imagen = bundle.getInt("imagen")
            nombre = bundle.getString("nombre")
            descripcion = bundle.getString("descripcion")
            precio = bundle.getInt("precio")


            imagen?.let {
                imagenDescripcion.setImageResource(it)
            }
            nombreDescripcion.text = nombre
            descripcionDescripcion.text = descripcion
            precioDescripcion.text = precio.toString()


        }


        botonAniadirCarrito.setOnClickListener {
            val intent = Intent(this@DescripcionActivity, CarritoActivity::class.java)
            intent.putExtra("imagen", imagen)
            intent.putExtra("nombre", nombre)
            intent.putExtra("descripcion", descripcion)
            intent.putExtra("precio", precio)
            startActivity(intent)




        }


    }
}
