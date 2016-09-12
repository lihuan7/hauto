$(document).ready(function () {
    $('button#submitButton').click(function () {

        if ((($('#lastName').val().length > 0)&&($('#firstName').val().length > 0)&&($('#middleName').val().length > 0))
        ||($('#cityName').val().length > 0)
        ||(($('#autoMark').val().length > 0)&&($('#autoModel').val().length > 0))){

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
        }else{
            alert("Необходимо заполнить один из признаков для поиска");
        }
    });
});