package co.edu.javeriana.arqui.rest;

import co.edu.javeriana.arqui.rest.controller.ControladorRecursos;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/recursos")
public class RecursosResource {

    @EJB
    private ControladorRecursos controlador;

    // Medicamentos
    @GET
    @Path("/medicamentos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> getMedicamentos() {
        return controlador.listarMedicamentos();
    }

    @POST
    @Path("/medicamentos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object registrarMedicamento(Map<String, String> data) {
        String nombre = data.getOrDefault("nombre", "");
        String dosis = data.getOrDefault("dosis", "");
        String precio = data.getOrDefault("precio", "");
        // Actualiza el método en el controlador para registrar el medicamento con dosis y precio
        return controlador.registrarNuevoMedicamento(nombre, dosis, precio);
        // O adapta el método para recibir estos campos de forma separada
    }

    // Clínicas
    @GET
    @Path("/clinicas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<?> getClinicas() {
        return controlador.listarClinicas();
    }

    @POST
    @Path("/clinicas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object registrarClinica(Map<String, String> data) {
        String nombre = data.getOrDefault("nombre", "");
        String direccion = data.getOrDefault("direccion", "");
        String telefono = data.getOrDefault("telefono", "");
        return controlador.registrarNuevaClinica(nombre, direccion ,telefono);
    }
}
