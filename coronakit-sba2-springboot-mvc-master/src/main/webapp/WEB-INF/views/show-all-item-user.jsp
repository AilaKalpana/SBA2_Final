<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Item Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<div align="left">
	<h3>Online Shop</h3>
</div>
<body>

	<jsp:include page="${pageContext.request.contextPath }/header" />

	<!-- <h3>${isNew?"New Item":"Delete Item" }</h3>  -->

	<c:forEach var="productMaster" items="${productMasters}">
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Product Name</th>
				<th>Cost</th>
				<th>Product Description</th>
				<th>Select Item</th>
			</tr>
			<form:form
				action='${pageContext.request.contextPath}/user/add-to-cart/${productMaster.id }'
				method="POST">
				<tr>
					<td><input type="text" id="pid" value=${productMaster.id }>
					</td>
					<td><input type="text" value=${productMaster.productName }>
					</td>
					<td><input type="text" value=${productMaster.cost }>
					</td>
					<td><input type="text"
						value=${productMaster.productDescription }></td>
					<td><input type="submit" value="Add to Kit"></td>
				</tr>


			</form:form>
		</table>
	</c:forEach>
	<form:form
		action='${pageContext.request.contextPath}/user/show-kit'
		method="POST">
		<button>View Kit</button>
	</form:form>

</body>
</html>