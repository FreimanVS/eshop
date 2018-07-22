var appendJson = "";
var ip = location.hostname;
var port = location.port;
var contextPath = $('#contextPathHolder').attr('data-contextPath');
var val = $('#valHolder').attr('data-val');
var curPage = new Number(1);
var curData = null;

//i18n variables
var featuresItems = "";
var addToCart = "";
var prev = "";
var next = "";

function i18n(name) {
    return $("#" + name).val();
}

$(document).ready(function() {

    //initialization of i18n variables
    featuresItems = $("#page_goods_featuresItems").val();
    addToCart = $("#page_goods_addToCart").val();
    prev = $("#page_goods_prev").val();
    next = $("#page_goods_next").val();

    appendJson = appendJson + "<h2 class=\"title text-center\">" + featuresItems + "</h2>";

    $.ajax({
        url: contextPath + "/search?q=" + val,
        type: "POST",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            curData = data;
            appendJson = "<h2 class=\"title text-center\">" + featuresItems + "</h2>";
            if (data.length <= 6) {
                for (var i = 0; i < data.length; i++) {
                    goods(i);
                }
            } else {
                for (var i = 0; i < 6; i++) {
                    goods(i);
                }
            }

            appendJson = appendJson + "<ul class=\"pagination\">\n";

            if (curPage >= 2) {
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"prevPage();return false;\">" + prev + "</a></li>\n";
            }

            if (curPage * 6 < data.length) {
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"nextPage();return false;\">" + next + "</a></li>\n";

            }

            appendJson = appendJson + "\t\t\t\t\t\t</ul>";

            $(".features_items").html(appendJson);
        },
        error: function () {
            alert('error');
        }
    });
});

function addToCartFunc(id) {
    $.ajax({
        url: contextPath + "/cart?id=" + id,
        type: "GET",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
        },
        error: function () {
        }
    });

    jQuery.easing["jswing"]=jQuery.easing["swing"];jQuery.extend(jQuery.easing,{def:"easeOutQuad",swing:function(a,b,c,d,e){return jQuery.easing[jQuery.easing.def](a,b,c,d,e)},easeInQuad:function(a,b,c,d,e){return d*(b/=e)*b+c},easeOutQuad:function(a,b,c,d,e){return-d*(b/=e)*(b-2)+c},easeInOutQuad:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b+c;return-d/2*(--b*(b-2)-1)+c},easeInCubic:function(a,b,c,d,e){return d*(b/=e)*b*b+c},easeOutCubic:function(a,b,c,d,e){return d*((b=b/e-1)*b*b+1)+c},easeInOutCubic:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b*b+c;return d/2*((b-=2)*b*b+2)+c},easeInQuart:function(a,b,c,d,e){return d*(b/=e)*b*b*b+c},easeOutQuart:function(a,b,c,d,e){return-d*((b=b/e-1)*b*b*b-1)+c},easeInOutQuart:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b*b*b+c;return-d/2*((b-=2)*b*b*b-2)+c},easeInQuint:function(a,b,c,d,e){return d*(b/=e)*b*b*b*b+c},easeOutQuint:function(a,b,c,d,e){return d*((b=b/e-1)*b*b*b*b+1)+c},easeInOutQuint:function(a,b,c,d,e){if((b/=e/2)<1)return d/2*b*b*b*b*b+c;return d/2*((b-=2)*b*b*b*b+2)+c},easeInSine:function(a,b,c,d,e){return-d*Math.cos(b/e*(Math.PI/2))+d+c},easeOutSine:function(a,b,c,d,e){return d*Math.sin(b/e*(Math.PI/2))+c},easeInOutSine:function(a,b,c,d,e){return-d/2*(Math.cos(Math.PI*b/e)-1)+c},easeInExpo:function(a,b,c,d,e){return b==0?c:d*Math.pow(2,10*(b/e-1))+c},easeOutExpo:function(a,b,c,d,e){return b==e?c+d:d*(-Math.pow(2,-10*b/e)+1)+c},easeInOutExpo:function(a,b,c,d,e){if(b==0)return c;if(b==e)return c+d;if((b/=e/2)<1)return d/2*Math.pow(2,10*(b-1))+c;return d/2*(-Math.pow(2,-10*--b)+2)+c},easeInCirc:function(a,b,c,d,e){return-d*(Math.sqrt(1-(b/=e)*b)-1)+c},easeOutCirc:function(a,b,c,d,e){return d*Math.sqrt(1-(b=b/e-1)*b)+c},easeInOutCirc:function(a,b,c,d,e){if((b/=e/2)<1)return-d/2*(Math.sqrt(1-b*b)-1)+c;return d/2*(Math.sqrt(1-(b-=2)*b)+1)+c},easeInElastic:function(a,b,c,d,e){var f=1.70158;var g=0;var h=d;if(b==0)return c;if((b/=e)==1)return c+d;if(!g)g=e*.3;if(h<Math.abs(d)){h=d;var f=g/4}else var f=g/(2*Math.PI)*Math.asin(d/h);return-(h*Math.pow(2,10*(b-=1))*Math.sin((b*e-f)*2*Math.PI/g))+c},easeOutElastic:function(a,b,c,d,e){var f=1.70158;var g=0;var h=d;if(b==0)return c;if((b/=e)==1)return c+d;if(!g)g=e*.3;if(h<Math.abs(d)){h=d;var f=g/4}else var f=g/(2*Math.PI)*Math.asin(d/h);return h*Math.pow(2,-10*b)*Math.sin((b*e-f)*2*Math.PI/g)+d+c},easeInOutElastic:function(a,b,c,d,e){var f=1.70158;var g=0;var h=d;if(b==0)return c;if((b/=e/2)==2)return c+d;if(!g)g=e*.3*1.5;if(h<Math.abs(d)){h=d;var f=g/4}else var f=g/(2*Math.PI)*Math.asin(d/h);if(b<1)return-.5*h*Math.pow(2,10*(b-=1))*Math.sin((b*e-f)*2*Math.PI/g)+c;return h*Math.pow(2,-10*(b-=1))*Math.sin((b*e-f)*2*Math.PI/g)*.5+d+c},easeInBack:function(a,b,c,d,e,f){if(f==undefined)f=1.70158;return d*(b/=e)*b*((f+1)*b-f)+c},easeOutBack:function(a,b,c,d,e,f){if(f==undefined)f=1.70158;return d*((b=b/e-1)*b*((f+1)*b+f)+1)+c},easeInOutBack:function(a,b,c,d,e,f){if(f==undefined)f=1.70158;if((b/=e/2)<1)return d/2*b*b*(((f*=1.525)+1)*b-f)+c;return d/2*((b-=2)*b*(((f*=1.525)+1)*b+f)+2)+c},easeInBounce:function(a,b,c,d,e){return d-jQuery.easing.easeOutBounce(a,e-b,0,d,e)+c},easeOutBounce:function(a,b,c,d,e){if((b/=e)<1/2.75){return d*7.5625*b*b+c}else if(b<2/2.75){return d*(7.5625*(b-=1.5/2.75)*b+.75)+c}else if(b<2.5/2.75){return d*(7.5625*(b-=2.25/2.75)*b+.9375)+c}else{return d*(7.5625*(b-=2.625/2.75)*b+.984375)+c}},easeInOutBounce:function(a,b,c,d,e){if(b<e/2)return jQuery.easing.easeInBounce(a,b*2,0,d,e)*.5+c;return jQuery.easing.easeOutBounce(a,b*2-e,0,d,e)*.5+d*.5+c}})

    $("button[value='" + id + "']").each(function() {
        var cart = $('#cart');
        var imgtofly = $($(this).parent().get(0).childNodes[1]);
        if (imgtofly) {
            var imgclone = imgtofly.clone()
                .offset({ top:imgtofly.offset().top, left:imgtofly.offset().left })
                .css({'opacity':'0.7', 'position':'absolute', 'height':'250px', 'width':'250px', 'z-index':'1000'})
                .appendTo($('body'))
                .animate({
                    'top':cart.offset().top + 10,
                    'left':cart.offset().left + 30,
                    'width':55,
                    'height':55
                }, 1000, 'easeInElastic');
            imgclone.animate({'width':0, 'height':0}, function(){ $(this).detach() });
        }
        return false;
    });
}

