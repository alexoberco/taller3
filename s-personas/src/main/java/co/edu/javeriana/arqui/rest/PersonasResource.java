package co.edu.javeriana.arqui.rest;

import co.edu.javeriana.arqui.rest.controller.ControladorPersonas;
import co.edu.javeriana.arqui.rest.entity.Paciente;
import co.edu.javeriana.arqui.rest.entity.Doctor;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/personas")
public class PersonasResource {

    @EJB
    private ControladorPersonas controlador;

    // Endpoints para Pacientes (agregar campos como cédula y teléfono si la entidad lo admite)
    @GET
    @Path("/pacientes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> getPacientes() {
        return controlador.listarPacientes();
    }

    @POST
    @Path("/pacientes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente registrarPaciente(Map<String, String> data) {
        String nombre = data.getOrDefault("nombre", "");
        String cedula = data.getOrDefault("cedula", "");
        String telefono = data.getOrDefault("telefono", "");
        String apellido = data.getOrDefault("apellido", "");
        return controlador.registrarNuevoPaciente(nombre, cedula, telefono, apellido);
    }

    // Endpoints para Doctores
    @GET
    @Path("/doctores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getDoctores() {
        return controlador.listarDoctores();
    }

    @POST
    @Path("/doctores")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Doctor registrarDoctor(Map<String, String> data) {
        String nombre = data.getOrDefault("nombre", "");
        String cedula = data.getOrDefault("cedula", "");
        String telefono = data.getOrDefault("telefono", "");
        String especialidad = data.getOrDefault("especialidad", "");
        return controlador.registrarNuevoDoctor(nombre, cedula, telefono, especialidad);
    }
}
