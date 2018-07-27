<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
</head>

<body>
	<header id="header">
		<%@ include file="/WEB-INF/jsp/parts/header.jsp"%>
	</header>

	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image"><%=session.getAttribute("page.cart.item")%></td>
							<td class="description"></td>
							<td class="price"><%=session.getAttribute("page.cart.price")%></td>
							<td class="quantity"><%=session.getAttribute("page.cart.quantity")%></td>
							<td class="total"><%=session.getAttribute("page.cart.total")%></td>
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
								<p class="cart_total_price"><fmt:formatNumber value="${entry.key.price * entry.value}" type="currency" currencySymbol=""/></p>
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
							<%=session.getAttribute("page.cart.total")%>
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
							<fmt:formatNumber value="${total}" type="currency" currencySymbol=""/></td>
							</p>
						<td class="cart_delete">
						</td>
					</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>

    <div class="shopper-informations">
        <div class="row">
            <div class="col-sm-offset-4 clearfix">
                <div class="bill-to">
                    <p><%=session.getAttribute("page.cart.to")%></p>
                    <div class="form-one">
                        <form method="POST" action="${pageContext.request.contextPath}/order">
                            <input id="name" type="text" name="name" placeholder="<%=session.getAttribute("page.cart.name")%>" required/>
                            <input id="phone" type="text" name="phone" placeholder="<%=session.getAttribute("page.cart.phone")%>" required/>
                            <input id="street" type="text" name="street" placeholder="<%=session.getAttribute("page.cart.street")%>" required/>
                            <input id="house" type="text" name="house" placeholder="<%=session.getAttribute("page.cart.house")%>" required/>
                            <input id="apartment" type="text" name="apartment" placeholder="<%=session.getAttribute("page.cart.apartment")%>" required/>
                            <input id="floor" type="text" name="floor" placeholder="<%=session.getAttribute("page.cart.floor")%>" required/>
                            <input id="codeEntrance" type="codeEntrance" name="codeEntrance" placeholder="<%=session.getAttribute("page.cart.code")%>"/>
                            <textarea id="comment" name="comment" placeholder="<%=session.getAttribute("page.cart.comment")%>" rows="16"></textarea>
                            <button class="btn btn-default check_out"><%=session.getAttribute("page.cart.submit")%></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<footer id="footer">
		<%@ include file="/WEB-INF/jsp/parts/footer.jsp"%>
	</footer>

	<counter:counter/>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/eshop/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/eshop/js/jquery.scrollUp.min.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/main.js"></script>
</body>
</html>