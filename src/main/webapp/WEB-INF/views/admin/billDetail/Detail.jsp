<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body>

<div class="container my-2 row">

    <div class="col-6">
        <h2>Bill</h2>
        <h4>Bill id: ${billDetail.bill.id}</h4>
        <h4>Employee code: ${billDetail.bill.employee.code}</h4>
        <h4>Customer code: ${billDetail.bill.customer.code}</h4>
        <h4>Purchase date: <fmt:formatDate value="${billDetail.bill.purchaseDate}" dateStyle="FULL" type="date"/></h4>
    </div>

    <div class="col-6">
        <div class="row">
            <div class="col-6">
                <h2>Product</h2>
                <h4>Product code: ${billDetail.productDetail.product.code}</h4>
                <h4>Product name: ${billDetail.productDetail.product.name}</h4>
                <h4>Product detail code: ${billDetail.productDetail.code}</h4>
                <h4>Price: ${billDetail.productDetail.product.price}</h4>
            </div>
            <div class="col-6">
                <img src="/resources/images/${billDetail.productDetail.product.images[0].url}" alt="" width="100%">
            </div>
        </div>
    </div>

    <div class="col-12">
        <h4>Quantity: ${billDetail.quantity}</h4>
        <h4>Status: ${billDetail.status?"Active":"Inactive"}</h4>
    </div>


</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>