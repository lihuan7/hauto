$(document).ready(function () {
    $('button#submitButton').click(function () {
        $.ajax({
            url: 'FindHumanServlet',
            data: {
                lastName: $('#lastName').val(),
                firstName: $('#firstName').val(),
                middleName: $('#middleName').val(),
                cityName: $('#cityName').val(),
                autoMark: $('#autoMark').val(),
                autoModel: $('#autoModel').val(),
            },
            success: function (responseText) {
                $('#ajaxFindHumanServletResponse').html(responseText);
            }
        });
    });
});