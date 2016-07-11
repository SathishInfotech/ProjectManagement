<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/charts.js"></script>
<script type="text/javascript">
	var data = {
		labels : [ "Completed", "Inprogress" ],
		datasets : [ {
			data : [ 70, 30 ],
			backgroundColor : [ "#5CB85C", "#FBA83C" ],
			hoverBackgroundColor : [ "#5CB85C", "#FBA83C" ]
		} ]
	};
	$(document).ready(function() {
		$('.ui.accordion').accordion();
		$('#pendingDatesPop').popover({
			html : true,
			content : function() {
				return $('#pendingDateContent').html();
			}
		});
		var ctx = $("#piechart");
		//  for a doughnut chart
		var myDoughnutChart = new Chart(ctx, {
			type : 'doughnut',
			data : data
		});

	});
</script>
</head>
<body>
<div class="ui very padded raised segment">
	<h4 class="ui horizontal divider header">
		<span class="glyphicon glyphicon-list-alt"></span> Current Task Status
	</h4>
	<p>You are currently working on bacbone.js integeration. Below is
		the current activity status</p>
	<div class="ui stackable two column grid">
		<div class="column">
			<!--Div that will hold the pie chart-->
			<div class="ui image">
				<canvas id="piechart" width="400" height="200"></canvas>
			</div>
		</div>
		<div class="column">
			<!-- accordion start -->
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
			<!-- accordion end -->
		</div>
	</div>
	<h4 class="ui horizontal divider header">
		<span class="glyphicon glyphicon-time"></span> Time Sheet Status
	</h4>
	<div class="alert alert-warning" role="alert">
		<p>
			You haven't completed filling the time sheet.These are the pending <span><a href="#" onclick="return false;" id="pendingDatesPop" data-toggle="popover"
				data-placement="top" title="Pending Dates" data-trigger="focus">dates</a></span>
		</p>
	</div>
	<h4 class="ui horizontal divider header">
		<span class="glyphicon glyphicon-copy"></span> Incoming Tasks
	</h4>
	<!-- <div class="ui raised segment">
		<div class="ui grid">
			<div class="one wide column">
				<img src="resources/img/placeholder-200x200.png"
					style="width: 60px; height: 60px;">
			</div>
			<div class="fifteen wide column">
				<h5>Backbone Task</h5>
				<p>Are you interested in working on backbone.js integeration
					into our application?</p>
				<p>
					<a class="btn btn-success btn-sm" href="taskestimation"><span
						class="glyphicon glyphicon-ok"> </span>Accept</a> <a
						class="btn btn-danger btn-sm" href="#"><span
						class="glyphicon glyphicon-remove"> </span>Decline</a>
				</p>
			</div>
		</div>
	</div> -->
	<div class="ui items">
	  <div class="item">
	    <div class="ui small image">
	      <img src="resources/img/placeholder-400x250.png">
	    </div>
	    <div class="middle aligned content">
	      <div class="header">
	        Backbone Task
	      </div>
	      <div class="description">
	        <p>Are you interested in working on backbone.js integeration into our application?</p>
	      </div>
	      <div class="extra">
	        <a class="btn btn-success btn-sm" href="taskestimation"><span
						class="glyphicon glyphicon-ok"> </span>Accept</a> <a
						class="btn btn-danger btn-sm" href="#"><span
						class="glyphicon glyphicon-remove"> </span>Decline</a>
	      </div>
	    </div>
	  </div>
  </div>
</div>
	<!-- incoming tasks end -->
	<div id="pendingDateContent" style="display: none;">
		<table style="color: black">
			<tr>
				<td>04/22/2016</td>
			</tr>
			<tr>
				<td>04/23/2016</td>
			</tr>
			<tr>
				<td>04/24/2016</td>
			</tr>
			<tr>
				<td>04/25/2016</td>
			</tr>
		</table>
	</div>
</body>
</html>