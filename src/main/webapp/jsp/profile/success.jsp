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
		<div class="alert alert-success lead">
            ${success}
        </div>
         
        <span class="well floatRight">
            Go to <a href="<c:url value='/list' />">Users List</a>
        </span>

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>

<script>
	
</script>
</html>