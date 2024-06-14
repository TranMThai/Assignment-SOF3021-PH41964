<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/resources/lib/bootstrap.css">
</head>
<body class="bg-body-secondary">

<header>

    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <button class="btn text-white h-100 me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo">
                <i class="fa-solid fa-bars fs-3"></i>
            </button>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <form class="d-flex align-items-center my-0" action="/sell/search">
                    <input class="form-control me-2" type="text" placeholder="Search" name="search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>

                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)">Link</a>
                    </li>
                </ul>
            </div>
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

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Không thể mua nhiều hơn số lượng sản phẩm trong kho
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<main class="row g-0">
    <div class="col-6 ps-4 pe-3">
        <div class="p-1 bg-white row">
            <div class="tbodyDiv pe-1" style="height: 90vh;overflow: auto;">
                <h3>Danh sách sản phẩm</h3>
                <table class="table table-striped table align-middle" style="overflow-y:scroll">
                    <thead class="sticky-top">
                    <tr>
                        <th>ID</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Size</th>
                        <th>Color</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Active</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="pd" items="${productDetails}">
                        <tr>
                            <td>${pd.id}</td>
                            <td>${pd.code}</td>
                            <td>${pd.product.name}</td>
                            <td>${pd.size.name}</td>
                            <td>${pd.color.name}</td>
                            <td>${pd.quantity}</td>
                            <td>${pd.product.price} vnđ</td>
                            <td>
                                <a href="/sell/add?id=${pd.id}" class="btn btn-sm btn-success">Add</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-6 ps-1 pe-2">
        <div class="row g-0">
            <div class="col-12 mb-1">
                <div class=" bg-white">
                    <div class="tbodyDiv pe-1" style="height:53vh;overflow: auto;">
                        <div class="p-2">
                            <h4>Giỏ hàng</h4>
                            <table class="table table-striped table align-middle" style="overflow-y:scroll">
                                <thead class="sticky-top">
                                <tr>
                                    <th>No.</th>
                                    <th>Code</th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Total Price</th>
                                    <th>Active</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:set var="totalAmount" value="0"/>
                                <c:set var="totalquantity" value="0"/>
                                <c:forEach var="c" varStatus="i" items="${cart}">
                                    <form action="/sell/edit">
                                        <tr>

                                            <td>${i.index+1}</td>
                                            <td>${c.code}</td>
                                            <td>${c.product.name}</td>
                                            <td>
                                                <input type="hidden" name="id" value="${c.id}">
                                                <input type="number" name="quantity" value="${c.quantity}"
                                                       style="width: 50px">
                                            </td>
                                            <td>${c.product.price}</td>
                                            <td>${c.quantity * c.product.price}</td>
                                            <td>
                                                <button type="submit" class="btn btn-sm btn-warning">Edit</button>
                                                <a href="/sell/remove?id=${c.id}"
                                                   class="btn btn-sm btn-danger">Remove</a>
                                            </td>
                                        </tr>
                                    </form>
                                    <c:set var="totalAmount" value="${totalAmount + c.quantity * c.product.price}"/>
                                    <c:set var="totalquantity" value="${totalquantity + c.quantity}"/>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mt-1">
                <div class="col-12 bg-white">
                    <div class="p-3">

                        <form action="/sell/pay" method="post">
                            <p class="text-nowrap my-3">Staff: ${auth.code}</p>
                            <div class="d-flex align-items-center mb-3">
                                <p class="text-nowrap mb-0 me-2">Customer: </p>
                                <select name="customer" class="form-control mx-3">
                                    <option value="${null}">Choose customer</option>
                                    <c:forEach var="cust" items="${customers}">
                                        <option value="${cust.id}">${cust.code}</option>
                                    </c:forEach>
                                </select>
                                <a href="/customer" class="btn btn-success text-nowrap">New customer</a>
                            </div>
                            <p class="text-nowrap my-3">Total quantity: ${totalquantity}
                            </p>
                            <p class="text-nowrap my-3">Total amount: ${totalAmount} vnđ
                            </p>
                            <div class="d-flex justify-content-evenly mb-2">
                                <button type="submit" class="btn btn-lg btn-primary">Pay
                                </button>
                                <a href="/sell/clear" class="btn btn-lg btn-danger">Clear</a>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</main>


<script src="/resources/lib/bootstrap.js"></script>
<script src="/resources/lib/font-fontawesome-ae333ffef2.js"></script>
<script>
    const message = "${message}"
    if(message!==""){
        new bootstrap.Modal(document.querySelector("#exampleModal")).show()
    }
</script>
</body>
</html>