<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>
<div class="container my-2">

    <form action="/color/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">Search:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3">
    </form>

    <div class="row">
        <div class="col-8">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Active</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="color" items="${list}">
                    <tr>
                        <td>${color.id}</td>
                        <td>${color.code}</td>
                        <td>${color.name}</td>
                        <td>
                            <a href="/color/detail/${color.id}"><button class="btn btn-sm btn-primary">Detail</button></a>
                            <a href="/color/remove?id=${color.id}"><button class="btn btn-sm btn-danger">Remove</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-4">
            <form:form action="/color/save" method="post" modelAttribute="color">
                <div class="mb-3">
                    Id:
                    <form:input path="id" cssClass="form-control" readonly="true"/>
                </div>
                <div class="mb-3">
                    Code:
                    <form:input path="code" cssClass="form-control"/>
                </div>
                <div class="mb-3">
                    Name:
                    <form:input path="name" cssClass="form-control"/>
                </div>
                <div class="d-flex justify-content-evenly">
                    <a href="/color/clear" class="btn btn-secondary">Clear</a>
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