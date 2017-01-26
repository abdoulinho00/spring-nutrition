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

		<div>
			<c:if test="${fn:length(articles)>0}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Author</th>
							<th>Type</th>
							<th>Creation date</th>
							<th>Last modification</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${articles}" var="article">
							<tr>
								<td><a href="${url}admin/articles/add?id=${article.id}">${article.title}</a></td>
								<td>${article.author}</td>
								<td><spring:message text="${ article.type}" code="" /></td>
								<td>${article.writtenAt}</td>
								<td>${article.modifiedAt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${fn:length(articles)<=0}">
				<div class="well">
					<h1>No  entries</h1>
				</div>
			</c:if>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	
</script>
</html>