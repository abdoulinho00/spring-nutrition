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
		
		
		<div class="">
			<ul class="sidebar-nav">
				<li><a href="#">somthing</a></li>
				<li><a href="#">somthing</a></li>
				<li><a href="#">somthing</a></li>
				<li><a href="#">somthing</a></li>
				<li><a href="#">somthing</a></li>
			</ul>
		</div>
		<div class="container-fluid">
			<h1>Control Panel</h1>
			
			<div class="panel panel-default">
				<ul>
					<li><a href="${url}admin/menu">Manage menu items</a></li>
				</ul>
			</div>
			
			<div class="panel panel-default">
				<ul>
					<li><a href="${url}admin/articles">Manage articles</a></li>
					<li><a href="${url}admin/articles/add">add article</a></li>
				</ul>
			</div>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	
</script>
</html>