<div class="footer-top">
    <div class="container">
        <div class="row">
            <div class="col-sm-2">
                <div class="companyinfo">
                    <h2><span>e</span>shop</h2>
                    <p><%=session.getAttribute("page.footer.logo.description")%></p>
                </div>
            </div>

            <div class="col-sm-3 col-md-offset-7">
                <div class="single-widget">
                    <h2><%=session.getAttribute("page.footer.about")%> Eshop</h2>
                    <form method="POST" action="${pageContext.request.contextPath}/newsLetters" class="searchform">
                        <input name="email" type="text" placeholder="<%=session.getAttribute("page.footer.about.email")%>" />
                        <button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
                        <p><%=session.getAttribute("page.footer.about.description")%></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer-bottom">
    <div class="container">
        <div class="row">
            <div class="col-sm-offset-4">
                Copyright © 2018 Eshop. All rights reserved.
            </div>
        </div>
    </div>
</div>