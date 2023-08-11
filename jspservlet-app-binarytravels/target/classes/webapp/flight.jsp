<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>FLIGHT</title>
		<link rel="stylesheet" type="text/css" href="./assets/style.css"/>
	</head>
	<body>
		<section class="result">
			<table>
				<tr>
					<td>TRIP TYPE</td>
					<td> <%out.print(request.getAttribute("flighttype")); %></td>
				</tr>
				<tr>
					<td>CHECK-IN</td>
					<td> <%out.print(request.getAttribute("fromdate")); %></td>
				</tr>
				<tr>
					<td>CHECK-OUT</td>
					<td> <%out.print(request.getAttribute("todate")); %></td>
				</tr>
				<tr>
					<td>TOTAL GUESTS</td>
					<td><%out.print(request.getAttribute("person")); %></td>
				</tr>
				<tr>
					<td>TOTAL FARE</td>
					<td><%out.print(request.getAttribute("flightfare")); %></td>
				</tr>
			</table>
		</section>
	</body>
</html>