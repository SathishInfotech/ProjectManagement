<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TaskSheet</title>
</head>
<body>

	<div class="ui padded raised segment">
		<p>
			<b>View Time Tracker Details</b>
		</p>
		<form:form class="ui form">
			<table>
				<tr>
					<td><b>Select a Project:</b></td>
					<td></td>
					<td><div class="field">
							<select>
								<option value="">select option</option>
								<option value="1">project1</option>
								<option value="2">project2</option>
								<option value="3">project3</option>
							</select>
						</div></td>

					<td><b>Select a User:</b></td>
					<td></td>
					<td><div class="field">
							<select>
								<option value="">select option</option>
								<option value="1">user1</option>
								<option value="2">user2</option>
								<option value="3">user3</option>
							</select>
						</div></td>

					<td><p>
							<b>Select a Date:</b>
						</p></td>
					<td></td>
					<td><div class="field">
							<input type="text">
						</div></td>
					<td></td>
					<td><div class="field">
							<input class="ui mini circular inverted green button"
								type="submit" id="submit" value="Submit" />
						</div></td>
				</tr>
			</table>
		</form:form>
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
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
					<td>7</td>

				</tr>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
					<td>7</td>

				</tr>
				<%-- <c:forEach items="${timetracker.timeTrackerDetailsDVOs}"
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
 --%>
			</tbody>
		</table>
	</div>

</body>
</html>