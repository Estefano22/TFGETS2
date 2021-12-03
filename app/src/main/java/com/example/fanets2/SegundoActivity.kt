package com.example.fanets2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList


class SegundoActivity: AppCompatActivity() {

    private lateinit var newRecyclerview: RecyclerView
    private var tempArrayList: ArrayList<ArticuloModel> = arrayListOf()
    private var newArrayList: ArrayList<ArticuloModel> = arrayListOf()
    lateinit var imagen: Array<Int>
    lateinit var nombre: Array<String>
    lateinit var descripcion: Array<String>
    lateinit var precio: Array<Int>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        var b = findViewById<FloatingActionButton>(R.id.botonCarrito)
        b.setOnClickListener {
            var intent = Intent(this, CarritoActivity::class.java)
            startActivity(intent)

        }



        imagen = arrayOf(
            R.drawable.volanteg29,
            R.drawable.palancacambiosets2,
            R.drawable.volvofh13,
            R.drawable.volanteets2,
            R.drawable.trackir,
            R.drawable.mochilaets2,
            R.drawable.volvofh16,
            R.drawable.camisetauno,
            R.drawable.camisetados
        )

        nombre = arrayOf(
            "Volante G29",
            "Palanca ETS 2",
            "Miniatura Volvo FH 13",
            "Volante Verdadero Scania",
            "Trackir Pro 5 ",
            "Mochila Tirantes ETS 2",
            "Miniatura Volvo FH 16",
            "Camiseta Logo ETS 2 Grande",
            "Camiseta Logo ETS 2 Pequeño"
        )

        descripcion = arrayOf(
            "Volante G29 con pedales y palanca de cambios.",
            "Pomo palanca de cambios de camion para simular ETS 2.",
            "Miniatura escala 1:43 Volvo FH 13 con pintura personalizada.",
            "Volante Verdadero Scania.",
            "Periférico para simulación virtual de videojuegos (para la cabeza).",
            "Mochila Saco Tirantes con el logo de  ETS 2.",
            "Miniatura escala 1:43 Volvo FH 16 con pintura personalizada.",
            "Camiseta Personalizada con el Logo grande de Euro Truck Simulator 2.",
            "Camiseta Personalizada con el Logo pequeño de Euro Truck Simulator 2."

        )

        precio = arrayOf(
            299,
            80,
            45,
            150,
            48,80,
            25,
            55,
            20,
            15
        )



        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)
        tempArrayList = arrayListOf<ArticuloModel>()

        getArticulodata()


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu,menu)
        val item = menu?.findItem(R.id.search_action)
        val searchView = item?.actionView as  SearchView
        searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                tempArrayList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())

                if (searchText.isNotEmpty()) {


                    newArrayList.forEach {

                        if (it.tvTitulo.lowercase(Locale.getDefault()).contains(searchText)) {

                            tempArrayList.add(it)

                        }

                    }

                    newRecyclerview.adapter?.notifyDataSetChanged()

                } else {

                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    newRecyclerview.adapter?.notifyDataSetChanged()


                }


                return false

            }


        })

        return super.onCreateOptionsMenu(menu)
    }



    private fun getArticulodata() {

        for (i in imagen.indices) {

            val articulos = ArticuloModel(imagen[i], nombre[i], descripcion[i], precio[i])
            newArrayList.add(articulos)
        }

        tempArrayList.addAll(newArrayList)


        val adapter = RecyclerViewAdapter(tempArrayList)
        newRecyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : RecyclerViewAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val item = tempArrayList[position]
                val intent = Intent(this@SegundoActivity, DescripcionActivity::class.java)
                intent.putExtra("imagen", item.imageView)
                intent.putExtra("nombre", item.tvTitulo)
                intent.putExtra("descripcion", item.tvDescripcion)
                intent.putExtra("precio", item.TVPrecio)
                startActivity(intent)

            }

        })


    }




}



