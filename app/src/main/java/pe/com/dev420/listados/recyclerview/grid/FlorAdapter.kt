package pe.com.dev420.listados.recyclerview.grid

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.flor_item.view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.modelo.Flor

class FlorAdapter(val flores: ArrayList<Flor>): RecyclerView.Adapter<FlorAdapter.FlorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flor_item, parent, false)
        return FlorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flores.size
    }

    override fun onBindViewHolder(holder: FlorViewHolder, position: Int) {

        val florItem = flores[position]

        holder.tvNombre.text = florItem.nombre
        holder.ivImagen.setImageResource(florItem.imagen)
    }

    class FlorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNombre = itemView.tvFlorNombre
        val ivImagen = itemView.ivFlorImagen
    }
}