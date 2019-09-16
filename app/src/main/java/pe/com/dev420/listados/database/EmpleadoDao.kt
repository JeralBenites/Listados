package pe.com.dev420.listados.database

import pe.com.dev420.listados.modelo.Empleado

object EmpleadoDao {

    fun getListaEmpleados(): ArrayList<Empleado>{
        val empleados = ArrayList<Empleado>()

        for(i in 1..5000){
            val empleado = Empleado(
                    "Bot Nª $i",
                    "developer",
                    "bot$i@dev420.com")
            empleados.add(empleado)
        }

        return empleados
    }
}