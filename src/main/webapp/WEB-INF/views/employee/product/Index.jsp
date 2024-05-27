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


<div class="container mt-3">
    <form action="/product/search" method="get" class="d-flex align-items-center gap-5">
        <label class="form-label">Search:</label>
        <input type="text" class="form-control" name="search">
        <input type="submit" class="btn btn-info px-3" value="Search">
    </form>

    <div class="my-4">
        <div class="d-flex justify-content-between my-2">
            <h2>Product list</h2>
            <a href="/product/create" class="float-end">
                <button class="btn btn-success">Add product</button>
            </a>
        </div>
        <div class="row g-3">
            <c:forEach var="pro" items="${list}">
                <div class="col-6 col-md-4 col-lg-3">
                    <div class="border rounded-4 overflow-hidden shadow-sm">
                        <div class="ratio ratio-1x1">
                            <img src="/resources/images/${pro.images[0].url}" class="object-fit-contain" alt="">
                        </div>
                        <div class="row w-100">
                            <div class="col-8 pe-1">
                                <div class="infor mt-2 ps-3">
                                    <div class="product-name overflow-hidden" style="height: 60px;">
                                        <p class="fw-bold fs-5">${pro.name}</p>
                                    </div>
                                    <div class="d-flex flex-wrap mb-3 ">
                                        <p class="fw-bold text-danger my-0">${pro.price}</p>
                                        <p class="fw-bold text-danger ms-1 my-0">vnđ</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4 px-0 py-1">
                                <a href="/product/detail/${pro.id}">
                                    <button class="btn w-100 btn-success my-1 btn-sm">Detail</button>
                                </a>
                                <a href="/product/update/${pro.id}">
                                    <button class="btn w-100 btn-warning my-1 btn-sm">Update</button>
                                </a>
                                <a href="/product/remove?id=${pro.id}">
                                    <button class="btn w-100 btn-danger my-1 btn-sm">Remove</button>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>


<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>