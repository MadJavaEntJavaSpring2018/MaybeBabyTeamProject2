package fitness.controller;

import fitness.service.FitnessService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet controls the calculation of BMR and forward the result to BMR JSP page.
 */
@WebServlet(
        name = "calculateBMR",
        urlPatterns = {"/calculateBMR"}
)
public class BMRController extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        FitnessService fitnessService = new FitnessService();

        String format = request.getParameter("format");
        double weight = Double.valueOf(request.getParameter("weight"));
        double height = Double.valueOf(request.getParameter("height"));
        int age = Integer.valueOf(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String activity = request.getParameter("activity");
        String unit = request.getParameter("unit");

        if (format.equals("json")) {
            request.setAttribute("resultBMR", fitnessService.getBMRJson(weight, height, age, gender, activity));
        } else if (format.equals("html")) {
            request.setAttribute("resultBMR", fitnessService.getBMRHtml(weight, height, age, gender, activity));
        }

        request.setAttribute("format", format);

        String url = "/resultBMR.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
