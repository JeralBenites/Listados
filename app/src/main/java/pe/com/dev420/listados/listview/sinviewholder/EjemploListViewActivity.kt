package pe.com.dev420.listados.listview.sinviewholder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ejemplo_list_view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.database.EmpleadoDao

class EjemploListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_list_view)

        val dataSet = EmpleadoDao.getListaEmpleados()

        val adapterSinViewHolder = EmpleadoAdapter(this, dataSet)

        lvEmpleados.adapter = adapterSinViewHolder
    }

    override fun onStop() {
        super.onStop()
        System.gc()
    }
}
