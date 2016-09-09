
$(document).ready(function() {

	$('button#submitButton').click( function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				userName : $('#lastName').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').html(responseText);
			}
		});
	});
});