
<html>
<head>
    <title>Fitness Service</title>
</head>
<body>
<h2>Hello World! MaybeBabyTeamProject</h2>

<!-- BMR calculation form -->
<div class="accordion-group">
    <h3>Calculate BMR</h3>
    <div>
        <form action="fitness/service/bmr" method="post">
            <div>
                <p>
                    Use this API to calculate BMR (Basal Metabolic Rate)  is an estimate of how many calories you'd burn if you were to do nothing but rest for 24 hours.
                    It represents the minimum amount of energy needed to keep your body functioning, including breathing and keeping your heart beating.
                    Send a GET request to <code>https://AWS Link/fitness/service/bmr/weight/height/age/gender/activity</code>.
                </p>

                <div>
                    <div>
                        <label>Format</label>
                        <select name="format" required="required">
                            <option value="json">Json</option>
                            <option value="html">Html</option>
                        </select>
                    </div>

                    <div>
                        <label>Weight</label>
                        <input type="text" name="weight" placeholder="Weight" required="required">
                    </div>

                    <div>
                        <label>Height</label>
                        <input type="text" name="height" placeholder="Height" required="required">
                    </div>
                    <div>
                        <label>Age</label>
                        <input type="text" name="age" placeholder="Age" required="required">
                    </div>
                    <div>
                        <label>Gender</label>
                        <select name="gender" required="required">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                    <div>
                        <label>Activity</label>
                        <select name="activity" required="required">
                            <option value="sedentary">Sedentary (little or no exercise)</option>
                            <option value="lightly">Lightly active (light exercise/sports 1-3 days/week)</option>
                            <option value="moderately">Moderately active (moderate exercise/sports 3-5 days/week)</option>
                            <option value="very">Very active (hard exercise/sports 6-7 days a week)</option>
                            <option value="extra">Extra active (very hard exercise/sports & physical job or 2x training)</option>
                        </select>
                    </div>


                    <div>
                        <label>Units</label>
                        <select name="unit" required="required">
                            <option value="kg">KG</option>
                            <option value="lbs">LBS</option>
                        </select>
                    </div>

                    <div>
                        <label>&nbsp;</label>
                        <input type="submit" name="submit"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <h3>BMR Done</h3>
</div>
<!--
<div class="accordion-group">

<div id="distance" class="accordion-body in collapse" style="height: auto;">
<form method="get" action="TODO ****">
<div class="accordion-inner">
<p>
Use this API to determine the distance between two zip codes.
Send a GET request to <code class="endpoint">https://AWS Link/fitness/service/1st param/2nd param/3rd param/4th param/5th param</code>.
</p>

<div class="row">
<div class="span1">
<label>Format</label>
<select class="input-mini" name="format" required="required">
<option value="json">json</option>
<option value="xml">html</option>
</select>
</div>

<div class="span2">
<label>Zip Code 1</label>
<input class="input-mini" type="text" name="zip_code1" placeholder="Zip Code" required="required">
</div>

<div class="span2">
<label>Zip Code 2</label>
<input class="input-mini" type="text" name="zip_code2" placeholder="Zip Code" required="required">
</div>

<div class="span1">
<label>Units</label>
<select class="input-mini" name="units" required="required">
<option value="km">kg</option>
<option value="mile">lbs</option>
</select>
</div>

<div class="span2 offset1">
<label>&nbsp;</label>
<button class="btn" type="submit">Make Request</button>
</div>
</div>

<div class="request-url" style="margin: 5px 0px;">
<span class="label">Request URL</span>
<code>https://www.zipcodeapi.com/rest/W6Xx087DjLfGWvBgfkaP3G612cGXDccl9B4b37SFVs0YOj2ooZp4wDEfdnUO0UMN/distance.json/53704/53714/mile</code>
</div>
</div>
</form>
</div>
</div>-->

<h3>Calculate Fat, Protein and Carbohydrates</h3>
<p>
    Use this API to calculate how much amount of Fat, Protein and Carbohydrates you needed per day to maintain weight / to lose 1 lb per week / to lose 2 lbs per week.
    Send a GET request to <code>https://AWS Link/fitness/service/ccr/json/weight/height/age/gender/activity</code>
                                                            OR
                          <code>https://AWS Link/fitness/service/ccr/html/weight/height/age/gender/activity</code>.
</p>

