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
    <h4>ID: ${cust.id}</h4>
    <h4>Code: ${cust.code}</h4>
    <h4>Name: ${cust.name}</h4>
    <h4>Phone number: ${cust.phoneNumber}</h4>
    <h4>Status: ${cust.status?"Active":"Inactive"}</h4>

    <h2 class="mt-4">Purchase history</h2>
    <table class="table table-striped table align-middle" style="overflow-y:scroll">
        <thead class="sticky-top">
        <tr>
            <th>No.</th>
            <th>Employ</th>
            <th>Purchase</th>
            <th>Total amount</th>
            <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="total" value="0"/>
        <c:forEach var="bill" varStatus="i" items="${cust.bills}">
            <tr>
                <td>${i.index+1}</td>
                <td>${bill.employee.code}</td>
                <td><fmt:formatDate value="${bill.purchaseDate}" type="date" dateStyle="Short"/></td>
                <td>
                    <c:set var="total" value="0"/>
                    <c:forEach var="detail" items="${bill.billDetails}">
                        <c:set var="total" value="${total+(detail.productDetail.product.price * detail.quantity)}"/>
                    </c:forEach>
                    ${total}
                </td>
                <td>
                    <a href="/bill/detail/${bill.id}" class="btn btn-sm btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>