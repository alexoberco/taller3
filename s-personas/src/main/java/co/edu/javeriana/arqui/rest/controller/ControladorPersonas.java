package co.edu.javeriana.arqui.rest.controller;

import co.edu.javeriana.arqui.rest.ejb.ServicioDoctores;
import co.edu.javeriana.arqui.rest.ejb.ServicioPacientes;
import co.edu.javeriana.arqui.rest.entity.Doctor;
import co.edu.javeriana.arqui.rest.entity.Paciente;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ControladorPersonas {

    @EJB
    private ServicioPacientes servicioPacientes;

    @EJB
    private ServicioDoctores servicioDoctores;

    /** Registra un nuevo paciente delegando al servicio de pacientes */
    public Paciente registrarNuevoPaciente(String nombre, String cedula, String telefono, String apellido) {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setCedula(cedula);
        paciente.setTelefono(telefono);
        paciente.setApellido(apellido);
        return servicioPacientes.registrarPaciente(paciente);
    }


    /** Lista todos los pacientes registrados */
    public List<Paciente> listarPacientes() {
        return servicioPacientes.listarPacientes();
    }

    /** Registra un nuevo doctor delegando al servicio de doctores */
    public Doctor registrarNuevoDoctor(String nombre, String cedula, String telefono, String especialidad) {
        Doctor doctor = new Doctor();
        doctor.setNombre(nombre);
        doctor.setCedula(cedula);
        doctor.setTelefono(telefono);
        doctor.setEspecialidad(especialidad);
        return servicioDoctores.registrarDoctor(doctor);
    }


    /** Lista todos los doctores registrados */
    public List<Doctor> listarDoctores() {
        return servicioDoctores.listarDoctores();
    }
}
