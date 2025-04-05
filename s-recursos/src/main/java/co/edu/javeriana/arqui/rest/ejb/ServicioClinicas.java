package co.edu.javeriana.arqui.rest.ejb;

import co.edu.javeriana.arqui.rest.entity.Clinica;
import co.edu.javeriana.arqui.rest.repository.RepositorioClinicas;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class ServicioClinicas {

    @EJB
    private RepositorioClinicas repoClinicas;

    public Clinica registrarClinica(Clinica clinica) {
        repoClinicas.crear(clinica);
        return clinica;
    }

    public List<Clinica> listarClinicas() {
        return repoClinicas.listarTodos();
    }
}
