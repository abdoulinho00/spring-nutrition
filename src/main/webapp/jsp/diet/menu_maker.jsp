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

			<div class="well text-center">
				<h1>Make your own menu</h1>
			</div>
			<div class="row">
				<div class="col-md-3">
					<form>
					<div class="form-group">
						<label>Type</label>
						<select id="menuType" name="menuType" class="form-control">
							<c:forEach items="${ menuTypes}" var="menuType">
								<option value="${menuType}"><spring:message text="${menuType }" code="${menuType }" /></option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Menu item</label>
						<c:if test="${fn:length(menuItems)>0}">
							<select id="menuItem" name="menuItem" class="form-control">
								<c:forEach items="${ menuItems}" var="menuItem" varStatus="loop">
									<option value="${menuItem.id}">${menuItem.name}</option>
								</c:forEach>
							</select>
						</c:if>
					</div>
					<button type="button" onclick="addMenuItem();">Add menu</button>
					</form>
				</div>
				<div class="col-md-9">
					<c:forEach items="${ menuTypes}" var="menuType">
						<fieldset>
							<legend>${menuType}</legend>
							<div class="panel-group" id="${menuType}"></div>
						</fieldset>
					</c:forEach>
				</div>
			</div>
		
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	function addMenuItem(){
		var menuItem = $("#menuItem").val(); 
		var type = $("#menuType").val();
		$.get("/medidoc/api/menuItem?id="+menuItem,function(data,status){
			if(status == "success"){
				var content = '<div class="panel panel-default"><div class="panel-heading">'+data.name+'</div>'
				content +='<div class="panel-body">'+data.content+'</div></div>'
				$("#"+type).append(content)
			}
		}
		);
		
	}
</script>
</html>