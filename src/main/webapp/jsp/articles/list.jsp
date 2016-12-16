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

		<h1>
			<spring:message code="patient-list" />
		</h1>
		<c:if test="${fn:length(articles)>0}">
			<p>Articles : ${fn:length(articles)}</p>
			<c:forEach items="${articles}" var="article">
				<div class="panel panel-primary">
				<div class="panel-heading">${article.title}</div>
					<div class="panel-body"><p>${article.content}</p></div>
					<div class="panel-footer">${article.author}</div>
				</div>
			</c:forEach>

		</c:if>
		<c:if test="${fn:length(articles)<=0}">
			<div class="alert alert-info">You don't have any article for
				the moment</div>

		</c:if>

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
</html>