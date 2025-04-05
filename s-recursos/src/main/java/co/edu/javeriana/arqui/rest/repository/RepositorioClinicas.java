package co.edu.javeriana.arqui.rest.repository;

import co.edu.javeriana.arqui.rest.entity.Clinica;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RepositorioClinicas {

    @PersistenceContext(unitName = "RecursosPU")
    private EntityManager em;

    public void crear(Clinica clinica) {
        em.persist(clinica);
    }

    public List<Clinica> listarTodos() {
        TypedQuery<Clinica> query = em.createQuery("SELECT c FROM Clinica c", Clinica.class);
        return query.getResultList();
    }
}
