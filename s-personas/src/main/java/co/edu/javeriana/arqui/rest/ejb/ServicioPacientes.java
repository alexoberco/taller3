package co.edu.javeriana.arqui.rest.ejb;

import co.edu.javeriana.arqui.rest.entity.Paciente;
import co.edu.javeriana.arqui.rest.repository.RepositorioPacientes;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ServicioPacientes {

    @EJB
    private RepositorioPacientes repoPacientes;

    public Paciente registrarPaciente(Paciente paciente) {
        repoPacientes.crear(paciente);
        return paciente;
    }

    public List<Paciente> listarPacientes() {
        return repoPacientes.listarTodos();
    }
}
