package pe.com.dev420.listados.database

import pe.com.dev420.listados.modelo.Titulo

object TituloDao {

    fun getListaTitulos(): ArrayList<Titulo>{
        val titulo = ArrayList<Titulo>()
        titulo.add(Titulo(1, "Ejemplo de Listview"))
        titulo.add(Titulo(2, "Ejemplo de Listview con ViewHolder"))
        titulo.add(Titulo(3, "Ejemplo de GridvIEW con ViewHolder"))
        titulo.add(Titulo(4, "RecyclerView - List - VERTICAL"))
        titulo.add(Titulo(5, "RecyclerView - List - Horizontal"))
        titulo.add(Titulo(6, "RecyclerView - Grid"))
        return titulo
    }
}