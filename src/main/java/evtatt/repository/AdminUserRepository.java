package evtatt.repository;

import java.util.List;

import evtatt.entity.AdminUser;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class AdminUserRepository {

    @PersistenceContext(unitName = "postgresDS")
    EntityManager em;

    public List<AdminUser> findAll() {
        return em.createQuery("SELECT a FROM AdminUser a", AdminUser.class)
                .getResultList();
    }

}
