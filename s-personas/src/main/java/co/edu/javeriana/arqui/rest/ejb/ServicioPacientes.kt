package co.edu.javeriana.arqui.rest.ejb

import co.edu.javeriana.arqui.rest.entity.Paciente
import co.edu.javeriana.arqui.rest.repository.RepositorioPacientes
import jakarta.ejb.EJB
import jakarta.ejb.Stateless

@Stateless
open class ServicioPacientes {

    @EJB
    private lateinit var repoPacientes: RepositorioPacientes

    fun registrarPaciente(paciente: Paciente): Paciente {
        repoPacientes.crear(paciente)
        return paciente  // Devuelve el paciente con su ID generado
    }

    fun listarPacientes(): List<Paciente> {
        return repoPacientes.listarTodos()
    }
}