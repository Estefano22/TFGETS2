package com.example.fanets2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    var articulos : MutableList<ArticuloModel> = ArrayList()
    lateinit var context: Context

    fun RecyclerViewAdapter(articulos:MutableList<ArticuloModel>,context:Context){
        this.articulos = articulos
        this.context = context
    }

val imagenes = intArrayOf(R.drawable.mochilaets2,
    R.drawable.palancacambiosets2,
    R.drawable.scaniaclasic,
    R.drawable.volante,
    R.drawable.volanteest2,
    R.drawable.volvofh13)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imagen.setImageResource(imagenes[position])
        holder.nombre.text = articulos[position].nombre
        holder.descripcion.text = articulos[position].descripcion
    }

    override fun getItemCount() = articulos.size

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val imagen:ImageView
        val nombre:TextView
        val descripcion:TextView

        init {
            imagen = view.findViewById(R.id.imgItem)
            nombre = view.findViewById(R.id.tvTitulo)
            descripcion = view.findViewById(R.id.tvDescripcion)
        }
    }

}


