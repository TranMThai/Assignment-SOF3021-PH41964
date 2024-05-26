<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>
<div class="container my-2">

    <form action="/bill/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">ID:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3" value="Search">
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>ID bill</th>
            <th>ID product detail</th>
            <th>Quạntity</th>
            <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="billDetail" items="${list}">
            <tr>
                <td>${billDetail.id}</td>
                <td>${billDetail.bill.id}</td>
                <td>${billDetail.productDetail.id}</td>
                <td>${billDetail.quantity}</td>
                <td>
                    <a href="/billDetail/detail/${billDetail.id}"><button class="btn btn-sm btn-primary">Detail</button></a>
                    <a href="/billDetail/view-update/${billDetail.id}"><button class="btn btn-sm btn-warning">Update</button></a>
                    <a href="/billDetail/remove?id=${billDetail.id}"><button class="btn btn-sm btn-danger">Remove</button></a>
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