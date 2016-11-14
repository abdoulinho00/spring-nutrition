<%@ include file="/jsp/layout/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add patient</title>
<%@ include file="/jsp/layout/meta.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/jsp/layout/banner-header.jsp"%>


		<div class="form-container">
			<form:form method="POST" modelAttribute="patient"
				class="form-horizontal">
				<div class="panel panel-primary">
					<div class="panel-heading">Personal information</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="fullname">
									Full Name</label>
								<div class="col-md-7">
									<form:input type="text" path="fullname" id="fullname"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="fullname" class="help-inline" />
									</div>
								</div>
							</div>
						</div>



						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="gender">Sex</label>
								<div class="col-md-7" class="form-control input-sm">
									<form:radiobutton path="gender" value="M" />
									Male
									<form:radiobutton path="gender" value="F" />
									Female
									<div class="has-error">
										<form:errors path="gender" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="dob">Date of
									birth</label>
								<div class="col-md-7">
									<form:input type="text" path="birthday" id="dob"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="birthday" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="email">Email</label>
								<div class="col-md-7">
									<form:input type="text" path="email" id="email"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="phone">Phone
									Number</label>
								<div class="col-md-7">
									<form:input type="text" path="phoneNumber" id="phoneNumber"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="phoneNumber" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="adress">Adress</label>
								<div class="col-md-7">
									<form:input type="text" path="adress" id="adress"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="adress" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="allergies">Allergies</label>
								<div class="col-md-7">
									<form:input type="text" path="allergies" id="allergies"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="allergies" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="history">History</label>
								<div class="col-md-7">
									<form:textarea type="text" path="history" id="history"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="history" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<%-- 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="section">Section</label>
                <div class="col-md-7" class="form-control input-sm">
                    <form:radiobuttons path="section" items="${sections}" />
                    <div class="has-error">
                        <form:errors path="section" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="country">Country</label>
                <div class="col-md-7">
                    <form:select path="country" id="country" class="form-control input-sm">
                        <form:option value="">Select Country</form:option>
                        <form:options items="${countries}" />
                    </form:select>
                    <div class="has-error">
                        <form:errors path="country" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="firstAttempt">First Attempt ?</label>
                <div class="col-md-1">
                    <form:checkbox path="firstAttempt" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="firstAttempt" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
     
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="subjects">Subjects</label>
                <div class="col-md-7">
                    <form:select path="subjects" items="${subjects}" multiple="true" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="subjects" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
  --%>
				<div class="row">
					<div class="form-actions floatRight">
						<input type="submit" value="Add patient"
							class="btn btn-primary btn-md">
					</div>
				</div>
			</form:form>
		</div>

		<%@ include file="/jsp/layout/footer.jsp"%>
	</div>
</body>
</html>