<c:if test="${sessionScope.locale == null}">
    <script>
        var contextPath = $('#contextPathHolder').attr('data-contextPath');
        var ip = location.hostname;
        var port = location.port;
        window.location.replace("http://" + ip + ":" + port + contextPath + "/locale");
    </script>
</c:if>

<div class="header-middle">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="logo pull-left">
                    <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/eshop/images/home/logo.png" alt="" /></a>
                </div>
                <div class="btn-group pull-right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                            <%=session.getAttribute("page.header.language")%>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/locale?l=en">English</a></li>
                            <li><a href="${pageContext.request.contextPath}/locale?l=ru">Русский</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="shop-menu pull-right">
                    <ul class="nav navbar-nav">
                        <li><a id="cart" href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i><%=session.getAttribute("page.header.cart")%></a></li>
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal ne null}">
                                <li><a href = ""><c:out value="Hello, <b>${pageContext.request.userPrincipal.name}</b>!" escapeXml="false"></c:out></a></li>
                                <li><a href = "<c:url value = "/login?logout=true"/>"><%=session.getAttribute("page.header.logout")%></a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i><%=session.getAttribute("page.header.login")%></a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="header-bottom">
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
                        <li><a href="${pageContext.request.contextPath}/"><%=session.getAttribute("page.header.home")%></a></li>
                        <li><a href="${pageContext.request.contextPath}/contact"><%=session.getAttribute("page.header.contact")%></a></li>
                        <c:if test="${pageContext.request.userPrincipal.name eq \"admin\"}">
                            <li><a href="${pageContext.request.contextPath}/admin"><%=session.getAttribute("page.header.admin")%></a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="search_box pull-right">
                    <input id="searchInput" type="text" placeholder="<%=session.getAttribute("page.header.search")%>"/>
                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <%@ include file="/WEB-INF/jsp/parts/variables.jsp"%>
</div>