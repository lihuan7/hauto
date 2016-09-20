$(document).ready(function () {

    $('button#submitButton').click(function () {

        var carMap = {"tag": "div", "html": "${brand} - ${model}"}
        var tableMap = {
            tag: 'tr',
            children: [{
                "tag": "td",
                "html": "${firstName}"
            }, {
                "tag": "td",
                "html": "${middleName}"
            }, {
                "tag": "td",
                "html": "${lastName}"
            }, {
                "tag": "td",
                "html": "${city.name}"
            }, {
                "tag": "td",
                "html": function () {
                    return ( json2html.transform(this.autoMobiles, carMap));
                }
            }]
        };
        
        if ((($('#lastName').val().length > 0) && ($('#firstName').val().length > 0) && ($('#middleName').val().length > 0))
            || ($('#cityName').val().length > 0)
            || (($('#autoMark').val().length > 0) && ($('#autoModel').val().length > 0))) {

            // create JSON
            var jsonObj = {
                "lastName": $('#lastName').val(),
                "firstName": $('#firstName').val(),
                "middleName": $('#middleName').val(),
                "cityName": $('#cityName').val(),
                "autoMark": $('#autoMark').val(),
                "autoModel": $('#autoModel').val()
            };
            // convert JSON to string
            var jsonString = JSON.stringify(jsonObj);

            $.ajax({
                type: "GET",
                url: 'FindHumanServlet',
                data: {jsonData: jsonString},
                dataType: "json",
                success: function (responseText) {
                    $('#placar tbody').empty().json2html(responseText, tableMap);
                }
            });
            
        } else {
            alert("Необходимо заполнить один из признаков для поиска");
        }
    });

});