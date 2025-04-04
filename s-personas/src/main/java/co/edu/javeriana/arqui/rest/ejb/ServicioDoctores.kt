package co.edu.javeriana.arqui.rest.ejb

import co.edu.javeriana.arqui.rest.entity.Doctor
import co.edu.javeriana.arqui.rest.repository.RepositorioDoctores
import jakarta.ejb.EJB
import jakarta.ejb.Stateless


@Stateless
open class ServicioDoctores {

    @EJB
    private lateinit var repoDoctores: RepositorioDoctores

    fun registrarDoctor(doctor: Doctor): Doctor {
        repoDoctores.crear(doctor)
        return doctor
    }

    fun listarDoctores(): List<Doctor> {
        return repoDoctores.listarTodos()
    }
}