<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>
<div class="contacts">
    <div class="body">

        <h2 style="text-align: center">Edit Contact</h2>
        <p style="margin-left: 20%; margin-top: 70px;">Please change contact information bellow:</p>

        <spring:url value="/contacts/successUpdate" var="addContactForm"/>
        <form:form action="${addContactForm}" method="post" modelAttribute="editContact">
            <form:input type="hidden" path="contactId" value="${editContact.contactId}"/>
            <label for="firstName">First Name*:
                <form:errors type="text" path="firstName" value="${editContact.firstName}" class="error"/>
            </label>
            <form:input type="text" path="firstName" value="${editContact.firstName}" id="firstName"
                        class="form-control"/>

            <label for="secondName">Second Name*:
                <form:errors path="secondName" value="${editContact.secondName}" class="error"/>
            </label>
            <form:input path="secondName" value="${editContact.secondName}" id="secondName" class="form-control"/>

            <label for="patronymic">Patronymic*:
                <form:errors type="text" value="${editContact.patronymic}" path="patronymic" class="error"/>
            </label>
            <form:input type="text" value="${editContact.patronymic}" path="patronymic" id="patronymic"
                        class="form-control"/>

            <label for="mobilePhoneNumber">Phone Number*:
                <form:errors path="mobilePhoneNumber" value="${editContact.mobilePhoneNumber}"
                             class="error"/>
            </label>
            <form:input path="mobilePhoneNumber" value="${editContact.mobilePhoneNumber}" id="mobilePhoneNumber"
                        class="form-control"/>
            <label for="homePhoneNumber">Home Phone Number:
                <form:errors type="text" value="${editContact.homePhoneNumber}" path="homePhoneNumber"
                             id="homePhoneNumber"
                             class="error"/>
            </label>
            <form:input type="text" value="${editContact.homePhoneNumber}" path="homePhoneNumber"
                        id="homePhoneNumber"
                        class="form-control"/>
            <label for="address">Address:
            </label>
            <form:input path="address" value="${editContact.address}" id="address" class="form-control"/>
            <label for="email">Email:</label>
            <form:input type="email" path="email" id="email" value="${editContact.email}" class="form-control"/>

            <input type="submit" value="Submit" class="submit">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </div>
</div>

</div>

<%@include file="template/footer.jsp" %>