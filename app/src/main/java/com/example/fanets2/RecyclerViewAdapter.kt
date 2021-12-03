package com.example.fanets2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView



class RecyclerViewAdapter(private val  newList : ArrayList<ArticuloModel>) : RecyclerView.Adapter<RecyclerViewAdapter.MyviewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val intemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view,parent,false)
        return MyviewHolder(intemView,mListener)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val currentItem = newList[position]
        holder.imageView.setImageResource(currentItem.imageView)
        holder.tvTitulo.text = currentItem.tvTitulo
        holder.tvDescripcion.text = currentItem.tvDescripcion
        holder.TVPrecio.text = currentItem.TVPrecio.toString()
        holder.layaoutPrincipal.setOnClickListener { mListener.onItemClick(position) }

    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class MyviewHolder(intemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(intemView){

        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val tvTitulo : TextView = intemView.findViewById(R.id.tvTitulo)
        val tvDescripcion : TextView = intemView.findViewById(R.id.tvDescripcion)
        val TVPrecio : TextView = intemView.findViewById(R.id.TVPrecio)
        val layaoutPrincipal : LinearLayout = intemView.findViewById(R.id.layout_principal)

    }


}





