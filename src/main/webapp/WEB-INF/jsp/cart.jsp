<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/html5/assets/css/main.css" />
    <noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/html5/assets/css/noscript.css" /></noscript>

    <%--<link rel="stylesheet" media="all" type="text/css" href="${pageContext.request.contextPath}/jsp/css/style.css" />--%>
    <link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>
    <title>list of goods</title>
    <%--<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>--%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/cart.js" type="text/javascript"></script>
</head>
<body class="is-preload">

<!-- Page Wrapper -->
<div id="page-wrapper">

    <!-- Header -->
    <header id="header">
        <h1><a href="index.html">Spectral</a></h1>
        <nav id="nav">
            <ul>
                <li class="special">
                    <a href="${pageContext.request.contextPath}/cart"
                    <%--class="menuToggle"--%>
                    ><span>Cart</span></a>
                    <%--<a href="${pageContext.request.contextPath}/cart"></a>--%>
                    <div id="menu">
                        <ul>
                            <li><a href="index.html">Home</a></li>
                            <li><a href="generic.jsp">Generic</a></li>
                            <li><a href="elements.html">Elements</a></li>
                            <li><a href="#">Sign Up</a></li>
                            <li><a href="#">Log In</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
    </header>

    <!-- Main -->
    <article id="main">
        <header>
            <h2>Generic Page</h2>
            <p>Aliquam ut ex ut interdum donec amet imperdiet eleifend</p>
        </header>
        <section class="wrapper style5">
            <div class="inner">
                <h3>Goods</h3>
                <p>
                    <table>
                        <caption><b>Goods</b></caption>
                        <thead>
                        <tr>
                            <th>Goods</th>
                            <th>Count</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="entry" items="${mapOfGoods}">
                            <tr>
                                <td align=\"center\"><c:out value="${entry.key}"/></td>
                                <td align=\"center\"><input name="<c:out value="${entry.key.id}"/>" type="number" min="1" max="99" step="1" value="<c:out value="${entry.value}"/>" style="color: black"></td>
                                <td align=\"center\"><button onclick="updateCart(<c:out value="${entry.key.id}"/>)">update</button></td>
                                <td align=\"center\"><button onclick="removeFromCart(<c:out value="${entry.key.id}"/>)">remove</button></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                        <%--<tfoot>--%>
                        <%--<tr>--%>
                        <%--<th colspan=\"3\">goods</th>--%>
                        <%--</tr>--%>
                        <%--</tfoot>--%>
                    </table>
                </p>

                <hr />

                <h4>DELIVERY</h4>
                <p>
                    <form method="POST" action="${pageContext.request.contextPath}/order">
                        <input type="text" name="name" placeholder="name"/>
                        <input type="text" name="phone" placeholder="phone"/>
                        <input type="text" name="street" placeholder="street"/>
                        <input type="text" name="house" placeholder="house"/>
                        <input type="text" name="apartment" placeholder="apartment"/>
                        <input type="text" name="floor" placeholder="floor"/>
                        <input type="text" name="codeEntrance" placeholder="code of entrance"/>
                        <textarea name="comment"></textarea>
                        <button>Send order</button>
                    </form>
                </p>
            </div>
        </section>
    </article>

    <!-- Footer -->
    <footer id="footer">
        <ul class="icons">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
        </ul>
        <ul class="copyright">
            <li>&copy; Untitled</li>
        </ul>
    </footer>

</div>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/html5/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/html5/assets/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/html5/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/html5/assets/js/browser.min.js"></script>
<script src="${pageContext.request.contextPath}/html5/assets/js/breakpoints.min.js"></script>
<script src="${pageContext.request.contextPath}/html5/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/html5/assets/js/main.js"></script>

</body>
</html>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--&lt;%&ndash;<link rel="stylesheet" media="all" type="text/css" href="${pageContext.request.contextPath}/jsp/css/style.css" />&ndash;%&gt;--%>
    <%--<link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>--%>
    <%--<title>list of goods</title>--%>
    <%--&lt;%&ndash;<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.min.js" type="text/javascript"></script>&ndash;%&gt;--%>
    <%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/cart.js" type="text/javascript"></script></head>--%>
<%--<body>--%>
<%--<header>--%>
    <%--&lt;%&ndash;<%@ include file="parts/header.jsp"%>&ndash;%&gt;--%>
<%--</header>--%>
<%--<main>--%>
    <%--<section>--%>
        <%--<article>--%>
            <%--<table>--%>
                <%--<caption><b>Goods</b></caption>--%>
                <%--<thead>--%>
                    <%--<tr>--%>
                        <%--<th>Goods</th>--%>
                        <%--<th>Count</th>--%>
                    <%--</tr>--%>
                <%--</thead>--%>
                <%--<tbody>--%>

                <%--<c:forEach var="entry" items="${mapOfGoods}">--%>
                    <%--<tr>--%>
                        <%--<td align=\"center\"><c:out value="${entry.key}"/></td>--%>
                        <%--<td align=\"center\"><input name="<c:out value="${entry.key.id}"/>" type="number" min="1" max="99" step="1" value="<c:out value="${entry.value}"/>"></td>--%>
                        <%--<td align=\"center\"><button onclick="updateCart(<c:out value="${entry.key.id}"/>)">update</button></td>--%>
                        <%--<td align=\"center\"><button onclick="removeFromCart(<c:out value="${entry.key.id}"/>)">remove</button></td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>

                <%--</tbody>--%>
                <%--&lt;%&ndash;<tfoot>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<th colspan=\"3\">goods</th>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</tfoot>&ndash;%&gt;--%>
            <%--</table>--%>
        <%--</article>--%>

        <%--<article>--%>
            <%--<h2>DELIVERY</h2>--%>
            <%--<form method="POST" action="${pageContext.request.contextPath}/order">--%>
                <%--<input type="text" name="name" placeholder="name"/>--%>
                <%--<input type="text" name="phone" placeholder="phone"/>--%>
                <%--<input type="text" name="street" placeholder="street"/>--%>
                <%--<input type="text" name="house" placeholder="house"/>--%>
                <%--<input type="text" name="apartment" placeholder="apartment"/>--%>
                <%--<input type="text" name="floor" placeholder="floor"/>--%>
                <%--<input type="text" name="codeEntrance" placeholder="code of entrance"/>--%>
                <%--<textarea name="comment"></textarea>--%>
                <%--<button>Send order</button>--%>
            <%--</form>--%>
        <%--</article>--%>
    <%--</section>--%>
<%--</main>--%>
<%--<aside>--%>
    <%--&lt;%&ndash;<%@ include file="parts/aside.jsp"%>&ndash;%&gt;--%>
<%--</aside>--%>
<%--<footer>--%>
    <%--&lt;%&ndash;<%@ include file="parts/footer.jsp"%>&ndash;%&gt;--%>
<%--</footer>--%>
<%--</body>--%>
<%--</html>--%>