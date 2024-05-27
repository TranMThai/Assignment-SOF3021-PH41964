<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js"
            integrity="sha512-7Pi/otdlbbCR+LnW+F7PwFcSDJOuUJB3OxtEHbg4vSMvzvJjde4Po1v4BR9Gdc9aXNUNFVUY+SK51wWT8WF0Gg=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="container login-container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-sm-8">
            <div class="card">
                <div class="card-header">
                    <h2 class="text-center">Login</h2>
                </div>
                <div class="card-body">
                    <form:form action="/login/enter" method="post" modelAttribute="auth">
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <form:input path="username" id="username" class="form-control"/>

                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <form:password path="password" id="password" class="form-control"/>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                        <span class="text-danger">${message}</span>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
