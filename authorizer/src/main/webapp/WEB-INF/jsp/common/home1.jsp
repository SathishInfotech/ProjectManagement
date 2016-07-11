<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('.ui.accordion').accordion();
	});
</script>
</head>
<body>
	<div class="ui very padded raised segment">
		<h4 class="ui horizontal divider header">
			<span class="glyphicon glyphicon-list-alt"></span> Current Task
			Status
		</h4>
		<!-- Start -->
		<table class="ui celled padded table">
			<thead>
				<tr>
					<th class="single line">Resource</th>
					<th>Current Task</th>
					<th>Status</th>
					<th>Progress</th>
					<th>Task Description</th>
				</tr>
			</thead>
			<tbody>
				<tr class="warning">
					<td class="single line">
						<h4 class="ui center aligned header">Mohamed Ismail</h4>
					</td>
					<td>Backbone Integeration</td>
					<td>Inprogress</td>
					<td>
						<div class="ui center aligned">70%</div>
					</td>
					<td>
						<div class="ui accordion">
							<div class="title">
								<i class="dropdown icon"></i> Inprogress Activities
							</div>
							<div class="content">
								<p>List of activities that are inprogress</p>
							</div>
							<div class="title">
								<i class="dropdown icon"></i> Completed Activities
							</div>
							<div class="content">
								<p>List of activities that are completed</p>
							</div>
						</div>
					</td>
				</tr>
				<tr class="positive">
					<td class="single line">
						<h4 class="ui center aligned header">Kesavan R</h4>
					</td>
					<td>Logging Module</td>
					<td>Completed</td>
					<td>
						<div class="ui center aligned">100%</div>
					</td>
					<td>
						<div class="ui accordion">
							<!-- <div class="title">
								<i class="dropdown icon"></i> Inprogress Activities
							</div>
							 <div class="content">
								<p>List of activities that are inprogress</p>
							</div> --> 
							<div class="title">
								<i class="dropdown icon"></i> Completed Activities
							</div>
							<div class="content">
								<p>List of activities that are completed</p>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<!-- End -->
		<h4 class="ui horizontal divider header">
			<span class="glyphicon glyphicon-time"></span> Time Sheet Status
		</h4>
		<!-- Start -->
		<table class="ui celled padded table">
			<thead>
				<tr>
					<th class="single line">Resource</th>
					<th>Status</th>
					<th>Dates</th>
				</tr>
			</thead>
			<tbody>
				<tr class="positive">
					<td class="single line">
						<h4 class="ui center aligned header">Mohamed Ismail</h4>
					</td>
					<td>Completed</td>
					<td>-</td>
				</tr>
				<tr class="warning">
					<td class="single line">
						<h4 class="ui center aligned header">Kesavan R</h4>
					</td>
					<td>Pending</td>
					<td>09/05/2016,10/05/2016,11/05/2016,12/05/2016,13/05/2016...</td>
				</tr>
			</tbody>
		</table>
		<!-- End -->
		<h4 class="ui horizontal divider header">
			<span class="glyphicon glyphicon-copy"></span> Feeds
		</h4>
		<div class="ui feed">
			<div class="event">
				<div class="label">
					<img src="resources/img/placeholder-30x30.png">
				</div>
				<div class="content">
					<div class="date">3 days ago</div>
					<div class="summary">
						You assigned <a>Backbone Integeration</a> task to <a>Mohamed
							Ismail</a>.
					</div>
				</div>
			</div>
			<div class="event">
				<div class="label">
					<img src="resources/img/placeholder-30x30.png">
				</div>
				<div class="content">
					<div class="date">3 days ago</div>
					<div class="summary">
						<a>Mohamed Ismail</a> has accepted <a>Backbone Integeration</a>
						task.
					</div>
				</div>
			</div>
			<div class="event">
				<div class="label">
					<img src="resources/img/placeholder-30x30.png">
				</div>
				<div class="content">
					<div class="date">5 days ago</div>
					<div class="summary">
						<a>Mohamed Ismail</a> has planned for leave on 12th April 2016.
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>