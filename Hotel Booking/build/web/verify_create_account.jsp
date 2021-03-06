<%-- 
    Document   : verify_create_account
    Created on : Mar 16, 2020, 10:37:02 PM
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
        

        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card" style="height:600px;">
                    <div class="card-header">
                        <h3>Verify</h3>
                    </div>
                    <c:set var="OTP_ERR" value="${requestScope.OTP_ERR}" />
                    <c:set var="rdNum" value="${requestScope.rdNum}" />
                    <c:if test="${not empty OTP_ERR}">
                        <h5 style="color: red">${OTP_ERR}</h5>
                    </c:if>
                    <div class="card-body">
                        <form action="VerifyServlet" method="POST">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" name="otp" placeholder="OTP" >
                                <input type="hidden" name="rdNum" value="${rdNum}" >
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn float-right login_btn" value="Verify" name="verify">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</body>
</html>
