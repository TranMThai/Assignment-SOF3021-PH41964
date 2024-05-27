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
    <form:form action="/bill_detail/update" method="post" modelAttribute="billDetail">
        <div class="my-3">
            ID:
            <form:input path="id" readonly="true" cssClass="form-control"/>
        </div>
        <div class="my-3">
            Bill id
            <form:select path="bill.id" cssClass="form-control">
                <c:forEach var="bill" items="${bills}">
                    <option value="${bill.id}" ${bill.id eq billDetail.bill.id?"selected":""}>${bill.id}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="my-3">
            Customer
            <form:select path="productDetail.id" cssClass="form-control">
                <c:forEach var="prod" items="${productDetails}">
                    <option value="${prod.id}" ${prod.id eq billDetail.productDetail.id?"selected":""}>${prod.code}</option>
                </c:forEach>
            </form:select>
        </div>
        <div class="my-3">
            Quantity:
            <form:input path="quantity" cssClass="form-control"/>
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
