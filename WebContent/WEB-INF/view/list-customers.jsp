<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
	<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href= "${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		
		<div id="content">
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button">
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
			
			
			<c:forEach items="${listOfCustomers}" var="customer">
				<!-- construct an "update" link with customer id -->
				
				<c:url var= "updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value= "${customer.id}"></c:param>
				</c:url>
				
				<c:url var= "deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value= "${customer.id}"></c:param>
				</c:url>
				
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
				</tr>
			</c:forEach>
			
		</table>
		
		</div>
	</div>

</body>

</html>