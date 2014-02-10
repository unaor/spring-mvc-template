<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add store</title>
</head>
<body>
<c:if test="${message!=null}">
		<div style="bold;">${message} </div>
</c:if>

<c:if test="${customErrors!=null}">
		<c:forEach items="${customErrors}" var="error">
		<span>${error}</span><br/>
		</c:forEach>
</c:if>


	<form:form modelAttribute="customer" method="post" action="/Test/customer/addCustomerDo">

		Customer userName : <form:input path="userName" type="text"  maxlength="25"></form:input>
		<br />
		Customer first name<form:input path="firstName" type="text"  maxlength="25"></form:input>
		<br />
		Customer last name<form:input path="lastName" type="text"  maxlength="25"></form:input>
		<br />
		<input type="submit" alt="register" value="Register customer" />
	</form:form>



<a href="/Test/store">return to store</a><br/>
</body>
</html>