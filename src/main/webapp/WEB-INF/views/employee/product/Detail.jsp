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

<main>
    <div class="container">
        <div class="m-auto my-4" style="width: 90%;">
            <div class="row">
                <div class="col-12 col-lg-6">
                    <div id="demo" class="carousel slide" data-bs-ride="carousel">

                        <!-- Indicators/dots -->
                        <div class="carousel-indicators">

                            <c:forEach var="image" varStatus="i" items="${product.images}">
                                <button type="button" data-bs-target="#demo"
                                        data-bs-slide-to="${i.index}" ${i.index==0?'class="active"':''}></button>
                            </c:forEach>
                        </div>

                        <div class="carousel-inner">
                            <c:forEach var="image" varStatus="i" items="${product.images}">
                                <div class="carousel-item ${i.index==0?'active':''}">
                                    <img src="/resources/images/${image.url}" class="d-block w-100"
                                         style="height: 90vh; object-fit: cover">
                                </div>
                            </c:forEach>
                        </div>

                        <!-- Left and right controls/icons -->
                        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon"></span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                            <span class="carousel-control-next-icon"></span>
                        </button>
                    </div>
                </div>
                <div class="col-12 col-lg-6">
                    <div>
                        <h2>ID: ${product.id}</h2>
                        <h2>Code: ${product.code}</h2>
                        <h2>Name: ${product.name}</h2>
                        <h2 class="fw-bold text-danger">Price: ${product.price} vnđ</h2>
                        <h2 class="fw-bold ${product.status?"text-success":"text-danger"}">
                            Status: ${product.status?"Active":"Inactive"}</h2>
                    </div>
                    <div class="mt-3">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>No.</th>
                                <th>ID</th>
                                <th>Code</th>
                                <th>Color</th>
                                <th>Size</th>
                                <th>Quantity</th>
                                <th>Active</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="pd" varStatus="i" items="${product.productDetails}">
                                <c:if test="${pd.status}">
                                    <form action="/product/update_detail" method="post">
                                        <input type="text" value="${pd.id}" name="id" hidden>
                                        <tr>
                                            <td>${i.index+1}</td>
                                            <td>${pd.id}</td>
                                            <td>${pd.code}</td>
                                            <td>${pd.color.code}</td>
                                            <td>${pd.size.code}</td>
                                            <td><input type="number" name="quantity" value="${pd.quantity}" style="width: 50px"></td>
                                            <td>
                                                <button class="btn btn-sm btn-warning" type="submit">Update</button>
                                                <a href="/product/remove_detail?id=${pd.id}" class="btn btn-sm btn-danger">Remove</a>
                                            </td>
                                        </tr>
                                    </form>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>