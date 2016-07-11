<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>

<link href="resources/css/jquery-datatable.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/jquery-ui.css" rel="stylesheet"
	type="text/css">
	<link rel='stylesheet' href='resources/css/fullcalendar.css' />
<link href="resources/css/authorizer-style.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/semantic.css" rel="stylesheet"
	type="text/css">
	<link href="resources/css/accordion.css" rel="stylesheet"
	type="text/css">
	
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-datatable.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/moment.min.js"></script>
<script src="resources/js/semantic.js"></script>
<script src="resources/js/accordion.js"></script>
<script src="resources/js/fullcalendar.js"></script>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div>
		<div id="layout_header">
			<header>
				<tiles:insertAttribute name="header" />
			</header>
		</div>
		<div id="layout_content">
			<div class="container-fluid body-content">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<%-- <div id="layout_footer">
			<footer>
				<tiles:insertAttribute name="footer" />
			</footer>
		</div> --%>
	</div>
</body>
</html>