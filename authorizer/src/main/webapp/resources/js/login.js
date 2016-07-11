/**
 * 
 */
$(document).ready(function() {
	$('.ui.form').form({
		fields : {
			email : {
				identifier : 'j_username',
				rules : [ {
					type : 'empty',
					prompt : 'Please enter your e-mail'
				}, {
					type : 'email',
					prompt : 'Please enter a valid e-mail'
				} ]
			},
			password : {
				identifier : 'j_password',
				rules : [ {
					type : 'empty',
					prompt : 'Please enter your password'
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
