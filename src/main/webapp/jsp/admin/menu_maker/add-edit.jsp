<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon'
	href='${pageContext.request.contextPath}/favicon.ico'
	type='image/x-icon' />
<title>list menu item</title>
<%@ include file="/jsp/layout/meta.jspf"%>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>

		<div class="container-fluid">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong>Add menu item</strong>
				</div>
				<div class="panel-body">
					<form method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" name="id" value="${menuItem.id}" />
						<div class="form-group">
							<label>Name : </label> 
							<input type="text" name="name" class="form-control" value="${menuItem.name}" />
						</div>
						<div class="form-group">
							<label>Description : </label> 
							<input type="text" name="description" placeholder="small description" class="form-control" value="${menuItem.description}"/>
						</div>
						
						<fieldset >
							<legend>
								<a class="" role="button" data-toggle="collapse" href="#metrics" aria-expanded="true" aria-controls="metrics">Metrics</a>
							</legend>
							<div id="metrics" class="row">
								<div class="form-group col-md-3">
									<label>Calories : </label> 
									<input type="text" name="calories" placeholder="0.0" class="form-control" value="${menuItem.calories}"/>
								</div>
								<div class="form-group col-md-3">
									<label>Proteins : </label> 
									<input type="text" name="proteins" placeholder="0.0" class="form-control" value="${menuItem.proteins}"/>
								</div>
								<div class="form-group col-md-3">
									<label>Carbs : </label> 
									<input type="text" name="carbs" placeholder="0.0" class="form-control" value="${menuItem.carbs}"/>
								</div>
								<div class="form-group col-md-3">
									<label>Fat : </label> 
									<input type="text" name="fat" placeholder="0.0" class="form-control" value="${menuItem.fat}"/>
								</div>
						</div>
						</fieldset>
						
						<div>
							<label>Content : </label>
							<textarea id="content" name="content" >${menuItem.content}</textarea>
						</div>
		
						<div class="row">
							<hr>
							<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span>Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div>
</body>

<script>
	tinymce
			.init({
				selector : '#content',
				height : 400,
				menubar : false,
				plugins : [
						'advlist autolink lists link image charmap print preview anchor',
						'searchreplace visualblocks code fullscreen',
						'insertdatetime media table contextmenu paste code' ],
				toolbar : 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
				content_css : '//www.tinymce.com/css/codepen.min.css'
			});
</script>
</html>