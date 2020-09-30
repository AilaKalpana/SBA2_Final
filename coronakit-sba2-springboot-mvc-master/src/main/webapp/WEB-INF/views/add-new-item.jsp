<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Item</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<script type="text/javascript">
function submitForm() {
	var cost = document.getElementById('cost').value;
	var productDescription = document.getElementById('productDescription').value;
	var productName = document.getElementById('productName').value;
	var context = document.getElementById('context').value;
	var url =  context+'/admin/product-save?cost='+cost+'&productDescription='+productDescription+'&productName='+productName;
	alert('alert ' + url);
	document.checkform.action=url;
	document.checkform.submit();
}
</script>
<div align="left">	
	<h3>Add New Item</h3>
</div>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header" />

	<form:form name="checkform"
		action='javascript:submitForm();'
		method="POST">	
		<table border="1">
			<tr>
				
				<th>Cost</th>
				<th>Product Description</th>
				<th>Product Name</th>
			</tr>
		
					
					<td><input type="text" id="cost" value=""></td>
					<td><input type="text" id="productDescription" value=""></td>
					<td><input type="text" id="productName" value=""></td>
					<td><input type="hidden" id="context" value='${pageContext.request.contextPath}'></td>
		</table>
		
		<button>Save</button>
	</form:form>
	
	</body>
</html>