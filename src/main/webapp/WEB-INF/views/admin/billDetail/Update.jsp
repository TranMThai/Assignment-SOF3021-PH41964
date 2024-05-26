<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>
<div class="container">
    <form:form action="/bill/update" method="post" modelAttribute="bill">
        <div class="my-3">
            ID:
            <form:input path="id" readonly="true" cssClass="form-control"/>
        </div>
        <div class="my-3">
            Employee
            <form:select path="employee.id" cssClass="form-control">
                <c:forEach var="emp" items="${employees}">
                    <option value="${emp.id}" ${emp.id eq bill.employee.id?"selected":""}>${emp.code}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="my-3">
            Customer
            <form:select path="customer.id" cssClass="form-control">
                <c:forEach var="cust" items="${customers}">
                    <option value="${cust.id}" ${cust.id eq bill.customer.id?"selected":""}>${cust.code}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="my-3">
            Purchase date:
            <input value="<fmt:formatDate value="${bill.purchaseDate}" type="date" dateStyle="short"/>" name="purchaseDate" type="text" cssClass="form-control" class="form-control"/>
        </div>
        <div class="my-3">
            Status:
            <form:radiobutton path="status" value="true" label="active" cssClass="ms-2"/>
            <form:radiobutton path="status" value="false" label="inactive" cssClass="ms-3"/>
        </div>
        <div>
            <button type="submit" class="btn btn-success">Update</button>
        </div>
    </form:form>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>
