<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admins Item Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<div align="left" > <h3> Online Shop </h3></div>
<body>

	<jsp:include page="${pageContext.request.contextPath }/header" />
	
	<a href="${pageContext.request.contextPath}/admin/product-entry">ADD NEW PRODUCT</a>
	
	<c:if test="${productMasters == null}">
						<p><strong> ${msg} </strong>
	</c:if>
	<c:if test="${productMasters != null}">
						<p><strong> ${msg} </strong>
	</c:if>
	<!-- <h3>${isNew?"New Item":"Delete Item" }</h3>  -->
	
	<form:form action="product-delete/${productMaster.id }" method="POST" >
		
		<table border="1">
		<tr>
		<th>Id</th>
     	<th>productName</th>
		<th>cost</th>
     	<th>productDescription</th>
     	</tr>
     	<c:if test="${productMasters != null}">
		<c:forEach  var="productMaster" items="${productMasters}">
				<tr>
					<td><input type="label" value=${productMaster.id }> </td>
					<td><input type="label" value=${productMaster.productName }> </td>
					<td><input type="label" value=${productMaster.cost }> </td>
					<td><input type="label" value=${productMaster.productDescription }> </td>
					<td>
					<a href="product-delete/${productMaster.id}">DELETE</a> <span>|</span>
					
					</td>
					
				</tr>
		</c:forEach>
		</c:if>
		</table>		
		
 <!-- <button>SAVE</button>		 --> 
	</form:form>
</body>
</html>