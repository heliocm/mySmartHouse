<?php
 // receive data from app's http request
if(isset ($_POST["myHttpData"]))
{
	$data = $_POST["myHttpData"];
	switch ($data) {
		case "On":
			system("cmd /c C:\Users\heliocm\mySmartHouse\Send1.vbs");
			break;
		case "Off":
			system("cmd /c C:\Users\heliocm\mySmartHouse\Send0.vbs");
			break;
		default:
			system("cmd /c C:\Users\heliocm\mySmartHouse\Send0.vbs");
			break;
		}

}
 // write data from my android app to a text file
 //file_put_contents('myTextFile.txt',$data);
?>