<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>
<div class="container my-2">

    <form action="/customer/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">Search:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3">
    </form>

    <div class="row">
        <div class="col-7">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Phone number</th>
                    <th>Active</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cust" items="${list}">
                    <tr>
                        <td>${cust.id}</td>
                        <td>${cust.code}</td>
                        <td>${cust.name}</td>
                        <td>${cust.phoneNumber}</td>
                        <td>
                            <a href="/customer/detail/${cust.id}">
                                <button class="btn btn-sm btn-primary">Detail purchase</button>
                            </a>
                            <a href="/customer/read/${cust.id}">
                                <button class="btn btn-sm btn-warning">Read</button>
                            </a>
                            <a href="/customer/remove?id=${cust.id}">
                                <button class="btn btn-sm btn-danger">Remove</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-5">
            <form:form action="/customer/save" method="post" modelAttribute="customer">
                <div class="mb-3">
                    Id:
                    <form:input path="id" cssClass="form-control" readonly="true"/>
                    <form:errors path="id" />
                </div>
                <div class="mb-3">
                    Code:
                    <form:input path="code" cssClass="form-control"/>
                    <form:errors path="code" />
                </div>
                <div class="mb-3">
                    Name:
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" />
                </div>
                <div class="mb-3">
                    Phone number:
                    <form:input path="phoneNumber" cssClass="form-control"/>
                    <form:errors path="phoneNumber" />
                </div>
                <div class="d-flex justify-content-evenly">
                    <a href="/customer/clear" class="btn btn-secondary">Clear</a>
                    <button type="submit" class="btn btn-warning">Save</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>