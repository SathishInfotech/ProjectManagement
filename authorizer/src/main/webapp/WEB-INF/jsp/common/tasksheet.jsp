<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/tasksheet.js"></script>
<title>TaskSheet</title>
</head>
<body>
	<form:form action="saveTaskSheet" modelAttribute="taskSheet" class="ui form">
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
		</div>
		<div class="ui padded raised segment">
		<button class="ui small right floated primary button"
			id="addTask">
			<span class="glyphicon glyphicon-plus"></span>Add Task
		</button>

		<table id="tasktable" class="table">
			<thead>
				<tr>
					<th>Task</th>
					<th>Phase</th>
					<th>Activity</th>
					<th>Remark</th>
					<th>Hours</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${taskSheet.taskDetailsDVOs}" var="taskDetailsDVO"
					varStatus="loop">
					<tr>
						<td><div class="field"><form:input type="text"
								path="taskDetailsDVOs[${loop.index}].taskName" id="taskName1"
								placeholder="Task name" /></div></td>
						<td><div class="field"><form:select id="phase1"
								path="taskDetailsDVOs[${loop.index}].phase" >
								<option value=""></option>
								<option value="coding">Requirement</option>
								<option value="review">Design</option>
								<option value="rework">Coding</option>
								<option value="rework">Testing</option>
							</form:select></div></td>
						<td><div class="field"><form:select id="activity1"
								path="taskDetailsDVOs[${loop.index}].activity">
								<option value=""></option>
								<option value="coding">Coding</option>
								<option value="review">Review</option>
								<option value="rework">Rework</option>
							</form:select></div></td>
						<td><div class="field"><form:input type="text" id="remark1"
								path="taskDetailsDVOs[${loop.index}].remark"
								placeholder="Remark" /></div></td>
						<td><div class="field"><form:input type="text" id="hour1"
								path="taskDetailsDVOs[${loop.index}].hour" placeholder="Hour"
								/></div></td>
						<td>
							<button id="editbtn1"
								class="ui circular yellow compact mini icon button edtbtn">
								<span class="glyphicon glyphicon-pencil"
									style="color: black; margin-right: 0px;"></span>
							</button>
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
			class="small ui inverted right floated green button submit" id="submitSheet">Submit</button>

	</form:form>

</body>
</html>