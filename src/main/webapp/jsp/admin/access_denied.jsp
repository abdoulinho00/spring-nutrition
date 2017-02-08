<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon'
	href='${pageContext.request.contextPath}/favicon.ico'
	type='image/x-icon' />
<title>list patient</title>

<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>
		<div class="container-fluid">
			<p>you don't have the right to view this page</p>
			<p>To logout click <a href="<c:url value='/logout'/>" >here</a></p>
			<p>To return to the home page click <a href="<c:url value='/' />" >here</a></p>
		</div>

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>

<script>
	
</script>
</html>