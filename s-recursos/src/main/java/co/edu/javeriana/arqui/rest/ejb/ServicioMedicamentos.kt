package co.edu.javeriana.arqui.rest.ejb

import co.edu.javeriana.arqui.rest.entity.Medicamento
import co.edu.javeriana.arqui.rest.repository.RepositorioMedicamentos
import jakarta.ejb.EJB
import jakarta.ejb.Stateless

@Stateless
open class ServicioMedicamentos {

    @EJB
    private lateinit var repoMedicamentos: RepositorioMedicamentos

    fun registrarMedicamento(medicamento: Medicamento): Medicamento {
        repoMedicamentos.crear(medicamento)
        return medicamento
    }

    fun listarMedicamentos(): List<Medicamento> {
        return repoMedicamentos.listarTodos()
    }
}