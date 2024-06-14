<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>

<header>

    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <button class="btn text-white h-100 me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo">
                <i class="fa-solid fa-bars fs-3"></i>
            </button>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%--            <div class="collapse navbar-collapse" id="mynavbar">--%>
            <%--                <form class="d-flex align-items-center my-0" action="/sell/search">--%>
            <%--                    <input class="form-control me-2" type="text" placeholder="Search" name="search">--%>
            <%--                    <button class="btn btn-primary" type="submit">Search</button>--%>
            <%--                </form>--%>

            <%--                <ul class="navbar-nav ms-auto">--%>
            <%--                    <li class="nav-item">--%>
            <%--                        <a class="nav-link" href="javascript:void(0)">Link</a>--%>
            <%--                    </li>--%>
            <%--                    <li class="nav-item">--%>
            <%--                        <a class="nav-link" href="javascript:void(0)">Link</a>--%>
            <%--                    </li>--%>
            <%--                    <li class="nav-item">--%>
            <%--                        <a class="nav-link" href="javascript:void(0)">Link</a>--%>
            <%--                    </li>--%>
            <%--                </ul>--%>
            <%--            </div>--%>
        </div>
    </nav>

    <div class="offcanvas offcanvas-start text-bg-dark" id="demo">
        <div class="offcanvas-header">
            <h1 class="offcanvas-title">Menu</h1>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"></button>
        </div>
        <div class="offcanvas-body">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/sell">Sell</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/bill">Bill</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/bill_detail">Bill detail</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/product">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/product_detail">Product detail</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/color">Color</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/size">Size</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-4" href="/logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</header>
<div class="container my-2">

    <form action="/bill/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">ID:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3" value="Search">
    </form>
    <h2>Bill</h2>
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
                <td><fmt:formatDate type = "date" dateStyle = "SHORT" value = "${bill.purchaseDate}" /></td>
                <td>
                    <c:set var="total" value="0"/>
                    <c:forEach var="db" items="${bill.billDetails}">
                        <c:set var="total" value="${total+(db.productDetail.product.price*db.quantity)}"/>
                    </c:forEach>
                    ${total} vnđ
                </td>
                <td>
                    <a href="/bill/detail/${bill.id}"><button class="btn btn-sm btn-primary">Detail</button></a>
                    <a href="/bill/view-update/${bill.id}"><button class="btn btn-sm btn-warning">Update</button></a>
                    <a href="/bill/remove?id=${bill.id}"><button class="btn btn-sm btn-danger">Remove</button></a>
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