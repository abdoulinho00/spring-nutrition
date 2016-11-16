<%@ include file="/jsp/layout/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add patient</title>
<%@ include file="/jsp/layout/meta.jsp"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jsp"%>

		<h1>Welcome to this nutrition website.</h1>
		<div class="panel panel-primary">
			<div class="panel-heading">User section</div>
			<div class="panel-body">
				<p>This section of the website handles the management of the
					users of the application</p>
				<ul>
					<li>User creation</li>
					<li>User edition</li>
					<li>List of registered users</li>
					<li>Remove users</li>
				</ul>
			</div>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Patient section</div>
			<div class="panel-body">
				<p>This section of the website allow the nutritionist to manage
					its patients. it allows the following functionalities :</p>
				<ul>
					<li class="text-success">Add a new patient</li>
					<li class="text-success">Edit a patient information</li>
					<li class="text-success">List registered patients</li>
					<li class="text-success">Remove a patient</li>
					<li>View a patient details</li>
					<li>add a visit to a patient history</li>
				</ul>
			</div>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Articles</div>
			<div class="panel-body">
				<p>This section of the website is for general informations. it
					contains mainly articles and good practices about health, nutrition
					and sports :</p>
				<ul>
					<li>Dieting articles</li>
					<li>sport articles</li>
				</ul>
			</div>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading">Diet section</div>
			<div class="panel-body">
				<p>This section of the website allows the nutritionist to
					calculate the needs in calories per day for a patient and also
					create a diet menu that suits the patient :</p>
				<ul>
					<li>Calculate calory needs</li>
					<li>Create a diet menu</li>
					<li>Create a training program</li>
				</ul>
			</div>
		</div>

	</div>
</body>
</html>