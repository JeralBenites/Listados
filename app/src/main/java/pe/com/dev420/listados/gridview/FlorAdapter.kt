package pe.com.dev420.listados.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.flor_item.view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.modelo.Flor

class FlorAdapter(val context: Context, val flores: ArrayList<Flor>): BaseAdapter() {

    override fun getItem(position: Int): Any {
        return flores[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return flores.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val itemView: View?
        val florViewHolder: FlorViewHolder?

        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.flor_item, parent, false)

            florViewHolder = FlorViewHolder(itemView)
            itemView?.tag = florViewHolder
        } else {
            itemView = convertView
            florViewHolder = itemView.tag as FlorViewHolder
        }

        val florItem = flores[position]

        florViewHolder.tvNombre.text = florItem.nombre
        florViewHolder.ivImagen.setImageResource(florItem.imagen)

        return itemView!!
    }

    class FlorViewHolder(itemView: View){
        var ivImagen = itemView.ivFlorImagen
        var tvNombre = itemView.tvFlorNombre
    }
}