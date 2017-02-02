<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon' href='${pageContext.request.contextPath}/favicon.ico' type='image/x-icon' />
<title>Add Visit</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container">
		<%@ include file="/jsp/layout/banner-header.jspf"%>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>Add visit</strong>
			</div>
			<div class="panel-body">
				<form method="post" action="${url}patient/nutrition/visit/add" enctype="multipart/form-data">
					<input type="hidden" name="patient.id" value="${patientId}" />
					<div class="row">
						<div class="col-md-6">
					
							<div class="form-group">
								<label>Reason</label>
								<input type="text" class="form-control" name="reason"/>
							</div>
							<div class="form-group">
								<label>Description</label>
								<input type="text" class="form-control" name="description"/>
							</div>
							<div class="row">
								<div class='col-md-12'>
							        <div class="form-group">
							        	<label>Visit date</label>
							            <div class='input-group date' id='visitTime'>
							            	
							                <input type='text' name="visitTime" class="form-control" readonly />
							                <span class="input-group-addon">
							                    <span class="glyphicon glyphicon-calendar"></span>
							                </span>
							            </div>
							        </div>
							    </div>
							</div>
							
							
							<div class="form-group">
								<label>Height</label>
								<input type="text" class="form-control" name="height"/>
							</div>
							<div class="form-group">
								<label>Weight</label>
								<input type="text" class="form-control" name="weight"/>
							</div>
							<div class="form-group">
								<label>Blood pressure</label>
								<input type="text" class="form-control" name="bloodPressure"/>
							</div>
							<div class="form-group">
								<label>Sugar rate</label>
								<input type="text" class="form-control" name="sugarRate"/>
							</div>
							<div class="form-group">
								<label>Heart beat</label>
								<input type="text" class="form-control" name="heartBeat"/>
							</div>
							
							<div class="form-group">
								<label>Before Picture</label>
								<input type="file" class="form-control" name="beforefile"/>
							</div>
							<div class="form-group">
								<label>After Picture</label>
								<input type="file" class="form-control" name="afterfile"/>
							</div>
						</div>
						<div class="col-dm-6 text-center">
							
							<strong>Before</strong><hr/>
							<img src="" />
							<hr>
							<strong>After</strong>
							<img src=""/>
						</div>
					</div>
					<button type="submit" class="btn btn-default">Add</button>
				</form>
			</div>
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
	
	<script>
		$( function() {
    		$( "#visitTime" ).datetimepicker(
    				{format : "DD/MM/YYYY" , 
    					ignoreReadonly : true
    				}
    		);
  		} );
  	</script>
	
</body>
</html>