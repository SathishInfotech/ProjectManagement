/**
 * 
 *//**
 * 
 */
$(document)
    .ready(
        function() {
        	 $("#datepicker-input").datepicker();
             $('#datepicker-btn').click(function() {
                 $("#datepicker-input").focus();
             });
            var taskCount = $('#tasktable tbody>tr').length;
            $("#addTask")
                .click(
                    function() {
                        var rowContent = '<tr>' +
                        	'<td><div class="ui form"><div class="field"><input type="text" name="taskInfoDVOs[' + taskCount + '].activity" id="activity' + taskCount + '" placeholder="Activity" /></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><select name="taskInfoDVOs[' + taskCount + '].phase" id="phase' + taskCount + '" onchange="loadSubphase(this,' + taskCount + '); "><option value="">select phase</option></select></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><select name="taskInfoDVOs[' + taskCount + '].subPhase" id="subPhase' + taskCount + '"><option value="">select subphase</option></select></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><input type="text" name="taskInfoDVOs[' + taskCount + '].estimatedHour" id="estHour' + taskCount + '" placeholder="Estimated Hour" /></div></div></td>'+
                            '<td><button id="editbtn' + taskCount + '" class="ui circular yellow compact mini icon button disabled edtbtn"><span class="glyphicon glyphicon-pencil" style="color:black;margin-right: 0px;"></span></button> <button id="removebtn' + taskCount + '" class="ui circular inverted red compact mini icon button disabled delbtn"><span class="glyphicon glyphicon-remove" style="margin-right: 0px;"></span></button></td></tr>';
                        $(rowContent).insertAfter(
                            '#tasktable tbody>tr:last');
                        fetchPhase('phase'+taskCount)
                        taskCount++;
                        return false;
                    });
            $('body').on('click', '.delbtn', function() {
                $(this).closest('tr').remove();
            });
        });

function fetchPhase(phaseId){
	$.ajax({
	    type : "GET",
	    url : "fetchPhase",
	    contentType: "application/json",
	    success : function(response) {		    
		    $.each(response, function(key,value){ 
		    	$("#"+phaseId).append("<option value=\"" + key + "\">" + value + "</option>"); 
		    });
	    },
	    error : function() {
		    alert('Error occured');
	    }
	});
}

function loadSubphase(selectedInst,selectedId){
	var phaseId = selectedInst.value;
	var subphaseId = "#subPhase"+selectedId;
	$(subphaseId).empty();
	$(subphaseId).append("<option value=\"\">select subphase</option>");
	if(phaseId == '')
		return false;
	$.ajax({
	    type : "GET",
	    url : "fetchSubPhase/"+phaseId,
	    contentType: "application/json",
	    success : function(response) {
		    $.each(response, function(key,value){ 
		    	$(subphaseId).append("<option value=\"" + key + "\">" + value + "</option>"); 
		    });
	    },
	    error : function() {
		    alert('Error occured');
	    }
	});
}