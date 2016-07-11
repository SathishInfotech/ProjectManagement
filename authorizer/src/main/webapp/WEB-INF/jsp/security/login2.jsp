<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

        <script src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
            <div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                    </div>
                    <div style="padding-top: 30px" class="panel-body">
                        <div  id="login-alert" class="alert ${loginClass} col-sm-12">${loginMsg}</div>
                        <form id="loginForm" class="form-horizontal" role="form" action="<c:url value='j_spring_security_check' />" method="post">
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username" type="text" class="form-control" name="j_username" value="" placeholder="username or email">
                            </div>
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password" type="password" class="form-control" name="j_password" placeholder="password">
                            </div>
                            <div class="input-group">
                                <div class="checkbox">
                                    <label> <input id="login-remember" type="checkbox"
									name="_spring_security_remember_me" value="1"> Remember me
								</label>
                                </div>
                            </div>
                            <div style="margin-top: 10px" class="form-group">
                                <!-- Button -->
                                <div class="col-sm-12 controls" align="center" >
                                <input name="submit" type="submit" class="btn btn-success "
									style="padding: 10px 100px 10px 100px; " value="Submit"/>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>