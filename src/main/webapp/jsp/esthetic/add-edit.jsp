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
			
			<form:form method="post" class="" action="${url}patient/esthetic/visit/add" modelAttribute="visit" enctype="multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="hidden" name="patient.id" value="${patientId}" />
				<input type="hidden" name="id" value="${visit.id}" />
				<div class="form-group">
					<label>Identity</label>
					<form:input type="text" path="identity" class="form-control" value="${visit.identity}"/>
				</div>
				 
				<div class="form-group">
					<label>reason</label>
					<input type="text"name="reason" class="form-control" value="${visit.reason}"/>
				</div>
				<div class="form-group">
					<label>allergiqueHistory</label>
					<input type="text"name="allergiqueHistory" class="form-control" value="${visit.allergiqueHistory}"/>
				</div>
				<div class="form-group">
					<label>dermatologiqueHistory</label>
					<input type="text"name="dermatologiqueHistory" class="form-control" value="${visit.dermatologiqueHistory}"/>
				</div>
				<div class="form-group">
					<label>estheticTreatmentHistory</label>
					<input type="text"name="estheticTreatmentHistory" class="form-control" value="${visit.estheticTreatmentHistory}"/>
				</div>
				
				
				<div class="form-group">
					<label>classification</label>
					<input type="text"name="classification" class="form-control" value="${visit.classification}"/>
				</div>
				<div class="form-group">
					<label>dermatologiqueExamination</label>
					<input type="text"name="dermatologiqueExamination" class="form-control" value="${visit.dermatologiqueExamination}"/>
				</div>
				<div class="form-group">
					<label>proposedProtocol</label>
					<input type="text"name="proposedProtocol" class="form-control" value="${visit.proposedProtocol}"/>
				</div>
				<div class="form-group">
					<label>estheticCondition</label>
					<input type="text"name="estheticCondition" class="form-control" value="${visit.estheticCondition}"/>
				</div>
				<div class="form-group">
					<label>visitDate</label>
					<input type="text"name="visitDate" class="form-control" value="${visit.visitDate}"/>
				</div>
				<div class="form-group">
					<label>observations</label>
					<input type="text"name="observations" class="form-control" value="${visit.observations}"/>
				</div>
				
				<c:if test="${fn:length(visit.sessions) le 0}">
					<div id="session selector" class="row form-group">
						<div class="col-md-1"><label for="sessions-input">Sessions : </label></div>
						<div class="col-md-1" ><input id="sessions-input" type="text" class="form-control"/></div>
						<div class="col-md-1" id="sessions-input"><button type="button" class="btn btn-default" onclick="setSessions()">Set</button></div>
					</div>
					<div id="sessions">
					
					</div>
				</c:if>
				<c:if test="${fn:length(visit.sessions) gt 0}">
					<div id="sessions">
						<table class="table table-striped  table-bordered">
							<tr>
								<th class="col-md-1">#</th>
								<th class="col-md-7">Observations</th>
								<th class="col-md-1">Date</th>
								<th class="col-md-3">Photos</th>
							</tr>
							<c:forEach var="session" items="${visit.sessions}" varStatus="loop">
								<input type="hidden" name="sessions[${loop.index}].id" value="${session.id}" />
								<tr>
									<td class="col-md-1">${(loop.index +1)}</td>
									<td class="col-md-7">
										<textarea name="sessions[${loop.index}].observations"  style="height : 100%;" class="form-control text-left">${session.observations}</textarea>
									</td>
									<td id="session${loop.index}" class="col-md-1">
										<div id="visitDate${loop.index}" class="input-group date">
											<fmt:formatDate pattern="dd/MM/yyyy"
											value="${session.date}" var="sessionDate" />
											<input name="sessions[${loop.index}].date" class="form-control" value="${sessionDate}"/>
											<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
										</div>
									</td>
									<td class="col-md-3">
										<input type="hidden" name="sessions[${loop.index}].facePath}" value="${session.facePath}"/>
										<input type="hidden" name="sessions[${loop.index}].rightProfilePath}" value="${session.rightProfilePath}"/>
										<input type="hidden" name="sessions[${loop.index}].leftProfilePath}" value="${session.leftProfilePath}"/>
										<div class="form-group"><label class="" for="">Face view</label><input type="file" name="facefile" class="form-control"/></div>
										<div class="form-group"><label class="" for="">Right Profile</label><input type="file" class="form-control" name="rightfile" /></div>
										<div class="form-group"><label class="" for="">Left profile</label><input type="file" class="form-control" name="leftfile" /></div>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<script>
					$( function() {
						for(var i=0;i<${fn:length(visit.sessions)} ; i++){
							$( "#visitDate"+i ).datetimepicker(
									{
										format : "DD/MM/YYYY",
										ignoreReadonly: true		
									}
							);
						}
					} );
					</script>
				</c:if>
				<div class="row">
					<div>
						<button type="submit" class="btn btn-default">Save</button>
					</div>
				</div>
			</form:form>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>


<script>
function setSessions(){
	var sessionNumber = $("#sessions-input").val();
	$("#sessions").html('<table class="table table-striped  table-bordered"><tr><th class="col-md-1">#</th><th class="col-md-8">Observations</th><th class="col-md-1">Date</th><th class="col-md-2">Photos</th></tr></table>')
	for(var i=0; i<sessionNumber ;i++){
		var input = '<textarea name="sessions['+ i+ '].observations" class="form-control"></textarea>';
		var date = '<input name="sessions['+ i+ '].date" class="form-control"/><span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>';
		var images = '<div class="form-group"><input type="file" class="form-control" name="facefile" /></div>' ;
		images += '<div class="form-group"><input type="file" class="form-control" name="rightfile" /></div>' ;
		images += '<div class="form-group"><input type="file" class="form-control" name="leftfile" /></div>' ;
		$("#sessions table").append('<tr><td class="col-md-1">'+(i+1) + '</td><td class="col-md-8 ">' +input +'</td><td id="session'+i+'" class="col-md-1"><div id="visitDate'+i+'" class="input-group date">'+ date+'</div></td><td class="col-md-2">'+images+'</td></tr>');
		
		$( function() {
			$( "#visitDate"+i ).datetimepicker(
					{
						format : "DD/MM/YYYY",
						ignoreReadonly: true		
					}
			);
			
		} );
	
	}
	
	
}



</script>
        
</html>
