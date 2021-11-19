package com.example.fanets2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fanets2.R.layout.activity_tienda


class SegundoActivity: AppCompatActivity() {

    private lateinit var newRecyclerview : RecyclerView
    private  var newArrayList : ArrayList<ArticuloModel> =arrayListOf()
    lateinit var imagen : Array<Int>
    lateinit var nombre : Array<String>
    lateinit var descripcion : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_tienda)



        imagen = arrayOf(
            R.drawable.volante,
            R.drawable.palancacambiosets2,
            R.drawable.volvofh13,
            R.drawable.volanteest2,
            R.drawable.scaniaclasic,
            R.drawable.mochilaets2
        )

        nombre = arrayOf(
            "Volante",
            "Palanca ETS 2",
            "Miniatura Volvo FH 13",
            "Volante Verdadero Scania",
            "Miniatura Scania Clasic ",
            "Mochila Tirantes ETS 2"
        )

        descripcion = arrayOf(
            "Volante G29 con pedales y palanca de cambios.",
            "Pomo palanca de cambios de camion para simular ETS 2.",
            "Miniatura escala  Volvo FH 13",
            "Volante Verdadero Scania",
            "Miniatura Scania Clasic",
            "Mochila Tirantes ETS 2"

        )




        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)


        getArticulodata()

    }

    private fun getArticulodata() {

        for (i in imagen.indices){

            val articulos = ArticuloModel(imagen[i], nombre[i], descripcion[i])
            newArrayList.add(articulos)
        }

        val adapter = RecyclerViewAdapter(newArrayList)
        newRecyclerview.adapter = adapter
        adapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                newArrayList[position]
                val intent = Intent(this@SegundoActivity,DescripcionActivity::class.java)
                intent.putExtra("imagen",newArrayList[position].imageView)
                intent.putExtra("nombre",newArrayList[position].tvTitulo)
                intent.putExtra("descripcion",newArrayList[position].tvDescripcion)
                startActivity(intent)

            }

        })


    }




}
