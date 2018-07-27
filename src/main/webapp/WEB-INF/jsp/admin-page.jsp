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
    <title>Admin</title>
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
    <script src="${pageContext.request.contextPath}/js/search.js" type="text/javascript"></script>
</head>

<body>
<header id="header">
    <%@ include file="/WEB-INF/jsp/parts/header.jsp"%>
</header>

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-9 padding-right">
                <section>
                    <article>
                        <a href="${pageContext.request.contextPath}/swagger"><h2>SWAGGER</h2></a>
                    </article>
                </section>
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