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
			<h1 class="text-primary">Control Panel</h1>
			
			<div class="row">
				<div class="col-md-6">
					<ul class="list-group ">
						<li class="list-group-item"><a href="${url}admin/menu">Manage menu items</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<ul class="list-group ">
						<li class="list-group-item"><a href="${url}admin/articles">Manage articles</a></li>
						<li class="list-group-item"><a href="${url}admin/articles/add">Add article</a></li>
					</ul>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-6">
					<ul class="list-group ">
						<li class="list-group-item"><a href="${url}admin/users">List and edit users</a></li>
						<li class="list-group-item"><a href="${url}signup">Add user</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	
</script>
</html>