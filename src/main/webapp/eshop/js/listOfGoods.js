var ip = location.hostname;
var port = location.port;
var contextPath = $('#contextPathHolder').attr('data-contextPath');

var appendJson = "<h2 class=\"title text-center\">Features Items</h2>";
var curPage = new Number(1);

var tempData = null;

function goods(i) {
    var data = tempData;
    appendJson = appendJson +
        "<div class=\"col-sm-4\">\n" +
        "\t\t\t\t\t\t\t<div class=\"product-image-wrapper\">\n" +
        "\t\t\t\t\t\t\t\t<div class=\"single-products\">\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"productinfo text-center\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<img src=\"" + contextPath + "/eshop/" + "images/shop/" + data[i].img + "\" alt=\"\" />\n" +
        "\t\t\t\t\t\t\t\t\t\t<h2>" + data[i].price + "</h2>\n" +
        "\t\t\t\t\t\t\t\t\t\t<p>" + data[i].name + "</p>\n" +
        "\t\t\t\t\t\t\t\t\t\t<button value='" + data[i].id + "' onclick='addToCart(" + data[i].id + ")' class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>add to cart</button>\n" +
        "\t\t\t\t\t\t\t\t\t</div>\n" +
        "\t\t\t\t\t\t\t\t\t<div class=\"product-overlay\">\n" +
        "\t\t\t\t\t\t\t\t\t\t<div class=\"overlay-content\">\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<h2>" + data[i].price + "</h2>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<p>" + data[i].name + "</p>\n" +
        "\t\t\t\t\t\t\t\t\t\t\t<button value='" + data[i].id + "' onclick='addToCart(" + data[i].id + ")' class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>add to cart</button>\n" +
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

function filter() {
    appendJson = "<h2 class=\"title text-center\">Features Items</h2>";
    var sliderValue = $("#sl2").val();
    $.ajax({
        url: contextPath + "/filter?sliderValue=" + sliderValue,
        type: "POST",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            tempData = data;
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
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"prevPage();return false;\">prev</a></li>\n";
            }

            if (curPage * 6 < data.length) {
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"nextPage();return false;\">next</a></li>\n";

            }

            appendJson = appendJson + "\t\t\t\t\t\t</ul>";

            $(".features_items").html(appendJson);
        },
        error: function () {
        }
    });
}

function addToCart(id) {
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
    appendJson = "<h2 class=\"title text-center\">Features Items</h2>";
    $.ajax({
        url: contextPath + "/api/v1/goods",
        type: "GET",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            tempData = data;
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
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"prevPage();return false;\">prev</a></li>\n";
            }

            if (curPage * 6 < data.length) {
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"nextPage();return false;\">next</a></li>\n";

            }

            appendJson = appendJson + "\t\t\t\t\t\t</ul>";

            $(".features_items").html(appendJson);
        },
        error: function () {

        }
    });
}

function prevPage() {
    curPage = curPage - 1;
    paginator();
}

function nextPage() {
    curPage = curPage + 1;
    paginator();
}

$(document).ready(function() {
    $.ajax({
        url: contextPath + "/api/v1/goods",
        type: "GET",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            tempData = data;

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
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"prevPage();return false;\">prev</a></li>\n";
            }

            if (curPage * 6 < data.length) {
                appendJson = appendJson + "\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"nextPage();return false;\">next</a></li>\n";

            }

            appendJson = appendJson + "\t\t\t\t\t\t</ul>";

            $(".features_items").html(appendJson);
        },
        error: function () {
        }
    });
});