function paginator() {
    var data = curData;
    appendJson = "<h2 class=\"title text-center\">" + featuresItems + "</h2>";
    var from = curPage * 6 - 5 - 1;

    var to;
    if (curPage * 6 - 1 < data.length - 1) {
        to = curPage * 6 - 1;
    } else {
        to = data.length - 1;
    }

    for (var i = from; i <= to; i++) {
        goods(i);
    }

    appendJson = appendJson + "<ul class=\"pagination\">\n";

    if (curPage >= 2) {
        appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"prevPage();return false;\">" + prev + "</a></li>\n";
    }

    if (curPage * 6 < data.length) {
        appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"nextPage();return false;\">" + next + "</a></li>\n";

    }

    appendJson = appendJson + "\t\t\t\t\t\t</ul>";

    $(".features_items").html(appendJson);
}

function prevPage() {
    curPage = curPage - 1;
    paginator();
}

function nextPage() {
    curPage = curPage + 1;
    paginator();
}

function goods(i) {
    var data = curData;
    appendJson = appendJson +
        "<div class=\"col-sm-4\">\n" +
        "\t\t\t\t\t\t\t<div class=\"product-image-wrapper\">\n" +
        "\t\t\t\t\t\t\t\t<div class=\"single-products\">\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"productinfo text-center\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<img src=\"" + contextPath + "/eshop/" + "images/shop/" + data[i].img + "\" alt=\"\" />\n" +
        "\t\t\t\t\t\t\t\t\t\t<h2>" + data[i].price + "</h2>\n" +
        "\t\t\t\t\t\t\t\t\t\t<p>" + i18n(data[i].name) + "</p>\n" +
        "\t\t\t\t\t\t\t\t\t\t<button value='" + data[i].id + "' onclick='addToCartFunc(" + data[i].id + ")' class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>" + addToCart + "</button>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t<div class=\"choose\">\n" +
        "\t\t\t\t\t\t\t\t\t<ul class=\"nav nav-pills nav-justified\">\n" +
        "\t\t\t\t\t\t\t\t\t</ul>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t</div>"
}