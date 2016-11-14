<%@ include file="/jsp/layout/init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add patient</title>
<%@ include file="/jsp/layout/meta.jsp"%>
</head>
<body>
	<div class="container">
		<%@ include file="/jsp/layout/banner-header.jsp"%>
		<h1>I am viewing the patient <c:out value="${patient.fullname}" /> </h1>
		<%@ include file="/jsp/layout/footer.jsp"%>
	</div>
</body>
</html>