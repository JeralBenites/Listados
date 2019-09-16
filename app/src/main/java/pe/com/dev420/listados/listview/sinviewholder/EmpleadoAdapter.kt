package pe.com.dev420.listados.listview.sinviewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.empleado_item.view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.modelo.Empleado

class EmpleadoAdapter(val context: Context, val empleados: ArrayList<Empleado>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val viewItem = inflater.inflate(R.layout.empleado_item, parent, false)

        val tvNombre = viewItem.tvNombre
        val tvEmail = viewItem.tvEmail
        val tvRol = viewItem.tvRol

        val empleadoItem = empleados[position]

        tvNombre.text = empleadoItem.nombre
        tvEmail.text = empleadoItem.email
        tvRol.text = empleadoItem.rol

        return viewItem
    }

    override fun getItem(position: Int): Any {
        return empleados[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return empleados.size
    }
}