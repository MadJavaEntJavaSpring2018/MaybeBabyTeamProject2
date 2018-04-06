package controller;

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
        urlPatterns = {"/calculateCalorieServlet"}
)

public class CalculateCalorieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double weight = Double.valueOf(request.getParameter("weight"));
        double height = Double.valueOf(request.getParameter("height"));
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String activity = request.getParameter("activity");

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/fitness/service/ccr/" +
                        weight + "/" + height + "/" + age + "/" + gender + "/" + activity);
        String output = target.request(MediaType.APPLICATION_JSON).get(String.class);
        //request.getRequestDispatcher("calender1.jsp").forward(request,response);
        PrintWriter writer = response.getWriter();
        writer.print(output);
        writer.flush();
        writer.close();
    }
}
