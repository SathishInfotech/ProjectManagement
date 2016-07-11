<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tasks</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#datepicker-from').datepicker({
			minDate:"+2w",
			onClose: function( selectedDate ) {
		        $( "#datepicker-to" ).datepicker( "option", "minDate", selectedDate );
		      }
		});
		$('#datepicker-to').datepicker();
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		$('#calendar').fullCalendar({
			header : {
				left : 'month,agendaWeek,agendaDay',
				center : 'title',
				right : 'prev,next today'
			},
			height : 450,
			editable : false,
			/*  events: function(start, end, timezone, callback) {
			     $.ajax({
			         url: 'getTasksCalendar',
			         type:'POST',
			         contentType: "application/json",
			         dataType: 'json',
			         data:JSON.stringify ( {
			             start: start.format(),
			             end: end.format(),
			             userId:"ismi"
			         }),
			         success: function(response) {
			             var my_events = [];
			             $.each(response, function (index, elem) {
			                my_events.push({
			                    title: elem.title,
			                    start: elem.start,
			                    end: elem.end,
			                });
			             });
			         callback(my_events);
			       }
			     });
			 } */
			events : [ {
				title : 'All Day Event',
				start : new Date(y, m, 1)
			}, {
				title : 'Long Event',
				start : new Date(y, m, d - 5),
				end : new Date(y, m, d - 2)
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d - 3, 16, 0),
				allDay : false
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d + 4, 16, 0),
				allDay : false
			}, {
				title : 'Meeting',
				start : new Date(y, m, d, 10, 30),
				allDay : false
			}, {
				title : 'Lunch',
				start : new Date(y, m, d, 12, 0),
				end : new Date(y, m, d, 14, 0),
				allDay : false
			}, {
				title : 'Birthday Party',
				start : new Date(y, m, d + 1, 19, 0),
				end : new Date(y, m, d + 1, 22, 30),
				allDay : false
			}, {
				title : 'Click for Google',
				start : new Date(y, m, 28),
				end : new Date(y, m, 29),
				url : 'http://google.com/'
			} ]
		});

	});
</script>
</head>
<body>
	<div class="ui very padded raised segment">
		<div id='calendar'></div>
	</div>
	<div class="ui very padded raised segment">
		<div class="ui three column very relaxed stackable grid">
			<div class="column">
				<h4 class="ui center aligned header">Public Holidays</h4>
				<table class="ui celled padded table">
					<thead>
						<tr>
							<th class="single line">Occasion</th>
							<th>Date</th>
							<th>Day</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<h4 class="ui center aligned header">New Year Day</h4>
							</td>
							<td>01.01.2016</td>
							<td>Friday</td>
						</tr>
						<tr>
							<td>
								<h4 class="ui center aligned header">Ramzan</h4>
							</td>
							<td>01.01.2016</td>
							<td>Friday</td>
						</tr>
						<tr>
							<td>
								<h4 class="ui center aligned header">Bakrid</h4>
							</td>
							<td>01.01.2016</td>
							<td>Friday</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="ui vertical divider"></div>
			<div class="column">
				<h4 class="ui center aligned header">Apply Leave</h4>
				<form action="applyLeave" class="ui form" method="post">
					<div class="fields">
						<div class="field">
							<label>From</label>
							<div class="ui left icon input">
								<input type="text" name="leaveFrom" id="datepicker-from" /><i
									class="calendar icon"></i>
							</div>
						</div>
						<div class="field">
							<label>To</label>
							<div class="ui left icon input">
								<input type="text" name="leaveTo" id="datepicker-to" /><i
									class="calendar icon"></i>
							</div>
						</div>
					</div>
					<button class="fluid ui green button">Apply</button>
				</form>
			</div>
			<div class="ui vertical divider"></div>
			<div class="column">
				<h4 class="ui center aligned header">Leave History</h4>
				<table class="ui celled padded table">
					<thead>
						<tr>
							<th>From</th>
							<th>To</th>
							<th>Reason</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>01.01.2016</td>
							<td>02.01.2016</td>
							<td>Planned</td>
						</tr>
						<tr>
							<td>01.01.2016</td>
							<td>02.01.2016</td>
							<td>Sick</td>
						</tr>
						<tr>
							<td>01.01.2016</td>
							<td>02.01.2016</td>
							<td>Sick</td>
						</tr>
						<tr>
							<td>01.01.2016</td>
							<td>02.01.2016</td>
							<td>Planned</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>