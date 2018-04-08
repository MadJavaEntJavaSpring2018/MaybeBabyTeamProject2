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
     * Verifies BMR's Imperial calculations.
     */
    @Test
    void testBMRcalculationsImperial() {
       Response bmr = fitnessService.getBMRcalculations("json",160,6,34,"male","very","lbs");
        assertEquals("{\"BMR\":1565.9550000000004} calories you need each day to maintain you weight.", bmr.getEntity());
    }

    /**
     * Verifies BMR's Metric calculations.
     */
    @Test
    void testBMRcalculationsMetric() {
        Response bmr = fitnessService.getBMRcalculations("json",85,178,34,"male","very","kg");
        assertEquals("{\"BMR\":3270.79665} calories you need each day to maintain you weight.", bmr.getEntity());
    }
}
