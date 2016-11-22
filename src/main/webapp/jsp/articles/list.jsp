<%@ include file="/jsp/layout/init.jspf"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list patient</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>

		<h1><spring:message code="patient-list" /></h1>
		<c:if test="${fn:length(articles)>0}">
			<p>you have ${fn:length(articles)} patients registered</p>
			<c:forEach items="${articles}" var="article">
				<div>
				
				</div>
			</c:forEach>
			
		</c:if>
				<c:if test="${fn:length(articles)<=0}">
			<div class="alert alert-info">You don't have any article for the moment</div>
			
		</c:if>

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
</html>