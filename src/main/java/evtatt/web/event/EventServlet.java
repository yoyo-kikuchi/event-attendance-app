package evtatt.web.event;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

@WebServlet("/events/*")
public class EventServlet extends HttpServlet {

    @Inject
    private EventController eventController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            eventController.index(req, resp);
        } else if (pathInfo.matches("/\\d{16}")) {
            String eventIdStr = pathInfo.substring(1);
            Long eventId = Long.parseLong(eventIdStr);
            eventController.show(eventId, req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
