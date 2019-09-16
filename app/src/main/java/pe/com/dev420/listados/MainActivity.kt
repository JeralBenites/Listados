package pe.com.dev420.listados

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pe.com.dev420.listados.database.TituloDao
import pe.com.dev420.listados.gridview.EjemploGridViewActivity
import pe.com.dev420.listados.listview.conviewholder.EjemploListViewViewHolderActivity
import pe.com.dev420.listados.listview.sinviewholder.EjemploListViewActivity
import pe.com.dev420.listados.recyclerview.grid.RecyclerViewEjemploGridActivity
import pe.com.dev420.listados.recyclerview.list.horizontal.RecyclerViewEjemploListHorizontalActivity
import pe.com.dev420.listados.recyclerview.list.vertical.RecyclerViewEjemploListVerticalActivity
import pe.com.dev420.listados.recyclerview.list.vertical.TituloAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSet = TituloDao.getListaTitulos()
        val adapterRecyclerView = TituloAdapter(dataSet)
        adapterRecyclerView.onClickItem = { titulo ->

            when(titulo.id) {
                1 -> {
                    val intent = Intent(this, EjemploListViewActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this, EjemploListViewViewHolderActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this, EjemploGridViewActivity::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this, RecyclerViewEjemploListVerticalActivity::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val intent = Intent(this, RecyclerViewEjemploListHorizontalActivity::class.java)
                    startActivity(intent)
                }
                6 -> {
                    val intent = Intent(this, RecyclerViewEjemploGridActivity::class.java)
                    startActivity(intent)
                }
                else -> println("Dev420 MotherFvcker !!!")
            }
        }
        rvTitulos.layoutManager = LinearLayoutManager(this)
        rvTitulos.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvTitulos.adapter = adapterRecyclerView
    }
}
