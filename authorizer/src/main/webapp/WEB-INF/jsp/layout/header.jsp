<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(document).ready(function() {
    var navbar = $('#navbar-main'),
    		distance = navbar.offset().top,
        $window = $(window);

    $window.scroll(function() {
        if ($window.scrollTop() >= distance) {
            navbar.removeClass('navbar-fixed-top').addClass('navbar-fixed-top');
          	$("body").css("padding-top", "70px");
        } else {
            navbar.removeClass('navbar-fixed-top');
            $("body").css("padding-top", "0px");
        }
    });
	
});
</script>
</head>
<body>
<!-- <div>
  <img src="resources/img/header.jpg" alt="Project Management"
		title="Project Management" class="headerImg">
</div> -->
	
	<nav class="navbar navbar-inverse navbar-static-top" id="navbar-main">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home" style="margin-top: -5px;"><span><img
						alt="Brand" src="resources/img/logo.png" style="width:32px;height:32px"></span>projectX</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="home"><span class="glyphicon glyphicon-home"></span>
							Home</a></li>
					<li><a href="tasks"><i class="calendar icon"></i>
							Calendar</a></li>
					<li><a href="tasksheet"><span class="glyphicon glyphicon-time"></span>
							TimeSheet</a></li>
					<li><a href="teamresources"><i class="users icon"></i> 
							Resources</a></li>
				</ul>
				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><img
						src="resources/img/placeholder-30x30.png"
						class="profile-image img-circle"> <security:authentication
							property="principal.username" /> <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="j_spring_security_logout"><i
								class="icon-share"></i><span class="glyphicon glyphicon-log-out"></span>
								Logout</a></li>
						<li class="divider"></li>
						<li><a href="editprofile"><i class="icon-wrench"></i><span
								class="glyphicon glyphicon-pencil"></span> Edit Profile</a></li>
					</ul>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</body>
</html>