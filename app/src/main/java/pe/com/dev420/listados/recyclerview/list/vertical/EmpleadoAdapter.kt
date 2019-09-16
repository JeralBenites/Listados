package pe.com.dev420.listados.recyclerview.list.vertical

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.empleado_item.view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.modelo.Empleado

class EmpleadoAdapter(val empleados: ArrayList<Empleado>, var onActualizarItem: ((Empleado)-> Unit)? = null, var onEliminarItem: ((Empleado, Int)-> Unit)? = null): RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder>() {

    fun agregarItem(){
        notifyItemChanged(empleados.size+1)
    }

    fun eliminarItem(empleado: Empleado, posicion: Int){
        empleados.remove(empleado)
        notifyItemRemoved(posicion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpleadoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.empleado_item, parent, false)
        return EmpleadoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return empleados.size
    }

    override fun onBindViewHolder(holder: EmpleadoViewHolder, position: Int) {

        val empleadoItem = empleados[position]

        holder.tvNombre.text = empleadoItem.nombre
        holder.tvEmail.text = empleadoItem.email
        holder.tvRol.text = empleadoItem.rol
    }

     inner class EmpleadoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNombre = itemView.tvNombre
        val tvEmail = itemView.tvEmail
        val tvRol = itemView.tvRol

        init {
            itemView.setOnClickListener {
                onActualizarItem?.invoke(empleados[adapterPosition])
            }

            itemView.setOnLongClickListener {
                onEliminarItem?.invoke(empleados[adapterPosition], adapterPosition)
                true
            }
        }
    }
}