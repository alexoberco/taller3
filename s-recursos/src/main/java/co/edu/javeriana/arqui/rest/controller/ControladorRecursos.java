package co.edu.javeriana.arqui.rest.controller;

import co.edu.javeriana.arqui.rest.ejb.ServicioClinicas;
import co.edu.javeriana.arqui.rest.ejb.ServicioMedicamentos;
import co.edu.javeriana.arqui.rest.entity.Clinica;
import co.edu.javeriana.arqui.rest.entity.Medicamento;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ControladorRecursos {

    @EJB
    private ServicioMedicamentos servicioMedicamentos;

    @EJB
    private ServicioClinicas servicioClinicas;

    public Medicamento registrarNuevoMedicamento(String nombre, String dosis, String precio) {
        Medicamento medicamento = new Medicamento();
        medicamento.setNombre(nombre);
        medicamento.setDosis(dosis);
        medicamento.setPrecio(Double.valueOf(precio));
        return servicioMedicamentos.registrarMedicamento(medicamento);
    }


    public List<Medicamento> listarMedicamentos() {
        return servicioMedicamentos.listarMedicamentos();
    }

    public Clinica registrarNuevaClinica(String nombre, String direccion, String telefono) {
        Clinica clinica = new Clinica();
        clinica.setNombre(nombre);
        clinica.setDireccion(direccion);
        clinica.setTelefono(telefono);
        return servicioClinicas.registrarClinica(clinica);
    }


    public List<Clinica> listarClinicas() {
        return servicioClinicas.listarClinicas();
    }
}
