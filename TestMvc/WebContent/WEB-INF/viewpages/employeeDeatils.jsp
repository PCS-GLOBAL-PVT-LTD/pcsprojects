<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2"><tr><th>ID</th><th>Name</th><th>Age</th></tr>
<jstl:forEach  var="empObj" items="${showemp}">
<tr><td>${empObj.id}</td><td>${empObj.name}</td><td>${empObj.age}</td><td> <a href="updateprocess.com?id=${empObj.id}">edit</a></td><td><a href="deleteaction.com?id=${empObj.id}">delete</a></td></tr>

</jstl:forEach>
</table>
</body>
</html>