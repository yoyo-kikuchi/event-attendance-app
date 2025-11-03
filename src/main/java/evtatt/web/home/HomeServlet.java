package evtatt.web.home;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Inject
    private HomeController homeController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            homeController.index(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
