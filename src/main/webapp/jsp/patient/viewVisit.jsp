<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon' href='${pageContext.request.contextPath}/favicon.ico' type='image/x-icon' />
<title>View visit</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container">
		<%@ include file="/jsp/layout/banner-header.jspf"%>

		<h1>${visit.patient.fullname}</h1>
		<div class="row text-center">
			<div class="col-md-4 col-md-offset-2">
				<img class="img-responsive" src="${url}api/getImage/${visit.patient.id}/nutrition/${visit.id}?imageId=${visit.beforePath}" alt="before image"/>
				
			</div>
			<div class="col-md-4"> 
				<img  class=" img-responsive" src="${url}api/getImage/${visit.patient.id}/nutrition/${visit.id}?imageId=${visit.afterPath}" alt="after image" />
			</div>
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>

	</div>
</body>
</html>