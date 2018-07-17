var ip = location.hostname;
var port = location.port;
var contextPath = $('#contextPathHolder').attr('data-contextPath');

$(document).ready(function() {
    $("#searchInput").keypress(function (e) {
        if (e.which == 13) {
            var val = $("#searchInput").val();
            window.location.replace("http://" + ip + ":" + port + contextPath + "/search?val=" + val);
        }
    });
});