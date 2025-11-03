package evtatt.web.event;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EventController {
    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
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
