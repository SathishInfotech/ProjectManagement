/**
 * 
 */
$(document).ready(function() {
	var taskCount = $('#tasktable tbody>tr').length;
	$('.ui.dropdown').dropdown();
	$("#datepicker-input").datepicker({maxDate: 0,dateFormat: 'dd-mm-yy'});
	$('#datepicker-btn').click(function() {
		$("#datepicker-input").focus();
	});
	$(document).on("click", '#addTimeTracker', function(e) {
		var projId = $("#projectId").val();
		var rowContent = '<tr><td><div class="ui form"><div class="field"><input type="text" name="timeTrackerDetailsDVOs[' + taskCount + '].timeDate" class="datepick" placeholder="Select Date" required="required"/></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select id="appendtasks'+taskCount+'"  name="timeTrackerDetailsDVOs[' + taskCount + '].taskId" onchange="changeTaskFunction(this)" required="required"><option value="">Select Task</option></select></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select id="activity' + taskCount + '" name="timeTrackerDetailsDVOs[' + taskCount + '].activityId" required="required"> <option value="">Select Activity</option></select></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select id="appendphases'+taskCount+'" name="timeTrackerDetailsDVOs[' + taskCount + '].phaseId" onchange="changePhaseFunction(this)" required="required"><option value="">Select Phase</option></select></div></div></td>'
		+
		'<td><div class="ui form"><div class="field"><select id="subphase' + taskCount + '" name="timeTrackerDetailsDVOs[' + taskCount + '].subphaseId" required="required"><option value="">Select SubPhase</option></select></div></div></td>' 
		+ 
		'<td><div class="ui form"><div class="field"><input type="text" id="hour' + taskCount + '" name="timeTrackerDetailsDVOs[' + taskCount + '].hoursSpent" placeholder="Hour" required="required"/></div></div></td>' 
		+ 
		'<td><div class="ui form"><div class="field"><input type="text" id="remark' + taskCount + '" name="timeTrackerDetailsDVOs[' + taskCount + '].remark" placeholder="Remarks" /></div></div></td>' 
		+ '<td><button id="removebtn' + taskCount + '" class="ui circular inverted red compact mini icon button delbtn"><span class="glyphicon glyphicon-remove" style="margin-right: 0px;"></span></button></td></tr>';
		$(rowContent).insertAfter('#tasktable tbody>tr:last');
		$('#tasktable tbody>tr:last input').val('');
		$('#tasktable tbody>tr:last select').val('');
		$(".datepick").datepicker({     
			maxDate: 0,
			dateFormat: 'dd-mm-yy'
        });
		$.ajax({
		    type : "GET",
		    url : "getTimeTrckerforDropdown",
		    data: {"projectId": projId},
		    async : false,
		    success : function(response) {
		    	$.each(response.tasks, function(index,value){ 
			    	$("#appendtasks"+taskCount).append("<option value=\"" + index + "\">" + value + "</option>"); 
			    });
		    	$.each(response.phases, function(index,value){ 
			    	$("#appendphases"+taskCount).append("<option value=\"" + index + "\">" + value + "</option>"); 
			    });
		    },
		    error : function() {
			    alert('Error occured');
		    }
		})
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

});

function changePhaseFunction(sel){
	var phaseIdName = sel.id;
	var lastCharacter=phaseIdName.slice(-1);
	var data = "";
	$.ajax({
	    type : "GET",
	    url : "getSubphasesByPhasId",
	    data : {'phaseid':$('#'+phaseIdName).val()},
	    async : false,
	    success : function(response) {
	    	$("#subphase"+lastCharacter).empty();
	    	$("#subphase"+lastCharacter).append("<option value=''>Select SubPhase</option>");
		    $.each(response.subPhases, function(index,value){ 
		    	$("#subphase"+lastCharacter).append("<option value=\"" + index + "\">" + value + "</option>"); 
		    });
	    },
	    error : function() {
		    alert('Error occured');
	    }
	})
}

function changeTaskFunction(sel){
	var taskIdName = sel.id;
	var lastCharacter=taskIdName.slice(-1);
	var data = "";
	$.ajax({
	    type : "GET",
	    url : "getActicitiesByTaskId",
	    data : {'taskid':$('#'+taskIdName).val()},
	    async : false,
	    success : function(response) {
	    	$("#activity"+lastCharacter).empty();
	    	$("#activity"+lastCharacter).append("<option value=''>Select Activity</option>");
		    $.each(response.activities, function(index,value){ 
		    	$("#activity"+lastCharacter).append("<option value=\"" + index + "\">" + value + "</option>"); 
		    });
	    },
	    error : function() {
		    alert('Error occured');
	    }
	})
}
