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
			
			<form:form method="post" class="" action="${url}patient/esthetic/visit/add" modelAttribute="visit">
				<input type="hidden" name="patient.id" value="${patientId}" />
				<input type="hidden" name="id" value="${visit.id}" />
				<div class="form-group">
					<label>Identity</label>
					<form:input type="text" path="identity" class="form-control" value="${visit.identity}"/>
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
				<c:if test="${fn:length(patient.visits) gt 0}">
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
		var images = '<div class="form-group"><input type="file" class="form-control" name=sessions['+i+'].facePath /></div>' ;
		images += '<div class="form-group"><input type="file" class="form-control" name=sessions['+i+'].rightProfilePath /></div>' ;
		images += '<div class="form-group"><input type="file" class="form-control" name=sessions['+i+'].leftProfilePath /></div>' ;
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


$( function() {
	$( "#visitDate0" ).datetimepicker(
			{
				format : "DD/MM/YYYY",
				ignoreReadonly: true		
			}
	);
	
} );
</script>
        
</html>
