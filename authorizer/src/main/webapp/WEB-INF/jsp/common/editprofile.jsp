<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('.menu .item').tab();
		$('.ui.radio.checkbox').checkbox();
		$('.ui.dropdown').dropdown({
			maxSelections : 3
		})
	});
</script>
<script src="resources/js/editprofile.js"></script>
</head>

<body>
	<!-- New Tab Start -->
	<div class="ui stackable grid">
		<div class="five wide column">
			<div class="ui large image">
				<img src="resources/img/placeholder-400x250.png">
				</div>
				<h5>Upload a photo...</h5>
				<div class="input-group">
					<span class="input-group-btn"> <span
						class="btn btn-primary btn-file"> Browse&hellip; <input
							type="file">
					</span>
					</span> <input type="text" class="form-control" readonly>
				</div>
		</div>
		<div class="three wide column">
			<div class="ui vertical fluid tabular menu">
				<a class="active item" data-tab="perInfo"><i class="male icon"></i>Personal
					Info</a> <a class="item" data-tab="workInfo"><i
					class="suitcase icon"></i>Work Info</a> <a class="item"
					data-tab="proInfo"><i class="book icon"></i>Project Info</a> <a
					class="item" data-tab="credentials"><i
					class="unlock alternate icon"></i>Credentials</a>
			</div>
		</div>
		<div class="eight wide column">
			<div class="ui bottom attached active tab segment" data-tab="perInfo">
				<div class="ui form">
					<div class=" fields">
						<div class="six wide field">
							<label>Name</label> <input type="text" placeholder="Name">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Email</label> <input type="text" placeholder="Email">
						</div>
					</div>
					<div class="inline fields">
						<label for="gender">Gender</label>
						<div class="field">
							<div class="ui radio checkbox">
								<input type="radio" name="gender" checked tabindex="0"
									class="hidden"> <label>Male</label>
							</div>
						</div>
						<div class="field">
							<div class="ui radio checkbox">
								<input type="radio" name="gender" tabindex="0" class="hidden">
								<label>Female</label>
							</div>
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>DOB</label> <input type="text" placeholder="Date of Birth">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Nationality</label> <input type="text"
								placeholder="Nationality">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Place</label> <input type="text"
								placeholder="Place of Birth">
						</div>
					</div>
					<div class="inline fields">
						<label for="marStatus">Marital Status</label>
						<div class="field">
							<div class="ui radio checkbox">
								<input type="radio" name="marStatus" checked tabindex="0"
									class="hidden"> <label>Single</label>
							</div>
						</div>
						<div class="field">
							<div class="ui radio checkbox">
								<input type="radio" name="marStatus" tabindex="0" class="hidden">
								<label>Married</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="ui bottom attached tab segment" data-tab="workInfo">
				<div class="ui form">
					<div class=" fields">
						<div class="six wide field">
							<label>Grade</label> <input type="text" placeholder="Grade">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Designation</label> <input type="text"
								placeholder="Designation">
						</div>
					</div>
					<div class="ui form">
						<div class="ten wide field">
							<label>Skill Set</label> <select multiple class="ui dropdown">
								<option value="">Select 3 or less Key Skills</option>
								<option value="java">Java</option>
								<option value="spring">Spring</option>
								<option value="hibernate">Hibernate</option>
								<option value="html">Html</option>
								<option value="css">Css</option>
								<option value="javascript">JavaScript</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="ui bottom attached tab segment" data-tab="proInfo">
				<div class="ui form">
					<div class=" fields">
						<div class="six wide field">
							<label>Business Unit</label> <input type="text"
								placeholder="Business Unit">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Cost Code</label> <input type="text"
								placeholder="Cost Code">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Project</label> <input type="text" placeholder="Project">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Location</label> <input type="text" placeholder="Location">
						</div>
					</div>
				</div>
			</div>
			<div class="ui bottom attached tab segment" data-tab="credentials">
				<div class="ui form">
					<div class=" fields">
						<div class="six wide field">
							<label>Username/Email</label> <input type="text"
								placeholder="User Name or Email ID">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Password</label> <input type="password"
								placeholder="Password">
						</div>
					</div>
					<div class=" fields">
						<div class="six wide field">
							<label>Confirm Password</label> <input type="password"
								placeholder="Confirm Password">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- New Tab End -->
	<!-- 	<div class="ui padded raised segment">
		<div class="ui grid">
			<div class="row">
				<div class="four wide column">
					<img src="resources/img/placeholder-400x250.png">
					<h5>Upload a photo...</h5>
					<div class="input-group">
						<span class="input-group-btn"> <span
							class="btn btn-primary btn-file"> Browse&hellip; <input
								type="file">
						</span>
						</span> <input type="text" class="form-control" readonly>
					</div>
				</div>
				<div class="ten wide column">
					<div class="ui top attached tabular menu">
						<a class="active item" data-tab="perInfo"><i class="male icon"></i>Personal
							Info</a> <a class="item" data-tab="workInfo"><i
							class="suitcase icon"></i>Work Info</a> <a class="item"
							data-tab="proInfo"><i class="book icon"></i>Project Info</a> <a
							class="item" data-tab="credentials"><i
							class="unlock alternate icon"></i>Credentials</a>
					</div>
					<div class="ui bottom attached active tab segment"
						data-tab="perInfo">
						<div class="ui form">
							<div class=" fields">
								<div class="six wide field">
									<label>Name</label> <input type="text" placeholder="Name">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Email</label> <input type="text" placeholder="Email">
								</div>
							</div>
							<div class="inline fields">
								<label for="gender">Gender</label>
								<div class="field">
									<div class="ui radio checkbox">
										<input type="radio" name="gender" checked tabindex="0"
											class="hidden"> <label>Male</label>
									</div>
								</div>
								<div class="field">
									<div class="ui radio checkbox">
										<input type="radio" name="gender" tabindex="0" class="hidden">
										<label>Female</label>
									</div>
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>DOB</label> <input type="text"
										placeholder="Date of Birth">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Nationality</label> <input type="text"
										placeholder="Nationality">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Place</label> <input type="text"
										placeholder="Place of Birth">
								</div>
							</div>
							<div class="inline fields">
								<label for="marStatus">Marital Status</label>
								<div class="field">
									<div class="ui radio checkbox">
										<input type="radio" name="marStatus" checked tabindex="0"
											class="hidden"> <label>Single</label>
									</div>
								</div>
								<div class="field">
									<div class="ui radio checkbox">
										<input type="radio" name="marStatus" tabindex="0"
											class="hidden"> <label>Married</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="ui bottom attached tab segment" data-tab="workInfo">
						<div class="ui form">
							<div class=" fields">
								<div class="six wide field">
									<label>Grade</label> <input type="text" placeholder="Grade">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Designation</label> <input type="text"
										placeholder="Designation">
								</div>
							</div>
							<div class="ui form">
								<div class="ten wide field">
									<label>Skill Set</label> <select multiple class="ui dropdown">
										<option value="">Select 3 or less Key Skills</option>
										<option value="java">Java</option>
										<option value="spring">Spring</option>
										<option value="hibernate">Hibernate</option>
										<option value="html">Html</option>
										<option value="css">Css</option>
										<option value="javascript">JavaScript</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="ui bottom attached tab segment" data-tab="proInfo">
						<div class="ui form">
							<div class=" fields">
								<div class="six wide field">
									<label>Business Unit</label> <input type="text"
										placeholder="Business Unit">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Cost Code</label> <input type="text"
										placeholder="Cost Code">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Project</label> <input type="text" placeholder="Project">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Location</label> <input type="text"
										placeholder="Location">
								</div>
							</div>
						</div>
					</div>
					<div class="ui bottom attached tab segment" data-tab="credentials">
						<div class="ui form">
							<div class=" fields">
								<div class="six wide field">
									<label>Username/Email</label> <input type="text"
										placeholder="User Name or Email ID">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Password</label> <input type="password"
										placeholder="Password">
								</div>
							</div>
							<div class=" fields">
								<div class="six wide field">
									<label>Confirm Password</label> <input type="password"
										placeholder="Confirm Password">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="two wide column"></div>
			</div>
		</div>
	</div> -->
</body>

</html>