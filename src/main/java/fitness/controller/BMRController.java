package fitness.controller;

import fitness.service.FitnessService;

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
    }

}
