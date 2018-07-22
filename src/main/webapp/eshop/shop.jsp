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
    <title>Eshop</title>
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

	<section id="advertisement">
		<%@ include file="/WEB-INF/jsp/parts/advertisement.jsp"%>
	</section>

	<%--<div id="removeIt">--%>
		<%--<style>--%>
			<%--#list1 li,#list2 li{--%>
				<%--width:60px;--%>
			<%--}--%>
			<%--#list2 li{--%>
				<%--background:green;--%>
			<%--}--%>
			<%--#list2{--%>
				<%--position:absolute;--%>
				<%--top:25px;--%>
				<%--right: 350px;--%>
			<%--}--%>
			<%--#list3 {--%>
				<%--position:absolute;--%>
				<%--bottom:600px;--%>
				<%--left:80px;--%>
				<%--background: yellow;--%>
			<%--}--%>
			<%--#list1 li{--%>
				<%--cursor:pointer;--%>
				<%--background:red;--%>
			<%--}--%>
			<%--ul{--%>
				<%--width:200px;--%>
			<%--}--%>
		<%--</style>--%>
		<%--<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js" type="text/javascript"></script>--%>
		<%--<script>--%>
			<%--// $(document).ready(function () {--%>
                <%--// $.fn.flyTo = function(options) {--%>
                <%--//     var _settings = $.extend({--%>
                <%--//         duration : 400,--%>
                <%--//         callback : function(){ }--%>
                <%--//     }, options);--%>
                <%--//--%>
                <%--//     return this.each(function() {--%>
                <%--//         var _ = $(this), _target = $(_settings.target),--%>
                <%--//             _clone = _.clone(false).height( _.height());--%>
                <%--//--%>
                <%--//         var t = $(this).clone(false).height($(this).height());--%>
                <%--//         var positionTop = _.position().top+'px';--%>
                <%--//         var positionLeft = _.position().left+'px';--%>
                <%--//--%>
                <%--//         _clone.find('a').remove();--%>
                <%--//         _clone.insertAfter(_).fadeTo( _settings.duration, 0);--%>
                <%--//         _.fadeTo( _settings.duration, 0.5);--%>
                <%--//--%>
                <%--//         _.css({--%>
                <%--//             position:'absolute',--%>
                <%--//             top:_.position().top+'px',--%>
                <%--//             left:_.position().left+'px'--%>
                <%--//         }).animate({--%>
                <%--//             top:(_target.position().top+_target.height())+'px',--%>
                <%--//             left:_target.position().left+'px'--%>
                <%--//         },_settings.duration,'swing',function(){--%>
                <%--//--%>
                <%--//             _.appendTo(_target).css({position:''});--%>
                <%--//             var _sortedItems = _target.children().sort(function(a, b) {--%>
                <%--//                 var--%>
                <%--//                     vA = $(a).data( _settings.orderByDataKey ),--%>
                <%--//                     vB = $(b).data( _settings.orderByDataKey );--%>
                <%--//                 return (vA < vB) ? -1 : (vA > vB) ? 1 : 0;--%>
                <%--//             });--%>
                <%--//             _target.append(_sortedItems);--%>
                <%--//             _clone.remove();--%>
                <%--//             _.fadeTo( 1000, 1);--%>
                <%--//             _settings.callback();--%>
                <%--//         });--%>
                <%--//         t.css({--%>
                <%--//             position: 'absolute',--%>
                <%--//             top: '100px',--%>
                <%--//             left: '100px'--%>
                <%--//         })--%>
                <%--//     });--%>
                <%--// };--%>
                <%--//--%>
                <%--// $('#li1').on("click", function () {--%>
                <%--//     $(this).flyTo({--%>
                <%--//         target:'#list2',--%>
                <%--//         orderByDataKey:null,--%>
                <%--//         callback:function(){--%>
                <%--//             console.log('done')--%>
                <%--//         }--%>
                <%--//     })--%>
                <%--// });--%>

            <%--$(document).ready(function () {--%>
                <%--jQuery.easing["jswing"]=jQuery.easing["swing"];jQuery.extend(jQuery.easing,{def:"easeOutQuad",swing:function(a,b,c,d,e){return jQuery.easing[jQuery.easing.def](a,b,c,d,e)},easeInQuad:function(a,b,c,d,e){return d*(b/=e)*b+c},easeOutQuad:function(a,b,c,d,e){return-d*(b/=e)*(b-2)+c},easeInOutQuad:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b+c;return-d/2*(--b*(b-2)-1)+c},easeInCubic:function(a,b,c,d,e){return d*(b/=e)*b*b+c},easeOutCubic:function(a,b,c,d,e){return d*((b=b/e-1)*b*b+1)+c},easeInOutCubic:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b*b+c;return d/2*((b-=2)*b*b+2)+c},easeInQuart:function(a,b,c,d,e){return d*(b/=e)*b*b*b+c},easeOutQuart:function(a,b,c,d,e){return-d*((b=b/e-1)*b*b*b-1)+c},easeInOutQuart:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b*b*b+c;return-d/2*((b-=2)*b*b*b-2)+c},easeInQuint:function(a,b,c,d,e){return d*(b/=e)*b*b*b*b+c},easeOutQuint:function(a,b,c,d,e){return d*((b=b/e-1)*b*b*b*b+1)+c},easeInOutQuint:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b*b*b*b+c;return d/2*((b-=2)*b*b*b*b+2)+c},easeInSine:function(a,b,c,d,e){return-d*Math.cos(b/e*(Math.PI/2))+d+c},easeOutSine:function(a,b,c,d,e){return d*Math.sin(b/e*(Math.PI/2))+c},easeInOutSine:function(a,b,c,d,e){return-d/2*(Math.cos(Math.PI*b/e)-1)+c},easeInExpo:function(a,b,c,d,e){return b==0?c:d*Math.pow(2,10*(b/e-1))+c},easeOutExpo:function(a,b,c,d,e){return b==e?c+d:d*(-Math.pow(2,-10*b/e)+1)+c},easeInOutExpo:function(a,b,c,d,e){if(b==0)return c;if(b==e)return c+d;if((b/=e/2)<1)return d/2*Math.pow(2,10*(b-1))+c;return d/2*(-Math.pow(2,-10*--b)+2)+c},easeInCirc:function(a,b,c,d,e){return-d*(Math.sqrt(1-(b/=e)*b)-1)+c},easeOutCirc:function(a,b,c,d,e){return d*Math.sqrt(1-(b=b/e-1)*b)+c},easeInOutCirc:function(a,b,c,d,e){if((b/=e/2)<1)return-d/2*(Math.sqrt(1-b*b)-1)+c;return d/2*(Math.sqrt(1-(b-=2)*b)+1)+c},easeInElastic:function(a,b,c,d,e){var f=1.70158;var g=0;var h=d;if(b==0)return c;if((b/=e)==1)return c+d;if(!g)g=e*.3;if(h<Math.abs(d)){h=d;var f=g/4}else var f=g/(2*Math.PI)*Math.asin(d/h);return-(h*Math.pow(2,10*(b-=1))*Math.sin((b*e-f)*2*Math.PI/g))+c},easeOutElastic:function(a,b,c,d,e){var f=1.70158;var g=0;var h=d;if(b==0)return c;if((b/=e)==1)return c+d;if(!g)g=e*.3;if(h<Math.abs(d)){h=d;var f=g/4}else var f=g/(2*Math.PI)*Math.asin(d/h);return h*Math.pow(2,-10*b)*Math.sin((b*e-f)*2*Math.PI/g)+d+c},easeInOutElastic:function(a,b,c,d,e){var f=1.70158;var g=0;var h=d;if(b==0)return c;if((b/=e/2)==2)return c+d;if(!g)g=e*.3*1.5;if(h<Math.abs(d)){h=d;var f=g/4}else var f=g/(2*Math.PI)*Math.asin(d/h);if(b<1)return-.5*h*Math.pow(2,10*(b-=1))*Math.sin((b*e-f)*2*Math.PI/g)+c;return h*Math.pow(2,-10*(b-=1))*Math.sin((b*e-f)*2*Math.PI/g)*.5+d+c},easeInBack:function(a,b,c,d,e,f){if(f==undefined)f=1.70158;return d*(b/=e)*b*((f+1)*b-f)+c},easeOutBack:function(a,b,c,d,e,f){if(f==undefined)f=1.70158;return d*((b=b/e-1)*b*((f+1)*b+f)+1)+c},easeInOutBack:function(a,b,c,d,e,f){if(f==undefined)f=1.70158;if((b/=e/2)<1)return d/2*b*b*(((f*=1.525)+1)*b-f)+c;return d/2*((b-=2)*b*(((f*=1.525)+1)*b+f)+2)+c},easeInBounce:function(a,b,c,d,e){return d-jQuery.easing.easeOutBounce(a,e-b,0,d,e)+c},easeOutBounce:function(a,b,c,d,e){if((b/=e)<1/2.75){return d*7.5625*b*b+c}else if(b<2/2.75){return d*(7.5625*(b-=1.5/2.75)*b+.75)+c}else if(b<2.5/2.75){return d*(7.5625*(b-=2.25/2.75)*b+.9375)+c}else{return d*(7.5625*(b-=2.625/2.75)*b+.984375)+c}},easeInOutBounce:function(a,b,c,d,e){if(b<e/2)return jQuery.easing.easeInBounce(a,b*2,0,d,e)*.5+c;return jQuery.easing.easeOutBounce(a,b*2-e,0,d,e)*.5+d*.5+c}})--%>

				<%--$('#list1').click(function() {--%>
					<%--var cart = $('#list2');--%>
					<%--var imgtofly = $('#li1');--%>
					<%--if (imgtofly) {--%>
						<%--var imgclone = imgtofly.clone()--%>
							<%--.offset({ top:imgtofly.offset().top, left:imgtofly.offset().left })--%>
							<%--.css({'opacity':'0.7', 'position':'absolute', 'height':'150px', 'width':'150px', 'z-index':'1000'})--%>
							<%--.appendTo($('body'))--%>
							<%--.animate({--%>
								<%--'top':cart.offset().top + 10,--%>
								<%--'left':cart.offset().left + 30,--%>
								<%--'width':55,--%>
								<%--'height':55--%>
							<%--}, 1000, 'easeInElastic');--%>
						<%--imgclone.animate({'width':0, 'height':0}, function(){ $(this).detach() });--%>
					<%--}--%>
					<%--return false;--%>
				<%--});--%>
            <%--});--%>
		<%--</script>--%>

		<%--<ul id="list1">--%>
			<%--<li id="li1">#item1</li>--%>
			<%--<li>#item2</li>--%>
			<%--<li>#item3</li>--%>
		<%--</ul>--%>
		<%--<ul id="list3">--%>
			<%--<li>#list3</li>--%>
		<%--</ul>--%>
		<%--<ul id="list2">--%>
			<%--<li>#item0</li>--%>
		<%--</ul>--%>
	<%--</div>--%>

	<%--<div id="removeIt2">--%>

		<%--<style>--%>
			<%--* {--%>
				<%--margin: 0;--%>
				<%--padding: 0;--%>
				<%--box-sizing: border-box;--%>
			<%--}--%>

			<%--html {--%>
				<%--height: 100%;--%>
				<%--position: relative;--%>
				<%--font-family: Helvetica, sans-serif;--%>
			<%--}--%>

			<%--.cart {--%>
				<%--position: absolute;--%>
				<%--top: 20px;--%>
				<%--right: 40px;--%>
				<%--height: 24px;--%>
				<%--width: 28px;--%>
				<%--background: url(http://static.jlbs.me/icon-cart.png);--%>
				<%--background-size: cover;--%>
			<%--}--%>

			<%--[data-count]:after {--%>
				<%--position: absolute;--%>
				<%--left: 35px;--%>
				<%--content: attr(data-count);--%>
				<%--color: white;--%>
				<%--background: #e16d6b;--%>
				<%--font-size: 12px;--%>
				<%--font-weight: bold;--%>
				<%--padding: 5px 8px;--%>
				<%--border-radius: 100%;--%>
			<%--}--%>

			<%--.helper {--%>
				<%--width: 100px;--%>
				<%--position: relative;--%>
				<%--left: 25%;--%>
				<%--right: 25%;--%>
				<%--top: 150px;--%>
				<%---webkit-transform: scale(0.5);--%>
				<%--transform: scale(0.5);--%>
				<%--opacity: 0;--%>
			<%--}--%>
			<%--.helper img {--%>
				<%--max-width: 100%;--%>
				<%--height: auto;--%>
			<%--}--%>

			<%--.helper.added {--%>
				<%---webkit-animation: fly-animation 1s ease-in-out;--%>
				<%--animation: fly-animation 1s ease-in-out;--%>
			<%--}--%>
			<%--.added {--%>
				<%--left: 2%;--%>
				<%--top: 2%;--%>
				<%---webkit-animation: fly-animation 1s ease-in-out;--%>
				<%--animation: fly-animation 1s ease-in-out;--%>
			<%--}--%>

			<%--.content {--%>
				<%--width: 90%;--%>
				<%--max-width: 500px;--%>
				<%--margin: 100px auto;--%>
			<%--}--%>

			<%--.product {--%>
				<%--width: 200px;--%>
				<%--float: left;--%>
				<%--margin-right: 100px;--%>
				<%--margin-bottom: 20px;--%>
				<%--position: relative;--%>
			<%--}--%>
			<%--.product img {--%>
				<%--max-width: 100%;--%>
				<%--height: auto;--%>
			<%--}--%>
			<%--.product .add-to-cart {--%>
				<%--font-size: 13px;--%>
				<%--text-transform: uppercase;--%>
				<%--color: #df6566;--%>
				<%--padding: 8px;--%>
				<%--margin-top: 5px;--%>
				<%--border: 2px solid #df6566;--%>
				<%--border-radius: 4px;--%>
				<%--cursor: pointer;--%>
			<%--}--%>
			<%--.product .add-to-cart:hover {--%>
				<%--background: #df6566;--%>
				<%--color: white;--%>
			<%--}--%>
			<%--.product:nth-child(2n) {--%>
				<%--margin-right: 0;--%>
			<%--}--%>

			<%--@-webkit-keyframes fly-animation {--%>
				<%--10% {--%>
					<%--opacity: 1;--%>
				<%--}--%>
				<%--50% {--%>
					<%--opacity: 1;--%>
					<%---webkit-transform: scale(0.75);--%>
					<%--transform: scale(0.75);--%>
				<%--}--%>
				<%--100% {--%>
					<%---webkit-transform: scale(0.1) translateX(-4rem) translateY(10rem);--%>
					<%--transform: scale(0.1) translateX(-4rem) translateY(10rem);--%>
					<%--left: 100%;--%>
					<%--top: -50px;--%>
					<%--opacity: 0;--%>
				<%--}--%>
			<%--}--%>

			<%--@keyframes fly-animation {--%>
				<%--10% {--%>
					<%--opacity: 1;--%>
				<%--}--%>
				<%--50% {--%>
					<%--opacity: 1;--%>
					<%---webkit-transform: scale(0.75);--%>
					<%--transform: scale(0.75);--%>
				<%--}--%>
				<%--100% {--%>
					<%---webkit-transform: scale(0.1) translateX(-4rem) translateY(10rem);--%>
					<%--transform: scale(0.1) translateX(-4rem) translateY(10rem);--%>
					<%--left: 100%;--%>
					<%--top: -50px;--%>
					<%--opacity: 0;--%>
				<%--}--%>
			<%--}--%>

		<%--</style>--%>

		<%--<script src='//ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js'></script>--%>
		<%--<script>--%>
            <%--var counter=0;--%>

            <%--$(document).ready(function() {--%>
                <%--$('.content .product .add-to-cart').click(function() {--%>
                    <%--$('.helper').addClass('added');--%>
                    <%--counter++;--%>

                    <%--var buttonCount = setTimeout(function(){--%>
                        <%--$('.cart').attr('data-count', counter);--%>
                    <%--}, 1000);--%>

                    <%--var removeClass = setTimeout(function(){--%>
                        <%--$('.helper, .cart').removeClass('added');--%>
                    <%--}, 1500);--%>
                <%--})--%>
            <%--});--%>
		<%--</script>--%>

		<%--<!-- / Click the "Add to cart" Button to see the animation. -->--%>
		<%--<span class='cart'></span>--%>
		<%--<div class='helper'>--%>
			<%--<img src='http://placehold.it/200x200'>--%>
		<%--</div>--%>
		<%--<section class='content'>--%>
			<%--<div class='product'>--%>
				<%--<img src='http://placehold.it/200x200'>--%>
				<%--<h3 class='add-to-cart'>Add to cart</h3>--%>
			<%--</div>--%>
			<%--<div class='product'>--%>
				<%--<img src='http://placehold.it/200x200'>--%>
				<%--<h3 class='add-to-cart'>Add to cart</h3>--%>
			<%--</div>--%>
			<%--<div class='product'>--%>
				<%--<img src='http://placehold.it/200x200'>--%>
				<%--<h3 class='add-to-cart'>Add to cart</h3>--%>
			<%--</div>--%>
			<%--<div class='product'>--%>
				<%--<img src='http://placehold.it/200x200'>--%>
				<%--<h3 class='add-to-cart'>Add to cart</h3>--%>
			<%--</div>--%>
		<%--</section>--%>
	<%--</div>--%>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<div class="price-range">
							<h2><%=session.getAttribute("page.main.priceRange")%></h2>
							<div class="well">
									<input name="sliderValue" type="text" class="span2" value="50,150" data-slider-min="0" data-slider-max="600" data-slider-step="1" data-slider-value="[50,150]" id="sl2" ><br />
									<b>$ 0</b> <b class="pull-right">$ 600</b>
									</br><button onclick="filter()"><%=session.getAttribute("page.main.accept")%></button>
							</div>
						</div>

						<div class="shipping text-center">
							<img src="${pageContext.request.contextPath}/eshop/images/home/shipping.jpg" alt="" />
						</div>

					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items">
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