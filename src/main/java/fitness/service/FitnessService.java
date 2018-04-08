package fitness.service;


import fitness.business.CalculateCalorieBO;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DecimalFormat;

/**
 * This is the service class. You can add your calculating methods in here.
 */
@Path("/service")
public class FitnessService {
    /**
     * 1. Calculate your BMR (basal metabolic rate):
     * Women: BMR = 655 + ( 4.35 x weight in pounds ) + ( 4.7 x height in inches ) - ( 4.7 x age in years )
     * Men: BMR = 66 + ( 6.23 x weight in pounds ) + ( 12.7 x height in inches ) - ( 6.8 x age in years )
     * <p>
     * 2. Multiply your BMR by the appropriate activity factor, as follows:
     * Sedentary (little or no exercise): BMR x 1.2
     * Lightly active (light exercise/sports 1-3 days/week): BMR x 1.375
     * Moderately active (moderate exercise/sports 3-5 days/week): BMR x 1.55
     * Very active (hard exercise/sports 6-7 days a week): BMR x 1.725
     * Extra active (very hard exercise/sports & physical job or 2x training): BMR x 1.9
     * 3. Your final number is the approximate number of calories you need each day to maintain your weight.
     * <p>
     * Source: (http://www.healthfitonline.com/resources/harris_benedict.php)
     * <p>
     * This method returns the JSON response.
     *
     * @param format   the format
     * @param weight   the weight
     * @param height   the height
     * @param age      the age
     * @param gender   the gender
     * @param activity the activity
     * @param unit     the unit
     * @return JSON object
     * @author Osamah Shareef
     */


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/bmr")
    public Response getBMRcalculations(
            @FormParam("format") String format, @FormParam("weight") double weight,
            @FormParam("height") double height, @FormParam("age") int age,
            @FormParam("gender") String gender, @FormParam("activity") String activity,
            @FormParam("unit") String unit) {

        if (format.equals("json")) {
            JSONObject json = new JSONObject();
            json.put("BMR", calculateBMR(gender, weight, height, age, activity, unit));
            return Response.status(200).entity(json.toString() + " calories you need each day to maintain you weight.").build();
        } else {
            String html = "Your BMR is " + calculateBMR(gender, weight, height, age, activity, unit);
            return Response.status(200).entity(html + " calories you need each day to maintain you weight.").build();
        }
    }

    /**
     * This method calculates the BMR both in KG & LBS.
     * @author Osamah Shareef
     * @param gender
     * @param weight
     * @param height
     * @param age
     * @param activity
     */
    private double calculateBMR(String gender, double weight, double height, int age, String activity, String unit) {
        double bmr = 0.0;
        double calories = 0.0;
        if (gender.equals("female")) {
            if (unit.equals("lbs")) {
                bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * (double) age);
            } else if (unit.equals("kg")) {
                bmr = 655.1 + ( 9.563 * weight) + (1.850 * height) - (4.676 * (double) age);
            }
        } else if (gender.equals("male")) {
            if (unit.equals("lbs")) {
                bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * (double) age);
            } else if (unit.equals("kg")) {
                bmr = 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
            }
        }

        if (activity.equals("sedentary")) {
            calories = bmr * 1.2;
        } else if (activity.equals("lightly")) {
            calories = bmr * 1.375;
        } else if (activity.equals("moderately")) {
            calories = bmr * 1.55;
        } else if (activity.equals("very")) {
            calories = bmr * 1.725;
        } else if (activity.equals("extra")) {
            calories = bmr * 1.9;
        }
        return calories;
    }


    /**
     * Calculate fat protien carbo hyderates required per day json response.
     *
     * @param weight   the weight
     * @param height   the height
     * @param age      the age
     * @param gender   the gender
     * @param activity the activity
     * @return response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccr/json/{weight}/{height}/{age}/{gender}/{activity}")
    public Response calculateFatProtienCarboHyderatesRequiredPerDayJson(
            @PathParam("weight") double weight,
            @PathParam("height") double height,
            @PathParam("age") int age,
            @PathParam("gender") String gender,
            @PathParam("activity") String activity
    ) {

        CalculateCalorieBO ccbo = new CalculateCalorieBO();
        double calorieNeeded = ccbo.calculateCalorie(weight, height, age, gender, activity);

        JSONArray json = ccbo.getJasonObject(calorieNeeded);

            return Response.status(200).entity(json.toString()).build();
    }

    /**
     * Calculate fat protien carbo hyderates required per day html response.
     *
     * @param weight   the weight
     * @param height   the height
     * @param age      the age
     * @param gender   the gender
     * @param activity the activity
     * @return the response
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/ccr/html/{weight}/{height}/{age}/{gender}/{activity}")
    public Response calculateFatProtienCarboHyderatesRequiredPerDayHtml(
            @PathParam("weight") double weight,
            @PathParam("height") double height,
            @PathParam("age") int age,
            @PathParam("gender") String gender,
            @PathParam("activity") String activity
    ) {

        CalculateCalorieBO ccbo = new CalculateCalorieBO();
        double calorieNeeded = ccbo.calculateCalorie(weight, height, age, gender, activity);

        String outHTML = ccbo.getHTML(calorieNeeded);

        return Response.status(200).entity(outHTML).build();
    }

    /**
     * Calculate calories burned during a run.
     *
     * @param distance the distance
     * @param weight   the weight
     * @return Calories - The calories burned during a run
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccb/json/{distance}/{weight}")
    public Response getJSONCaloriesBurned(
            @PathParam("distance") double distance,
            @PathParam("weight") int weight) {

        double calories = 0.0;

        calories = (int)((distance * 1.60934) * (weight * 0.453592) * 1.036);

        {
            JSONObject json = new JSONObject();
            json.put("CaloriesBurned", calories);
            return Response.status(200).entity(json.toString()).build();
        }
    }

    /**
     * Calculate calories burned during a run.
     *
     * @param distance the distance
     * @param weight   the weight
     * @return Calories - The calories burned during a run
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/ccb/html/{distance}/{weight}")
    public Response getHTMLCaloriesBurned(
            @PathParam("distance") double distance,
            @PathParam("weight") int weight) {

        double calories = 0.0;
        String response;

        calories = (int)((distance * 1.60934) * (weight * 0.453592) * 1.036);

        {
            response =  "<html> " + "Calories burned: " + calories + "</html>";
            return Response.status(200).entity(response).build();
        }

    }

    /**
     * Calculate bm ilbs response.
     *
     * @param weight weight in lbs
     * @param height height in inches
     * @return BMI - Body Mass Index
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bmilbs/{weight}/{height}")
    public Response calculateBMIlbs(
            @PathParam("weight") double weight,
            @PathParam("height") double height) {
        DecimalFormat df = new DecimalFormat("###.##");
        double bmi = (weight / Math.pow(height, 2)) * 703;
        JSONObject json = new JSONObject();
        json.put("BMI", df.format(bmi));
        return Response.status(200).entity(json.toString()).build();
    }

    /**
     * Calculate bm ikg response.
     *
     * @param weight weight in kg
     * @param height height in meters
     * @return BMI - Body Mass Index
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/bmikg/{weight}/{height}")
    public Response calculateBMIkg(
            @PathParam("weight") double weight,
            @PathParam("height") double height) {

        DecimalFormat df = new DecimalFormat("###.##");
        double bmi = weight / Math.pow(height, 2);
        JSONObject json = new JSONObject();
        json.put("BMI", df.format(bmi));
        return Response.status(200).entity(json.toString()).build();
    }
}

