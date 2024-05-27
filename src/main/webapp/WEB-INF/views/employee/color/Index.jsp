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
            <h1 class="offcanvas-title">Heading</h1>
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
            </ul>
        </div>
    </div>
</header>
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
                    <form:errors path="code"/>
                </div>
                <div class="mb-3">
                    Name:
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name"/>
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