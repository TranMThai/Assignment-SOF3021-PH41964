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
    <h3>Id Employee: ${bill.idEmployee}</h3>
    <h3>Id Customer: ${bill.idCustomer}</h3>
    <h3>Purchase Date: <fmt:formatDate value="${bill.purchaseDate}" type="both" dateStyle="Full" timeStyle="Full"/></h3>
    <h3>Status: ${bill.status?"Đúng":"Sai"}</h3>
</div>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>