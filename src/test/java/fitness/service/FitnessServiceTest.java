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
        assertEquals("<html><head><title>Fat Protein Carbohydrates Result Page</title></head><body><p><h3>Maintain weight<"
                , response.getEntity().toString().substring(0,100));
    }

    /**
     * Calculate Activity Calories
     */
    @Test
    void calculateActivityCaloriesBurned() {
        int caloriesBurned = fitnessService.calculateActivityCaloriesBurned(5.0,30, 200);
        assertEquals(227 , caloriesBurned);
    }

    /**
     * Calculate Activity Calories burned json response.
     */
    @Test
    void calculateActivityCaloriesBurnedJSON() {
        Response respone = fitnessService.calculateGetActivityCaloriesBurned ("json",5.0,30, 200) ;
        assertEquals("{\"CaloriesBurned\":227}"
                , respone.getEntity().toString());
    }

    /**
     * Calculate Activity Calories burned html response.
     */
    @Test
    void calculateActivityCaloriesBurnedHTML() {
        Response response = fitnessService.calculateGetActivityCaloriesBurned("html",5.0,30, 200) ;
        assertEquals("<h3>Calories burned: 227</h3>"
                , response.getEntity().toString());
    }

    /**
     * Verifies BMR's Imperial calculations with JSON output.
     */
    @Test
    void testBMIcalculationsImperial() {
        Response bmi = fitnessService.calculateBMIlbs("json",200,69);
        assertEquals("{\"Height\":69,\"Weight\":200,\"BMI\":\"29.53\"}", bmi.getEntity());
    }

    /**
     * Verifies BMR's Metric calculations with JSON output.
     */
    @Test
    void testBMIcalculationsMetric() {
        Response bmi = fitnessService.calculateBMIkg("json",95,1.9);
        assertEquals("{\"Height\":1.9,\"Weight\":95,\"BMI\":\"26.32\"}", bmi.getEntity());
    }

    /**
     * Verifies BMR's Imperial calculations with JSON output.
     */
    @Test
    void testBMIGetCalculationsImperial() {
        Response bmi = fitnessService.calculateGetBMIlbs("json",200,69);
        assertEquals("{\"Height\":69,\"Weight\":200,\"BMI\":\"29.53\"}", bmi.getEntity());
    }

    /**
     * Verifies BMR's Metric calculations with JSON output.
     */
    @Test
    void testBMIGetCalculationsMetric() {
        Response bmi = fitnessService.calculateGetBMIkg("json",95,1.9);
        assertEquals("{\"Height\":1.9,\"Weight\":95,\"BMI\":\"26.32\"}", bmi.getEntity());
    }

    /**
     * Verifies BMR's Metric calculations with JSON output.
     */
    @Test
    void testBMIGetCalculationsMetricHtml() {
        Response bmi = fitnessService.calculateGetBMIkg("html",95,1.9);
        assertEquals("<h3>BMI</h3><p>The BMI for a person with a height of 1.9 and a weight of 95.0 is : 26.32</p>", bmi.getEntity());
    }



}
