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

<div class="container">
    <h2>Create New Product</h2>
    <form:form action="/product/create" method="post" modelAttribute="product">
        <div>
            Code: <form:input path="code" cssClass="form-control"/>
            <form:errors path="code"/>
        </div>
        <div>
            Name: <form:input path="name" cssClass="form-control"/>
            <form:errors path="name"/>
        </div>
        <div>
            Price: <form:input path="price" cssClass="form-control"/>
            <form:errors path="price"/>
        </div>
        <div>
            Color:
            <c:forEach var="color" items="${colors}">
                <span class="mx-3">
                    <lab>${color.name}</lab>
                <input type="checkbox" name="colors" value="${color.id}">
                </span>
            </c:forEach>
        </div>
        <div>
            Size:
            <c:forEach var="size" items="${sizes}">
                <span class="mx-3">
                    <lab>${size.name}</lab>
                    <input type="checkbox" name="sizes" value="${size.id}">
                </span>
            </c:forEach>
        </div>
        <div>
            Image: <input type="file" class="form-control" name="image">
        </div>
        <div class="mt-3">
            <input type="submit" value="Create"/>
        </div>
        </table>
    </form:form>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>