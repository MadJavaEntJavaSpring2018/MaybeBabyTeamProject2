package fitness.service;


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
     *
     * 2. Multiply your BMR by the appropriate activity factor, as follows:
     * Sedentary (little or no exercise): BMR x 1.2
     * Lightly active (light exercise/sports 1-3 days/week): BMR x 1.375
     * Moderately active (moderate exercise/sports 3-5 days/week): BMR x 1.55
     * Very active (hard exercise/sports 6-7 days a week): BMR x 1.725
     * Extra active (very hard exercise/sports & physical job or 2x training): BMR x 1.9
     * 3. Your final number is the approximate number of calories you need each day to maintain your weight.
     *
     * Source: (http://www.healthfitonline.com/resources/harris_benedict.php)
     *
     * This method returns the JSON response.
     * @author Osamah Shareef
     * @param weight
     * @param height
     * @param age
     * @param gender
     * @param activity
     * @return JSON object
     */

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/bmr")
    public Response getBMRcalculations( @FormParam("format") String format,
            @FormParam("weight") double weight, @FormParam("height") double height,
            @FormParam("age") int age, @FormParam("gender") String gender,
            @FormParam("activity") String activity) {

        if (format.equals("json")) {
            JSONObject json = new JSONObject();
            json.put("BMR", calculateBMR(gender, weight, height, age, activity));
            return Response.status(200).entity(json.toString() + " calories you need each day to maintain you weight.").build();
        } else {
            String html = "Your BMR is " + calculateBMR(gender, weight, height, age, activity);
            return Response.status(200).entity(html + " calories you need each day to maintain you weight.").build();
        }
    }

    /**
     * This method calculates the BMR.
     * @author Osamah Shareef
     * @param gender
     * @param weight
     * @param height
     * @param age
     * @param activity
     */
    private double calculateBMR(String gender, double weight, double height, int age, String activity) {
        double bmr = 0.0;
        double calories = 0.0;
        if (gender.equals("female")) {
            bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * (double) age);
        } else if (gender.equals("male")) {
            bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * (double) age);
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
     * @param weight
     * @param height
     * @param age
     * @param gender
     * @param activity
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccr/{weight}/{height}/{age}/{gender}/{activity}")
    public Response calculateCaloriesRequiredPerDay(
            @PathParam("weight") double weight,
            @PathParam("height") double height,
            @PathParam("age") int age,
            @PathParam("gender") String gender,
            @PathParam("activity") String activity
    ) {
        double calorieNeeded = 0.0;
        double bmr = 0.0;
        // weight in kg
        // height in cm
        age = Math.round(age);

        if (gender.equals("male")) {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;

        } else {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }


        // Calories needed based on activity type
        if (activity.equals("sed")) {
            calorieNeeded = bmr * 1.2;

        } else if (activity.equals("lht")) {
            calorieNeeded = bmr * 1.375;

        } else if (activity.equals("mod")) {
            calorieNeeded = bmr * 1.55;

        } else if (activity.equals("hrd")) {
            calorieNeeded = bmr * 1.725;

        } else if (activity.equals("ext")) {
            calorieNeeded = bmr * 1.9;

        }

        calorieNeeded = Math.floor(calorieNeeded);
        double calorieNeededPerDayLoseOnePounds = calorieNeeded - 500;
        double calorieNeededPerDayLoseTwoPounds = calorieNeededPerDayLoseOnePounds - 500;
        double calorieNeededPerDayLoseThreePounds = calorieNeededPerDayLoseTwoPounds - 500;

        JSONObject json = new JSONObject();
        json.put("clrsPerDayMntnWt", String.valueOf(calorieNeeded));
        json.put("clrsPerDayLs1PndsPerWk", String.valueOf(calorieNeededPerDayLoseOnePounds));
        json.put("clrsPerDayLs2PndsPerWk", String.valueOf(calorieNeededPerDayLoseTwoPounds));

        return Response.status(200).entity(json.toString()).build();
    }

    /**
     * Calculate calories burned during a run.
     *
     * @param distance
     * @param weight
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
     * @param distance
     * @param weight
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

