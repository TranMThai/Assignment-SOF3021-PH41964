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

<div class="container my-2">
    <form:form action="/employee/create" method="post" modelAttribute="employee">
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
        <div class="mb-3">
            Username:
            <form:input path="username" cssClass="form-control"/>
            <form:errors path="username"/>
        </div>
        <div class="mb-3">
            Password:
            <form:input path="password" cssClass="form-control"/>
            <form:errors path="password"/>
        </div>
        <div class="mb-3">
            Role:
            <form:radiobutton path="role" value="true" label="Admin" cssClass="ms-3"/>
            <form:radiobutton path="role" value="false" label="Staff" cssClass="ms-3"/>
            <form:errors path="role"/>
        </div>
        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form:form>
</div>

<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
</body>
</html>