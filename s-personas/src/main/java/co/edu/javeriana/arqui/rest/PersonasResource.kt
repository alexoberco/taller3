package co.edu.javeriana.arqui.rest

import co.edu.javeriana.arqui.rest.controller.ControladorPersonas
import co.edu.javeriana.arqui.rest.entity.Paciente
import jakarta.ejb.EJB
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.core.MediaType

@Path("/personas")
open class PersonasResource {

    @EJB
    private lateinit var controlador: ControladorPersonas

    @GET
    @Path("/pacientes")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPacientes(): List<Paciente> {
        return controlador.listarPacientes()
    }

    @POST
    @Path("/pacientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun registrarPaciente(data: Map<String, String>): Paciente {
        return controlador.registrarNuevoPaciente(
            nombre = data["nombre"] ?: "",
            apellido = data["apellido"] ?: ""
        )
    }
}
