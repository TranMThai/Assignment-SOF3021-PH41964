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
    <a href="/bill/view-create" class="float-end"><button class="btn btn-success px-4">Add</button></a>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Code employee</th>
            <th>Code customer</th>
            <th>Purchase date</th>
            <th>Total Amount</th>
            <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bill" items="${list}">
            <tr>
                <td>${bill.id}</td>
                <td>${bill.employee.code}</td>
                <td>${bill.customer.code}</td>
                <td><fmt:formatDate type = "both" dateStyle = "SHORT" timeStyle = "SHORT" value = "${bill.purchaseDate}" /></td>
                <td>
                    <c:set var="total" value="0"/>
                    <c:forEach var="db" items="${bill.billDetails}">
                        <c:set var="total" value="${total+(db.productDetail.product.price*db.quantity)}"/>
                    </c:forEach>
                    ${total} vnđ
                </td>
                <td>
                    <a href="/bill/detail/${bill.id}"><button class="btn btn-primary">Detail</button></a>
                    <a href="/bill/view-update/${bill.id}"><button class="btn btn-warning">Update</button></a>
                    <a href="/bill/remove?id=${bill.id}"><button class="btn btn-danger">Remove</button></a>
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