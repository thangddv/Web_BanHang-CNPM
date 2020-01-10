<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>AMAZ - eCommerce</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Place favicon.ico in the root directory -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">


    <!-- All css files are included here. -->
    <!-- Bootstrap fremwork main css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Owl Carousel min css -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <!-- This core.css file contents all plugings css file. -->
    <link rel="stylesheet" href="css/core.css">
    <!-- Theme shortcodes/elements style -->
    <link rel="stylesheet" href="css/shortcode/shortcodes.css">
    <link rel="stylesheet" href="style1.css">
    <!-- Theme main style -->
    <!-- Responsive css -->
    <link rel="stylesheet" href="css/particles.css">

    <link rel="stylesheet" href="css/responsive.css">
    <!-- User style -->
    <link rel="stylesheet" href="css/custom.css">
    <link rel="stylesheet" href="css/image.css">


    <!-- Modernizr JS -->
    <script src="js/vendor/modernizr-3.5.0.min.js"></script>
</head>

<body>
<div id="particles-js"></div>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Body main wrapper start -->
<div class="wrapper">
    <!-- Start Header Style -->
    <jsp:include page="header.jsp"/>
    <!-- End Header Area -->

    <div class="body__overlay"></div>
    <!-- Start Offset Wrapper -->
    <div class="offset__wrapper">
        <!-- Start Search Popap -->
        <div class="search__area">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="search__inner">
                            <form action="search" method="get">
                                <input name="ProductName" placeholder="Search here... " type="text">
                                <button type="submit"></button>
                            </form>
                            <div class="search__close__btn">
                                <span class="search__close__btn_icon"><i class="zmdi zmdi-close"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Search Popap -->
        <!-- Start Cart Panel -->
        <div class="shopping__cart">
            <div class="shopping__cart__inner">
                <div class="offsetmenu__close__btn">
                    <a href="#"><i class="zmdi zmdi-close"></i></a>
                </div>
                <div class="shp__cart__wrap">
                    <c:forEach var="item" items="${cart.getItems()}">
                    <div class="shp__single__product">
                        <div class="shp__pro__thumb">
                            <a href="#">
                                <img src="${item.getProduct().getImage()}" alt="product images">
                            </a>
                        </div>
                        <div class="shp__pro__details">
                            <h2><a href="detail?product_id=${item.getProduct().getProductId()}">${item.getProduct().getName()}</a></h2>
                            <span class="quantity">QTY: 1</span>
                            <span class="shp__price">$${item.getProduct().getPrice()}</span>
                        </div>
                        <div class="remove__btn">
                            <a href="#" title="Remove this item"><i class="zmdi zmdi-close"></i></a>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <ul class="shoping__total">
                    <li class="subtotal">Subtotal:</li>
                    <li class="total__price">$${cart.getTotal()}</li>
                </ul>
                <ul class="shopping__btn">
                    <li><a href="cart.jsp">View Cart</a></li>
                </ul>
            </div>
        </div>
        <!-- End Cart Panel -->
    </div>
    <!-- End Offset Wrapper -->
    <!-- Start Slider Area -->
    <div class="slider__container slider--one bg__cat--3">
        <div class="slide__container slider__activation__wrap owl-carousel">
            <!-- Start Single Slide -->
            <div class="single__slide animation__style01 slider__fixed--height">
                <div class="container">
                    <div class="row align-items__center">
                        <div class="col-md-7 col-sm-7 col-xs-12 col-lg-6">
                            <div class="slide">
                                <div class="slider__inner">
                                    <h2>Welcome friends to our website!</h2>
                                    <h1>TEAM 16</h1>
                                    <div class="cr__btn">
                                        <a href="cart.jsp">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-5 col-xs-12 col-md-5">
                            <div class="slide__thumb">
                                <img src="images/banner2.jpg" alt="slider images" style="width:628px; height: 472px">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Single Slide -->
            <!-- Start Single Slide -->
            <div class="single__slide animation__style01 slider__fixed--height">
                <div class="container">
                    <div class="row align-items__center">
                        <div class="col-md-7 col-sm-7 col-xs-12 col-lg-6">
                            <div class="slide">
                                <div class="slider__inner">
                                    <h2>May this new year bring you joy and laughter!</h2>
                                    <h1>TEAM 16</h1>
                                    <div class="cr__btn">
                                        <a href="cart.jsp">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-sm-5 col-xs-12 col-md-5">
                            <div class="slide__thumb">
                                <img src="images/banner1.jpg" alt="slider images" style="width:628px; height: 472px">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Single Slide -->
        </div>
    </div>
    <!-- Start Slider Area -->
    <!-- Start Category Area -->
    <section class="ftr__product__area ptb--10">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="section__title--2 text-center">
                        <h2 class="title__line">Top Sales</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="product__wrap clearfix">
                    <!-- Start Single Category -->
                    <c:forEach var="product" items="${newProducts}">
                        <div class="col-md-4 col-lg-3 col-sm-4 col-xs-12" style="height: 370px">
                            <div class="category">
                                <div class="ht__cat__thumb">
                                    <a href="detail?product_id=${product.getProductId()}">
                                        <img class="image" src="${product.getImage()}" alt="product images">
                                    </a>
                                </div>
                                <div class="fr__hover__info">
                                    <ul class="product__action">
                                        <li><a href="addcart?product_id=${product.getProductId()}"><i
                                                class="icon-handbag icons"></i></a></li>
                                    </ul>
                                </div>
                                <div class="fr__product__inner">
                                    <h4><a href="detail?product_id=${product.getProductId()}">${product.getName()}</a></h4>
                                    <ul class="fr__pro__prize">
                                        <li class="old__prize">$${Math.round(product.getPrice()+15)}</li>
                                        <li>$ ${product.getPrice()}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- End Single Category -->
                </div>
            </div>
        </div>
    </section>
    <!-- End Category Area -->
    <!-- Start Product Area -->
    <section class="ftr__product__area ptb--10">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="section__title--2 text-center">
                        <h2 class="title__line">Best Sellers</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="product__wrap clearfix">
                    <!-- Start Single Category -->
                    <c:forEach var="product" items="${newProducts_1}">
                        <div class="col-md-4 col-lg-3 col-sm-4 col-xs-12" style="height: 370px">
                            <div class="category">
                                <div class="ht__cat__thumb">
                                    <a href="detail?product_id=${product.getProductId()}">
                                        <img class="image" src="${product.getImage()}" alt="product images">
                                    </a>
                                </div>
                                <div class="fr__hover__info">
                                    <ul class="product__action">
                                        <li><a href="addcart?product_id=${product.getProductId()}"><i
                                                class="icon-handbag icons"></i></a></li>
                                    </ul>
                                </div>
                                <div class="fr__product__inner">
                                    <h4><a href="detail?product_id=${product.getProductId()}">${product.getName()}</a></h4>
                                    <ul class="fr__pro__prize">
                                        <li>$ ${product.getPrice()}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <!-- End Single Category -->
                </div>
            </div>
        </div>
    </section>
    <!-- End Product Area -->
    <!-- Start Top Rated Area -->
    <section class="top__rated__area bg__white pt--100 pb--110">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section__title--2 text-center">
                        <h2 class="title__line">Top Rated</h2>
                    </div>
                </div>
            </div>
            <div class="row mt--20">
                <!-- Start Single Product -->
                <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                    <div class="htc__best__product">
                        <div class="htc__best__pro__thumb">
                            <a href="detail?product_id=${product.getProductId()}">
                                <img class="image" src="images/Macbook.jpg" alt="small product">
                            </a>
                        </div>
                        <div class="htc__best__product__details">
                            <h2><a href="detail?product_id=${product.getProductId()}">dummy Product title</a></h2>
                            <ul class="rating">
                                <li><i class="icon-star icons"></i></li>
                                <li><i class="icon-star icons"></i></li>
                                <li><i class="icon-star icons"></i></li>
                                <li class="old"><i class="icon-star icons"></i></li>
                                <li class="old"><i class="icon-star icons"></i></li>
                            </ul>
                            <ul class="top__pro__prize">
                                <li>$75.2</li>
                            </ul>
                            <div class="best__product__action">
                                <ul class="product__action--dft">
                                    <li><a href="addcart?product_id=${product.getProductId()}"><i
                                            class="icon-handbag icons"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Single Product -->
            </div>
        </div>
    </section>
    <!-- End Top Rated Area -->
    <!-- Start Footer Area -->
    <jsp:include page="footer.jsp"/>
    <!-- End Footer Style -->
</div>
</body>
<!-- Body main wrapper end -->

<!-- Placed js at the end of the document so the pages load faster -->

<!-- jquery latest version -->
<script type="text/javascript" src="js/particles.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<%--<script type="text/javascript" src="js/mousemove.js"></script>--%>
<script src="js/vendor/jquery-3.2.1.min.js"></script>
<!-- Bootstrap framework js -->
<script src="js/bootstrap.min.js"></script>
<!-- All js plugins included in this file. -->
<script src="js/plugins.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<!-- Waypoints.min.js. -->
<script src="js/waypoints.min.js"></script>
<!-- Main js file that contents all jQuery plugins activation. -->
<script src="js/main.js"></script>

</body>

</html>