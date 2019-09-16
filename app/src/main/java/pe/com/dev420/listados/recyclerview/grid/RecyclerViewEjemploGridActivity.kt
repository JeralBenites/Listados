package pe.com.dev420.listados.recyclerview.grid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_ejemplo_grid.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.database.FlorDao
import pe.com.dev420.listados.recyclerview.grid.itemdecoration.SpacesItemDecoration

class RecyclerViewEjemploGridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_ejemplo_grid)

        val gridLayoutManager = GridLayoutManager(this, 3)

        val dataSetFlores = FlorDao.getFlores()

        val florAdapter = FlorAdapter(dataSetFlores)

        rvFlores.layoutManager =gridLayoutManager
        rvFlores.adapter = florAdapter
        rvFlores.addItemDecoration(SpacesItemDecoration(10))
    }
}
