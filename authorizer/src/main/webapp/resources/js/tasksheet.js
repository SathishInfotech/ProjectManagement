/**
 * 
 */
$(document)
    .ready(
        function() {
            var taskCount = $('#tasktable tbody>tr').length;
            $('.ui.dropdown').dropdown();
            $("#datepicker-input").datepicker();
            $('#datepicker-btn').click(function() {
                $("#datepicker-input").focus();
            });
            $("#addTask")
                .click(
                    function() {

                        var rowContent = '<tr><td><div class="ui form"><div class="field"><input type="text" name="taskDetailsDVOs[' + taskCount + '].taskName" id="taskName' + taskCount + '" placeholder="Task name" /></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><select name="taskDetailsDVOs[' + taskCount + '].phase" id="phase' + taskCount + '"><option value=""></option><option value="coding">Requirement</option><option value="review">Design</option><option value="rework">Coding</option><option value="rework">Testing</option></select></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><select name="taskDetailsDVOs[' + taskCount + '].activity" id="activity' + taskCount + '"><option value=""></option><option value="coding">Coding</option><option value="review">Review</option><option value="rework">Rework</option></select></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><input type="text" name="taskDetailsDVOs[' + taskCount + '].remark" id="remark' + taskCount + '" placeholder="Remark" /></div></div></td>' +
                            '<td><div class="ui form"><div class="field"><input type="text" name="taskDetailsDVOs[' + taskCount + '].hour" id="hour' + taskCount + '" placeholder="Hour" /></div></div></td>' +
                            '<td><button id="editbtn' + taskCount + '" class="ui circular yellow compact mini icon button edtbtn"><span class="glyphicon glyphicon-pencil" style="color:black;margin-right: 0px;"></span></button> <button id="removebtn' + taskCount + '" class="ui circular inverted red compact mini icon button delbtn"><span class="glyphicon glyphicon-remove" style="margin-right: 0px;"></span></button></td></tr>';
                        $(rowContent).insertAfter(
                            '#tasktable tbody>tr:last');
                        $('#tasktable tbody>tr:last input')
                            .val('');
                        $('#tasktable tbody>tr:last select')
                            .val('');
                        taskCount++;
                        return false;
                    });
            $('body').on('click', '.delbtn', function() {
                $(this).closest('tr').remove();
            });
            $('.ui.form').form({
              inline : true,
              on     : 'blur'
            });
            /*$('form').bind('submit', function () {
                $(this).find(':input').prop('disabled', false);
                $(this).find(':select').prop('disabled', false);
              });*/
        });