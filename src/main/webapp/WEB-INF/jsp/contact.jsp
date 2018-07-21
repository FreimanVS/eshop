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
    <title>Contact | Eshop</title>
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
</head>

<body>
<header id="header">
    <%@ include file="/WEB-INF/jsp/parts/header.jsp"%>
</header>
<div id="contact-page" class="container">
    <div class="bg">
        <div class="row">
            <div class="col-sm-8">
                <div class="contact-form">
                    <h2 class="title text-center"><%=session.getAttribute("page.contact.getInTouch")%></h2>
                    <div class="status alert alert-success" style="display: none"></div>
                    <form id="main-contact-form" class="contact-form row" name="contact-form" method="POST" action="${pageContext.request.contextPath}/contact" >
                        <div class="form-group col-md-6">
                            <input type="text" name="fromName" class="form-control" required="required" placeholder="<%=session.getAttribute("page.contact.name")%>">
                        </div>
                        <div class="form-group col-md-6">
                            <input type="email" name="fromEmail" class="form-control" required="required" placeholder="<%=session.getAttribute("page.contact.email")%>">
                        </div>
                        <div class="form-group col-md-12">
                            <input type="text" name="subject" class="form-control" required="required" placeholder="<%=session.getAttribute("page.contact.subject")%>">
                        </div>
                        <div class="form-group col-md-12">
                            <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="<%=session.getAttribute("page.contact.message")%>"></textarea>
                        </div>
                        <div class="form-group col-md-12">
                            <input type="submit" name="submit" class="btn btn-primary pull-right" value="<%=session.getAttribute("page.contact.submit")%>">
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="contact-info">
                    <h2 class="title text-center"><%=session.getAttribute("page.contact.contactInfo")%></h2>
                    <address>
                        <p>Eshop Inc.</p>
                        <p>3536  Musgrave Street Oklahoma City Oklahoma </p>
                        <p>Newyork USA</p>
                        <p>Phone: +1-405-213-2286</p>
                        <p>Email: info@eshop.com</p>
                    </address>
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
<script type="${pageContext.request.contextPath}/eshop/text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script type="${pageContext.request.contextPath}/eshop/text/javascript" src="${pageContext.request.contextPath}/eshop/js/gmaps.js"></script>
<script src="${pageContext.request.contextPath}/eshop/js/contact.js"></script>
<script src="${pageContext.request.contextPath}/eshop/js/price-range.js"></script>
<script src="${pageContext.request.contextPath}/eshop/js/jquery.scrollUp.min.js"></script>
<script src="${pageContext.request.contextPath}/eshop/js/jquery.prettyPhoto.js"></script>
<script src="${pageContext.request.contextPath}/eshop/js/main.js"></script>
</body>
</html>