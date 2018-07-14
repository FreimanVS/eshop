<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="counter" uri="/custom" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart</title>
	<link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>
    <link href="${pageContext.request.contextPath}/eshop/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/eshop/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/eshop/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/eshop/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/eshop/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/eshop/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/eshop/css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/eshop/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/eshop/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/eshop/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/eshop/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/eshop/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/eshop/images/ico/apple-touch-icon-57-precomposed.png">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/cart.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/search.js" type="text/javascript"></script>

</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<%@ include file="/WEB-INF/jsp/parts/header.jsp"%>
		<%--<div class="header_top"><!--header_top-->--%>
			<%--<div class="container">--%>
				<%--<div class="row">--%>
					<%--<div class="col-sm-6">--%>
						<%--<div class="contactinfo">--%>
							<%--<ul class="nav nav-pills">--%>
								<%--<li><a href=""><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>--%>
								<%--<li><a href=""><i class="fa fa-envelope"></i> info@domain.com</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-6">--%>
						<%--<div class="social-icons pull-right">--%>
							<%--<ul class="nav navbar-nav">--%>
								<%--<li><a href=""><i class="fa fa-facebook"></i></a></li>--%>
								<%--<li><a href=""><i class="fa fa-twitter"></i></a></li>--%>
								<%--<li><a href=""><i class="fa fa-linkedin"></i></a></li>--%>
								<%--<li><a href=""><i class="fa fa-dribbble"></i></a></li>--%>
								<%--<li><a href=""><i class="fa fa-google-plus"></i></a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div><!--/header_top-->--%>
		<%----%>
		<%--<div class="header-middle"><!--header-middle-->--%>
			<%--<div class="container">--%>
				<%--<div class="row">--%>
					<%--<div class="col-sm-4">--%>
						<%--<div class="logo pull-left">--%>
							<%--<a href="index.html"><img src="${pageContext.request.contextPath}/eshop/images/home/logo.png" alt="" /></a>--%>
						<%--</div>--%>
						<%--<div class="btn-group pull-right">--%>
							<%--<div class="btn-group">--%>
								<%--<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">--%>
									<%--USA--%>
									<%--<span class="caret"></span>--%>
								<%--</button>--%>
								<%--<ul class="dropdown-menu">--%>
									<%--<li><a href="">Canada</a></li>--%>
									<%--<li><a href="">UK</a></li>--%>
								<%--</ul>--%>
							<%--</div>--%>
							<%----%>
							<%--<div class="btn-group">--%>
								<%--<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">--%>
									<%--DOLLAR--%>
									<%--<span class="caret"></span>--%>
								<%--</button>--%>
								<%--<ul class="dropdown-menu">--%>
									<%--<li><a href="">Canadian Dollar</a></li>--%>
									<%--<li><a href="">Pound</a></li>--%>
								<%--</ul>--%>
							<%--</div>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-8">--%>
						<%--<div class="shop-menu pull-right">--%>
							<%--<ul class="nav navbar-nav">--%>
								<%--<li><a href=""><i class="fa fa-user"></i> Account</a></li>--%>
								<%--<li><a href=""><i class="fa fa-star"></i> Wishlist</a></li>--%>
								<%--<li><a href="${pageContext.request.contextPath}/eshop/checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>--%>
								<%--<li><a href="${pageContext.request.contextPath}/eshop/cart" class="active"><i class="fa fa-shopping-cart"></i> Cart</a></li>--%>
								<%--<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div><!--/header-middle-->--%>
	<%----%>
		<%--<div class="header-bottom"><!--header-bottom-->--%>
			<%--<div class="container">--%>
				<%--<div class="row">--%>
					<%--<div class="col-sm-9">--%>
						<%--<div class="navbar-header">--%>
							<%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">--%>
								<%--<span class="sr-only">Toggle navigation</span>--%>
								<%--<span class="icon-bar"></span>--%>
								<%--<span class="icon-bar"></span>--%>
								<%--<span class="icon-bar"></span>--%>
							<%--</button>--%>
						<%--</div>--%>
						<%--<div class="mainmenu pull-left">--%>
							<%--<ul class="nav navbar-nav collapse navbar-collapse">--%>
								<%--<li><a href="${pageContext.request.contextPath}/">Home</a></li>--%>
								<%--<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>--%>
                                    <%--<ul role="menu" class="sub-menu">--%>
                                        <%--<li><a href="${pageContext.request.contextPath}/eshop/shop.jsp">Products</a></li>--%>
										<%--<li><a href="${pageContext.request.contextPath}/eshop/product-details.html">Product Details</a></li>--%>
										<%--<li><a href="${pageContext.request.contextPath}/eshop/checkout.html">Checkout</a></li>--%>
										<%--<li><a href="${pageContext.request.contextPath}/eshop/cart.jsp" class="active">Cart</a></li>--%>
										<%--<li><a href="${pageContext.request.contextPath}/eshop/login.html">Login</a></li>--%>
                                    <%--</ul>--%>
                                <%--</li> --%>
								<%--<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>--%>
                                    <%--<ul role="menu" class="sub-menu">--%>
                                        <%--<li><a href="${pageContext.request.contextPath}/eshop/blog.html">Blog List</a></li>--%>
										<%--<li><a href="${pageContext.request.contextPath}/eshop/blog-single.html">Blog Single</a></li>--%>
                                    <%--</ul>--%>
                                <%--</li> --%>
								<%--<li><a href="${pageContext.request.contextPath}/eshop/404.html">404</a></li>--%>
								<%--<li><a href="${pageContext.request.contextPath}/eshop/contact-us.html">Contact</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-3">--%>
						<%--<div class="search_box pull-right">--%>
							<%--<input type="text" placeholder="Search"/>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div><!--/header-bottom-->--%>
	</header><!--/header-->

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="entry" items="${mapOfGoods}">
						<tr>
							<td class="cart_product">
								<a href=""><img src="${pageContext.request.contextPath}/eshop/images/shop/<c:out value="${entry.key.img}"/>"  alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><c:out value="${entry.key.name}"/></a></h4>
								<p>Web ID: <c:out value="${entry.key.id}"/></p>
							</td>
							<td class="cart_price">
								<p><c:out value="${entry.key.price}"/></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<button class="cart_quantity_down" onclick="quantityDown(<c:out value="${entry.key.id}"/>)"> - </button>
									<input class="cart_quantity_input" type="text" name="<c:out value="${entry.key.id}"/>" value="<c:out value="${entry.value}"/>" autocomplete="off" size="2">
									<button class="cart_quantity_up" onclick="quantityUp(<c:out value="${entry.key.id}"/>)"> + </button>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${entry.key.price * entry.value}</p>
							</td>
							<td class="cart_delete">
								<button class="cart_quantity_delete" onclick="removeFromCart(<c:out value="${entry.key.id}"/>)"><i class="fa fa-times"></i></button>
							</td>
						</tr>
					</c:forEach>

					<p>
						<td class="cart_product">

						</td>
						<td class="cart_description">
							TOTAL
						</td>
						<td class="cart_price">

						</td>
						<td class="cart_quantity">

						</td>
						<td class="cart_total">
							<p class="cart_total_price"><c:set var="total" value="${0}"/>
								<c:forEach var="goods" items="${mapOfGoods}">
									<c:set var="total" value="${total + goods.key.price * goods.value}" />
								</c:forEach>
								<c:out value="${total}"/></td>
							</p>
						<td class="cart_delete">
						</td>
					</tr>




						<%--<tr>--%>
							<%--<td class="cart_product">--%>
								<%--<a href=""><img src="images/cart/one.png" alt=""></a>--%>
							<%--</td>--%>
							<%--<td class="cart_description">--%>
								<%--<h4><a href="">Colorblock Scuba</a></h4>--%>
								<%--<p>Web ID: 1089772</p>--%>
							<%--</td>--%>
							<%--<td class="cart_price">--%>
								<%--<p>$59</p>--%>
							<%--</td>--%>
							<%--<td class="cart_quantity">--%>
								<%--<div class="cart_quantity_button">--%>
									<%--<a class="cart_quantity_up" href=""> + </a>--%>
									<%--<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">--%>
									<%--<a class="cart_quantity_down" href=""> - </a>--%>
								<%--</div>--%>
							<%--</td>--%>
							<%--<td class="cart_total">--%>
								<%--<p class="cart_total_price">$59</p>--%>
							<%--</td>--%>
							<%--<td class="cart_delete">--%>
								<%--<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>--%>
							<%--</td>--%>
						<%--</tr>--%>

						<%--<tr>--%>
							<%--<td class="cart_product">--%>
								<%--<a href=""><img src="images/cart/two.png" alt=""></a>--%>
							<%--</td>--%>
							<%--<td class="cart_description">--%>
								<%--<h4><a href="">Colorblock Scuba</a></h4>--%>
								<%--<p>Web ID: 1089772</p>--%>
							<%--</td>--%>
							<%--<td class="cart_price">--%>
								<%--<p>$59</p>--%>
							<%--</td>--%>
							<%--<td class="cart_quantity">--%>
								<%--<div class="cart_quantity_button">--%>
									<%--<a class="cart_quantity_up" href=""> + </a>--%>
									<%--<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">--%>
									<%--<a class="cart_quantity_down" href=""> - </a>--%>
								<%--</div>--%>
							<%--</td>--%>
							<%--<td class="cart_total">--%>
								<%--<p class="cart_total_price">$59</p>--%>
							<%--</td>--%>
							<%--<td class="cart_delete">--%>
								<%--<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>--%>
							<%--</td>--%>
						<%--</tr>--%>
						<%--<tr>--%>
							<%--<td class="cart_product">--%>
								<%--<a href=""><img src="images/cart/three.png" alt=""></a>--%>
							<%--</td>--%>
							<%--<td class="cart_description">--%>
								<%--<h4><a href="">Colorblock Scuba</a></h4>--%>
								<%--<p>Web ID: 1089772</p>--%>
							<%--</td>--%>
							<%--<td class="cart_price">--%>
								<%--<p>$59</p>--%>
							<%--</td>--%>
							<%--<td class="cart_quantity">--%>
								<%--<div class="cart_quantity_button">--%>
									<%--<a class="cart_quantity_up" href=""> + </a>--%>
									<%--<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">--%>
									<%--<a class="cart_quantity_down" href=""> - </a>--%>
								<%--</div>--%>
							<%--</td>--%>
							<%--<td class="cart_total">--%>
								<%--<p class="cart_total_price">$59</p>--%>
							<%--</td>--%>
							<%--<td class="cart_delete">--%>
								<%--<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>--%>
							<%--</td>--%>
						<%--</tr>--%>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->






    <div class="shopper-informations">
        <div class="row">
            <div class="col-sm-offset-4 clearfix">
                <div class="bill-to">
                    <p>Bill To</p>
                    <div class="form-one">
                        <form method="POST" action="${pageContext.request.contextPath}/order">
                            <%--<label for="name">Name:</label>--%>
                            <input id="name" type="text" name="name" placeholder="name"/>
                            <%--<label for="phone">Phone:</label>--%>
                            <input id="phone" type="text" name="phone" placeholder="phone"/>
                            <%--<label for="phone">Street:</label>--%>
                            <input id="street" type="text" name="street" placeholder="street"/>
                            <%--<label for="house">House:</label>--%>
                            <input id="house" type="text" name="house" placeholder="house"/>
                            <%--<br> <label for="apartment">Apartment:</label>--%>
                            <input id="apartment" type="text" name="apartment" placeholder="apartment"/>
                            <%--<label for="floor">Floor:</label>--%>
                            <input id="floor" type="text" name="floor" placeholder="floor"/>
                            <%--<label for="codeEntrance">Code of entrance:</label>--%>
                            <input id="codeEntrance" type="codeEntrance" name="codeEntrance" placeholder="code of entrance"/>
                            <%--<br> <label for="comment">Any additional information:</label>--%>
                            <textarea id="comment" name="comment" placeholder="Notes about your order, Special Notes for Delivery" rows="16"></textarea>
                            <button class="btn btn-default check_out">Send order</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<footer id="footer"><!--Footer-->
		<%@ include file="/WEB-INF/jsp/parts/footer.jsp"%>
		<%--<div class="footer-top">--%>
			<%--<div class="container">--%>
				<%--<div class="row">--%>
					<%--<div class="col-sm-2">--%>
						<%--<div class="companyinfo">--%>
							<%--<h2><span>e</span>-shopper</h2>--%>
							<%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-7">--%>
						<%--<div class="col-sm-3">--%>
							<%--<div class="video-gallery text-center">--%>
								<%--<a href="#">--%>
									<%--<div class="iframe-img">--%>
										<%--<img src="${pageContext.request.contextPath}/eshop/images/home/iframe1.png" alt="" />--%>
									<%--</div>--%>
									<%--<div class="overlay-icon">--%>
										<%--<i class="fa fa-play-circle-o"></i>--%>
									<%--</div>--%>
								<%--</a>--%>
								<%--<p>Circle of Hands</p>--%>
								<%--<h2>24 DEC 2014</h2>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%----%>
						<%--<div class="col-sm-3">--%>
							<%--<div class="video-gallery text-center">--%>
								<%--<a href="#">--%>
									<%--<div class="iframe-img">--%>
										<%--<img src="${pageContext.request.contextPath}/eshop/images/home/iframe2.png" alt="" />--%>
									<%--</div>--%>
									<%--<div class="overlay-icon">--%>
										<%--<i class="fa fa-play-circle-o"></i>--%>
									<%--</div>--%>
								<%--</a>--%>
								<%--<p>Circle of Hands</p>--%>
								<%--<h2>24 DEC 2014</h2>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%----%>
						<%--<div class="col-sm-3">--%>
							<%--<div class="video-gallery text-center">--%>
								<%--<a href="#">--%>
									<%--<div class="iframe-img">--%>
										<%--<img src="${pageContext.request.contextPath}/eshop/images/home/iframe3.png" alt="" />--%>
									<%--</div>--%>
									<%--<div class="overlay-icon">--%>
										<%--<i class="fa fa-play-circle-o"></i>--%>
									<%--</div>--%>
								<%--</a>--%>
								<%--<p>Circle of Hands</p>--%>
								<%--<h2>24 DEC 2014</h2>--%>
							<%--</div>--%>
						<%--</div>--%>
						<%----%>
						<%--<div class="col-sm-3">--%>
							<%--<div class="video-gallery text-center">--%>
								<%--<a href="#">--%>
									<%--<div class="iframe-img">--%>
										<%--<img src="${pageContext.request.contextPath}/eshop/images/home/iframe4.png" alt="" />--%>
									<%--</div>--%>
									<%--<div class="overlay-icon">--%>
										<%--<i class="fa fa-play-circle-o"></i>--%>
									<%--</div>--%>
								<%--</a>--%>
								<%--<p>Circle of Hands</p>--%>
								<%--<h2>24 DEC 2014</h2>--%>
							<%--</div>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-3">--%>
						<%--<div class="address">--%>
							<%--<img src="${pageContext.request.contextPath}/eshop/images/home/map.png" alt="" />--%>
							<%--<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>--%>
						<%--</div>--%>
					<%--</div>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%----%>
		<%--<div class="footer-widget">--%>
			<%--<div class="container">--%>
				<%--<div class="row">--%>
					<%--<div class="col-sm-2">--%>
						<%--<div class="single-widget">--%>
							<%--<h2>Service</h2>--%>
							<%--<ul class="nav nav-pills nav-stacked">--%>
								<%--<li><a href="">Online Help</a></li>--%>
								<%--<li><a href="">Contact Us</a></li>--%>
								<%--<li><a href="">Order Status</a></li>--%>
								<%--<li><a href="">Change Location</a></li>--%>
								<%--<li><a href="">FAQ’s</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-2">--%>
						<%--<div class="single-widget">--%>
							<%--<h2>Quock Shop</h2>--%>
							<%--<ul class="nav nav-pills nav-stacked">--%>
								<%--<li><a href="">T-Shirt</a></li>--%>
								<%--<li><a href="">Mens</a></li>--%>
								<%--<li><a href="">Womens</a></li>--%>
								<%--<li><a href="">Gift Cards</a></li>--%>
								<%--<li><a href="">Shoes</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-2">--%>
						<%--<div class="single-widget">--%>
							<%--<h2>Policies</h2>--%>
							<%--<ul class="nav nav-pills nav-stacked">--%>
								<%--<li><a href="">Terms of Use</a></li>--%>
								<%--<li><a href="">Privecy Policy</a></li>--%>
								<%--<li><a href="">Refund Policy</a></li>--%>
								<%--<li><a href="">Billing System</a></li>--%>
								<%--<li><a href="">Ticket System</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-2">--%>
						<%--<div class="single-widget">--%>
							<%--<h2>About Shopper</h2>--%>
							<%--<ul class="nav nav-pills nav-stacked">--%>
								<%--<li><a href="">Company Information</a></li>--%>
								<%--<li><a href="">Careers</a></li>--%>
								<%--<li><a href="">Store Location</a></li>--%>
								<%--<li><a href="">Affillate Program</a></li>--%>
								<%--<li><a href="">Copyright</a></li>--%>
							<%--</ul>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%--<div class="col-sm-3 col-sm-offset-1">--%>
						<%--<div class="single-widget">--%>
							<%--<h2>About Shopper</h2>--%>
							<%--<form action="#" class="searchform">--%>
								<%--<input type="text" placeholder="Your email address" />--%>
								<%--<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>--%>
								<%--<p>Get the most recent updates from <br />our site and be updated your self...</p>--%>
							<%--</form>--%>
						<%--</div>--%>
					<%--</div>--%>
					<%----%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
		<%----%>
		<%--<div class="footer-bottom">--%>
			<%--<div class="container">--%>
				<%--<div class="row">--%>
					<%--<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>--%>
					<%--<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
		
	</footer><!--/Footer-->

	<counter:counter/>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/eshop/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/eshop/js/jquery.scrollUp.min.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/main.js"></script>
</body>
</html>