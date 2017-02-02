<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon' href='${pageContext.request.contextPath}/favicon.ico' type='image/x-icon' />
<title>Add patient</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>

		<c:choose>
			<c:when test="${patient.id > 0}">
				<c:set var="action" value="edit" />
			</c:when>
			<c:otherwise>
				<c:set var="action" value="add" />
			</c:otherwise>
		</c:choose>
		<div class="form-container">
			<form:form method="POST" modelAttribute="patient" action="${action}" id="formSelector"
				class="form-horizontal" enctype="multipart/form-data">
				<c:if test="${ patient.id > 0 }">
					<form:input type="hidden" path="id" value="${patient.id}" />
					<form:input type="hidden" path="visits[0].id" value="${patient.visits[0].id}" />
				</c:if>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<spring:message code="patient-add-personal-information" />
					</div>
					<div class="panel-body">
						<!-- Patient full name -->
						<div class="row">
							<div class="col-md-8">
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="fullname"> <spring:message
										code="patient-fullname" /></label>
								<div class="col-md-4">
									<form:input type="text" path="fullname" id="fullname"
										value="${patient.fullname}" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="fullname" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="fullname"> <spring:message
										code="patient-fullname" /></label>
								<div class="col-md-4 text-right">
									<input type="file" name="file" id="file"
										 class="form-control input-sm" />
									
								</div>
							</div>
						</div>

						<!-- Patient birthday and age  -->
						<div class="row form-group">
							<div class='col-md-6'>
						        <div class="form-group">
						        	<label class="col-md-4 control-lable">Birthday</label>
						            <div class='col-md-8 input-group date' id='birthday'>
						            	<fmt:formatDate pattern="dd/MM/yyyy"
										value="${patient.birthday}" var="strDate" />
						                <input type='text' name="birthday" value="${strDate}" class="form-control input-sm" readonly/>
						                <span class="input-group-addon">
						                    <span class="glyphicon glyphicon-calendar"></span>
						                </span>
						            </div>
						        </div>
						    </div>
								<%-- <label class="col-md-2 control-lable" for="birthday"> <spring:message
										code="patient-birthday" /></label>
								<div class="col-md-2">
									<fmt:formatDate pattern="dd/MM/yyyy"
										value="${patient.birthday}" var="strDate" />
									<form:input type="text" path="birthday" id="birthday"
										value="${strDate}" class="form-control input-sm" />
									<span class="input-group-addon">
					                    <span class="glyphicon glyphicon-calendar"></span>
					                </span>
									<div class="has-error">
										<form:errors path="birthday" class="help-inline" />
									</div>
								</div> --%>
							<div class="col-md-6">
								<label class="col-md-1 control-label" for="age"> <spring:message
										code="patient-age" /></label>
								<div class="col-md-2">
									<form:input type="text" path="age" id="age"
										value="${patient.age}" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="age" class="help-inline" />
									</div>
								</div>
							</div>
						</div>


						<!-- Patient gender  -->
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="gender"><spring:message
										code="patient-sex" /></label>
								<div class="col-md-2" class="form-control input-sm">
									<form:radiobutton path="gender" value="M" />
									<spring:message code="patient-male" />
									<form:radiobutton path="gender" value="F" />
									<spring:message code="patient-female" />
									<div class="has-error">
										<form:errors path="gender" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						<!--  patient profession -->
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="profession"><spring:message
										code="patient-profession" /></label>
								<div class="col-md-2">

									<form:input type="text" path="profession" id="profession"
										value="${patient.profession}" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="profession" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						
							<!--  patient profession -->
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="identification"><spring:message
										code="patient-identification" /></label>
								<div class="col-md-2">

									<form:input type="text" path="identification" id="identification"
										value="${patient.identification}" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="profession" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<!--  patient email and phone number -->
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="email"><spring:message
										code="patient-email" /></label>
								<div class="col-md-2">
									<form:input type="text" path="email" id="email"
										value="${patient.email}" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="phone"><spring:message
										code="patient-phone" /></label>
								<div class="col-md-2">
									<form:input type="text" path="phoneNumber" id="phoneNumber"
										value="${patient.phoneNumber}" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="phoneNumber" class="help-inline" />
									</div>
								</div>
							</div>
						</div>
						</div>
						<div class="col-md-4 text-right">
							<c:if test="${ patient.id gt 0}">
								<img src="${url}api/getImage/${patient.id}?imageId=${patient.picturePath}" class="img-thumbnail"  alt="profile picture" width="250" />
							</c:if>
						</div>
					</div>
						<%-- <div class="row">
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
						</div> --%>
						
						<!--  patient history -->
						<div class="row">
							<div class="form-group col-md-2 text-center">
								<h3>
									<spring:message code="patient-history" />
								</h3>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="personalhistory"><spring:message
										code="patient-personal-history" /></label>
								<div class="col-md-7">
									<form:input type="text" path="personalHistory" value="${patient.personalHistory}"
										id="personalhistory" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="personalHistory" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="familyhistory"><spring:message
										code="patient-family-history" /></label>
								<div class="col-md-7">
									<form:input type="text" path="familyHistory" id="familyhistory" value="${patient.familyHistory}"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="familyHistory" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="allergies"><spring:message
										code="patient-allergy" /></label>
								<div class="col-md-7">
									<form:input type="text" path="allergies" id="allergies" value="${patient.allergies}"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="allergies" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="treatment"><spring:message
										code="patient-treatment" /></label>
								<div class="col-md-7">
									<form:textarea type="text" path="treatment" id="treatment" value="${patient.treatment}"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="treatment" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>


				<div class="panel panel-primary">
					<div class="panel-heading">
						<spring:message code="patient-diet-history" />
					</div>
					<div class="panel-body">

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="height"><spring:message
										code="patient-height" /></label>
								<div class="col-md-2">
									<form:input type="text" path="visits[0].height"
										id="height" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="visits[0].height"
											class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="maxWeight"><spring:message
										code="patient-max-weight" /></label>
								<div class="col-md-2">
									<form:input type="text" path="maxWeight" id="maxWeight"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="maxWeight" class="help-inline" />
									</div>
								</div>



								<label class="col-md-2 control-lable" for="minWeight"><spring:message
										code="patient-min-weight" /></label>
								<div class="col-md-2">
									<form:input type="text" path="minWeight" id="minWeight"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="minWeight" class="help-inline" />
									</div>
								</div>



								<label class="col-md-2 control-lable" for="goodWeight"><spring:message
										code="patient-good-weight" /></label>
								<div class="col-md-2">
									<form:input type="text" path="goodWeight" id="goodWeight"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="goodWeight" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="maxIMC"><spring:message
										code="patient-max-imc" /></label>
								<div class="col-md-2">
									<form:input type="text" path="maxIMC" id="maxIMC"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="maxIMC" class="help-inline" />
									</div>
								</div>



								<label class="col-md-2 control-lable" for="minIMC"><spring:message
										code="patient-min-imc" /></label>
								<div class="col-md-2">
									<form:input type="text" path="minIMC" id="minIMC"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="minIMC" class="help-inline" />
									</div>
								</div>



								<label class="col-md-2 control-lable" for="goodIMC"><spring:message
										code="patient-good-imc" /></label>
								<div class="col-md-2">
									<form:input type="text" path="goodIMC" id="goodIMC"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="goodIMC" class="help-inline" />
									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="taste"><spring:message
										code="patient-taste" /></label>
								<div class="col-md-7">
									<form:textarea type="text" path="taste" id="taste"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="taste" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="water"><spring:message
										code="patient-water" /></label>
								<div class="col-md-2">
									<form:input type="text" path="water" id="water"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="water" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="pa"><spring:message
										code="patient-pa" /></label>
								<div class="col-md-7">
									<form:textarea type="text" path="physicalActivity" id="pa"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="physicalActivity" class="help-inline" />
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>

				<div class="panel panel-primary">
					<div class="panel-heading">
						<spring:message code="patient-observation" />
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-md-12">


								<form:textarea type="text" path="observations" id="observations"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="observations" class="help-inline" />
								</div>

							</div>
						</div>


					</div>
				</div>


				<div class="panel panel-primary">
					<div class="panel-heading">
						<spring:message code="patient-appointment" />
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-md-12"></div>
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
                        <form:errors patignoreReadonly: trueh="section" class="help-inline"/>
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
						<input type="submit" value="${action} patient"
							class="btn btn-primary btn-md" />
					</div>
				</div>
			</form:form>
		</div>

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
<script>
jQuery( document ).ready(function() {
	   jQuery("#formSelector").attr("accept-charset", "UTF-8");
	});

</script>


<script>
$( function() {
	$( "#birthday" ).datetimepicker(
			{
				format : "DD/MM/YYYY",
				ignoreReadonly: true		
			}
	);
	
} );

$( "#birthday input" ).change(calculateAge);
function calculateAge(){
	var dob = new Date($("#birthday input").val());
	var today  = new Date();
	var age = today - birthday ; 
	alert(age);
}

</script>
        
</html>
