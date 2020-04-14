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
        <title>Room Booking</title>
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
            .btn{
                margin: 0 auto;
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
            <div class="row">
                <div class="col-sm-12 text-center">
                    <h3>Lavish Rooms</h3>
                    <hr class="hr_menu hr_color">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <img class="img-fluid img-body" src="img/Room/Room1.jpg" alt="DuyAnhRoom" width="630" height="420">
                    <form class="form-inline" action="booking.jsp" method="POST">
                        <input type="submit" class="btn btn-success" name="btnAction" value="Book Now" >
                    </form>
                </div>
                <div class="col-sm-4">
                    <img class="img-fluid img-body" src="img/Room/Rom2.jpg" alt="DuyAnhRoom" width="630" height="420">
                    <form class="form-inline" action="booking.jsp" method="POST">
                        <input type="submit" class="btn btn-success" name="btnAction" value="Book Now" >
                    </form>
                </div>
                <div class="col-sm-4">
                    <img class="img-fluid img-body" src="img/Room/Rom3.jpg" alt="DuyAnhRoom" width="630" height="420">
                    <form class="form-inline"action="booking.jsp" method="POST">
                        <input type="submit" class="btn btn-success" name="btnAction" value="Book Now" >
                    </form>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-12 text-center">
                    <br><h3>Facilities</h3>
                    <hr class="hr_menu hr_color">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <img class="img-fluid img-body" src="img/Room/Rom4.jpg" alt="DuyAnhRoom" >
                    <form class="form-inline" action="booking.jsp" method="POST">
                        <input type="submit" class="btn btn-success" name="btnAction" value="Book Now" >
                    </form>
                </div>
                <div class="col-sm-4">
                    <img class="img-fluid img-body" src="img/Room/Rom 5.jpg" alt="DuyAnhRoom">
                    <form class="form-inline" action="booking.jsp" method="POST">
                        <input type="submit" class="btn btn-success" name="btnAction" value="Book Now" >
                    </form>
                </div>
                <div class="col-sm-4">
                    <img class="img-fluid img-body" src="img/Room/Rom6.jpg" alt="DuyAnhRoom" >
                    <form class="form-inline" action="booking.jsp" method="POST">
                        <input type="submit" class="btn btn-success" name="btnAction" value="Book Now" >
                    </form>
                </div>
            </div>
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
