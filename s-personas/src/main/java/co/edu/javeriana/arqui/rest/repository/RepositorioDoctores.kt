package co.edu.javeriana.arqui.rest.repository

import co.edu.javeriana.arqui.rest.entity.Doctor
import jakarta.ejb.Stateless
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

@Stateless
open class RepositorioDoctores {

    @PersistenceContext(unitName = "PersonasPU")
    private lateinit var em: EntityManager

    fun crear(doctor: Doctor) {
        em.persist(doctor)
    }

    fun listarTodos(): List<Doctor> {
        val query = em.createQuery("SELECT d FROM Doctor d", Doctor::class.java)
        return query.resultList
    }
}