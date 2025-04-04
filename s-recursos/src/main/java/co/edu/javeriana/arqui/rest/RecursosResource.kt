package co.edu.javeriana.arqui.rest

import co.edu.javeriana.arqui.rest.controller.ControladorRecursos
import jakarta.ejb.EJB
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.core.MediaType

@Path("/recursos")
open class RecursosResource {

    @EJB
    private lateinit var controlador: ControladorRecursos

    @GET
    @Path("/medicamentos")
    @Produces(MediaType.APPLICATION_JSON)
    fun getMedicamentos() = controlador.listarMedicamentos()

    @POST
    @Path("/medicamentos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun registrarMedicamento(medicamento: Map<String, String>) =
        controlador.registrarNuevoMedicamento(
            nombre = medicamento["nombre"] ?: "",
            laboratorio = medicamento["laboratorio"]
        )

    @GET
    @Path("/clinicas")
    @Produces(MediaType.APPLICATION_JSON)
    fun getClinicas() = controlador.listarClinicas()

    @POST
    @Path("/clinicas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun registrarClinica(clinica: Map<String, String>) =
        controlador.registrarNuevaClinica(
            nombre = clinica["nombre"] ?: "",
            direccion = clinica["direccion"]
        )
}
