<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h2>REPORTS</h2>
            <p>
                <a href="${pageContext.request.contextPath}/report?report=employee&format=pdf">
                    <img src="http://www.devona.ru/upload/medialibrary/9a1/9a11a476e0fb4211ed50ebb03e591918.png"
                         alt="pdf-download" style="width:40px;height:40px;border:0;">
                </a>
                <a href="${pageContext.request.contextPath}/mail?report=employee&format=pdf">
                    send pdf to email
                </a>
                <a href="${pageContext.request.contextPath}/report?report=employee&format=xml">
                    <img src="https://cdn0.iconfinder.com/data/icons/file-formats-flat-colorful-1/2048/1754_-_XML-512.png"
                         alt="xml-download" style="width:40px;height:40px;border:0;">
                </a>
                <a href="${pageContext.request.contextPath}/mail?report=employee&format=xml">
                    send xml to email
                </a>
            </p>
            <p id="allEmployees"></p>
        </article>
        <article>
            <h2>SWAGGER</h2>
            <p>
                <a href="${pageContext.request.contextPath}/swagger">to a swagger page</a>
            </p>
        </article>
    </section>
</main>
<aside>
</aside>
<footer>
</footer>
</body>
</html>