package fitness.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests all service methods.
 */
public class FitnessServiceTest {
    FitnessService fitnessService;

    @BeforeEach()
    void setUp() {
        fitnessService = new FitnessService();
    }

    /**
     * Verifies BMR's Imperial calculations with JSON output.
     */
    @Test
    void testBMRcalculationsImperialJSON() {
       Response bmr = fitnessService.getBMRcalculations("json",160,6,34,"male","very","lbs");
        assertEquals("{\"BMR\":1565.9550000000004} calories you need each day to maintain you weight.", bmr.getEntity());
    }

    /**
     * Verifies BMR's Imperial calculations with HTML output.
     */
    @Test
    void testBMRcalculationsImperialHTML() {
        Response bmr = fitnessService.getBMRcalculations("html",160,6,34,"male","very","lbs");
        assertEquals("<h3>BMR</h3><p>BMR is 1565.9550000000004 calories you need each day to maintain you weight.</p>", bmr.getEntity());
    }

    /**
     * Verifies BMR's Metric calculations with JSON output.
     */
    @Test
    void testBMRcalculationsMetricJSON() {
        Response bmr = fitnessService.getBMRcalculations("json",85,178,34,"male","very","kg");
        assertEquals("{\"BMR\":3270.79665} calories you need each day to maintain you weight.", bmr.getEntity());
    }

    /**
     * Verifies BMR's Metric calculations with JSON output.
     */
    @Test
    void testBMRcalculationsMetricHTML() {
        Response bmr = fitnessService.getBMRcalculations("html",85,178,34,"male","very","kg");
        assertEquals("<h3>BMR</h3><p>BMR is 3270.79665 calories you need each day to maintain you weight.</p>", bmr.getEntity());
    }

    @Test
    void calculateFatProtienCarboHyderatesRequiredPerDayJson() {
        Response respone = fitnessService.calculateFatProtienCarboHyderatesRequiredPerDayJson(100, 178, 37, "m", "sed");
        assertEquals("[{\"Carbohydrates\":144,\"Fat\":64,\"Protein\":144},{\"Carbohydrates\":113,\"Fat\":50,\"Protein\":113},{\"Carbohydrates\":82,\"Fat\":36,\"Protein\":82}]"
                , respone.getEntity().toString());
    }

    @Test
    void calculateFatProtienCarboHyderatesRequiredPerDayHtml() {
        Response response = fitnessService.calculateFatProtienCarboHyderatesRequiredPerDayHtml(100, 178, 37, "m", "sed");
        assertEquals("<h3>Maintain weight</h3><table border = '1'><tbody><tr><td><b>Daily intake</b></td><td><b>grams</b><"
                , response.getEntity().toString().substring(0,100));
    }

    /**
     * Calculate Activity Calories
     */
    @Test
    void calculateActivityCaloriesBurned() {
        int caloriesBurned = fitnessService.calculateActivityCalories(5.0,30, 200);
        assertEquals(227 , caloriesBurned);
    }

    /**
     * Calculate Activity Calories burned json response.
     */
    @Test
    void calculateActivityCaloriesBurnedJSON() {
        Response respone = fitnessService.getJSONCaloriesBurned (5.0,30, 200);
        assertEquals("{\"CaloriesBurned\":227}"
                , respone.getEntity().toString());
    }

    /**
     * Calculate Activity Calories burned html response.
     */
    @Test
    void calculateActivityCaloriesBurnedHTML() {
        Response response = fitnessService.getHTMLCaloriesBurned(5.0,30, 200);
        assertEquals("<h3>Calories burned: 227</h3>"
                , response.getEntity().toString());
    }

}
