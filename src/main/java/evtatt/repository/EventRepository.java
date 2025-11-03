package evtatt.repository;

import java.util.List;

import evtatt.entity.Event;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class EventRepository {

    @PersistenceContext(unitName = "postgresDS")
    EntityManager em;

    public List<Event> findAll() {
        return em.createQuery("SELECT e FROM Event e", Event.class)
                .getResultList();
    }

}
