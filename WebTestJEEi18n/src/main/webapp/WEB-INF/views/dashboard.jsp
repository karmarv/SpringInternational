<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dash</title>
</head>
<body>

<h3>
	Message Key message.springmvc : <spring:message code="message.springmvc" text="default text" />
</h3>
<br/>
<h4>
	Hmmmm : <spring:message code="welcome.dashboard" text="Language not set here" />
</h4>

Check Locale : ${pageContext.response.locale}
<br/>
<div>
<a href="<c:url value="/welcome"/>">Dashboard</a>
</div>
</body>
</html>