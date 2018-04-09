package fitness.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(
        name = "calculateActivityCaloriesServlet",
        urlPatterns = {"/calculateActivityCaloriesServlet"}
)
public class CalculateActivityCaloriesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        double met = Double.valueOf(request.getParameter("met"));
        int duration = Integer.valueOf(request.getParameter("duration"));
        int weight = Integer.valueOf(request.getParameter("weight"));
        String format = request.getParameter("format");

        //Response Parameters
        String output = "";
        Client client = ClientBuilder.newClient();
        if (format.equals("json")) {
            WebTarget target =
                    client.target("http://localhost:8080/fitness/service/cac/json/" +
                            met + "/" + duration + "/" + weight);
            output = target.request(MediaType.APPLICATION_JSON).get(String.class);
        } else if (format.equals("html")) {
            WebTarget target =
                    client.target("http://localhost:8080/fitness/service/cac/html/" +
                            met + "/" + duration + "/" + weight);
            output = target.request(MediaType.TEXT_HTML).get(String.class);
        }

        try {
            String url = "/resultActivity.jsp";
            request.setAttribute("calories", output);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
         } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}