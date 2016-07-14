<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
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
								<b>Select a Date:</b>
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

			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$("#datepicker-input").datepicker({
	        maxDate : 0
        });
	</script>
</body>
</html>