package pe.com.dev420.listados.listview.conviewholder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ejemplo_list_view_view_holder.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.database.EmpleadoDao
import pe.com.dev420.listados.modelo.Empleado

class EjemploListViewViewHolderActivity : AppCompatActivity(), AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private lateinit var dataSet: ArrayList<Empleado>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_list_view_view_holder)

        dataSet = EmpleadoDao.getListaEmpleados()

        val adapterSinViewHolder = EmpleadoAdapter(this, dataSet)

        lvEmpleados.adapter = adapterSinViewHolder
        lvEmpleados.onItemClickListener = this
        lvEmpleados.onItemLongClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val empleado = dataSet[position]

        Toast.makeText(this, "Click en ${empleado.nombre}", Toast.LENGTH_SHORT).show()
    }

    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {

        val empleado = dataSet[position]

        Toast.makeText(this, "Long Click en ${empleado.nombre}", Toast.LENGTH_SHORT).show()

        return true
    }
}
