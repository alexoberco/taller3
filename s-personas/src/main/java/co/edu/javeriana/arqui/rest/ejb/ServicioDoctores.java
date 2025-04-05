package co.edu.javeriana.arqui.rest.ejb;

import co.edu.javeriana.arqui.rest.entity.Doctor;
import co.edu.javeriana.arqui.rest.repository.RepositorioDoctores;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ServicioDoctores {

    @EJB
    private RepositorioDoctores repoDoctores;

    public Doctor registrarDoctor(Doctor doctor) {
        repoDoctores.crear(doctor);
        return doctor;
    }

    public List<Doctor> listarDoctores() {
        return repoDoctores.listarTodos();
    }
}
