package co.edu.javeriana.arqui.rest.repository;

import co.edu.javeriana.arqui.rest.entity.Doctor;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RepositorioDoctores {

    @PersistenceContext(unitName = "PersonasPU")
    private EntityManager em;

    public void crear(Doctor doctor) {
        em.persist(doctor);
    }

    public List<Doctor> listarTodos() {
        TypedQuery<Doctor> query = em.createQuery("SELECT d FROM Doctor d", Doctor.class);
        return query.getResultList();
    }
}
