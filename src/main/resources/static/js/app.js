
    $(document).ready(function(){
    $('.login-info-box').fadeOut();
    $('.login-show').addClass('show-log-panel');
});


$('.login-reg-panel input[type="radio"]').on('change', function() {
    if($('#log-login-show').is(':checked')) {
        $('.register-info-box').fadeOut(); 
        $('.login-info-box').fadeIn();
        
        $('.white-panel').addClass('right-log');
        $('.register-show').addClass('show-log-panel');
        $('.login-show').removeClass('show-log-panel');
        
    }
    else if($('#log-reg-show').is(':checked')) {
        $('.register-info-box').fadeIn();
        $('.login-info-box').fadeOut();
        
        $('.white-panel').removeClass('right-log');
        
        $('.login-show').addClass('show-log-panel');
        $('.register-show').removeClass('show-log-panel');
    }
});

$("#registerBtn").on('click', function(){
	$registerForm = $('#registerForm');
	if($registerForm.find(".password").val() != $registerForm.find(".confirmPassword").val()) {
		alert("Password and Confirm Password doesn't match");
		$registerForm.find(".password").val("");
		$registerForm.find(".confirmPassword").val("");
	} else {
		var values = $registerForm.serializeArray();
		$.post( "/register",  $.param(values) )
		.done(function( data ) {
			if(data.status == 1) {
				alert("Registration successful, Please login.");
				location.href = "/login";
			} else {
				alert("Something went wrong");
			}
		});
	}
});
  
