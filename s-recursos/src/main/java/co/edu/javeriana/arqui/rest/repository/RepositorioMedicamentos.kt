package co.edu.javeriana.arqui.rest.repository

import co.edu.javeriana.arqui.rest.entity.Medicamento
import jakarta.ejb.Stateless
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

@Stateless
open class RepositorioMedicamentos {

    @PersistenceContext(unitName = "RecursosPU")
    private lateinit var em: EntityManager

    fun crear(medicamento: Medicamento) {
        em.persist(medicamento)
    }

    fun listarTodos(): List<Medicamento> {
        val query = em.createQuery("SELECT m FROM Medicamento m", Medicamento::class.java)
        return query.resultList
    }
}