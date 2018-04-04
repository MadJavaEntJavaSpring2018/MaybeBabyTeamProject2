<html>
<body>
<h2>Hello World! MaybeBabyTeamProject</h2>
<!-- BMR calcualtion form -->
<div class="accordion-group">

    <div id="distance" class="accordion-body in collapse" style="height: auto;">
        <form method="get" action="calculateBMR">
            <div class="accordion-inner">
                <p>
                    Use this API to calculate BMR (Basal Metabolic Rate)  is an estimate of how many calories you'd burn if you were to do nothing but rest for 24 hours.
                    It represents the minimum amount of energy needed to keep your body functioning, including breathing and keeping your heart beating.
                    Send a GET request to <code class="endpoint">https://AWS Link/fitness/service/bmr/weight/height/age/gender/activity</code>.
                </p>
                <p>
                    <ul>
                        <li>Sedentary (little or no exercise)</li>
                        <li>Lightly active (light exercise/sports 1-3 days/week)</li>
                        <li>Moderately active (moderate exercise/sports 3-5 days/week)</li>
                        <li>Very active (hard exercise/sports 6-7 days a week)</li>
                        <li>Extra active (very hard exercise/sports & physical job or 2x training)</li>
                    </ul>
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
                        <button type="submit">Make Request</button>
                    </div>
                </div>

                <div class="request-url" style="margin: 5px 0px;">
                    <span class="label">Request URL</span>
                    <code>https://www.zipcodeapi.com/rest/W6Xx087DjLfGWvBgfkaP3G612cGXDccl9B4b37SFVs0YOj2ooZp4wDEfdnUO0UMN/distance.json/53704/53714/mile</code>
                </div>
            </div>
        </form>
    </div>
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

</body>
</html>