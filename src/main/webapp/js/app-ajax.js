$(document).ready(function () {

    $('button#submitButton').click(function () {

        var carMap = {"tag": "div", "html": "${brand} - ${model}"}
        var tableMap = {
            "tag": "table", "class":"wborder" , "children": [
                {
                    "tag": "tbody", "children": [
                    {
                        "tag": "tr", "children": [
                        {"tag": "td", "html": "${firstName}"},
                        {"tag": "td", "html": "${middleName}"},
                        {"tag": "td", "html": "${lastName}"},
                        {"tag": "td", "html": "${city.name}"},
                        {
                            "tag": "td", "html": function () {
                            return ( json2html.transform(this.autoMobiles, carMap) );
                        }
                        },
                    ]
                    }
                ]
                }
            ]
        };


        if ((($('#lastName').val().length > 0) && ($('#firstName').val().length > 0) && ($('#middleName').val().length > 0))
            || ($('#cityName').val().length > 0)
            || (($('#autoMark').val().length > 0) && ($('#autoModel').val().length > 0))) {

            // $.ajax({
            //     url: 'FindHumanServlet',
            //     data: {
            //         lastName: $('#lastName').val(),
            //         firstName: $('#firstName').val(),
            //         middleName: $('#middleName').val(),
            //         cityName: $('#cityName').val(),
            //         autoMark: $('#autoMark').val(),
            //         autoModel: $('#autoModel').val(),
            //     },
            //     success: function (responseText) {
            //         //$('#ajaxFindHumanServletResponse').html(responseText);
            //         $('#ajaxFindHumanServletResponse').html(json2html.transform(responseText, tableMap));
            //     }
            // });

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
                    //$('#ajaxFindHumanServletResponse').html(responseText);
                    $('#ajaxFindHumanServletResponse').html(json2html.transform(responseText, tableMap));
                }
            });

            // $.ajax({
            //     url: 'FindHumanServlet', // url where to submit the request
            //     type : "POST", // type of action POST || GET
            //     dataType : 'json', // data type
            //     data : $("#frm").serialize(), // post data || get data
            //     success : function(result) {
            //         // you can see the result from the console
            //         // tab of the developer tools
            //         console.log(result);
            //     },
            //     error: function(xhr, resp, text) {
            //         console.log(xhr, resp, text);
            //     }
            // });
        } else {
            alert("Необходимо заполнить один из признаков для поиска");
        }
    });

});