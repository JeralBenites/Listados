package pe.com.dev420.listados.gridview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ejemplo_grid_view.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.database.FlorDao

class EjemploGridViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_grid_view)

        val dataSet = FlorDao.getFlores()

        val florAdapter = FlorAdapter(this, dataSet)

        gvFlores.adapter = florAdapter

        gvFlores.setOnItemClickListener { parent, view, position, id ->

            val flor = dataSet[position]

            Toast.makeText(this, "Click en ${flor.nombre}", Toast.LENGTH_SHORT).show()
        }

        gvFlores.setOnItemLongClickListener { parent, view, position, id ->

            val flor = dataSet[position]

            Toast.makeText(this, "Long Click en ${flor.nombre}", Toast.LENGTH_SHORT).show()

            true
        }
    }
}
