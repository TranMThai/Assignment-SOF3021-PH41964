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

    <form action="/employee/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">Search:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3">
    </form>

    <a href="/employee/create" class="btn btn-success float-end">Create</a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Username</th>
            <th>Name</th>
            <th>Role</th>
            <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${list}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.code}</td>
                <td>${emp.username}</td>
                <td>${emp.name}</td>
                <td>${emp.role?"ADMIN":"STAFF"}</td>
                <td>
                    <a href="/employee/detail/${emp.id}">
                        <button class="btn btn-sm btn-primary">Detail</button>
                    </a>
                    <a href="/employee/change_password/${emp.id}">
                        <button class="btn btn-sm btn-warning">Change password</button>
                    </a>
                    <a href="/employee/remove?id=${emp.id}">
                        <button class="btn btn-sm btn-danger">Remove</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>