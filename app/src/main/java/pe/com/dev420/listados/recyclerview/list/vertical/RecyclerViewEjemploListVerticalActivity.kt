package pe.com.dev420.listados.recyclerview.list.vertical

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_recycler_view_ejemplo_list_vertical.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.database.EmpleadoDao

class RecyclerViewEjemploListVerticalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_ejemplo_list_vertical)

        val dataSet = EmpleadoDao.getListaEmpleados()

        val adapterRecyclerView = EmpleadoAdapter(dataSet)

        adapterRecyclerView.onActualizarItem = { empleado ->
            Toast.makeText(this, " ${empleado.nombre} fue actualizado", Toast.LENGTH_LONG).show()
        }

        adapterRecyclerView.onEliminarItem = { empleado, posicion ->
            Toast.makeText(this, " ${empleado.nombre} fue eliminado", Toast.LENGTH_LONG).show()

            adapterRecyclerView.eliminarItem(empleado, posicion)
        }

        rvEmpleados.layoutManager = LinearLayoutManager(this)
        rvEmpleados.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvEmpleados.adapter = adapterRecyclerView
    }
}
