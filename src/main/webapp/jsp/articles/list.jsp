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

		<div class="well lead text-center">
			<spring:message code="articles-list" text="List of Articles" />
		</div>
		
		<%-- <div class="row">
			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading "><h3><a href="">Article 1</a></h3></div>
					<div class="panel-body">
						<p><spring:message code="sample-text-1" text="sample text" /></p>
						<p><spring:message code="sample-text-3" text="sample text" /></p>
					</div>
					<div class="panel-footer">test author</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">Article 2</div>
					<div class="panel-body">
						<p><spring:message code="sample-text-1" text="sample text" /></p>
						<p><spring:message code="sample-text-3" text="sample text" /></p>
						<p><spring:message code="sample-text-5" text="sample text" /></p>
					</div>
					<div class="panel-footer">test author</div>
				</div>
			</div>
		</div> --%>
		
		
		<c:if test="${fn:length(articles)>0}">
			<div class="row">
			<c:forEach items="${articles}" var="article" varStatus="loop">
				<c:if test="${loop.index %2 == 0 }">
					<div class="clearfix visible-md-block"></div>
				</c:if>
				<div class="col-md-6">
					<div class="panel panel-primary">
					<div class="panel-heading" ><strong ><u>${article.title}</u></strong></div>
						<div class="panel-body text-justify"><p>${article.content}</p></div>
						<div class="panel-footer">${article.author} - <fmt:formatDate pattern="dd MMMM yyyy" value="${article.modifiedAt}"/></div>
					</div>
				</div>
			</c:forEach>
			</div>

		</c:if>
		<c:if test="${fn:length(articles)<=0}">
			<div class="row alert alert-info">You don't have any article for
				the moment</div>

		</c:if>

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
</html>