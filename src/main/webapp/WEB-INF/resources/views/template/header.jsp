<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <style>
        <%@include file="/WEB-INF/resources/css/main.css" %>
    </style>
</head>
<body>
<div class="header">
    <ul>
        <div class="header-right">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a href="/contacts">My phone-book</a></li>
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <li>
                    <form action="${logoutUrl}" method="post">
                        <input id="logout-btn" type="submit" value="Logout"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </c:if>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li><a href="<c:url value="/login" />">Login</a></li>
                <li><a href="<c:url value="/register" />">Register</a></li>
            </c:if>
        </div>
    </ul>
</div>
