package co.edu.javeriana.arqui.rest.repository

import co.edu.javeriana.arqui.rest.entity.Paciente
import jakarta.ejb.Stateless
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

@Stateless
open class RepositorioPacientes {

    @PersistenceContext(unitName = "PersonasPU")
    private lateinit var em: EntityManager

    fun crear(paciente: Paciente) {
        em.persist(paciente)
    }

    fun listarTodos(): List<Paciente> {
        val query = em.createQuery("SELECT p FROM Paciente p", Paciente::class.java)
        return query.resultList
    }
}