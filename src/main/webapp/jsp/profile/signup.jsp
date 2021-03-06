<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon'
	href='${pageContext.request.contextPath}/favicon.ico'
	type='image/x-icon' />
<title>Sign up</title>

<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>

	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>
		        <div class="well lead">User Registration Form</div>
        <form:form method="POST" modelAttribute="user" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="firstname">First Name <span class="text-danger">*</span></label>
                    <div class="col-md-7">
                        <form:input type="text" path="firstname" id="firstname" class="form-control input-sm" required="true"/>
                        <div class="has-error">
                            <form:errors path="firstname" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="lastName">Last Name <span class="text-danger">*</span></label>
                    <div class="col-md-7">
                        <form:input type="text" path="lastname" id="lastname" class="form-control input-sm" required="true"/>
                        <div class="has-error">
                            <form:errors path="lastname" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="username">Username  <span class="text-danger">*</span></label>
                    <div class="col-md-7">
                        <c:choose>
                            <c:when test="${edit}">
                                <form:input type="text" path="username" id="username" class="form-control input-sm" disabled="true"/>
                            </c:when>
                            <c:otherwise>
                                <form:input type="text" path="username" id="username" class="form-control input-sm" required="true"/>
                                <div class="has-error">
                                    <form:errors path="username" class="help-inline"/>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="password">Password <span class="text-danger">*</span></label>
                    <div class="col-md-7">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" required="true" />
                        <div class="has-error">
                            <form:errors path="password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="email">Email</label>
                    <div class="col-md-7">
                        <form:input type="email" path="email" id="email" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="email" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     		<sec:authorize access="hasRole('ADMIN')">
	            <div class="row">
	                <div class="form-group col-md-12">
	                    <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
	                    <div class="col-md-7">
	                        <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
	                        <div class="has-error">
	                            <form:errors path="userProfiles" class="help-inline"/>
	                        </div>
	                    </div>
	                </div>
	            </div>
     		</sec:authorize>
            <div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
   

		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>
</html>