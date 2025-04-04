package co.edu.javeriana.arqui.rest.repository

import co.edu.javeriana.arqui.rest.entity.Clinica
import jakarta.ejb.Stateless
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

@Stateless
open class RepositorioClinicas {

    @PersistenceContext(unitName = "RecursosPU")
    private lateinit var em: EntityManager

    fun crear(clinica: Clinica) {
        em.persist(clinica)
    }

    fun listarTodos(): List<Clinica> {
        val query = em.createQuery("SELECT c FROM Clinica c", Clinica::class.java)
        return query.resultList
    }
}