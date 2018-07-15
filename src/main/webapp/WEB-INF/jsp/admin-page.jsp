<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="counter" uri="/custom" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" media="all" type="text/css" href="${pageContext.request.contextPath}/jsp/css/style.css" />
    <link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>
    <title>Админская</title>
    <%--<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>--%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/jsp/js/sidebar.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/jsp/js/admin-page-scripts.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/jsp/js/get-all-performance.js" type="text/javascript"></script>
</head>
<body>
<header>
</header>
<main>
    <section>
        <article>
            <h2>SWAGGER</h2>
            <p>
                <a href="${pageContext.request.contextPath}/swagger">swagger page</a>
            </p>
        </article>
        <article>
            <h2>BACK</h2>
            <p>
                <a href="${pageContext.request.contextPath}/">main page</a>
            </p>
        </article>
    </section>
</main>
<aside>
</aside>
<footer>

    <counter:counter/>
</footer>
</body>
</html>