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
	<div class="container">
		<%@ include file="/jsp/layout/banner-header.jspf"%>
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong>${patient.fullname}</strong>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">Age : ${patient.age}</div>
				</div>
				
				
					
				<p>To add a visit click <a href="${url }patient/visit/add/${patient.id}">here</a></p>
			</div>
		</div>
		<c:if test="${fn:length(patient.visits)>0}">
			<div id="weight_chart" class="text-center" style="width: 90%; height: 800px; margin: 0 auto;"> 
				
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading text-center">
					<strong>Visit history</strong>
				</div>
				<div class="panel-boody">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Reason</th>
								<th>Visit Date</th>
								<th>Weight</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items ="${patient.visits}" var="visit">
								<tr>
									<td>${visit.reason}</td>
									<td><fmt:formatDate pattern="dd MMMM yyyy"  value="${visit.visitTime}" /></td>
									<td>${visit.weight}</td>
									<td><a class="btn btn-sm" href="${url}patient/visit/view/${visit.id}"><span class="glyphicon glyphicon-search"></span></a></td>
									<td><a class="btn btn-sm" href="${url}patient/visit/edit/${visit.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
	
	<script>
	var chartData;
	$.get("${url}api/getchartdata/${patient.id}",function(data,status){
			if(status == "success"){
				chartData = data;
			}
		}
		);
	 google.charts.load('current', {'packages':['corechart']});
     google.charts.setOnLoadCallback(drawWeightChart);

     
     function drawWeightChart() {
         var data = google.visualization.arrayToDataTable(chartData);
          
         var options = {
           title: '${patient.fullname} progression',
           curveType: 'function',
           legend: { position: 'bottom' },
           vAxis: {
               viewWindowMode:'explicit',
               viewWindow: {
                 max:150,
                 min:0
               }
           },
           
           explorer: {
               maxZoomOut:2,
               keepInBounds: true
           }
         };
         var chart = new google.visualization.LineChart(document.getElementById('weight_chart'));

         chart.draw(data, options);
       }
    
	</script>
</body>
</html>