<form action="/calculateCalorieServlet" name="calform" method="post">
    <table id="calinputtable" width="420">
        <tbody>
        <tr>
            <td width="50">Age</td>
            <td width="370">
                <input type="text" name="age" id="age" value="" class="innormal" required="required">
            </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <label for="gender1">
                    <input type="radio" name="gender" id="gender1" value="m"> male</label> &nbsp;
                <label for="gender2">
                    <input type="radio" name="gender" id="gender2" value="f"> female</label>
            </td>
        </tr>
        </tbody>
    </table>
    <table width="420" id="standardheightweight" style="display: block;">
        <tbody>
        <tr>
            <td width="50">Height</td>
            <td width="370">
                <input type="text" name="height" id="height" value="" class="in4char" required="required"> cms
            </td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>
                <input type="text" name="weight" id="weight" value="" class="innormal" required="required"> kg
            </td>
        </tr>
        </tbody>
    </table>
    <table width="500">
        <tbody>
        <tr>
            <td width="50">Activity</td>
            <td width="450">
                <select id="activity" name="activity" required="required">
                    <option value="sed">Sedentary - little or no exercise</option>
                    <option value="lht">Lightly Active - exercise/sports 1-3 times/week</option>
                    <option value="mod">Moderatetely Active - exercise/sports 3-5 times/week</option>
                    <option value="hrd">Very Active - hard exercise/sports 6-7 times/week</option>
                    <option value="ext">Extra Active - very hard exercise/sports or physical job</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="50">Format</td>
            <td width="450">
            <select name="format" required="required">
                <option value="json">Json</option>
                <option value="html">Html</option>
            </select>
            </td>
        </tr>
        <tr>
            <td width="50">&nbsp;</td>
            <td width="450">
                <input type="submit" value="submit">
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
<%--Calculation Fat, Protein and carbohydrates done--%>

<h3>Calculate Calories Burned (Running)</h3>
<p>
    Use this API to calculate how many calories are burning during a run based on 12 minute miles.
    Send a GET request to <code>https://AWS Link/fitness/service/ccr/json/weight/height/age/gender/activity</code>
    OR
    <code>https://AWS Link/fitness/service/crc/html/distance/weight</code>.
</p>
<form action="/calculateRunCalorieServlet" method="GET">

    <table width="420" id="caloriesburnedinput" style="display: block;">
        <tbody>
        <tr>
            <td>Distance</td>
            <td>
                <input type="text" name="distance" id="caloriesburneddistance"  placeholder="miles" required="required">
            </td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>
                <input type="text" name="weight" id="caloriesburnedweight"  placeholder="pounds" required="required">
            </td>
        </tr>
        <tr>
            <td width="50">Format</td>
            <td width="450">
                <select name="format" required="required">
                    <option value="json">Json</option>
                    <option value="html">Html</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="50">&nbsp;</td>
            <td width="450">
                <input type="submit" value="submit">
            </td>
        </tr>
          </tbody>
    </table>
</form>

<!--BMI Form (lbs) -->
<div class="accordion-group">
<h3>Calculate BMI (Imperial Units)</h3>
<p>
    Use this API to calculate Body Mass Index (BMI) based on weight in pounds and height in inches.
    Send a GET request to <code>https://AWS Link/fitness/service/bmilbs</code>.
</p>
    <div>
        <form action="http://localhost:8080/maybebaby/fitness/service/bmilbs" method="post">
            <div>
                <div>
                    <div>
                        <label>Format</label>
                        <select name="format" required="required">
                            <option value="json">Json</option>
                            <option value="html">Html</option>
                        </select>
                    </div>

                    <div>
                        <label>Weight</label>
                        <input type="text" name="weight" placeholder="Weight" required="required">
                    </div>

                    <div>
                        <label>Height</label>
                        <input type="text" name="height" placeholder="Height" required="required">
                    </div>
                    <div>
                        <label>&nbsp;</label>
                        <input type="submit" name="submit"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <h3>BMI (Imperial) Done</h3>
</div>

<!--BMI Form (kg) -->
<div class="accordion-group">
    <h3>Calculate BMI (Metric Units)</h3>
    <p>
        Use this API to calculate Body Mass Index (BMI) based on height in meters and weight in kilograms.
        Send a GET request to <code>https://AWS Link/fitness/service/bmikg</code>.
    </p>
    <div>
        <form action="fitness/service/bmikg" method="post">
            <div>
                <div>
                    <div>
                        <label>Format</label>
                        <select name="format" required="required">
                            <option value="json">Json</option>
                            <option value="html">Html</option>
                        </select>
                    </div>
                    <div>
                        <label>Weight</label>
                        <input type="text" name="weight" placeholder="Weight" required="required">
                    </div>
                    <div>
                        <label>Height</label>
                        <input type="text" name="height" placeholder="Height" required="required">
                    </div>
                    <div>
                        <label>Age</label>
                        <input type="text" name="age" placeholder="Age" required="required">
                    </div>
                    <div>
                        <label>&nbsp;</label>
                        <input type="submit" name="submit"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <h3>BMI (Metric) Done</h3>
</div>
