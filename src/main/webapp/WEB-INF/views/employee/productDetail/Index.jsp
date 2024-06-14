<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <form action="/product_detail/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">Search:</label>
        <input type="text" class="form-control" name="search" value="${param.search}">
        <input type="submit" class="btn btn-info px-3" value="Search">
    </form>
    <h2>Product detail</h2>
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
        <c:forEach var="pd" items="${list.content}">
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
    <nav aria-label="Page navigation example">
        <ul class="pagination d-flex justify-content-center">
            <li class="page-item">
                <a class="page-link" href="${url}page=0" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link"
                                     href="${url}page=${list.number-1<0?0:list.number-1}">${list.number==0?"...":list.number}</a>
            </li>
            <li class="page-item"><a class="page-link" href="${url}page=${list.number}">${list.number+1}</a></li>
            <li class="page-item"><a class="page-link"
                                     href="${url}page=${list.number+1>list.totalPages-1?list.totalPages-1:list.number+1}">${list.number==list.totalPages-1?"...":list.number+2}</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="${url}page=${list.totalPages-1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                </a>
            </li>
        </ul>
    </nav>

</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>