<%-- 
    Document   : home
    Created on : Feb 21, 2020, 9:18:03 AM
    Author     : duyan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/home.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <style>
            .fakeimg {
                height: 200px;
                background: #aaa;
            }
            .carousel-inner img {
                height: 100%;
                width: auto;
            }
            .carousel-item {
                transition: 500ms;
            }
            .logo {
                margin-top: 60px;
                margin-left: 30px;
            }
            .hr_color{
                width: 100%;
                margin-left: 0;

            }
            .hr_menu{
                color: white;
                background-color: white;
            }
        </style>
    </head>
    <body>
        <!--navigation-->
        <c:url var="logout" value="MainController" >
            <c:param name="btnAction" value="Logout" />
        </c:url>
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:if test="${empty USER}">
            <c:redirect url="login.jsp" />
        </c:if>
        <!------Navigation----->
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <a class="navbar-brand" href="home_admin.jsp">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">  
                    <c:if test="${not empty user}" >
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                ${user.fullName}
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${logout}">Logout</a>
                            </div>
                        </li>
                        <form class="form-inline" action="MainController">
                            <select name="type" class="form-control mr-sm-2">
                                <option value="userManagement">User Management</option>
                                <option value="productManagement">Product Management</option>
                                <option value="bookingManagement">Booking Management</option>
                            </select>
                            <input type="submit" class="btn btn-success" name="btnAction" value="Search" >
                        </form>

                    </c:if>
                    <c:if test="${empty user}" >
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>  
                    </c:if>

                </ul>
            </div>  
        </nav>

        <!--carousel-->
        <div id="demo" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#" data-slide-to="0" class="active"></li>
                <li data-target="#" data-slide-to="1"></li>
                <li data-target="#" data-slide-to="2"></li>
            </ul>

            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/Hotel background 1.jpg" alt="Background Hotel" width="1100" height="500">
                </div>
                <div class="carousel-item">
                    <img src="img/Hotel background 2.jpg" alt="Background Hotel" width="1100" height="500">
                </div>
                <div class="carousel-item">
                    <img src="img/Hotel background 3.jpg" alt="Background Hotel" width="1100" height="500">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>

        <div class="container-fluid" style="margin-top:30px">
            <div class="row">
                <div class="col-md-3">
                    <c:set var="searchValue" value="${requestScope.SEARCH}"/>
                    <c:if test="${not empty searchValue}">
                        <c:if test="${searchValue == 'userManagement'}">
                            <c:set var="list_user" value="${requestScope.LIST_USER}" />
                            <c:if test="${not empty list_user}">
                                <table border="1" class="text-center">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>UserName</th>
                                            <th>PassWord</th>
                                            <th>FullName</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" items="${list_user}" varStatus="counter" >
                                        <form action="MainController" method="POST">
                                            <tr>
                                                <td> ${counter.count}</td>
                                                <td>
                                                    ${dto.userName}
                                                    <input type="hidden"  name="userName" value="${dto.userName}" >
                                                    <input type="hidden" name="type" value="${searchValue}">
                                                </td>
                                                <td>
                                                    <input type="text" class="text-center" name="passWord" value="${dto.passWord}" >
                                                </td>
                                                <td>
                                                    <input type="text" class="text-center" name="fullName" value="${dto.fullName}" >
                                                </td>
                                                <td>
                                                    <input type="number" class="text-center" name="phone" value="${dto.phone}" >
                                                </td>
                                                <td>
                                                    <input type="text" class="text-center" name="address" value="${dto.address}" >
                                                </td>
                                                <td>
                                                    <input type="submit"  name="btnAction" value="Update User" > 
                                                </td>
                                                <td>
                                                    <c:url var="deleteUser" value="MainController">
                                                        <c:param name="btnAction" value="Delete User"></c:param>
                                                        <c:param name="userName" value="${dto.userName}"></c:param>
                                                        <c:param name="type" value="${searchValue}"></c:param>
                                                    </c:url>
                                                    <a href="${deleteUser}">Delete User</a>
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                        </c:if>

                        <c:if test="${searchValue == 'productManagement'}">
                            <c:set var="list_product" value="${requestScope.LIST_PRODUCT}" />
                            <c:if test="${not empty list_product}">
                                <table border="1" class="text-center">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Product ID</th>
                                            <th>Product Name</th>
                                            <th>Product Price</th>
                                            <th>Product Quantity</th>
                                            <th>Update</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="dto" varStatus="counter" items="${list_product}">
                                        <form action="MainController">
                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>${dto.productID}</td>
                                                <td>${dto.productName}</td>
                                                <td>${dto.productPrice}</td>
                                                <td>
                                                    <input type="number" name="productQuantity" value="${dto.productQuantity}" />
                                                </td>
                                                <td>
                                                    <input type="hidden" name="type" value="${searchValue}">
                                                    <input type="hidden" name="productID" value="${dto.productID}" />
                                                    <input type="submit" name="btnAction" value="Update Product" />
                                                </td>
                                            </tr>
                                        </form>
                                    </c:forEach>

                                    </tbody>
                                </table>

                            </c:if>
                        </c:if>

                        <c:if test="${searchValue == 'bookingManagement'}">
                            <c:set var="list_booking" value="${requestScope.LIST_BOOKING}" />
                            <c:if test="${not empty list_booking}">
                                <table border="1" class="text-center">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>Booking ID</th>
                                            <th>Reservation ID</th>
                                            <th>Date Generated</th>
                                            <th>Room ID</th>
                                            <th>User Name</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach varStatus="counter" var="dto" items="${list_booking}">
                                            <tr>
                                                <td>${counter.count}</td>
                                                <td>${dto.bookingID}</td>
                                                <td>${dto.reservationID}</td>
                                                <td>${dto.dateGenerated}</td>
                                                <td>${dto.roomID}</td>
                                                <td>${dto.userName}</td>
                                            </tr> 
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </c:if>
                        </c:if>
                    </c:if>
                </div>
            </div>

            <br><br>
        </div>

        <!--<div class="jumbotron text-center" style="margin-bottom:0">-->
        <footer class="page-footer font-small indigo">
            <div class="container-fluid text-center text-md-left">
                <div class="row">
                    <div class="col-md-3 mx-auto">
                        <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Information</h5>
                        <ul class="list-unstyled">
                            <li>
                                <p>18/3 Nguyễn Thái Bình, P9, Q.1, TP.HCM.</p>
                            </li>
                            <li>
                                <a href="#!">Tel:0569441221</a>
                            </li>
                            <li>
                                <a href="#!">Hotline:028180399</a>
                            </li>
                            <li>
                                <a href="#!">Email:info@meowmeow.com</a>
                            </li>
                            <li>
                                <a href="#!">Web:meowmeow183.com</a>
                            </li>
                        </ul>

                    </div>
                    <hr class="clearfix w-100 d-md-none">
                    <div class="col-md-3 mx-auto">
                        <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Catalogues</h5>
                        <ul class="list-unstyled">
                            <li>
                                <a href="#!">Introduction</a>
                            </li>
                            <li>
                                <a href="#!">Profile</a>
                            </li>
                            <li>
                                <a href="#!">Customers</a>
                            </li>
                            <li>
                                <a href="#!">News</a>
                            </li>
                            <li>
                                <a href="#!">Contact</a>
                            </li>
                        </ul>

                    </div>
                    <hr class="clearfix w-100 d-md-none">
                    <div class="col-md-3 mx-auto">

                        <h5 class="font-weight-bold text-uppercase mt-3 mb-4">Services</h5>

                        <ul class="list-unstyled">
                            <li>
                                <a href="#!">Food</a>
                            </li>
                            <li>
                                <a href="#!">Support</a>
                            </li>
                            <li>
                                <a href="#!">Room Service</a>
                            </li>
                            <li>
                                <a href="#!">Exotic Location</a>
                            </li>

                        </ul>

                    </div>

                    <hr class="clearfix w-100 d-md-none">
                    <div class="col-md-3 mx-auto" >
                        <a href="home.jsp"><img src="img/logo.png" class="img-fluid logo" alt="Meow Meow Hotel"></a> 
                    </div>
                </div>
            </div>

            <div class="footer-copyright text-center py-3">© 2020 Copyright:
                <a href="#"> Meow Meow.com</a>
            </div>


        </footer>
        <!--</div>-->

    </body>
</html>
