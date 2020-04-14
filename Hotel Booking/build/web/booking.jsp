<%-- 
Document   : booking
Created on : Mar 26, 2020, 9:16:07 PM
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
        <script>
            function leaveemail() {
                var a = document.getElementById("Email").value;
                var valid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                if (a == "") {
                    document.getElementById("ErrorEmail").style.display = "block";
                    document.getElementById("ErrorEmail").textContent = "Cannot Empty";
                } else {
                    if (!a.match(valid)) {
                        document.getElementById("ErrorEmail").style.display = "block";
                        document.getElementById("ErrorEmail").textContent = "Not valid";
                    } else {
                        document.getElementById("ErrorEmail").style.display = "none";
                    }
                }
            }
            function leavePhone() {
                var a = document.getElementById("Phone").value;
                if (a == "") {
                    document.getElementById("ErrorPhone").style.display = "block";
                    document.getElementById("ErrorPhone").textContent = "Cannot Empty";
                } else {
                    if (!Number(a)) {
                        document.getElementById("ErrorPhone").style.display = "block";
                        document.getElementById("ErrorPhone").textContent = "Please input number";
                    } else {
                        document.getElementById("ErrorPhone").style.display = "none";
                    }
                }
            }
        </script>
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
            <c:if test="${empty user}">
                <h2>Opps...! You must login before booking. Please sign in!</h2>
                <h2><a href="login.jsp">Go to login</a></h2>
            </c:if>
            <c:if test="${not empty user}">
                <c:if test="${not empty requestScope.SUCCESS}">
                    <h5 style="color: red">${requestScope.SUCCESS}</h5>
                </c:if>
                <c:if test="${empty requestScope.SUCCESS}">
                    <c:if test="${not empty requestScope.ERROR}">
                        <h5 style="color: red">${requestScope.ERROR}</h5>
                    </c:if>
                    <form action="MainController">
                        <div class="form-group">    
                            <label for="formGroupExampleInput">Name:  <sup>*</sup></label>
                            <input type="text" name="fullName" value="${user.fullName}" class="form-control" readonly="readonly">
                            <p id="ErrorName" style="display:none ; color:#FF0000">Input Error</p>
                            <input type="hidden" name="userName" value="${user.userName}" />
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email: <sup>*</sup></label>
                            <input type="email" name="email" class="form-control" id="Email" aria-describedby="emailHelp" placeholder="Example: anhndse130595@fpt.edu.vn" required="required" onBlur="leaveemail()">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                            <p id="ErrorEmail" style="display:none ; color:#FF0000">Input Error</p>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Kind of room: </label>
                            <select required="required" name="roomID">
                                <option value="111">Single</option>
                                <option value="112">Double</option>
                                <option value="113">Triple</option>
                                <option value="211">Quad</option>
                                <option value="212">Queen</option>
                                <option value="213">King</option>
                            </select>

                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Arrival Date: </label>
                            <input type="date" name="arrivalDate" class="form-control" id="formGroupExampleInput" required="required">
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Departure Date: </label>
                            <input type="date" name="departureDate" class="form-control" id="formGroupExampleInput" required="required">
                        </div>
                        <div class="form-group">
                            <label for="formGroupExampleInput">Number of Guest:  <sup>*</sup></label>
                            <input type="number" class="form-control" name="numberOfGuest"  maxlength="10" minlength="10" required="required">
                            <p id="ErrorPhone" style="display:none ; color:#FF0000">Input Error</p>
                        </div>
                        <div class="form-group">
                            <label> Smoking:  
                                <input type="radio" name="isSmoking" value="no" checked="checked"> No
                                <input type="radio" name="isSmoking" value="yes"> Yes
                            </label><br>
                            <label> Pet: 
                                <input type="radio" name="isPet" value="no" checked="checked"> No
                                <input type="radio" name="isPet" value="yes"> Yes
                            </label> 
                        </div>
                        <div class="form-group">
                            <input type="submit" name="btnAction" value="Submit booking" class="form-control btn btn-success">
                        </div>
                    </form>
                </c:if>
            </c:if>

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
