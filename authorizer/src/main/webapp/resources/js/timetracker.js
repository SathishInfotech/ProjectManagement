/**
 * 
 */
$(document).ready(function() {
	/*var formURL = 'getCourseDetails';
	$.post(formURL, $(this).serialize(), function(response) {
	   console.log(response);
	});
	
	
	var taskMap =  '${timetracker.tasks}' ;//JSON.parse($('#tasksList').val());//"${timetracker.tasks}";
	   $.each('${timetracker.tasks}', function(index,value){
			  $('#allTasks').append("<option value=\"" + index + "\">" + value + "</option>");
		});*/
	var taskCount = $('#tasktable tbody>tr').length;
	$('.ui.dropdown').dropdown();
	$("#datepicker-input").datepicker({maxDate: 0});
	$('#datepicker-btn').click(function() {
		$("#datepicker-input").focus();
	});
	$("#addTimeTracker").click(function() {
		
		var rowContent = '<tr><td><div class="ui form"><div class="field"><input type="text" name="timeTrackerDetailsDVOs[' + taskCount + '].timeDate" class="datepick" placeholder="Select Date" /></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select id="allTasks" name="timeTrackerDetailsDVOs[0].taskId"><option value="">Select Task</option></select></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select name="timeTrackerDetailsDVOs[' + taskCount + '].activityId" id="activity' + taskCount + '"><option value="">Select Activity</option><option value="coding">Coding</option><option value="review">Review</option><option value="rework">Rework</option></select></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select name="timeTrackerDetailsDVOs[' + taskCount + '].phaseId" id="phase' + taskCount + '"><option value="">Select Phase</option><option value="coding">Requirement</option><option value="review">Design</option><option value="rework">Coding</option><option value="rework">Testing</option></select></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select name="timeTrackerDetailsDVOs[' + taskCount + '].subphaseId" id="subphase' + taskCount + '"><option value="">Select SubPhase</option><option value="coding">Requirement</option><option value="review">Design</option><option value="rework">Coding</option><option value="rework">Testing</option></select></div></div></td>' 
		+ 
		'<td><div class="ui form"><div class="field"><input type="text" name="timeTrackerDetailsDVOs[' + taskCount + '].hoursSpent" id="hour' + taskCount + '" placeholder="Hour" /></div></div></td>' 
		+ 
		'<td><div class="ui form"><div class="field"><input type="text" name="timeTrackerDetailsDVOs[' + taskCount + '].remark" id="remark' + taskCount + '" placeholder="Remarks" /></div></div></td>' 
		+ '<td><button id="removebtn' + taskCount + '" class="ui circular inverted red compact mini icon button delbtn"><span class="glyphicon glyphicon-remove" style="margin-right: 0px;"></span></button></td></tr>';
		$(rowContent).insertAfter('#tasktable tbody>tr:last');
		$('#tasktable tbody>tr:last input').val('');
		$('#tasktable tbody>tr:last select').val('');
		$(".datepick").datepicker({     
			maxDate: 0
        });
		taskCount++;
		return false;
	});
	$('body').on('click', '.delbtn', function() {
		$(this).closest('tr').remove();
	});
	$('.ui.form').form({
	    inline : true,
	    on : 'blur'
	});
	/*
	 * $('form').bind('submit', function () {
	 * $(this).find(':input').prop('disabled', false);
	 * $(this).find(':select').prop('disabled', false); });
	 */
});