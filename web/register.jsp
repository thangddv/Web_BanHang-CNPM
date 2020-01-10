<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/particles.css">

    <style>
        body {
            background: url('https://static-communitytable.parade.com/wp-content/uploads/2014/03/rethink-target-heart-rate-number-ftr.jpg') fixed;
            background-size: cover;
        }

        *[role="form"] {
            max-width: 530px;
            padding: 15px;
            margin: 0 auto;
            border-radius: 0.3em;
            background-color: #f2f2f2;
        }

        *[role="form"] h2 {
            font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Ubuntu, "Helvetica Neue", sans-serif;
            font-size: 35px;
            font-weight: 800;
            color: #000000;
            margin-top: 5%;
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 4px;
        }
    </style>
</head>
<!------ Include the above in your HEAD tag ---------->
<body style="background: url(https://www.upsieutoc.com/images/2019/12/10/back.jpg)">

<div class="container">
    <form action="CustomerServlet" method="post" class="form-horizontal" role="form">
        <h2>Registration</h2>
        <div class="form-group">
            <label class="col-sm-3 control-label">Full Name</label>
            <div class="col-sm-9">
                <input type="text" placeholder="Full Name" class="form-control" name="Name">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Account</label>
            <div class="col-sm-9">
                <input type="text" placeholder="Account" class="form-control" name="Account">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Password*</label>
            <div class="col-sm-9">
                <input type="password" name="Password" placeholder="Password" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Confirm Password*</label>
            <div class="col-sm-9">
                <input type="password" placeholder="Repeat Password" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Email* </label>
            <div class="col-sm-9">
                <input type="email" placeholder="Email" class="form-control" name="Email">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Phone number </label>
            <div class="col-sm-9">
                <input type="text" name="Phone" placeholder="Phone number" class="form-control">
                <!--<span class="help-block">Your phone number won't be disclosed anywhere </span>-->
            </div>
        </div>
        <div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Address </label>
                <div class="col-sm-9">
                    <input type="text" id="address" placeholder="Address" class="form-control" name="Address">
                </div>
            </div>
        </div>
        <div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Location </label>
                <div class="col-sm-9">
                    <input type="text" id="city-region" placeholder="City-Region" class="form-control" name="CityRegion">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label">Credit Card </label>
            <div class="col-sm-9">
                <input type="text" id="ccNumber" placeholder="Credit Card Number" class="form-control" name="CcNumber">
            </div>
        </div>
        <div class="form-group">
            <input type="hidden" value="insert" name="command">
            <input type="submit" value="Login" class="btn btn-primary btn-block">
        </div>
<%--        <button type="submit" class="btn btn-primary btn-block">Register</button>--%>
    </form> <!-- /form -->
</div> <!-- ./container -->
<script src="js/mousemove.js" type="text/javascript"></script>
</body>
