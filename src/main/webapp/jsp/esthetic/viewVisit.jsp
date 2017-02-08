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

		<c:forEach items="${visit.sessions}" var="session" varStatus="loop">
			<div class="panel panel-default">
				<div class="panel-heading">
					Session ${ (loop.index + 1)} : <fmt:formatDate value="${session.date}" pattern="dd MMMM yyyy"/>
				</div>
				<div class="panel-body" >
					<div class="row">
						${session.observations}
					</div>
					<div class="row">
						<div class="col-md-4">
							<p class="text-center">Left profile</p>
							<hr>
							<img class="img-thumbnail img-responsive" src="${url}api/getImage/${visit.patient.id}/esthetic/${visit.id}/${session.id}?imageId=${session.leftProfilePath}" alt="left profile picture" />
						</div>
						<div class="col-md-4">
							<p class="text-center">Face profile</p>
							<hr>
							<img class="img-thumbnail img-responsive" src="${url}api/getImage/${visit.patient.id}/esthetic/${visit.id}/${session.id}?imageId=${session.facePath}" alt="face profile picture" />
						</div>
						<div class="col-md-4">
							<p class="text-center">Right profile</p>
							<hr>
							<img class="img-thumbnail img-responsive" src="${url}api/getImage/${visit.patient.id}/esthetic/${visit.id}/${session.id}?imageId=${session.rightProfilePath}" alt="right profile picture"/>
						</div>
					</div>
				</div>
			</div>
		
		</c:forEach>
			
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>


<script>



</script>
        
</html>
