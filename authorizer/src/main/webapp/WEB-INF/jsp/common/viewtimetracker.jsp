<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<style type="text/css">
.ui-datepicker-calendar {
	display: none;
}
.ui-datepicker .ui-datepicker-prev span, .ui-datepicker .ui-datepicker-next span{
display:none;
}
</style>
<script type="text/javascript" src="resources/js/viewtimetracker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TaskSheet</title>
</head>
<body>

	<div class="ui padded raised segment">
		<p>
			<b>View Time Tracker Details</b>
		</p>
		<form class="ui form" name="viewtimetrackerform"
			action="viewtimetracker" method="post">
			<table>
				<tbody>
					<tr>
						<td><b>Select a Project:</b></td>
						<td></td>
						<td><div class="field">
								<select name="projectId" id="projectId" required="required">
									<option value="">Select Project</option>
									<c:forEach var="projectMap" items="${timetracker.projects}">
										<option value="${projectMap.key}"><c:out
												value="${projectMap.value}" /></option>
									</c:forEach>
								</select>
							</div></td>

						<td><b>Select a User:</b></td>
						<td></td>
						<td><div class="field">
								<select name="userId" id="projectUser" required="required">
									<option value="">Select User</option>
								</select>
							</div></td>

						<td><p>
								<b>Select a Month:</b>
							</p></td>
						<td></td>
						<td><div class="field">
								<input type="text" name="timeDate" id="datepicker-input"
									placeholder="Select Date" required="required">
							</div></td>
						<td></td>
						<td><div class="field">
								<input class="ui mini circular inverted green button"
									type="submit" id="submit" value="Submit" />
							</div></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div>
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
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${viewTimetrackerDetails.timeTrackerDetailsDVOs}" var="timetrker">
				<tr>
					<td>${timetrker.timeDate}</td>
					<td>${timetrker.taskId}</td>
					<td>${timetrker.activityId}</td>
					<td>${timetrker.phaseId}</td>
					<td>${timetrker.subphaseId}</td>
					<td>${timetrker.hoursSpent}</td>
					<td>${timetrker.remark}</td>

				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$("#datepicker-input").datepicker(
                {
                    changeMonth : true,
                    showButtonPanel: true,
                    dateFormat : 'm',
                    onClose : function(dateText, inst) {
	                    $(this).datepicker(
	                            'setDate',
	                            new Date(inst.selectedYear,
	                                    inst.selectedMonth,
	                                    1));
                    }
                });
	</script>
</body>
</html>