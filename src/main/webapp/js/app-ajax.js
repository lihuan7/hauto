$(document).ready(function () {

        $('button#submitButton').click(function () {

            var transformTab = {
                "tag": "table", "children": [
                    {
                        "tag": "tbody", "children": [
                        {
                            "tag": "tr", "children": [
                            {"tag": "td", "html": "${firstName}"},
                            {"tag": "td", "html": "${middleName}"}
                        ]
                        }
                    ]
                    }
                ]
            };

            if ((($('#lastName').val().length > 0) && ($('#firstName').val().length > 0) && ($('#middleName').val().length > 0))
                || ($('#cityName').val().length > 0)
                || (($('#autoMark').val().length > 0) && ($('#autoModel').val().length > 0))) {

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
                        //$('#ajaxFindHumanServletResponse').html(responseText);
                        $('#ajaxFindHumanServletResponse').html(json2html.transform(responseText, transformTab));
                    }
                });
            } else {
                alert("Необходимо заполнить один из признаков для поиска");
            }
        });

});