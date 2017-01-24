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
				Add visit
			</div>
			<div class="">
				<form>
					<p>Visit form</p>
					<button type="submit" class="btn btn-default">Add</button>
				</form>
			</div>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
</html>