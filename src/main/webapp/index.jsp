<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Maybe Baby</title>

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">
    <!-- Themify Icons-->
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <!-- Bootstrap DateTimePicker -->
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div class="gtco-loader"></div>

<div id="page">


    <!-- <div class="page-inner"> -->
    <nav class="gtco-nav" role="navigation">
        <div class="gtco-container">

            <div class="row">
                <div class="col-sm-4 col-xs-12">
                    <div id="gtco-logo"><a href="index.jsp">fitness<em>.</em></a></div>
                </div>
            </div>

        </div>
    </nav>

    <div id="gtco-header" class="gtco-cover-md" role="banner">
        <div class="overlay"></div>
        <div class="gtco-container">
            <div class="row">
                <div class="col-md-12 col-md-offset-0 text-left">
                    <div class="row">
                        <div class="col-md-10 mt-text animate-box" data-animate-effect="fadeInUp">
                            <span class="intro-text-small">Fitness Calculations for an active lifestyle!</span>
                            <h2 class="cursive-font">Browse for more info</h2>
                        </div>
                    </div>

                    <!-- Block for form div BMR-->
                    <div class="row gtco-cover gtco-cover-md">
                        <div class="col-md-10 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                            <div class="form-wrap">
                                <div class="tab">

                                    <div class="tab-content">
                                        <div class="tab-content-inner active" data-content="signup">
                                            <!--Put forms here-->
                                            <!--BMR Form -->
                                            <div class="row form-group">
                                                <h3>Calculate BMR</h3>
                                                <p>
                                                    Use this API to calculate BMR (Basal Metabolic Rate)  is an estimate of how many calories you'd burn if you were to do nothing but rest for 24 hours.
                                                    It represents the minimum amount of energy needed to keep your body functioning, including breathing and keeping your heart beating.
                                                    Send a GET request to <code>http://18.222.105.50:8080/MaybeBabyTeamProject/fitness/service/bmr</code>
                                                </p>
                                                <div>
                                                    <form action="fitness/service/bmr" method="get">
                                                        <div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Format</label>
                                                                    <select name="format" required="required" class="form-control">
                                                                        <option value="json" style="color:grey;">Json</option>
                                                                        <option value="html" style="color:grey;">Html</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Weight</label>
                                                                    <input type="text" name="weight" placeholder="Weight" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Height</label>
                                                                    <input type="text" name="height" placeholder="Height" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Age</label>
                                                                    <input type="text" name="age" placeholder="Age" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Gender</label>
                                                                    <select name="gender" required="required" class="form-control">
                                                                        <option value="male" style="color:grey;">Male</option>
                                                                        <option value="female" style="color:grey;">Female</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Activity</label>
                                                                    <select name="activity" required="required" class="form-control">
                                                                        <option value="sedentary" style="color:grey;">Sedentary (little or no exercise)</option>
                                                                        <option value="lightly" style="color:grey;">Lightly active (light exercise/sports 1-3 days/week)</option>
                                                                        <option value="moderately" style="color:grey;">Moderately active (moderate exercise/sports 3-5 days/week)</option>
                                                                        <option value="very" style="color:grey;">Very active (hard exercise/sports 6-7 days a week)</option>
                                                                        <option value="extra" style="color:grey;">Extra active (very hard exercise/sports & physical job or 2x training)</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Units</label>
                                                                    <select name="unit" required="required" class="form-control">
                                                                        <option value="kg" style="color:grey;">KG</option>
                                                                        <option value="lbs" style="color:grey;">LBS</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>&nbsp;</label>
                                                                    <input type="submit" name="submit" value="Calculate BMR" class="btn btn-primary btn-block"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- End block form div BMR-->

                    <!-- Block for form div WeightLoss-->
                    <div class="row gtco-cover gtco-cover-md">
                        <div class="col-md-10 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                            <div class="form-wrap">
                                <div class="tab">

                                    <div class="tab-content">
                                        <div class="tab-content-inner active" data-content="signup">
                                            <!--Put forms here-->
                                            <!--Weight Loss Form -->
                                            <div class="row form-group">
                                                <h3>Calculate Fat, Protein and Carbohydrates</h3>
                                                <p>
                                                    Use this API to calculate how much amount of Fat, Protein and Carbohydrates you needed per day to maintain weight / to lose 1 lb per week / to lose 2 lbs per week.
                                                    Send a GET request to <code>http://18.222.105.50:8080/MaybeBabyTeamProject/fitness/service/ccr/json/weight/height/age/gender/activity</code>
                                                    OR
                                                    <code>http://18.222.105.50:8080/MaybeBabyTeamProject/fitness/service/ccr/html/weight/height/age/gender/activity</code>
                                                </p>
                                                <div>
                                                    <form action="calculateCalorieServlet" name="calform" method="post">
                                                        <div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Format</label>
                                                                    <select name="format" required="required" class="form-control">
                                                                        <option value="json" style="color:grey;">Json</option>
                                                                        <option value="html" style="color:grey;">Html</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Weight</label>
                                                                    <input type="text" name="weight" id="weightCalorie" placeholder="Weight" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Height</label>
                                                                    <input type="text" name="height" id="height" placeholder="Height" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Age</label>
                                                                    <input type="text" name="age" id="age" placeholder="Age" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label for="gender1">
                                                                        <input type="radio" name="gender" id="gender1" value="m"> male</label> &nbsp;
                                                                    <label for="gender2">
                                                                        <input type="radio" name="gender" id="gender2" value="f"> female</label>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Activity</label>
                                                                    <select name="activity" required="required" class="form-control">
                                                                        <option value="sed" style="color:grey;">Sedentary - little or no exercise</option>
                                                                        <option value="lht" style="color:grey;">Lightly Active - exercise/sports 1-3 times/week</option>
                                                                        <option value="mod" style="color:grey;">Moderately Active - exercise/sports 3-5 times/week</option>
                                                                        <option value="hrd" style="color:grey;">Very Active - hard exercise/sports 6-7 times a week)</option>
                                                                        <option value="ext" style="color:grey;">Extra Active - very hard exercise/sports or physical job</option>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>&nbsp;</label>
                                                                    <input type="submit" name="submit" value="Calculate BMR" class="btn btn-primary btn-block"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- End block form div WeightLoss-->

                    <!-- Block for form div CaloriesBurned-->
                    <div class="row gtco-cover gtco-cover-md">
                        <div class="col-md-10 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                            <div class="form-wrap">
                                <div class="tab">

                                    <div class="tab-content">
                                        <div class="tab-content-inner active" data-content="signup">
                                            <!--Put forms here-->
                                            <!--Calories Burned Form -->
                                            <div class="row form-group">
                                                <h3>Calculate Calories Burned by Activity</h3>
                                                <p>
                                                    Use this API to calculate how many calories are burned during certain activities.
                                                    Send a GET request to <code>http://18.222.105.50:8080/MaybeBabyTeamProject/fitness/service/get/cac/</code>
                                                </p>
                                                <div>
                                                    <form action="fitness/service/cac"  method="post">
                                                        <div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Format</label>
                                                                    <select name="format" required="required" class="form-control">
                                                                        <option value="json" style="color:grey;">Json</option>
                                                                        <option value="html" style="color:grey;">Html</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Weight</label>
                                                                    <input type="number" min="85" max="350" step="1" name="weight" id="weight" placeholder="Pounds" class="number form-control" required="required"/>
                                                                </div>
                                                            </div>
															<div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Duration</label>
                                                                    <input type="number" min="1" max="120" step="1" name="duration" id="duration" placeholder="Minutes"value="" class="number form-control" required="required"/>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Activity</label>
                                                                    <select id="met" name="met" required="required" class="form-control">
																		<option value="4.0" style="color:grey;">Biking <10 mph leisure</option>
																		<option value="6.0" style="color:grey;">Biking 10-11.9 mph light</option>
																		<option value="8.0" style="color:grey;">Biking 12-13.9 mph moderate</option>
																		<option value="10.0" style="color:grey;">Biking 14-15.9 mph fast</option>
																		<option value="12.0" style="color:grey;">Biking 16.0-19.9 mph very fast</option>
																		<option value="16.0" style="color:grey;">Biking >20 mph racing</option>
																		<option value="8.0" style="color:grey;">Running 5 mph 12 minute miles</option>
																		<option value="10.0" style="color:grey;">Running 6 mph 10 minute miles</option>
																		<option value="11.5" style="color:grey;">Running 7 mph 8.5 minute miles</option>
																		<option value="13.5" style="color:grey;">Running 8 mph 7.5 minute miles</option>
																		<option value="15.0" style="color:grey;">Running 9 mph 6.5 minute miles</option>
																		<option value="16.0" style="color:grey;">Running 10 mph 6.0 minute miles</option>
																		<option value="2.5" style="color:grey;">Walking 2 mph slow</option>
																		<option value="3.5" style="color:grey;">Walking 3 mph moderate</option>
																		<option value="4.0" style="color:grey;">Walking 3.5-4 mph brisk</option>
																		<option value="1.80" style="color:grey;">Homework</option>
																	</select>
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>&nbsp;</label>
                                                                    <input type="submit" name="submit" value="Calculate Calories Burned" class="btn btn-primary btn-block"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- End block form div CaloriesBurned-->

                    <!-- Block for form div BMI Lbs-->
                    <div class="row gtco-cover gtco-cover-md">
                        <div class="col-md-10 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                            <div class="form-wrap">
                                <div class="tab">

                                    <div class="tab-content">
                                        <div class="tab-content-inner active" data-content="signup">
                                            <!--Put forms here-->
                                            <!--BMI Form (lbs) -->
                                            <div class="row form-group">
                                                <h3>Calculate BMI (Imperial Units)</h3>
                                                <p>
                                                    Use this API to calculate Body Mass Index (BMI) based on weight in pounds and height in inches.
                                                    Send a GET request to <code>http://18.222.105.50:8080/MaybeBabyTeamProject/fitness/service/get/bmilbs</code>
                                                </p>
                                                <div>
                                                    <form action="fitness/service/bmilbs" method="post">
                                                        <div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Format</label>
                                                                    <select name="format" required="required" class="form-control">
                                                                        <option value="json" style="color:grey;">Json</option>
                                                                        <option value="html" style="color:grey;">Html</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Weight</label>
                                                                    <input type="text" name="weight" placeholder="Weight" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Height</label>
                                                                    <input type="text" name="height" placeholder="Height" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>&nbsp;</label>
                                                                    <input type="submit" name="submit" value="Calculate BMI" class="btn btn-primary btn-block"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- End block form div BMI Lbs-->

                    <!-- Block for form div BMI Kg-->
                    <div class="row gtco-cover gtco-cover-md">
                        <div class="col-md-10 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
                            <div class="form-wrap">
                                <div class="tab">

                                    <div class="tab-content">
                                        <div class="tab-content-inner active" data-content="signup">
                                            <!--Put forms here-->
                                            <!--BMI Form (Kg) -->
                                            <div class="row form-group">
                                                <h3>Calculate BMI (Metric Units)</h3>
                                                <p>
                                                    Use this API to calculate Body Mass Index (BMI) based on weight in kilograms and height in meters.
                                                    Send a GET request to <code>http://18.222.105.50:8080/MaybeBabyTeamProject/fitness/service/get/bmikg</code>
                                                </p>
                                                <div>
                                                    <form action="fitness/service/bmikg" method="post">
                                                        <div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Format</label>
                                                                    <select name="format" required="required" class="form-control">
                                                                        <option value="json" style="color:grey;">Json</option>
                                                                        <option value="html" style="color:grey;">Html</option>
                                                                    </select>
                                                                </div>
                                                            </div>

                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Weight</label>
                                                                    <input type="text" name="weight" placeholder="Weight" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>Height</label>
                                                                    <input type="text" name="height" placeholder="Height" required="required" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row form-group">
                                                                <div class="col-md-12">
                                                                    <label>&nbsp;</label>
                                                                    <input type="submit" name="submit" value="Calculate BMI" class="btn btn-primary btn-block"/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- End block form div BMI Kg-->

                </div>
            </div>
        </div>
    </div>

    <footer id="gtco-footer" role="contentinfo" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="gtco-container">
            <div class="row row-pb-md">

                <div class="col-md-12 text-center copyright">
                    <p><small class="block">&copy; 2018 Team Maybe Baby</small>
                </div>

            </div>



        </div>
    </footer>
    <!-- </div> -->

</div>


<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="js/jquery.countTo.js"></script>

<!-- Stellar Parallax -->
<script src="js/jquery.stellar.min.js"></script>

<!-- Magnific Popup -->
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/magnific-popup-options.js"></script>

<script src="js/moment.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>


<!-- Main -->
<script src="js/main.js"></script>

</body>
</html>

