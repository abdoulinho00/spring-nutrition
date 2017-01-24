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
		<div class="well">${patient.fullname}</div>
		<div class="panel panel-default">
			<p>To add a visit click <a href="${url }patient/visit/add/${patient.id}">here</a></p>
		</div>
		<div class="text-center">
		<img src="${chart}" alt="chart"/>
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
</html>