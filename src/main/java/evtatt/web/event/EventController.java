package evtatt.web.event;

import java.io.IOException;

import evtatt.repository.EventRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EventController {
    @Inject
    EventRepository repo;

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        var events = repo.findAll();
        System.out.println("=======================");
        System.out.println(events.size());

        req.getRequestDispatcher("/WEB-INF/views/event/index.jsp")
                .forward(req, resp);
    }

    public void show(Long eventId, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(eventId);
        req.getRequestDispatcher("/WEB-INF/views/event/show.jsp")
                .forward(req, resp);
    }
}
