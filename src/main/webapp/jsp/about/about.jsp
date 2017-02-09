<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon'
	href='<c:url value="/resources/img/favicon.ico" /> '
	type='image/x-icon' />
<title>About us</title>

<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-body">
					<h2 class="text-primary">About the development team</h2>
					<p>This website was developped and maintained by <a href="https://ca.linkedin.com/in/abderrahmane-el-bardai-1a49665b
					" target="_blank"><em>Abderrahmane El Bardai</em></a></p>
					<p>The idea of this website was to provide a platform for physicits to manage their patients. 
					It was tailored for two medecine specializations : Nutrition and Esthetic medecine.
					<br>
					the website also allow th physicists to post articles about what they are doing or whatever they find interesting 
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<img class="img-thumbnail img-responsive center-block" width="300px" src="<c:url value="/resources/img/me.jpg" /> " alt="me" />
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>

<script>
	
</script>
</html>