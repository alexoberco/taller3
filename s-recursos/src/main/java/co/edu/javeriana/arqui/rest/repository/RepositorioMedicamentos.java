package co.edu.javeriana.arqui.rest.repository;

import co.edu.javeriana.arqui.rest.entity.Medicamento;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RepositorioMedicamentos {

    @PersistenceContext(unitName = "RecursosPU")
    private EntityManager em;

    public void crear(Medicamento medicamento) {
        em.persist(medicamento);
    }

    public List<Medicamento> listarTodos() {
        TypedQuery<Medicamento> query = em.createQuery("SELECT m FROM Medicamento m", Medicamento.class);
        return query.getResultList();
    }
}
