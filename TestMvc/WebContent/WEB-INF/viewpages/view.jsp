<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE>
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3 align="center" style="color: red">${msg}</h3>
<s:form action="formreceiver.com" modelAttribute="userobj">
<p> <s:input path="name" /> </p>
<s:errors path="name"></s:errors>
<p> <s:input path="age"/> </p>
<s:errors path="age"></s:errors><br>

<s:button>Submit</s:button>
</s:form>
</body>
</html>