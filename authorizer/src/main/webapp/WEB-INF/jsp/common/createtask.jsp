<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>
</head>
<script src="resources/js/createtask.js" type="text/javascript"
	charset="UTF-8"></script>
<script>
$(document).on("change", '#projectId', function(e) {
    var projId = $(this).val();
    
    $.ajax({
        type: "POST",
        data: {"projectId": projId},
        url: 'getUser',
        dataType: 'json',
        success: function(json) {

            var $el = $("#userId");
            $el.empty(); // remove old options
            $el.append($("<option></option>")
                    .attr("value", '').text('Please Select User'));
            var data = json.userDVOs;
            for(i=0; i<data.length; i++) {
                 $el.append($("<option></option>")
                        .attr("value", data[i].userId).text(data[i].userName));
               }
           			
        }
    });

});
</script>
<body>
<div class="ui middle aligned center aligned grid">
<table  class="ui celled table" style="width: 80%"><tr><td>
	<div class="column">
		<h4 class="ui center aligned header">Create Task</h4>
		
		<c:if test="${not empty loginMsg}">
						<div class="ui ${loginClass} message">
							<i class="close icon"></i> ${loginMsg}
						</div>
		</c:if>

		<form class="ui large form" name="TaskDVO" action="savetask">
			<div class="field">
				<label>Project</label>  
				<select	class="ui search dropdown" id="projectId" name="projectId">
				<option value="">Select Project</option>
					<c:forEach items="${taskDVO.projectDVOs}" var="element"> 
						<option value="${element.projectId}">${element.projectName}</option>
    				</c:forEach>
				</select>
			</div>
			<div class="field">
				<label>Task Name</label> <input type="text" name="taskName"
					placeholder="Task Name">
			</div>
			<div class="field">
				<label>User</label> <select class="ui search dropdown" id="userId" name="userId">
					<option value="">Select User</option>
					<option value="1">User1</option>
					<option value="2">User2</option>
					<option value="3">User3</option>
					<option value="4">User4</option>
				</select>
			</div>
			<button class="small ui inverted right floated green button submit" type="submit">Submit</button>
		</form>
	</div>
	</td></tr></table>
</div>
</body>
</html>