<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {

		$('body').on('click', '.assignTask', function() {
			$('.small.modal').modal('show');
		});
		$('[data-toggle="tooltip"]').tooltip()
	});
</script>
</head>
<body>
	<div class="ui raised segment">
		<div class="ui grid">
			<div class="ten wide column">
				<h3>Team Members</h3>
			</div>
			<div class="six wide column">
				<button class="ui blue icon button right floated">
					<i class="add user icon"></i>&nbsp;Add Member
				</button>
			</div>
		</div>

	</div>
	<div class="ui padded segment">
		<div class="ui divided items">
			<div class="item">
				<div class="image">
					<img src="resources/img/placeholder-400x250.png">
				</div>
				<div class="content">
					<a class="header">Mohamed Ismail</a>
					<div class="meta">
						<span class="cinema">Senior Developer</span>
					</div>
					<div class="description">
						<p>Currently working on backbone.js integeration</p>
					</div>
					<div class="extra">
						<a
							class="ui right floated circular inverted red compact  icon button"
							title="remove" data-toggle="tooltip"> <span
							class="glyphicon glyphicon-remove" style="margin-right: 0px;"></span>
						</a> <a class="ui right floated circular yellow compact  icon button"
							title="edit profile" data-toggle="tooltip"> <span
							class="glyphicon glyphicon-pencil"
							style="color: black; margin-right: 0px;"></span>
						</a> <a
							class="ui right floated circular  green compact  icon button assignTask"
							title="assign task" data-toggle="tooltip"> <span
							class="glyphicon glyphicon-list-alt"
							style="color: black; margin-right: 0px;"></span>
						</a>
						<div class="ui label">Java</div>
						<div class="ui label">Spring</div>
						<div class="ui label">Hibernate</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="image">
					<img src="resources/img/placeholder-400x250.png">
				</div>
				<div class="content">
					<a class="header">Kesavan</a>
					<div class="meta">
						<span class="cinema">Senior Developer</span>
					</div>
					<div class="description">
						<p>Currently working on logging module</p>
					</div>
					<div class="extra">
						<a
							class="ui right floated circular inverted red compact  icon button">
							<span class="glyphicon glyphicon-remove"
							style="margin-right: 0px;"></span>
						</a> <a class="ui right floated circular yellow compact  icon button">
							<span class="glyphicon glyphicon-pencil"
							style="color: black; margin-right: 0px;"></span>
						</a> <a class="ui right floated circular  green compact  icon button">
							<span class="glyphicon glyphicon-list-alt"
							style="color: black; margin-right: 0px;"></span>
						</a>
						<div class="ui label">Java</div>
						<div class="ui label">Spring</div>
						<div class="ui label">Hibernate</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="image">
					<img src="resources/img/placeholder-400x250.png">
				</div>
				<div class="content">
					<a class="header">Balchendar</a>
					<div class="meta">
						<span class="cinema">Senior Developer</span>
					</div>
					<div class="description">
						<p>Currently working on letters and template</p>
					</div>
					<div class="extra">
						<a
							class="ui right floated circular inverted red compact  icon button">
							<span class="glyphicon glyphicon-remove"
							style="margin-right: 0px;"></span>
						</a> <a class="ui right floated circular yellow compact  icon button">
							<span class="glyphicon glyphicon-pencil"
							style="color: black; margin-right: 0px;"></span>
						</a> <a class="ui right floated circular  green compact  icon button">
							<span class="glyphicon glyphicon-list-alt"
							style="color: black; margin-right: 0px;"></span>
						</a>
						<div class="ui label">Java</div>
						<div class="ui label">Spring</div>
						<div class="ui label">Hibernate</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="image">
					<img src="resources/img/placeholder-400x250.png">
				</div>
				<div class="content">
					<a class="header">Raja R</a>
					<div class="meta">
						<span class="cinema">Senior Developer</span>
					</div>
					<div class="description">
						<p>Currently working on letters and template</p>
					</div>
					<div class="extra">
						<a
							class="ui right floated circular inverted red compact  icon button">
							<span class="glyphicon glyphicon-remove"
							style="margin-right: 0px;"></span>
						</a> <a class="ui right floated circular yellow compact  icon button">
							<span class="glyphicon glyphicon-pencil"
							style="color: black; margin-right: 0px;"></span>
						</a> <a class="ui right floated circular  green compact  icon button">
							<span class="glyphicon glyphicon-list-alt"
							style="color: black; margin-right: 0px;"></span>
						</a>
						<div class="ui label">Java</div>
						<div class="ui label">Spring</div>
						<div class="ui label">Hibernate</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="image">
					<img src="resources/img/placeholder-400x250.png">
				</div>
				<div class="content">
					<a class="header">Sathish P</a>
					<div class="meta">
						<span class="cinema">Senior Developer</span>
					</div>
					<div class="description">
						<p>Currently working on logging module</p>
					</div>
					<div class="extra">
						<a
							class="ui right floated circular inverted red compact  icon button">
							<span class="glyphicon glyphicon-remove"
							style="margin-right: 0px;"></span>
						</a> <a class="ui right floated circular yellow compact  icon button">
							<span class="glyphicon glyphicon-pencil"
							style="color: black; margin-right: 0px;"></span>
						</a> <a class="ui right floated circular  green compact  icon button">
							<span class="glyphicon glyphicon-list-alt"
							style="color: black; margin-right: 0px;"></span>
						</a>
						<div class="ui label">Java</div>
						<div class="ui label">Spring</div>
						<div class="ui label">Hibernate</div>
					</div>
				</div>
			</div>

		</div>
		<!-- assign model -->
		<div class="ui small modal">
			<div class="header">Delete Your Account</div>
			<div class="content">
				<p>Are you sure you want to delete your account</p>
			</div>
			<div class="actions">
				<div class="ui negative button">No</div>
				<div class="ui positive button">Yes</div>
			</div>
		</div>
		<!-- assign model end-->
	</div>

</body>
</html>