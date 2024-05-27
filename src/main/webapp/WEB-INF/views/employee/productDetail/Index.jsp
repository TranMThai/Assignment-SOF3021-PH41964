<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>
<div class="container my-2">

    <form action="/product_detail/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">Search:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3" value="Search">
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Size</th>
            <th>Color</th>
            <th>Quantity</th>
            <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pd" items="${list}">
            <form action="/product_detail/update" method="post">
                <input type="text" value="${pd.id}" name="id" hidden>
                <tr>
                    <td>${pd.id}</td>
                    <td>${pd.code}</td>
                    <td>${pd.size.code}</td>
                    <td>${pd.color.code}</td>
                    <td><input type="number" name="quantity" value="${pd.quantity}" style="width: 50px"></td>
                    <td>
                        <a href="/product_detail/detail/${pd.id}" class="btn btn-sm btn-primary">Detail</a>
                        <button class="btn btn-sm btn-warning" type="submit">Update</button>
                        <a href="/product_detail/remove?id=${pd.id}" class="btn btn-sm btn-danger">Remove</a>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>

</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>