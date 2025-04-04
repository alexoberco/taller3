package co.edu.javeriana.arqui.rest.ejb

import co.edu.javeriana.arqui.rest.entity.Clinica
import co.edu.javeriana.arqui.rest.repository.RepositorioClinicas
import jakarta.ejb.EJB
import jakarta.ejb.Stateless


@Stateless
open class ServicioClinicas {

    @EJB
    private lateinit var repoClinicas: RepositorioClinicas

    fun registrarClinica(clinica: Clinica): Clinica {
        repoClinicas.crear(clinica)
        return clinica
    }

    fun listarClinicas(): List<Clinica> {
        return repoClinicas.listarTodos()
    }
}