<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>check out summary page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<div align="left">
	<h3>Online Shop - Order Summary</h3>
</div>
<body>

	<table border="1">
			<tr>
				<th>Id</th>
				<th>Date</th>
				<th>Address</th>
				<th>Product Amount</th>
				
			</tr>
			<form:form
				action='${pageContext.request.contextPath}/user/checkout?amount="${totalAmount}+${kitDetail.amount} }'
				method="POST">
				<tr>
					<td><input type="text" id="pid" value=${coronaKit.id }>
					</td>
					<td><input type="text" value=${coronaKit.orderDate }>
					</td>
					<td><input type="text" value=${coronaKit.deliveryAddress }>
					</td>
					<td><input type="text"
						value='${coronaKit.totalAmount}'></td>
					
				</tr>


			</form:form>
		</table>
		
		<a href="${pageContext.request.contextPath}/user/show-list">SHOW ALL ITEMS</a>

</body>
</html>