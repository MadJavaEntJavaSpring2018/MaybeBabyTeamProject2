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
import java.io.PrintWriter;

@WebServlet(
        name = "calculateCalorieServlet",
        urlPatterns = {"/calculateCalorieServlet"}
        )
public class CalculateCalorieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        double weight = Double.valueOf(request.getParameter("weight"));
        double height = Double.valueOf(request.getParameter("height"));
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String activity = request.getParameter("activity");
        String format = request.getParameter("format");

        //Response Parameters
        String output = "";
        Client client = ClientBuilder.newClient();
        if (format.equals("json")) {
            WebTarget target =
                    client.target("http://localhost:8080/MaybeBabyTeamProject/fitness/service/ccr/json/" +
                            weight + "/" + height + "/" + age + "/" + gender + "/" + activity);
            output = target.request(MediaType.APPLICATION_JSON).get(String.class);
        } else if (format.equals("html")) {
            WebTarget target =
                    client.target("http://localhost:8080/MaybeBabyTeamProject/fitness/service/ccr/html/" +
                            weight + "/" + height + "/" + age + "/" + gender + "/" + activity);
            output = target.request(MediaType.TEXT_HTML).get(String.class);
        }

        try {
            String url = "/resultCalorie.jsp";
            request.setAttribute("resultFPC", output);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        /*PrintWriter writer = response.getWriter();
        writer.println(request.getAttribute("resultFPC"));
        writer.println("dgfhhhf");
        writer.flush();
        writer.close();*/
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}