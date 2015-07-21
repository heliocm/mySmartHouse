<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/brand.png"/>

	<title>mySmartHouse</title>

<!-- Css Archives -->
    <link rel="stylesheet" href="css/bootstrap.css" >
    <link rel="stylesheet" href="css/material-fullpalette.css"/>
    <link rel="stylesheet" href="css/app.css"/>
    <link rel="stylesheet" href="css/ripples.css">
    <link rel="stylesheet" href="css/roboto.css">

<!-- Javascript Archives -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/material.js"></script>
    <script src="js/ripples.js"></script>
    <script src="js/jquery.smooth-scroll.js"></script>
    <script src="js/app.js"></script>
    <script src="js/scroll.js"></script>
    <script src="js/slick.js"></script>
    <script>
        $('.carousel').carousel({
        interval: 5000 //changes the speed of carousel rotation
        })
    </script>
	
<!-- Fonts -->
	<link href='//fonts.googleapis.com/css?family=Roboto:400,300' rel='stylesheet' type='text/css'>

</head>

<body>

<!-- Navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle Navigation</span>
					<span class="mdi-navigation-menu"></span>
					<span class="mdi-navigation-close"></span>
				</button>
				<a class="navbar-brand" href="index.html#home">
				    <img src="images/brand.png" alt=""/> 
				</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html#home">Home</a></li>
                    <li><a href="index.html#whatisit">What is it?</a></li>
                    <li><a href="index.html#whyshouldi">Why should I?</a></li>
                    <li><a href="index.html#download">Download our app!</a></li>
                    <li><a href="index.html#contact">Contact us</a></li>
                    <li><a href="lights.php">Give a try!</a></li>
				</ul>
			</div>
		</div>
	</nav>

<section id="main-container" class="container-fluid">


<!-- Content -->
<div class="section" id="whatisit">
    <div class="container">
    <h1 class="text-center"> Let's test it!</h1>
        <?php
             if(isset($_POST['off']))
             {
                system("cmd /c C:\Users\heliocm\mySmartHouse\Send0.vbs");
             } 
            else if(isset($_POST['on']))
             {
                system("cmd /c C:\Users\heliocm\mySmartHouse\Send1.vbs");
            } 
        ?>
            <form action="" method="post">
            <center>
            <br><br><br><br><br><br>
            <input type="submit"  class="btn btn-primary" name="on" value="Lights on">
            <input type="submit"  class="btn btn-danger" name="off" value="Lights off">
            <br><br><br><br><br><br>
            </center>
            </form>

    </div>
</div>


</section>

    <!--<footer>
        <div class="container">
            <div class="row parceiros">
                <a href="heliocm.github.io" class="development"> 
                    I always thought on being a bodybuilder but I wasn't thinking on this - <strong>sL1p</strong>, &ltbody&gtbuilder of this website
                </a>
            </div>
        </div>
    </footer> -->
</body>
</html>
