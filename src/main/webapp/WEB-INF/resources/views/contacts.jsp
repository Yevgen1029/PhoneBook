<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="template/header.jsp" %>
<div class="contacts">
    <table style="font-size: 14px; width: 81%; margin-left: 10%; margin-top: 70px;">
        <tr>
            <th style="width:9%;">Name</th>
            <th style="width:9%;">Patronymic</th>
            <th style="width:9%;">Surname</th>
            <th style="width:13%;">Phone number</th>
            <th style="width:13%;">Home phone number</th>
            <th style="width:20%;">Address</th>
            <th style="width:11%;">Email</th>
            <th>Actions</th>
        </tr>
        <c:if test="${not empty contactList}">
            <c:forEach var="contact" varStatus="status" items="${contactList}">
                <tr>
                    <td><c:out value="${contact.getFirstName()}"/></td>
                    <td><c:out value="${contact.getPatronymic()}"/></td>
                    <td><c:out value="${contact.getSecondName()}"/></td>
                    <td><c:out value="${contact.getMobilePhoneNumber()}"/></td>
                    <td><c:out value="${contact.getHomePhoneNumber()}"/></td>
                    <td><c:out value="${contact.getAddress()}"/></td>
                    <td><c:out value="${contact.getEmail()}"/></td>
                    <td style="text-align: center;">
                        <table class="empty-table">
                            <tr>
                                <a class="btn btn-default" style="background-color: #ff898c"
                                   href="/contacts/delete?contactId=${contact.contactId}" role="button">DELETE</a>
                                <a class="btn btn-default" style="background-color: #22d387"
                                   href="/contacts/update?contId=${contact.contactId}" role="button">UPDATE</a>
                            </tr>
                        </table>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

    </table>
</div>
<!-- Trigger/Open The Modal -->
<button id="myBtn" style="background-color: #6da9ff">Add Contact</button>

<!-- The Modal -->
<div id="myModal" class="modal" style="display: ${modalDisplay};">

    <!-- Modal content -->
    <%--<div class="modal-content">--%>
    <div class="body" style="margin-left: 20%; width: 60%">
        <span class="close">&times;</span>
        <div id="login-box">
            <h2 style="text-align: center">Add Contact</h2>
            <p class="lead" style="text-align: center; margin-left: 10%">Please input contact information bellow:</p>

            <c:if test="${not empty emptyFieldError}">
                <label style="color: #ff5954; font-size: 20px">${emptyFieldError}</label>
            </c:if>
            <spring:url value="/contacts" var="addContactForm"/>
            <form:form action="${addContactForm}" method="post" modelAttribute="contact">

                <div class="form-group">
                    <label for="firstName">First Name*:
                        <form:errors type="text" path="firstName" id="firstName" class="error"/>
                    </label>
                    <form:input type="text" path="firstName" id="firstName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="secondName">Second Name*:
                        <form:errors path="secondName" id="secondName" class="error"/>
                    </label>
                    <form:input path="secondName" id="secondName" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="patronymic">Patronymic*:
                        <form:errors type="text" path="patronymic" id="patronymic" class="error"/>
                    </label>
                    <form:input type="text" path="patronymic" id="patronymic" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="mobilePhoneNumber">Phone Number*:
                        <form:errors path="mobilePhoneNumber" id="mobilePhoneNumber" class="error"/>
                    </label>
                    <form:input path="mobilePhoneNumber" id="mobilePhoneNumber" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="homePhoneNumber">Home Phone Number:
                        <form:errors type="text" path="homePhoneNumber" id="homePhoneNumber" class="error"/>
                    </label>
                    <form:input type="text" path="homePhoneNumber" id="homePhoneNumber" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="address">Address:
                    </label>
                    <form:input path="address" id="address" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <form:input type="email" path="email" id="email" class="form-control"/>
                </div>

                <input type="submit" value="Submit" class="submit">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
        </div>
    </div>

</div>

<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    btn.onclick = function () {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>


<%@include file="template/footer.jsp" %>

