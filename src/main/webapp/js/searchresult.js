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
        "\t\t\t\t\t\t\t\t\t<div class=\"product-overlay\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"overlay-content\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<h2>" + data[i].price + "</h2>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<p>" + i18n(data[i].name) + "</p>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<button value='" + data[i].id + "' onclick='addToCartFunc(" + data[i].id + ")' class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>" + addToCart + "</button>\n" +
        "\t\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t<div class=\"choose\">\n" +
        "\t\t\t\t\t\t\t\t\t<ul class=\"nav nav-pills nav-justified\">\n" +
        "\t\t\t\t\t\t\t\t\t</ul>\n" +
        "\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t</div>"
}