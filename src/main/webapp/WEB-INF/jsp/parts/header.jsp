<div class="header_top"><!--header_top-->
    <div class="container">
        <div class="row">
            <div class="col-sm-6 ">
                <div class="contactinfo">
                    <ul class="nav nav-pills">
                        <li><a href=""><i class="fa fa-phone"></i> +1 213 456 78 90</a></li>
                        <li><a href=""><i class="fa fa-envelope"></i> info@domain.com</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="social-icons pull-right">
                    <ul class="nav navbar-nav">
                        <li><a href=""><i class="fa fa-facebook"></i></a></li>
                        <li><a href=""><i class="fa fa-twitter"></i></a></li>
                        <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                        <li><a href=""><i class="fa fa-dribbble"></i></a></li>
                        <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div><!--/header_top-->

<div class="header-middle"><!--header-middle-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="logo pull-left">
                    <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/eshop/images/home/logo.png" alt="" /></a>
                </div>
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
            </div>
            <div class="col-sm-8">
                <div class="shop-menu pull-right">
                    <ul class="nav navbar-nav">
                        <%--<li><a href=""><i class="fa fa-user"></i> Account</a></li>--%>
                        <%--<li><a href=""><i class="fa fa-star"></i> Wishlist</a></li>--%>
                        <%--<li><a href="${pageContext.request.contextPath}/eshop/checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>--%>
                        <li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                        <%--<li><a href="${pageContext.request.contextPath}/WEB-INF/jsp/login.jsp"><i class="fa fa-lock"></i> Login</a></li>--%>
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal ne null}">
                                <li><a href = ""><c:out value="Hello, <b>${pageContext.request.userPrincipal.name}</b>!" escapeXml="false"></c:out></a></li>
                                <li><a href = "<c:url value = "/login?logout=true"/>">Logout</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div><!--/header-middle-->

<div class="header-bottom"><!--header-bottom-->
    <div class="container">
        <div class="row">
            <div class="col-sm-9">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="mainmenu pull-left">
                    <ul class="nav navbar-nav collapse navbar-collapse">
                        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li class="dropdown"><a href="#" class="active">Shop<i class="fa fa-angle-down"></i></a>
                            <ul role="menu" class="sub-menu">
                                <%--<li><a href="${pageContext.request.contextPath}/eshop/shop.jsp" class="active">Products</a></li>--%>
                                <%--<li><a href="${pageContext.request.contextPath}/eshop/product-details.html">Product Details</a></li>--%>
                                <%--<li><a href="${pageContext.request.contextPath}/eshop/checkout.html">Checkout</a></li>--%>
                                <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
                                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                            </ul>
                        </li>
                        <%--<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>--%>
                            <%--<ul role="menu" class="sub-menu">--%>
                                <%--<li><a href="blog.html">Blog List</a></li>--%>
                                <%--<li><a href="blog-single.html">Blog Single</a></li>--%>
                            <%--</ul>--%>
                        <%--</li>--%>
                        <%--<li><a href="${pageContext.request.contextPath}/eshop/404.html">404</a></li>--%>
                        <li><a href="${pageContext.request.contextPath}/eshop/contact-us.html">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="search_box pull-right">
                    <input id="searchInput" type="text" placeholder="Search"/>
                </div>
            </div>
        </div>
    </div>
</div>