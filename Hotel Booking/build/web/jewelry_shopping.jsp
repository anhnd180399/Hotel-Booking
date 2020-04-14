<%-- 
    Document   : room
    Created on : Mar 9, 2020, 7:44:25 AM
    Author     : duyan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Jewelry Shopping</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="./CSS/home.css" >
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
            .hr_color{
                width: 100%;
                margin-left: 0;
            }
            .hr_menu{
                color: chocolate;
                background-color: chocolate;
            }
            .logo {
                margin-top: 60px;
                margin-left: 30px;
            }
            .img-body{
                margin-bottom: 10px;
            }
            .btn-pay{
                width: 100px;
                height: 50px;
                margin-right: 10px;
            }
        </style>
    </head>
    <body>
        <!--navigation-->
        <c:url var="logout" value="MainController" >
            <c:param name="btnAction" value="Logout" />
        </c:url>
        <c:set var="user" value="${sessionScope.USER}" />
        <!------Navigation----->
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <a class="navbar-brand" href="home.jsp">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="room.jsp">Rooms</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="jewelry_shopping.jsp">Shopping</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="booking.jsp">Booking</a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="contact.jsp">Contact Us</a>
                    </li>
                    <c:if test="${not empty user}" >
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                ${user.fullName}
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${logout}">Logout</a>
                            </div>
                        </li>
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
            <c:if test="${not empty requestScope.SUCCESS}">
                <h5 style="color: red">${requestScope.SUCCESS}</h5>
            </c:if>
            <c:if test="${empty requestScope.SUCCESS}">

                <div class="row">
                    <div class="col-sm-2">
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/Addictedtowoo.jpg" alt="Jewelry" width="145" height="150">
                            <h6> Addictedtowoo</h6>
                            <h6> Price: 60$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="101" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form>
                        </div>
                        <br><br>
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/DayEnd.jpg" alt="Jewelry" width="145" height="150">
                            <h6> DayEnd</h6>
                            <h6> Price: 80$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="102" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form>
                        </div>


                    </div>
                    <div class="col-sm-2">
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/BeyoundTheMoon.jpg" alt="Jewelry" width="145" height="150">
                            <h6> BeyoundTheMoon</h6>
                            <h6> Price: 100$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="103" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form> 
                        </div>
                        <br><br>
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/Donkey.jpg" alt="Jewelry" width="145" height="150">
                            <h6> Donkey</h6>
                            <h6> Price: 120$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="104" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form> 
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/Bloody Mary.jpg" alt="Jewelry" width="145" height="150">
                            <h6> Bloody Mary</h6>
                            <h6> Price: 140$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="105" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form> 
                        </div>
                        <br><br>
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/GoldBracelet.jpg" alt="Jewelry" width="145" height="150">
                            <h6> GoldBracelet</h6>
                            <h6> Price: 160$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="106" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form> 
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/ChainedNecklace.jpg" alt="Jewelry" width="145" height="150">
                            <h6> ChainedNecklace</h6>
                            <h6> Price: 180$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="107" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form> 
                        </div>
                        <br><br>
                        <div>
                            <img class="img-fluid img-body" src="img/Shop/SilverChain.jpg" alt="Jewelry" width="145" height="150">
                            <h6> SilverChain</h6>
                            <h6> Price: 200$</h6>
                            <form class="form-inline" action="MainController">
                                <input type="hidden" name="productID" value="108" >
                                <input type="submit" class="btn btn-success" name="btnAction" value="Add to cart" >
                            </form> 
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div>
                            <h1>Cart</h1>
                            <hr>
                            <c:set var="cart" value="${sessionScope.CART.cart}"></c:set>
                            <c:if test="${not empty requestScope.ERROR_PAY}">
                                <h5 style="color: red">${requestScope.ERROR_PAY}</h5>
                            </c:if>
                            <c:if test="${empty cart}">
                                <h5>Empty Cart!</h5>
                            </c:if>
                            <c:if test="${not empty cart}">
                                <div class="table-responsive-sm">
                                    <table border="1" class="table">
                                        <thead>
                                            <tr class="table-info">
                                                <th>No</th>
                                                <th>Product Name</th>
                                                <th>Product Price</th>
                                                <th>Product Quantity</th>
                                                <th>Remove</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach varStatus="counter" var="dto" items="${cart}">
                                                <tr class="table-active">
                                                    <td>${counter.count}</td>
                                                    <td>${dto.value.productName}</td>
                                                    <td>${dto.value.productPrice}$</td>
                                                    <td>${dto.value.productQuantity}</td>
                                                    <td>
                                                        <c:url var="deleteProduct" value="MainController">
                                                            <c:param name="btnAction" value="Delete product from cart"></c:param>
                                                            <c:param name="productID" value="${dto.key}" />
                                                        </c:url>
                                                        <a href="${deleteProduct}">Remove</a>
                                                    </td>
                                                    <c:set var="subtotal" 
                                                           value="${subtotal + dto.value.productPrice*dto.value.productQuantity}" />
                                                </tr>
                                            </c:forEach>
                                            <tr class="table-active">
                                                <td colspan="4" style="color: red">Subtotal:</td>
                                                <td style="color: red">${subtotal}$</td>
                                            </tr>
                                            <tr class="table-active">
                                                <td colspan="4" style="color: red">VAT 10%:</td>
                                                <td style="color: red">${subtotal*0.1}$</td>
                                                <c:set var="vat" value="${subtotal*0.1}" />
                                            </tr>
                                            <tr class="table-active">
                                                <td colspan="4" style="color: red">Total:</td>
                                                <td style="color: red">${vat + subtotal}$</td>

                                            </tr>
                                        </tbody>
                                    </table>
                                    <hr>
                                    <form action="MainController">
                                        <div class="form-group">
                                            <input type="submit" class="btn btn-success btn-pay float-right" value="Pay" name="btnAction">
                                        </div>
                                    </form>
                                </div>
                            </c:if>
                        </div>

                    </div>
                </div>
            </c:if>
            <div class="row">
                <div class="col-sm-12"><br></div>
            </div>
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
