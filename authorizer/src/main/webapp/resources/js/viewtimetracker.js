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
		    	$("#projectUser").empty();
		    	$("#projectUser").append("<option value=''>Select User</option>");
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
