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
<body>
	<%-- 
	<c:if test="${not empty saveStatus}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Success!</strong> ${saveStatus}
		</div>
	</c:if>
 --%>
	<div class="ui padded raised segment">
		<p>
			<b>Time Tracker Details</b>
		</p>
	</div>
	<form name="timetracker" action="saveTimeTracker" id="timetracker"
		class="ui form" method="post">
		<div class="ui padded raised segment">
			<button class="ui small right floated primary button"
				id="addTimeTracker">
				<span class="glyphicon glyphicon-plus"></span>Add TimeTracker
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
									id="datepicker-input" placeholder="Select Date" />
							</div></td>
						<td><div class="field">
								<select name="timeTrackerDetailsDVOs[0].taskId" id="allTasks">
									<option value="">Select Task</option>
									<c:forEach var="taskMap" items="${timetracker.tasks}">
										<option value="${taskMap.key}"><c:out
												value="${taskMap.value}" /></option>
									</c:forEach>
								</select>

							</div></td>
						<td><div class="field">
								<select id="activity1"
									name="timeTrackerDetailsDVOs[0].activityId">
									<option value="">Select Activity</option>
									<option value="coding">Coding</option>
									<option value="review">Review</option>
									<option value="rework">Rework</option>
								</select>
							</div></td>
						<td><div class="field">
								<select id="phase1" name="timeTrackerDetailsDVOs[0].phaseId">
									<option value="">Select Phase</option>
									<c:forEach var="phaseMap" items="${timetracker.phases}">
										<option value="${phaseMap.key}"><c:out
												value="${phaseMap.value}" /></option>
									</c:forEach>
								</select>
							</div></td>
						<td><div class="field">
								<select id="phase1" name="timeTrackerDetailsDVOs[0].subphaseId">
									<option value="">Select SubPhase</option>
									<option value="coding">Requirement</option>
									<option value="review">Design</option>
									<option value="rework">Coding</option>
									<option value="rework">Testing</option>
								</select>
							</div></td>
						<td><div class="field">
								<input type="text" id="hour1"
									name="timeTrackerDetailsDVOs[0].hoursSpent" placeholder="Hours" />
							</div></td>

						<td><div class="field">
								<input type="text" id="remark1"
									name="timeTrackerDetailsDVOs[0].remark" placeholder="Remarks" />
							</div></td>
						<td>
							<button id="removebtn1"
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

<input type="hidden" id="tasksList" value="${timetracker.tasks}">

</body>
</html>