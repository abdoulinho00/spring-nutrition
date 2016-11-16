<%@ include file="/jsp/layout/init.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list patient</title>
<%@ include file="/jsp/layout/meta.jsp" %>
</head>
<body>
<div class="container-fluid">
<%@ include file="/jsp/layout/banner-header.jsp" %>

<h1>List patient</h1>
<c:if test="${fn:length(patients)>0}">
<p>you have ${fn:length(patients)} patients registered</p>
<table class="table table-striped table-hover">
<thead>
<tr>
<th>Full name</th>
<th>birthday</th>
<th>gender</th>
<th>goodWeight</th>
<th>actions</th>
</tr>
</thead>
<tbody>
<c:forEach items="${patients}" var="patient">
<tr>
<td>${patient.fullname}</td>
<td>${patient.birthday}</td>
<td>${patient.gender}</td>
<td>${patient.goodWeight}</td>
<td>
<form method="post" action="${url}patient/delete" class="form-inline">
<a class="btn btn-primary" href="${url}patient/view?id=${patient.id}" role="button">view</a>
<a class="btn btn-success" href="${url}patient/edit?id=${patient.id}" role="button">edit</a>

<div class="form-group">
<input type="hidden" name="id" value="${patient.id}" />
</div>
<button type="submit"  class="btn btn-danger" >Delete</button>
</form>
  </td>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
<p>to add a patient click <a href="${url}patient/add">here</a></p>

<%@ include file="/jsp/layout/footer.jsp" %>
</div>
</body>
</html>