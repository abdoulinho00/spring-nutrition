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
		
		<form method="post">
			<input type="hidden" value="${article.id}" />
			<div class="form-group">
				<label><spring:message code="" text="Title"/><span> *</span></label>
				<input type="text" name="title" value="${article.title}" class="form-control"/>
			</div>
			<div class="form-group">
				<label><spring:message code="" text="Content"/><span> *</span></label>
				<input type="text" name="content" value="${article.content}" class="form-control"/>
			</div>
			<div class="form-group">
				<label><spring:message code="" text="Tags"/><span> *</span></label>
				<input type="text" name="tags" value="${article.tags}" class="form-control"/>
			</div>
			<div class="form-group">
				<label><spring:message code="" text="author"/><span> *</span></label>
				<input type="text" name="author" value="${article.author}" class="form-control"/>
			</div>
			<div class="form-group">
				<label><spring:message code="" text="type"/><span> *</span></label>
				<select name="type" class="form-control" >
					<c:forEach items="${types}" var="articleType">
						<c:set var="selected" value="" />
						<c:if test="${article.type eq articleType}" >
							<c:set var="selected" value="selected" />
						</c:if>
						<option value="${articleType}" ${selected}><spring:message code="" text="${articleType}" /></option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-default">Save</button>
		</form>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	
</script>
</html>