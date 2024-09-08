package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.entity.Account;

import java.util.List;

public class AccountRepository {
    private EntityManager em;

    public AccountRepository(EntityManager em) {
        this.em = em;
    }

    public boolean create(Account account) {
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Account findByID(Long id) {
        return em.find(Account.class, id);
    }

    public Account findByAccountId(String accountId) {
        return em.createNamedQuery("Account.findByAccountId", Account.class)
                .setParameter("accountId", accountId)
                .getSingleResult();
    }

    public List<Account> findAll() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }
}
