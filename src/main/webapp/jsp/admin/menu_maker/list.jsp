<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon'
	href='${pageContext.request.contextPath}/favicon.ico'
	type='image/x-icon' />
<title>list menu item</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>

		
			<div class="panel panel-default">
				<div class="panel-heading">
					Menu Items
				</div>
				<div class="panel-body">
					here we list all the menu items you have <a href="${url}admin/menu/add">Click here to add a menu item</a>
				</div>
			</div>
			<c:if test="${fn:length(menuItems)>0}">
				<c:forEach items="${menuItems}" var="item">
					<div class="panel panel-default">
						<div class="panel-heading">
							${item.name }
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-10">
									<p>${item.description }</p>
									<p>${item.content }</p>
								</div>
								<div class="col-md-2 ">
									<ul class="list-unstyled">
										<li><span class="glyphicon glyphicon-triangle-right"></span>  Calories : ${item.calories }</li>
										<li><span class="glyphicon glyphicon-triangle-right"></span>  Proteins : ${item.proteins }</li>
										<li><span class="glyphicon glyphicon-triangle-right"></span>  Carbs : ${item.carbs }</li>
										<li><span class="glyphicon glyphicon-triangle-right"></span>  Fat : ${item.fat }</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>
	
</body>

<script>
	
</script>
</html>