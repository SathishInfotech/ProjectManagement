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

$(document).on("click", '#viewTaskIdBtn', function(e) {
    var usrId = $("#userId").val();
    $.ajax({
        type: "POST",
        data: {"userId": usrId},
        url: 'viewtaskdetails',
        dataType: 'json',
        success: function(json) {

            var $el = $("#tasktablId");
            $el.empty(); // remove old options
            var data = json.userDVOs;
            for(i=0; i<data.length; i++) {
                 $el.append($("<option></option>").attr("value", data[i].userId).text(data[i].userName));
                 $el.append("<tr><td>"+data[i].taskId+"</td><td>"+data[i].taskName+"</td><td>In Progress"+</td>");
                 $el.append("<td><button class='ui button' type='button' class='tskDtsView' id='detailsBtn"+data[i].taskId+"'>Details</button></td></tr>");
               }
            $('#taskTabl').css('display','block');
            $('#taskTabl').show();
        }
    });

});

$(document).on("click", '.tskDtsView', function(e) {
    var projId = $(this).val();
   /*  $.ajax({
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
    }); */

});




</script>
<body>
	<div class="column" >
		<h4 class="ui center aligned header">View Task Details</h4>

		<form class="ui form" name="TaskDVO" action="viewtaskdetails">
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
				<label>User</label> <select class="ui search dropdown" id="userId" name="userId">
					<option value="">Select User</option>
					<option value="1">User1</option>
					<option value="2">User2</option>
					<option value="3">User3</option>
					<option value="4">User4</option>
				</select>
			</div>
			<button class="ui button" type="button" id="viewTaskIdBtn">View Task</button>
		</form>
		
	</div>
	<div id="taskTabl" style="display: none;">
		<table class="ui celled striped table">
			<thead>
				<tr>
					<th colspan="4">Task Details</th>
				</tr>
			</thead>
			<tbody id="tasktablId">
				<tr>
					<td class="collapsing"><i class="folder icon"></i>
						node_modules</td>
					<td>Initial commit</td>
					<td class="right aligned collapsing">10 hours ago</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
</html>