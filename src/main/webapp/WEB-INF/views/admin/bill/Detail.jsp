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
<div>
    <h3>ID: ${bill.id}</h3>
    <br>
    <h3>Id employee: ${bill.employee.id}</h3>
    <h3>Code employee: ${bill.employee.code}</h3>
    <h3>Name employee: ${bill.employee.name}</h3>
    <br>
    <h3>Id Customer: ${bill.customer.id}</h3>
    <h3>Code Customer: ${bill.customer.code}</h3>
    <h3>Name Customer: ${bill.customer.name}</h3>
    <br>
    <h3>Purchase Date: <fmt:formatDate value="${bill.purchaseDate}" type="both" dateStyle="Full" timeStyle="Full"/></h3>
    <h3>Status: ${bill.status?"Active":"Inactive"}</h3>
    <br>
    <table class="table table-striped table align-middle" style="overflow-y:scroll">
        <thead class="sticky-top">
        <tr>
            <th>No.</th>
            <th>Code</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total Price</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="total" value="0"/>
        <c:forEach var="bill" varStatus="i" items="${bill.billDetails}">
            <tr>
                <td>${i.index+1}</td>
                <td>${bill.productDetail.code}</td>
                <td>${bill.productDetail.product.name}</td>
                <td>${bill.quantity}</td>
                <td>${bill.productDetail.product.price}</td>
                <td>${bill.quantity * bill.productDetail.product.price}</td>
            </tr>
            <c:set var="total" value="${total+bill.quantity * bill.productDetail.product.price}"/>
        </c:forEach>
        </tbody>
    </table>

    <h3 class="float-end">Total amount: ${total} vnđ</h3>
</div>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>