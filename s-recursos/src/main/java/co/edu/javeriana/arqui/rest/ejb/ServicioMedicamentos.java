package co.edu.javeriana.arqui.rest.ejb;

import co.edu.javeriana.arqui.rest.entity.Medicamento;
import co.edu.javeriana.arqui.rest.repository.RepositorioMedicamentos;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ServicioMedicamentos {

    @EJB
    private RepositorioMedicamentos repoMedicamentos;

    public Medicamento registrarMedicamento(Medicamento medicamento) {
        repoMedicamentos.crear(medicamento);
        return medicamento;
    }

    public List<Medicamento> listarMedicamentos() {
        return repoMedicamentos.listarTodos();
    }
}
