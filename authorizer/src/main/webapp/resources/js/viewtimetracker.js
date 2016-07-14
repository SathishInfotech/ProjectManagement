/**
 * 
 */
$(document).ready(function() {
	$('#projectId').change(function() {
		var data = "";
		$.ajax({
		    type : "GET",
		    url : "getUsersByProject",
		    data : {'projectid':$('#projectId').val()},
		    async : false,
		    success : function(response) {		    
			    $.each(response.users, function(index,value){ 
			    	$("#projectUser").append("<option value=\"" + index + "\">" + value + "</option>"); 
			    });
		    },
		    error : function() {
			    alert('Error occured');
		    }
		})
	})
});
