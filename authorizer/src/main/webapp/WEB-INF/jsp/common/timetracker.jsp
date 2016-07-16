<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/timetracker.js"></script>
<title>TaskSheet</title>
</head>
<script type="text/javascript">
$(document).on("change", '#projectId', function(e) {
    var projId = $(this).val();
    $.ajax({
        type: "GET",
        data: {"projectId": projId},
        url: 'getTimeTrckerTaskPhase',
        dataType: 'json',
        success: function(json) {

        	var tasks = json.tasks;
        	var phases = json.phases;
            var $elTask = $("#appendtasks0");
            var $elPhase = $("#appendphases0");
            $elTask.empty(); // remove old options
            $elPhase.empty();
            $elTask.append($("<option></option>")
                    .attr("value", '').text('Select Task'));
            $elPhase.append($("<option></option>")
                    .attr("value", '').text('Select Phase'));
            var data = json.userDVOs;
            $.each(tasks, function(k, v) {
            	$elTask.append($("<option></option>")
                        .attr("value", k).text(v));
            });
            $.each(phases, function(k, v) {
            	$elPhase.append($("<option></option>")
                        .attr("value", k).text(v));
            });
        }
    });

});
</script>
<body>
<div class="column" >
		<h4 class="ui center aligned header">Create Time Tracker</h4>
	<c:if test="${not empty saveStatus}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${status}</strong> ${saveStatus}
		</div>
	</c:if>
	<form name="timetracker" action="saveTimeTracker" id="timetracker"
		class="ui form" method="post">
	<div class="ui padded raised segment">
		<div class="field" style="width: 50%" align="left">
				<label>Project</label>  
				<select	class="ui search dropdown" id="projectId" name="projectId">
				<option value="">Select Project</option>
					<c:forEach items="${taskDVO.projectDVOs}" var="element"> 
						<option value="${element.projectId}">${element.projectName}</option>
    				</c:forEach>
				</select>
		</div>
	</div>
		<div class="ui padded raised segment">
			<button class="ui small right floated primary button"
				id="addTimeTracker">
				<span class="glyphicon glyphicon-plus"></span>Add New Row
			</button>

			<table id="tasktable" class="table">
				<thead>
					<tr>
						<th>Date</th>
						<th>Task Name</th>
						<th>Activity Name</th>
						<th>Phase</th>
						<th>Sub Phase</th>
						<th>Hours</th>
						<th>Remarks</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><div class="field">
								<input type="text" name="timeTrackerDetailsDVOs[0].timeDate"
									id="datepicker-input" placeholder="Select Date" required="required"/>
							</div></td>
						<td><div class="field">
								<select id="appendtasks0"
									name="timeTrackerDetailsDVOs[0].taskId"
									onchange="changeTaskFunction(this)" required="required">
									<option value="">Select Task</option>
								</select>

							</div></td>
						<td><div class="field">
								<select id="activity0"
									name="timeTrackerDetailsDVOs[0].activityId" required="required">
									<option value="">Select Activity</option>
								</select>
							</div></td>
						<td><div class="field">
								<select id="appendphases0"
									name="timeTrackerDetailsDVOs[0].phaseId"
									onchange="changePhaseFunction(this)" required="required">
									<option value="">Select Phase</option>
								</select>
							</div></td>
						<td><div class="field">
								<select id="subphase0"
									name="timeTrackerDetailsDVOs[0].subphaseId" required="required">
									<option value="">Select SubPhase</option>
								</select>
							</div></td>
						<td><div class="field">
								<input type="text" id="hour0"
									name="timeTrackerDetailsDVOs[0].hoursSpent" placeholder="Hours" required="required"/>
							</div></td>

						<td><div class="field">
								<input type="text" id="remark0"
									name="timeTrackerDetailsDVOs[0].remark" placeholder="Remarks" />
							</div></td>
						<td>
							<button id="removebtn0"
								class="ui circular inverted red compact mini icon button disabled delbtn">
								<span class="glyphicon glyphicon-remove"
									style="margin-right: 0px;"></span>
							</button>
						</td>
					</tr>
				</tbody>
			</table>

		</div>
		<a class="small ui right floated button" href="#" id="resetSheet">Reset</a>
		<button type="submit"
			class="small ui inverted right floated green button submit"
			id="submitSheet">Submit</button>
	</form>
</div>
</body>
</html>