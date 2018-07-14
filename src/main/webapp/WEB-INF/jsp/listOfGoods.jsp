<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%--<link rel="stylesheet" media="all" type="text/css" href="${pageContext.request.contextPath}/jsp/css/style.css" />--%>
    <link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>
    <title>list of goods</title>
    <%--<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>--%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/listOfGoods.js" type="text/javascript"></script>
</head>
<body>
<header>
    <%--<%@ include file="parts/header.jsp"%>--%>
</header>
<main>
    <section>
        <article>
            <h2>GOODS</h2>
            <p class="listOfGoods"></p>
        </article>
    </section>
    <section>
        <article>
            <h2>CART</h2>
            <p><a href="${pageContext.request.contextPath}/cart">to the cart</a></p>
        </article>
    </section>
</main>
<aside>
    <%--<%@ include file="parts/aside.jsp"%>--%>
</aside>
<footer>
    <%--<%@ include file="parts/footer.jsp"%>--%>
</footer>
</body>
</html>