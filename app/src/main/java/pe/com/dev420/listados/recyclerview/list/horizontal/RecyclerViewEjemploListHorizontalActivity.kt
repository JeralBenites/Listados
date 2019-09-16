package pe.com.dev420.listados.recyclerview.list.horizontal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view_ejemplo_grid.*
import pe.com.dev420.listados.R
import pe.com.dev420.listados.database.FlorDao
import pe.com.dev420.listados.recyclerview.grid.itemdecoration.SpacesItemDecoration

class RecyclerViewEjemploListHorizontalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_ejemplo_list_horizontal)

        val linearLayoutManagerHorizontal = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val dataSetFlores = FlorDao.getFloresListaPequena()

        val florAdapter = FlorAdapter(dataSetFlores)

        rvFlores.layoutManager = linearLayoutManagerHorizontal
        rvFlores.adapter = florAdapter
        rvFlores.addItemDecoration(SpacesItemDecoration(10))
    }
}
