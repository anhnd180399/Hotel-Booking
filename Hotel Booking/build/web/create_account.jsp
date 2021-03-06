<%-- 
    Document   : create_account
    Created on : Feb 26, 2020, 9:54:28 AM
    Author     : duyan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/login.css" >
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!--navigation-->
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
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>    
                </ul>
            </div>  
        </nav>
        <c:set var="errors" value="${requestScope.ERRORS}" />

        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card" style="height:600px;">
                    <div class="card-header">
                        <h3>Sign Up</h3>
                    </div>
                    <div class="card-body">
                        <form action="MainController" method="POST">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="userName" value="${param.userName}"  placeholder="Username" >
                            </div>
                            <c:if test="${not empty errors.userNameErr}">
                                <p style="color: red">${errors.userNameErr}</p>
                            </c:if>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" name="passWord" value="${param.passWord}" placeholder="Password"><br>
                            </div>
                            <c:if test="${not empty errors.passWordErr}">
                                <p style="color: red">${errors.passWordErr}</p>
                            </c:if>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="password" class="form-control" name="confirmPassWord" value="${param.confirmPassWord}" placeholder="Comfirm Password"><br>

                            </div>
                            <c:if test="${not empty errors.confirmPassWordErr}">
                                <p style="color: red">${errors.confirmPassWordErr}</p>
                            </c:if>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="fullName" value="${param.fullName}" placeholder="Fullname"><br>
                            </div>
                            <c:if test="${not empty errors.fullNameErr}">
                                <p style="color: red">${errors.fullNameErr}</p>
                            </c:if>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="number" class="form-control" name="phone" value="${param.phone}" placeholder="Phone"><br>
                            </div>
                            <c:if test="${not empty errors.phoneErr}">
                                <p style="color: red">${errors.phoneErr}</p>
                            </c:if>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="address" value="${param.address}" placeholder="Address"><br>
                            </div>
                            <c:if test="${not empty errors.addressErr}">
                                <p style="color: red">${errors.addressErr}</p>
                            </c:if>
                            <div class="form-group">
                                <input type="reset" class="btn float-right login_btn" value="Reset" >
                                <input type="submit" class="btn float-right login_btn" value="Create" name="btnAction">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</body>
</html>