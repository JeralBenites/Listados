package pe.com.dev420.listados.listview.conviewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.empleado_item.view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.modelo.Empleado

class EmpleadoAdapter(val context: Context, val empleados: ArrayList<Empleado>): BaseAdapter() {

    override fun getItem(position: Int): Any {
        return empleados[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return empleados.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val itemView: View?
        val empleadoViewHolder: EmpleadoViewHolder?

        if(convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.empleado_item, parent, false)

            empleadoViewHolder = EmpleadoViewHolder(itemView)
            itemView?.tag = empleadoViewHolder
        } else {
            itemView = convertView
            empleadoViewHolder = itemView.tag as EmpleadoViewHolder
        }

        val empleadoItem = empleados[position]

        empleadoViewHolder.tvNombre.text = empleadoItem.nombre
        empleadoViewHolder.tvEmail.text = empleadoItem.email
        empleadoViewHolder.tvRol.text = empleadoItem.rol

        return itemView!!
    }

    class EmpleadoViewHolder(itemView: View){
        var tvNombre = itemView.tvNombre
        var tvRol = itemView.tvEmail
        var tvEmail = itemView.tvRol
    }
}