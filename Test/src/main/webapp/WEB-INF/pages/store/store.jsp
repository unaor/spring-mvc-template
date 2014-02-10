<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>virtual store</title>
</head>
<body>
<c:if test="${message!=null}">
		<div style="bold;">${message} </div>
</c:if>
Hello dear user what would you like to do <br/>

<c:choose>
<c:when test ="${! empty stores }">
<table>
<tr>
<td>Store name</td>
<td>store nit</td>
</tr>
<c:forEach items="${stores}" var="store">
					<tr>
					<td>${store.storeName }</td>
					<td>${store.storeNit }</td>
					</tr>
				</c:forEach>
</table>
</c:when>
<c:otherwise>
no stores are currently registered
</c:otherwise>
</c:choose>
<a href="/Test/store/add">add new store</a><br/>


<a href="/Test/">return to index</a><br/>
</body>
</html>