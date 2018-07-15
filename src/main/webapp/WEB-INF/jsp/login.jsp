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
    <title>Login | Eshop</title>
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
	<link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/listOfGoods.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/search.js" type="text/javascript"></script>
</head><!--/head-->

<body>
	<header id="header">
		<%@ include file="/WEB-INF/jsp/parts/header.jsp"%>
	</header>
	
	<section id="form">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<div style="color:red;text-align: center";>${param.error}</div>
						<form method="POST" action="j_security_check">
							<input type="text" placeholder="Name" name="j_username" required="required" size="25"
								   minlength="5" maxlength="100" autofocus />
							<input type="password" placeholder="Password" name="j_password" required="required" size="25"
								   minlength="5" maxlength="100" />
							<span>
								<input type="checkbox" class="checkbox"> 
								Keep me signed in
							</span>
							<button class="btn btn-default">Login</button>
						</form>
					</div>
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<form method="POST" action="${pageContext.request.contextPath}/register">
							<input type="text" placeholder="Name" name="login" required="required" size="25"
								   minlength="5" maxlength="100" />
							<input type="password" placeholder="Password" name="password" required="required" size="25"
								   minlength="5" maxlength="100" />
							<input type="email" placeholder="Email" name="email" required="required" size="25"
								   minlength="5" maxlength="100" />
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	<footer id="footer">
		<%@ include file="/WEB-INF/jsp/parts/footer.jsp"%>
	</footer>

	<counter:counter/>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/eshop/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/eshop/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/eshop/js/main.js"></script>
</body>
</html>