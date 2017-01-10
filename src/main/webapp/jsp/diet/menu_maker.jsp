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
			<h1>Make your own menu</h1>
			<form>
			<div>
				<label>Repas</label>
				<select>
					<option>Ftour</option>
					<option>Ghda</option>
					<option>3cha</option>
				</select>
			</div>
			</form>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	
</script>
</html>