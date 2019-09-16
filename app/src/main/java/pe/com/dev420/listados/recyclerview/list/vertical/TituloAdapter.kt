package pe.com.dev420.listados.recyclerview.list.vertical

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.titulo_item.view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.modelo.Titulo

class TituloAdapter (val titulos: ArrayList<Titulo>, var onClickItem: ((Titulo)-> Unit)? = null) :RecyclerView.Adapter<TituloAdapter.TituloViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TituloViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.titulo_item, parent, false)
        return TituloViewHolder(view)
    }

    override fun getItemCount(): Int {
      return titulos.size
    }

    override fun onBindViewHolder(holder: TituloViewHolder, position: Int) {
        val item = titulos[position]
        holder.btnTitulo.text = item.nombre
    }

    inner class TituloViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val btnTitulo = itemView.btnTitulo
        init {
            btnTitulo.setOnClickListener() {
                onClickItem?.invoke(titulos[adapterPosition])
            }
        }
    }

}