<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon' href='${pageContext.request.contextPath}/favicon.ico' type='image/x-icon' />
<title>list patient</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>

		<h1 class="text-primary"><spring:message code="patient-list" /></h1>
		<c:if test="${fn:length(patients)>0}">
			<p>you have ${fn:length(patients)} patients registered</p>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><spring:message code="patient-fullname" /></th>
						<th><spring:message code="patient-birthday" /></th>
						<th><spring:message code="patient-sex" /></th>
						<th><spring:message code="patient-good-weight" /></th>
						<th><spring:message code="patient-actions" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patients}" var="patient">
						<tr>
							<td>${patient.fullname}</td>
							<td><fmt:formatDate pattern="dd MMMM yyyy"  value="${patient.birthday}" /></td>
							<td>${patient.gender}</td>
							<td>${patient.goodWeight}</td>
							<td>
								<form method="post" action="${url}patient/delete" 
									class="form-inline">
									<a class="btn btn-primary"
										href="${url}patient/view?id=${patient.id}" role="button">view</a>
									<a class="btn btn-success"
										href="${url}patient/edit?id=${patient.id}" role="button">edit</a>

									<div class="form-group">
										<input type="hidden" name="id" value="${patient.id}" />
									</div>
									<button type="submit" class="btn btn-danger">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${fn:length(patients) le 0}">
			<div class="alert alert-info text-center"> You don't have any registered patients</div>
		</c:if>
		<p>
			To add a patient click <a href="${url}patient/add">here</a>
		</p>

		
	</div>
	<%@ include file="/jsp/layout/footer.jspf"%>
</body>
</html>