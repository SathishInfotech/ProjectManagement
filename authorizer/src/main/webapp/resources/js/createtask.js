/**
 * 
 */
$(document).ready(function() {
	$('.ui.form').form({
		fields : {
			project : {
				identifier : 'projectId',
				rules : [ {
					type : 'empty',
					prompt : 'Please select Project'
				}
				]
			},
			 taskname: {
			        identifier: 'taskName',
			        rules: [
			          {
			            type   : 'empty',
			            prompt : 'Please enter a Task Name'
			          },
			          {
			              type   : 'minLength[6]',
			              prompt : 'Your Task Name must be at least 6 characters'
			           },
			           {
			                type   : 'maxLength[45]',
			                prompt : 'Your Task Name must be at maximum 45 characters'
			           }
			        ]
			      },
			username : {
				identifier : 'userId',
				rules : [ {
					type : 'empty',
					prompt : 'Please select user'
				} ]
			}
		}
	});
	
	$('.message .close')
	  .on('click', function() {
	    $(this)
	      .closest('.message')
	      .transition('fade')
	    ;
	  })
	;
});
