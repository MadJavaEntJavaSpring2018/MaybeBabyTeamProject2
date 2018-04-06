<html>
<body>
<h2>Hello World! MaybeBabyTeamProject</h2>
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

<a href="/calculateCalorieServlet">Calorie Calculator</a>

<form action="/calculateCalorieServlet" name="calform" method="post">
    <table id="calinputtable" width="420">
        <tbody>
        <tr>
            <td width="50">Age</td>
            <td width="370">
                <input type="text" name="age" id="age" value="" class="innormal">
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
                <input type="text" name="height" id="height" value="" class="in4char"> cms
            </td>
        </tr>
        <tr>
            <td>Weight</td>
            <td>
                <input type="text" name="weight" id="weight" value="" class="innormal"> kg
            </td>
        </tr>
        </tbody>
    </table>
    <table width="500">
        <tbody>
        <tr>
            <td width="50">Activity</td>
            <td width="450">
                <select id="activity" name="activity">
                    <option value="sed">Sedentary - little or no exercise</option>
                    <option value="lht">Lightly Active - exercise/sports 1-3 times/week</option>
                    <option value="mod">Moderatetely Active - exercise/sports 3-5 times/week</option>
                    <option value="hrd">Very Active - hard exercise/sports 6-7 times/week</option>
                    <option value="ext">Extra Active - very hard exercise/sports or physical job</option>
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