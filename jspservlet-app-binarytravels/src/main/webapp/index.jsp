<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="./assets/style.css" /> 
		<title>Binary Travels</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<br><p id="bp"> BEST DESTINATIONS AROUND THE WORLD</p>
		<h1>Travel, enjoy and live a new and full life</h1>
		<div id="container">
			<div id="type">
				<a href="#hotel" id="hotelbtn">Hotels</a>
				<a href="#flight" id="flightbtn">Flights</a>
				<a href="#train" id="trainbtn">Trains</a>
				<a href="#bus" id="busbtn">Bus</a>
			</div>
			<form action="/jspservlet-app-binarytravels/hotel" method="post">
			<div id="hotel">
				<div id="sel">
					<div id="rt">
						<label id="b">Room Type</label> <input class="roomtype" type="radio" name="roomtype" value="AC" id="AC-room" required/><label>AC</label>
						<input class="roomtype" type="radio" name="roomtype" value="Non-AC" id="Non-AC-room" required /><label>Non-AC</label>
					</div>
					<div id="occ">
						<label id="b">Occupancy</label><input class="occupancy" type="radio" name="occupancy" value="single" id="Single" required/><label>Single</label>
						<input class="occupancy" type="radio" name="occupancy" value="double" id="Double" required/><label>Double</label>
					</div>
				</div>
				<div id="vals">
					<p>CHECK-IN</p> <p>CHECK-OUT</p> <p>GUESTS</p>
				</div>
				<div id="ins">
					<div id="inputs">
						<input type="date" name="from">
						<input type="date" name="to">
						<input type="number" name="persons" placeholder="Number of persons">
					</div>
					<button>Calculate</button>
				</div>
			</div>
			</form>
			<form action="/jspservlet-app-binarytravels/bus" method="post">
			<div id="bus">
				<div id="sel">
					<div id="rt">
						<label id="b">AC BUS</label> <input type="radio" name="bustype" value="acsleeper"><label>Sleeper</label>
						<input type="radio" name="bustype" value="acsemisleeper"><label>Semi-sleeper</label>
						<input type="radio" name="bustype" value="acseater"><label>Seater</label>
					</div>
					<div id="occ">
						<label id="b">NON-AC BUS</label> <input type="radio" name="bustype" value="nonacsleeper"><label>Sleeper</label>
						<input type="radio" name="bustype" value="nonacsemisleeper"><label>Semi-sleeper</label>
						<input type="radio" name="bustype" value="nonacseater"><label>Seater</label>
					</div>
				</div>
				<div id="vals">
					<p>CHECK-OUT</p> 
					<p>GUESTS</p>
				</div>
				<div id="ins">
				<div id="inputs">
					<input type="date" name="start">
					<input type="number" name="persons" placeholder="Number of persons">
					</div>
					<button>Calculate</button>
				</div>
			</div>
			</form>
			<form action="/jspservlet-app-binarytravels/flight" method="post">
			<div id="flight">
				<div id="sel">
					<div id="rt">
						<label id="b">Trip Type</label><input class="roomtype" type="radio" name="trip" value="one-way" id="one-way" required/><label>One way</label>
						<input class="roomtype" type="radio" name="trip" value="round-trip" id="round-trip"  required/><label>Round Trip</label>
					</div>
					<div id="occ">
						<label id="b">CLASS</label><input class="occupancy" type="radio" name="class" value="executive" id="executive" required/><label>Executive</label>
						<input class="occupancy" type="radio" name="class" value="economy" id="economy" required/><label>Economy</label>
					</div>
				</div>
				<div id="vals">
					<p>START-DATE</p> <p>RETURN-DATE</p> <p>TRAVELLERS</p>
				</div>
				<div id="ins">
				<div id="inputs">
					<input type="date" name="from"  required>
					<input type="date" name="to"  required>
					<input type="number" name="persons" placeholder="Number of persons">
					</div>
					<button>Calculate</button>
				</div>
			</div>
			</form>
			<form action="/jspservlet-app-binarytravels/train" method="post">
			<div id="train">
				<div id="sel">
					<div id="rt">
						<label id="b">CLASS</label> <input class="roomtype"	type="radio" name="berth" value="general" id="general" required/><label>General</label>
						<input class="roomtype"	type="radio" name="berth" value="second-class" id="second-class" /><label>Second class</label>
						<input class="roomtype" type="radio" name="berth" value="ac3" id="3-tier-ac" required/><label>3Tier AC</label>
						<input class="roomtype" type="radio" name="berth" value="ac2" id="2-tier-ac" required/><label>2Tier AC</label>
						<input class="roomtype" type="radio" name="berth" value="ac1" id="1-tier-ac" required/><label>1Tier AC</label>
					</div>
				</div>
				<div id="vals">
					<p>CHECK-OUT</p> <p>GUESTS</p>
				</div>
				<div id="ins">
				<div id="inputs">
					<input type="date" name="to" required>
					<input type="number" name="persons" placeholder="Number of persons">
					</div>
					<button>Calculate</button>
					
				</div>
			</div>
			</form>
		</div>
	</body>
	<script>
		document.getElementById('hotelbtn').addEventListener('click',()=>{
			document.getElementById('bus').style.display="none";
			document.getElementById('train').style.display="none";
			document.getElementById('flight').style.display="none";
			document.getElementById('hotel').style.display="block";
		})
		document.getElementById('busbtn').addEventListener('click',()=>{
			document.getElementById('bus').style.display="block";
			document.getElementById('train').style.display="none";
			document.getElementById('flight').style.display="none";
			document.getElementById('hotel').style.display="none";
		})
		document.getElementById('trainbtn').addEventListener('click',()=>{
			document.getElementById('bus').style.display="none";
			document.getElementById('train').style.display="block";
			document.getElementById('flight').style.display="none";
			document.getElementById('hotel').style.display="none";
		})
		document.getElementById('flightbtn').addEventListener('click',()=>{
			document.getElementById('bus').style.display="none";
			document.getElementById('train').style.display="none";
			document.getElementById('flight').style.display="block";
			document.getElementById('hotel').style.display="none";
		})
	</script>
</html>