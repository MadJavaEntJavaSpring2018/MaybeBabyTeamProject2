package fitness.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This is the service class. You can add your calculating methods in here.
 */

@Path("/service")
public class FitnessService {
    /**
     * 1. Calculate your BMR (basal metabolic rate):
             Women: BMR = 655 + ( 4.35 x weight in pounds ) + ( 4.7 x height in inches ) - ( 4.7 x age in years )
             Men: BMR = 66 + ( 6.23 x weight in pounds ) + ( 12.7 x height in inches ) - ( 6.8 x age in years )

       2. Multiply your BMR by the appropriate activity factor, as follows:
             Sedentary (little or no exercise): BMR x 1.2
             Lightly active (light exercise/sports 1-3 days/week): BMR x 1.375
             Moderately active (moderate exercise/sports 3-5 days/week): BMR x 1.55
             Very active (hard exercise/sports 6-7 days a week): BMR x 1.725
             Extra active (very hard exercise/sports & physical job or 2x training): BMR x 1.9
       3. Your final number is the approximate number of calories you need each day to maintain your weight.

        Source: (http://www.healthfitonline.com/resources/harris_benedict.php)

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
            bmr = 66 + ( 6.23 * weight) + ( 12.7 * height) - ( 6.8 * (double)age);
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
   public Response calculateCaloriesRequiredPerDay(){
        String arrayToJson = "";
        return Response.status(200).entity(arrayToJson).build();
   }
}
