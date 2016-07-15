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
	 $('#taskTabl').css('display','none');
     $('#taskTabl').hide();
     $('#taskActivityTabl').css('display','none');
     $('#taskActivityTabl').hide();
    var usrId = $("#userId").val();
    $.ajax({
        type: "POST",
        data: {"userId": usrId},
        url: 'viewtaskdetails',
        dataType: 'json',
        success: function(json) {

            var $el = $("#tasktablId");
            $el.empty(); // remove old options
            var data = json;
            for(i=0; i<data.length; i++) {
                 $el.append("<tr><td>"+data[i].taskName+"</td><td>In Progress</td><td><button class='ui green button tskDtsView' type='button' class='tskDtsView' id='detailsBtn_"+data[i].taskId+"'>View</button></td></tr>");
               }
            $('#taskTabl').css('display','block');
            $('#taskTabl').show();
        }
    });

});

$(document).on("click", '.tskDtsView', function(e) {
    var taskId = $(this).attr('id');
    var taskIdVal = taskId.split("_")[1];
    
     $.ajax({
        type: "POST",
        data: {"taskId": taskIdVal},
        url: 'viewactivity',
        dataType: 'json',
        success: function(json) {

        	 var $el = $("#taskActivitytablId");
             $el.empty(); // remove old options
             var data = json;
             for(i=0; i<data.length; i++) {
            	 var respVal = "<tr><td>"+data[i].task+"</td>";
            	 respVal+="<td>"+data[i].activity+"</td>";
            	 respVal+="<td>"+data[i].phase+"</td>";
            	 respVal+="<td>"+data[i].subPhase+"</td>";
            	 respVal+="<td>"+data[i].estimatedHour+"</td>";
            	 respVal+="<td>"+data[i].plannedStartDate+"</td>";
            	 respVal+="<td>"+data[i].plannedEndDate+"</td>";
            	 respVal+="<td>"+data[i].actualStartDate+"</td>";
            	 respVal+="<td>"+data[i].actualEndDate+"</td>";
            	 respVal+="<td>"+data[i].status+"</td></tr>";
                  $el.append(respVal);
                }
             $('#taskActivityTabl').css('display','block');
             $('#taskActivityTabl').show();
        }
    }); 

});




</script>
<body>
<div class="ui middle aligned center aligned grid">
<table  class="ui celled table" style="width: 80%"><tr><td>
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
	<div class="column" >
	</br></br>
	</div>
	<div class="column" >
	<div id="taskTabl" style="display: none;">
	<h1>Task Details</h1>
		<table class="ui celled striped table">
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Task Status</th>
					<th>Details</th>
				</tr>
			</thead>
			<tbody id="tasktablId">
			</tbody>
		</table>
	</div>
	</div>
	<div class="column" >
	</br></br>
	</div>
	<div class="column" >
	<div id="taskActivityTabl" style="display: none;">
	<h1>Task Activity Details</h1>
		<table class="ui celled striped table">
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Activity Name</th>
					<th>Phase</th>
					<th>Sub Phase</th>
					<th>Estimated Hrs</th>
					<th>Planned Start Date</th>
					<th>Planned End Date</th>
					<th>Actual Start Date</th>
					<th>Actual End Date</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody id="taskActivitytablId">
			</tbody>
		</table>
	</div>
	</div>
	
</td></tr></table>
</div>
</body>
</html>