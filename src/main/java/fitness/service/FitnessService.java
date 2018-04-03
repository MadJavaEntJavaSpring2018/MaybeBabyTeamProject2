package fitness.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
     *
     * @param weight
     * @param height
     * @param age
     * @param gender
     * @return bmr the Basal Metabolic Rate
     */

    @GET
    //@Produces({MediaType.APPLICATION_JSON})
    @Produces("text/plain")
    @Path("/{weight}/{height}/{age}/{gender}")
    public Response calculateBMR(
            @PathParam("weight") double weight, @PathParam("height") double height,
            @PathParam("age") int age, @PathParam("gender") String gender) {

        double bmr = 0.0;
        if (gender.equals("female")) {
            bmr = 655 + (4.35 * weight) + (4.7 * height) - (4.7 * (double) age);
        } else if (gender.equals("male")) {
            bmr = 66 + (6.23 * weight) + (12.7 * height) - (6.8 * (double) age);
        }


        return Response.status(200).entity(bmr + " " + gender).build();
    }


    /**
     * Calculate calories required per day response.
     *
     * @return response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{age}/{height}/{weight}/{activity}")
    public Response calculateCaloriesRequiredPerDay() {
        String arrayToJson = "";
        return Response.status(200).entity(arrayToJson).build();
    }


   /**
    *  Calculate calories burned during a run.
    *
    *  Men use the following formula:
    *  Calories Burned = [(Age x 0.2017) - (Weight x 0.09036) + (Heart Rate x 0.6309) - 55.0969] x Duration / 4.184.
    *
    *  Women use the following formula:
    *  Calories Burned = [(Age x 0.074) - (Weight x 0.05741) + (Heart Rate x 0.4472) - 20.4022] x Duration / 4.184.
    *
    *  @param age
    *  @param weight
    *  @param heartRate
    *  @param duration
    *  @param gender
    *
    *  @return calories the calories burned during a run bases on gender
    *
    */
    @GET
    @Produces("text/plain")
    @Path("/{age}/{weight}/{heartRate}/{duration}/{gender}")
    public Response calculateCaloriesBurned(
            @PathParam("age") int age,
            @PathParam("weight") int weight,
            @PathParam("heartRate") int heartRate,
            @PathParam("duration") int duration,
            @PathParam("gender") String gender) {

        double calories = 0.0;

        if (gender.equals("female")) {
            calories = ((age * 0.074) - (weight * 0.05741) + (heartRate * 0.4472) - 20.4022) * duration / 4.184;
        } else if (gender.equals("male")) {
            calories = ((age * 0.2017) - (weight * 0.09036) + (heartRate * 0.6309) - 55.0969) * duration / 4.184;
        }
        {
            return Response.status(200).entity(calories + " " + gender).build();
        }
    }
}

