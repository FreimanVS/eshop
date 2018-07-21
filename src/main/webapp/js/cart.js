var contextPath = $('#contextPathHolder').attr('data-contextPath');
var confirmation = "";

$(document).ready(function() {
    confirmation = $("#page_cart_confirmation").val()
});

function removeFromCart(id) {
    if (!(confirm(confirmation))) {
        return false;
    }
    $.ajax({
        url: contextPath + "/cart?id=" + id,
        type: "DELETE",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });
}

function updateCart(id) {
    var count = 0;
    $("input[name='" + id + "']").each(function (index) {
        count = $(this).val();
    });

    $.ajax({
        url: contextPath + "/cart?id=" + id + "&count=" + count,
        type: "PUT",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });
}

function quantityDown(id) {
    var count = Number("0");
    $("input[name='" + id + "']").each(function (index) {
        count = parseInt($(this).val());
    });

    count = count - Number("1");

    $.ajax({
        url: contextPath + "/cart?id=" + id + "&count=" + count,
        type: "PUT",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });

}

function quantityUp(id) {
    var count = Number("0");
    $("input[name='" + id + "']").each(function (index) {
        count = parseInt($(this).val());
    });

    count = count + Number("1");

    $.ajax({
        url: contextPath + "/cart?id=" + id + "&count=" + count,
        type: "PUT",
        data: ({}),
        dataType: "JSON",
        beforeSend: function() {
        },
        success: function(data) {
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });
}