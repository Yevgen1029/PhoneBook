<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp"%>
<div class="body">

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2 style="text-align: center">Sign in with Login and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg" style="text-align: center">${msg}</div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="error" style="color: #ff0000;">${error}</div>
            </c:if>

            <form action="<c:url value="/j_spring_security_check"/>"  method="post">
                <div class="form-group">
                    <label for="login">Login: </label>
                    <input type="text" id="login" name="login" class="form-control"/>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>
                <input type="submit" value="Submit" class="btn btn-default">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>
    </div>
</div>
<%@include file="template/footer.jsp"%>