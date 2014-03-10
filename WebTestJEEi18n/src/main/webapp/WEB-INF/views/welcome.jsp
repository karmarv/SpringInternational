<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Go International</title>
</head>
<body>

<h1>Spring MVC internationalization example</h1>

Language : <a href="?language=en_US">English</a>|
<a href="?language=zh_CN">Chinese</a>|
<a href="?language=es_SP">Spanish</a>|
<a href="?language=fr_FR">French</a>

<h3>
	Message Key message.springmvc : <spring:message code="message.springmvc" text="Language not set here" />
</h3>
<br/>
<h4>
	Welcome : <spring:message code="welcome.message" text="Language still not set here" />
</h4>
Current Locale : ${pageContext.response.locale}
<br/>
<div>
<a href="<c:url value="/dashboard"/>">Dashboard</a>
</div>
</body>
</html>