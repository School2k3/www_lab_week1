package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.entity.Log;

import java.util.List;

public class LogRepository {
    private EntityManager em;

    public LogRepository(EntityManager em) {
        this.em = em;
    }

    public boolean create(Log log) {
        try {
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Log findByID(Long id) {
        return em.find(Log.class, id);
    }

    public List<Log> findAll() {
        return em.createNamedQuery("Log.findAll").getResultList();
    }
}
