package co.edu.javeriana.arqui.rest.controller

import co.edu.javeriana.arqui.rest.ejb.ServicioDoctores
import co.edu.javeriana.arqui.rest.ejb.ServicioPacientes
import co.edu.javeriana.arqui.rest.entity.Doctor
import co.edu.javeriana.arqui.rest.entity.Paciente
import jakarta.ejb.EJB
import jakarta.ejb.Stateless

@Stateless
open class ControladorPersonas {

    @EJB
    private lateinit var servicioPacientes: ServicioPacientes

    @EJB
    private lateinit var servicioDoctores: ServicioDoctores

    /** Registra un nuevo paciente delegando al servicio de pacientes */
    fun registrarNuevoPaciente(nombre: String, apellido: String): Paciente {
        // Crear instancia de Paciente y asignar datos
        val paciente = Paciente().apply {
            this.nombre = nombre
            this.apellido = apellido
        }
        // Delegar persistencia al servicio
        return servicioPacientes.registrarPaciente(paciente)
    }

    /** Lista todos los pacientes registrados */
    fun listarPacientes(): List<Paciente> {
        return servicioPacientes.listarPacientes()
    }

    /** Registra un nuevo doctor delegando al servicio de doctores */
    fun registrarNuevoDoctor(nombre: String, especialidad: String): Doctor {
        val doctor = Doctor().apply {
            this.nombre = nombre
            this.especialidad = especialidad
        }
        return servicioDoctores.registrarDoctor(doctor)
    }

    /** Lista todos los doctores registrados */
    fun listarDoctores(): List<Doctor> {
        return servicioDoctores.listarDoctores()
    }
}