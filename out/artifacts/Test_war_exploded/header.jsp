<%@ page import="model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/darkmode.css" rel="stylesheet">
<html>
<head>
    <%
        Customer customer = null;
        if (session.getAttribute("customer") != null) {
            customer = (Customer) session.getAttribute("customer");
        }
    %>
</head>
<body>
<header id="htc__header" class="htc__header__area header--one">
    <!-- Start Mainmenu Area -->
    <div id="sticky-header-with-topbar" class="mainmenu__wrap sticky__header">
        <div class="container">
            <div class="row">
                <div class="menumenu__container clearfix">
                    <div class="col-lg-2 col-md-2 col-sm-3 col-xs-5">
                        <div class="logo">
                            <a href="index"><img src="images/logo.png" alt="logo images"></a>
                        </div>
                    </div>
                    <div class="col-md-7 col-lg-8 col-sm-5 col-xs-3">
                        <nav class="main__menu__nav hidden-xs hidden-sm">
                            <ul class="main__menu">
                                <li class="drop"><a href="index">Home</a></li>
                                <li class="drop"><a href="product">Product</a></li>
                                <li class="drop"><a href="http://localhost:8081/index?username=${customer.getName()}">Contact</a></li>
                                <%
                                    if (session.getAttribute("customer") != null) {
                                %>
                                <li class="drop">
                                    <a href="#"><%=customer.getName()%>
                                    </a>
                                </li>
                                <li class="drop">
                                    <a href="CustomerServlet"> Log out </a>
                                </li>
                                <li class="drop switch">
                                    Dark mode:
                                    <span class="inner-switch">OFF</span>
                                </li>

                                <%
                                } else {
                                %>
                                <li class="nav-item">
                                    <a class="nav-link" href="login.jsp">Sign in</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="register.jsp"> Register </a>
                                </li>
                                <li class="drop switch">
                                    Dark mode:
                                    <span class="inner-switch">OFF</span>
                                </li>


                                <%
                                    }
                                %>
                            </ul>
                        </nav>

                        <div class="mobile-menu clearfix visible-xs visible-sm">
                            <nav id="mobile_dropdown">
                                <ul>
                                    <li><a href="index.jsp">Home</a></li>
                                    <li><a href="product">Product</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="contact.html">Login</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                    <div class="col-md-3 col-lg-2 col-sm-4 col-xs-4">
                        <div class="header__right">
                            <div class="header__search search search__open">
                                <a href="#"><i class="icon-magnifier icons"></i></a>
                            </div>
                            <%
                                if (session.getAttribute("customer") != null) {
                            %>
                            <div class="htc__shopping__cart">
                                <a class="cart__menu" href="cart.jsp">
                                    <i class="icon-handbag icons"></i></a>
                                <a href="cart.jsp">
                                    <span class="htc__qua">
                                        <c:choose>
                                            <c:when test="${cart.numberOfItems == null}">
                                                0
                                            </c:when>
                                            <c:otherwise>
                                                ${cart.numberOfItems}
                                            </c:otherwise>
                                        </c:choose>
                                    </span>
                                </a>
                            </div>
                            <%
                            } else {
                            %>
                            <div class="htc__shopping__cart">
                                <a class="cart__menu" href="login.jsp">
                                    <i class="icon-handbag icons"></i></a>
                                <a href="login.jsp">
                                        <span class="htc__qua">
                                            <c:choose>
                                                <c:when test="${cart.numberOfItems == null}">
                                                    0
                                                </c:when>
                                                <c:otherwise>
                                                    ${cart.numberOfItems}
                                                </c:otherwise>
                                            </c:choose>
                                        </span>
                                </a>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
            <div class="mobile-menu-area"></div>
        </div>
    </div>
</header>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src ="js/darkmode.js"></script>
</body>
</html>
