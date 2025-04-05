package co.edu.javeriana.arqui.rest.repository;

import co.edu.javeriana.arqui.rest.entity.Paciente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RepositorioPacientes {

    @PersistenceContext(unitName = "PersonasPU")
    private EntityManager em;

    public void crear(Paciente paciente) {
        em.persist(paciente);
    }

    public List<Paciente> listarTodos() {
        TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p", Paciente.class);
        return query.getResultList();
    }
}
