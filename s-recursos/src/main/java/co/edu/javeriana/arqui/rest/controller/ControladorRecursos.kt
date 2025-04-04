package co.edu.javeriana.arqui.rest.controller

import co.edu.javeriana.arqui.rest.ejb.ServicioClinicas
import co.edu.javeriana.arqui.rest.ejb.ServicioMedicamentos
import co.edu.javeriana.arqui.rest.entity.Clinica
import co.edu.javeriana.arqui.rest.entity.Medicamento
import jakarta.ejb.EJB
import jakarta.ejb.Stateless

@Stateless
open class ControladorRecursos {

    @EJB
    private lateinit var servicioMedicamentos: ServicioMedicamentos

    @EJB
    private lateinit var servicioClinicas: ServicioClinicas

    fun registrarNuevoMedicamento(nombre: String, laboratorio: String?): Medicamento {
        val medicamento = Medicamento().apply {
            this.nombre = nombre
            this.laboratorio = laboratorio
        }
        return servicioMedicamentos.registrarMedicamento(medicamento)
    }

    fun listarMedicamentos(): List<Medicamento> {
        return servicioMedicamentos.listarMedicamentos()
    }

    fun registrarNuevaClinica(nombre: String, direccion: String?): Clinica {
        val clinica = Clinica().apply {
            this.nombre = nombre
            this.direccion = direccion
        }
        return servicioClinicas.registrarClinica(clinica)
    }

    fun listarClinicas(): List<Clinica> {
        return servicioClinicas.listarClinicas()
    }
}