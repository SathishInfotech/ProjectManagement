<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
<link href="resources/css/semantic.css" rel="stylesheet" type="text/css">
<script src="resources/js/jquery.js" type="text/javascript"
	charset="UTF-8"></script>
<script src="resources/js/semantic.js" type="text/javascript"
	charset="UTF-8"></script>
<script src="resources/js/login.js" type="text/javascript"
	charset="UTF-8"></script>
<style type="text/css">
body {
	background-color: #DADADA;
}

body>.grid {
	height: 100%;
}

.image {
	margin-top: -100px;
}

.column {
	max-width: 450px;
}
</style>
</head>
<body>
	<div class="ui middle aligned center aligned grid">
		<div class="column">
			<h2 class="ui black image header">
				<img src="resources/img/logo.png" class="image">
				<div class="content">Log-in to your account</div>
			</h2>
			<form id="loginForm" class="ui large form" role="form"
				action="<c:url value='j_spring_security_check' />" method="post">
				<div class="ui stacked secondary  segment">
					<div class="ui error message"></div>
					<c:if test="${not empty loginMsg}">
						<div class="ui ${loginClass} message">
							<i class="close icon"></i> ${loginMsg}
						</div>
					</c:if>
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i> <input type="text" name="j_username"
								placeholder="Username/E-mail address">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i> <input type="password"
								name="j_password" placeholder="Password">
						</div>
					</div>
					<div class="ui fluid large black submit button">Login</div>
				</div>
			</form>

			<!-- <div class="ui message">
			</div> -->
		</div>
	</div>
</body>
</html>