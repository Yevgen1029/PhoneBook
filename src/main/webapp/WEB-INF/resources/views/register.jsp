<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="template/header.jsp" %>
<div class="body">

    <div class="container-wrapper">
        <div class="container">
            <div id="login-box">
                <h2 style="text-align: center">Register User</h2>
                <p class="lead" style="margin-left: 10%">Please input your information bellow:</p>

                <spring:url value="/register" var="registerForm"/>
                <form:form action="${registerForm}" method="post" modelAttribute="user">

                    <div class="form-group">
                        <label for="login">Login*:
                            <form:errors type="login" path="login" id="login" class="error"/>
                        </label>
                        <form:input type="login" path="login" id="login" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="password">
                            <Password>Password:</Password>
                            <form:errors path="password" id="password" class="error"/>
                        </label>
                        <form:password path="password" id="password" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="password">
                            <Password>Confirm your password:</Password>
                            <c:if test="${not empty confirmPasswordError}">
                                <b class="error">${  confirmPasswordError}</b>
                            </c:if>
                        </label>
                        <input type="password" id="confirmPasswordError" name="checkPassword" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="fio">Full name:
                            <form:errors path="fio" id="fio" class="error"/>
                        </label>
                        <form:input path="fio" id="fio" class="form-control"/>
                    </div>


                    <input type="submit" value="Submit" class="submit">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form:form>
            </div>
        </div>
    </div>
<%@include file="template/footer.jsp" %>