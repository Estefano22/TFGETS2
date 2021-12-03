package com.example.fanets2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class DescripcionActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripcion)

        val  imagenDescripcion : ImageView = findViewById(R.id.imgItem)
        val  nombreDescripcion : TextView = findViewById(R.id.DSTitulo)
        val  descripcionDescripcion : TextView = findViewById(R.id.DSDescripcion)
        val  precioDescripcion : TextView = findViewById(R.id.TVPrecio)
        val  botonAñadirCarrito : Button = findViewById(R.id.Añadir_Carrito)



        botonAñadirCarrito.setOnClickListener {






        }

        val bundle = intent.extras
        bundle?.let {
            val imagen = bundle.getInt("imagen")
            val nombre = bundle.getString("nombre")
            val descripcion = bundle.getString("descripcion")
            val precio = bundle.getInt("precio")


            imagenDescripcion.setImageResource(imagen)
            nombreDescripcion.text = nombre
            descripcionDescripcion.text = descripcion
            precioDescripcion.text = precio.toString()


        }


    }

}