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
					<input type="hidden" name="id" value="${visit.id}" />
					<div class="row">
						<div class="col-md-6">
					
							<div class="form-group">
								<label>Reason</label>
								<input type="text" class="form-control" name="reason" value="${visit.reason}"/>
							</div>
							<div class="form-group">
								<label>Description</label>
								<input type="text" class="form-control" name="description" value="${visit.description}"/>
							</div>
							<div class="row">
								<div class='col-md-12'>
							        <div class="form-group">
							        	<label>Visit date</label>
							            <div class='input-group date' id='visitTime'>
							            	<fmt:formatDate pattern="dd/MM/yyyy" value="${visit.visitTime}" var="visitTime" />
							                <input type='text' name="visitTime" class="form-control" value="${visitTime}" readonly />
							                <span class="input-group-addon">
							                    <span class="glyphicon glyphicon-calendar"></span>
							                </span>
							            </div>
							        </div>
							    </div>
							</div>
							
							
							<div class="form-group">
								<label>Height</label>
								<input type="text" class="form-control" name="height" value="${visit.height}"/>
							</div>
							<div class="form-group">
								<label>Weight</label>
								<input type="text" class="form-control" name="weight" value="${visit.weight}"/>
							</div>
							<!-- <div class="form-group">
								<label>Blood pressure</label>
								<input type="text" class="form-control" name="bloodPressure" />
							</div>
							<div class="form-group">
								<label>Sugar rate</label>
								<input type="text" class="form-control" name="sugarRate"/>
							</div>
							<div class="form-group">
								<label>Heart beat</label>
								<input type="text" class="form-control" name="heartBeat"/>
							</div> -->
							
							<!--  
							private float waistSize;
	private float armSize;
	private float hipSize;
	private float wristSize;
	
	private float baseMetabolism; // in Kcal
	private short biologicalAge;
	private float water; // in %
	private float boneMass;
	private float visceralFat;
	private float leanMass;
	private float fatMass;
							 -->
							<div class="form-group">
								<label>armSize</label>
								<input type="text" class="form-control" name="armSize" value="${visit.armSize}"/>
							</div>
							<div class="form-group">
								<label>hipSize</label>
								<input type="text" class="form-control" name="hipSize" value="${visit.hipSize}"/>
							</div>
							<div class="form-group">
								<label>wristSize</label>
								<input type="text" class="form-control" name="wristSize" value="${visit.wristSize}"/>
							</div>
							
							
							<div class="form-group">
								<label>baseMetabolism</label>
								<input type="text" class="form-control" name="baseMetabolism" value="${visit.baseMetabolism}"/>
							</div>
							<div class="form-group">
								<label>biologicalAge</label>
								<input type="text" class="form-control" name="biologicalAge" value="${visit.biologicalAge}"/>
							</div>
							<div class="form-group">
								<label>water</label>
								<input type="text" class="form-control" name="water" value="${visit.water}"/>
							</div>
							<div class="form-group">
								<label>boneMass</label>
								<input type="text" class="form-control" name="boneMass" value="${visit.boneMass}"/>
							</div>
							<div class="form-group">
								<label>visceralFat</label>
								<input type="text" class="form-control" name="visceralFat" value="${visit.visceralFat}"/>
							</div>
							<div class="form-group">
								<label>leanMass</label>
								<input type="text" class="form-control" name="leanMass" value="${visit.leanMass}"/>
							</div>
							<div class="form-group">
								<label>fatMass</label>
								<input type="text" class="form-control" name="fatMass" value="${visit.fatMass}"/>
							</div>
							
							<!--  Pictures files -->
							
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
							<input type="hidden" name="beforePath" value="${visit.beforePath}"/>
							<input type="hidden" name="afterPath" value="${visit.afterPath}"/>
							<strong>Before</strong><hr/>
							<img src="${url}api/getImage/${patientId}/nutrition/${visit.id}?imageId=${visit.beforePath}" class="img-thumbnail img-responsive"/>
							<hr>
							<strong>After</strong><hr/>
							<img src="${url}api/getImage/${patientId}/nutrition/${visit.id}?imageId=${visit.afterPath}" class="img-thumbnail img-responsive"/>
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