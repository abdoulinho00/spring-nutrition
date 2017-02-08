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
		<div class="row">
			<div class="container-fluid col-md-6 col-md-offset-3">
				<h1 class="text-primary text-center">Login</h1>
	
				<form action="${loginUrl}" method="post" class="form-horizontal ">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"><i
							class="fa fa-user"></i></label> <input type="text" class="form-control"
							id="username" name="username" placeholder="Enter Username" required>
					</div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i
							class="fa fa-lock"></i></label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter Password" required>
					</div>
					<div class="input-group input-sm">
						<div class="checkbox">
							<label><input type="checkbox" id="rememberme"
								name="remember-me"> Remember Me</label>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
	
					<div class="form-actions text-center">
						<input type="submit" class="btn btn-primary btn-default"
							value="Log in">
					</div>
					
				</form>
			</div>
			<div class="row text-center">
						Not registered ? <a href='<c:url value="/signup"/>'>click here to sign up</a>
			</div>
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>

<script>
	
</script>
</html>