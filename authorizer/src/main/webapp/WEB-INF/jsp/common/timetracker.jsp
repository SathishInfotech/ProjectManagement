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
	<form:form action="saveTimeTracker" modelAttribute="timetracker"
		class="ui form">
		<c:if test="${not empty saveStatus}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>Success!</strong> ${saveStatus}
			</div>
		</c:if>
		<div class="ui padded raised segment">
			<p>
				<b>Time Tracker Details</b>
			</p>
		</div>
		<%-- <div class="ui padded raised segment">
			<p>
				<b>Select a Date:</b>
				<form:input type="text" path="sheetDate" id="datepicker-input"
					placeholder="Select Date" class="three wide field" />
				<a class="circular ui small icon button" href="#" id="datepicker-btn">
					<span class="glyphicon glyphicon-calendar"
						style="margin-right: 0px;"></span>
				</a>
				<a class="ui mini circular inverted green button"
					id="fetchTask" href="#">
					<span class="glyphicon glyphicon-arrow-right"></span>Go
				</a>
			</p>
		</div> --%>
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
					<c:forEach items="${timetracker.timeTrackerDetailsDVOs}"
						var="timeTrackerDetailsDVOs" varStatus="loop">
						<tr>
							<td><div class="field">
									<form:input type="text"
										path="timeTrackerDetailsDVOs[${loop.index}].timeDate"
										id="datepicker-input" placeholder="Select Date" />
								</div></td>
							<td><div class="field">
									<form:input type="text"
										path="timeTrackerDetailsDVOs[${loop.index}].taskId"
										id="taskName1" placeholder="Task name" />
								</div></td>
							<td><div class="field">
									<form:select id="activity1"
										path="timeTrackerDetailsDVOs[${loop.index}].activityId">
										<option value="">Select Activity</option>
										<option value="coding">Coding</option>
										<option value="review">Review</option>
										<option value="rework">Rework</option>
									</form:select>
								</div></td>
							<td><div class="field">
									<form:select id="phase1"
										path="timeTrackerDetailsDVOs[${loop.index}].phaseId">
										<option value="">Select Phase</option>
										<option value="coding">Requirement</option>
										<option value="review">Design</option>
										<option value="rework">Coding</option>
										<option value="rework">Testing</option>
									</form:select>
								</div></td>
							<td><div class="field">
									<form:select id="phase1"
										path="timeTrackerDetailsDVOs[${loop.index}].subphaseId">
										<option value="">Select SubPhase</option>
										<option value="coding">Requirement</option>
										<option value="review">Design</option>
										<option value="rework">Coding</option>
										<option value="rework">Testing</option>
									</form:select>
								</div></td>
							<td><div class="field">
									<form:input type="text" id="hour1"
										path="timeTrackerDetailsDVOs[${loop.index}].hoursSpent"
										placeholder="Hours" />
								</div></td>

							<td><div class="field">
									<form:input type="text" id="remark1"
										path="timeTrackerDetailsDVOs[${loop.index}].remark"
										placeholder="Remarks" />
								</div></td>
							<td>
								<button id="removebtn1"
									class="ui circular inverted red compact mini icon button disabled delbtn">
									<span class="glyphicon glyphicon-remove"
										style="margin-right: 0px;"></span>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a class="small ui right floated button" href="#" id="resetSheet">Reset</a>
		<button type="submit"
			class="small ui inverted right floated green button submit"
			id="submitSheet">Submit</button>

	</form:form>

</body>
</html>