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
                            '<td><div class="ui form"><div class="field"><select name="taskInfoDVOs[' + taskCount + '].phase" id="phase' + taskCount + '"><option value=""></option><option value="requirement">Requirement</option><option value="design">Design</option><option value="coding">Coding</option><option value="testing">Testing</option></select></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><select name="taskInfoDVOs[' + taskCount + '].activity" id="activity' + taskCount + '"><option value=""></option><option value="coding">Coding</option><option value="review">Review</option><option value="rework">Rework</option></select></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><input type="text" name="taskInfoDVOs[' + taskCount + '].remark" id="remark' + taskCount + '" placeholder="Remark" /></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><input type="text" name="taskInfoDVOs[' + taskCount + '].estimatedHour" id="estHour' + taskCount + '" placeholder="Estimated Hour" /></div></div></td>'+
                            '<td><button id="editbtn' + taskCount + '" class="ui circular yellow compact mini icon button disabled edtbtn"><span class="glyphicon glyphicon-pencil" style="color:black;margin-right: 0px;"></span></button> <button id="removebtn' + taskCount + '" class="ui circular inverted red compact mini icon button disabled delbtn"><span class="glyphicon glyphicon-remove" style="margin-right: 0px;"></span></button></td></tr>';
                        $(rowContent).insertAfter(
                            '#tasktable tbody>tr:last');
                        taskCount++;
                        return false;
                    });
            $('body').on('click', '.delbtn', function() {
                $(this).closest('tr').remove();
            });
        });