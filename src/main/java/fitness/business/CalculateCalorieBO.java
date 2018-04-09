package fitness.business;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Calculate calorie bo.
 */
public class CalculateCalorieBO {


    /**
     * Calculate calorie double.
     *
     * @param weight   the weight
     * @param height   the height
     * @param age      the age
     * @param gender   the gender
     * @param activity the activity
     * @return the double
     */
    public double calculateCalorie(double weight,double height, int age, String gender, String activity){

        double calorieNeeded = 0.0;
        double bmr = 0.0;
        // weight in kg
        // height in cm
        age = Math.round(age);

        if (gender.equals("m")) {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
            //bmr = 66 + ( 6.23  * weight) + ( 12.7 * height) - ( 6.8 * age);

        } else {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
            //bmr = 655 + ( 4.35 * weight) + ( 4.7 * height) - ( 4.7 * age);
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

        return calorieNeeded;
    }

    /**
     * Calculate fat double.
     *
     * @param calorie the calorie
     * @return the double
     */
    public double calculateFat(double calorie){

        double fatNeeded = Math.floor((calorie*0.25)/9);
        return fatNeeded;
    }

    /**
     * Calculate protein double.
     *
     * @param calorie the calorie
     * @return the double
     */
    public double calculateProtein(double calorie){

        double proteinNeeded = Math.floor((calorie*0.25)/4);
        return proteinNeeded;
    }

    /**
     * Calculate carbohydrates double.
     *
     * @param calorie the calorie
     * @return the double
     */
    public double calculateCarbohydrates(double calorie){

        double carbohydratesNeeded = Math.floor((calorie*0.25)/4);
        return carbohydratesNeeded;
    }


    /**
     * Get jason object json array.
     *
     * @param calorie the calorie
     * @return the json array
     */
    public JSONArray getJasonObject(double calorie){

        List<Double> list = new ArrayList<Double>();
        //Calories needed to maintain weight
        list.add(calorie);
        //Calories needed to lose 1 lbs per week
        list.add(calorie-500);
        //Calories needed to lose 2 lbs per week
        list.add(calorie-1000);

        final JSONArray arr = new JSONArray();

        for(int i = 0 ; i< list.size() ; i++) {

            final JSONObject obj = new JSONObject();
            double p = list.get(i);
            obj.put("Fat", this.calculateFat(p));
            obj.put("Protein", this.calculateProtein(p));
            obj.put("Carbohydrates", this.calculateCarbohydrates(p));
            arr.put(obj);
        }

        return arr;
    }

    /**
     * Get html string.
     *
     * @param calorie the calorie
     * @return the string
     */
    public String getHTML(double calorie){

        List<Double> list = new ArrayList<Double>();
        //Calories needed to maintain weight
        list.add(calorie);
        //Calories needed to lose 1 lbs per week
        list.add(calorie-500);
        //Calories needed to lose 2 lbs per week
        list.add(calorie-1000);

        String outHTML = "";

        outHTML += "<html>" ;
        outHTML += "<head>" ;
        outHTML += "<title>" + "Fat Protein Carbohydrates Result Page" + "</title>";
        outHTML += "</head>" ;
        outHTML += "<body>" ;
        outHTML += "<p>" ;

        for(int i = 0 ; i< list.size() ; i++) {

            if(i==0) {
                outHTML += "<h3>" + "Maintain weight" + "</h3>";
            } else if (i==1) {
                outHTML += "<h3>" + "Loss 1 pound per week" + "</h3>";
            } else {
                outHTML += "<h3>" + "Loss 2 pounds per week" + "</h3>";
            }
            outHTML += "<table border = '1'>" ;
            outHTML += "<tbody>";
            outHTML += "<tr>";
            outHTML += "<td>";
            outHTML += "<b>";
            outHTML += "Daily intake";
            outHTML += "</b>";
            outHTML += "</td>";
            outHTML += "<td>";
            outHTML += "<b>";
            outHTML += "grams";
            outHTML += "</b>";
            outHTML += "</td>";
            outHTML += "</tr>";

            double p = list.get(i);
            outHTML += "<tr>";
            outHTML += "<td>";
            outHTML += "Fat";
            outHTML += "</td>";
            outHTML += "<td>";
            outHTML += this.calculateFat(p);
            outHTML += "</td>";
            outHTML += "</tr>";

            outHTML += "<tr>";
            outHTML += "<td>";
            outHTML += "Protein";
            outHTML += "</td>";
            outHTML += "<td>";
            outHTML += this.calculateProtein(p);
            outHTML += "</td>";
            outHTML += "</tr>";

            outHTML += "<tr>";
            outHTML += "<td>";
            outHTML += "Carbohydrates";
            outHTML += "</td>";
            outHTML += "<td>";
            outHTML += this.calculateCarbohydrates(p);
            outHTML += "</td>";
            outHTML += "</tr>";

            outHTML += "</tbody>";
            outHTML += "</table>";
        }
        outHTML += "</p>" ;
        outHTML += "<p>" ;
        outHTML += "<a href=";
        outHTML += "index.jsp";
        outHTML += ">";
        outHTML += "Back to HomePage";
        outHTML += "</a>";
        outHTML += "</p>" ;
        outHTML += "</body>" ;
        outHTML += "</html>" ;
        return outHTML;
    }
}
