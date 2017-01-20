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
			<h1>Add menu item</h1>
			
			<div class="panel panel-default">
				<form method="post">
					<div>
					<label>Name : </label><input type="text" name="name"/>
					</div>
					<div>
					<label>Description : </label><input type="text" name="description" placeholder="make it small"/>
					</div>
					<div>
					<label>Content : </label><textarea  id="content" name="content"></textarea>
					</div>
					
					<div>
						<button type="submit">Add</button>
					</div>
				</form>
			</div>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
tinymce.init({
	  selector: '#content',
	  height: 400,
	  menubar: false,
	  plugins: [
	    'advlist autolink lists link image charmap print preview anchor',
	    'searchreplace visualblocks code fullscreen',
	    'insertdatetime media table contextmenu paste code'
	  ],
	  toolbar: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
	  content_css: '//www.tinymce.com/css/codepen.min.css'
	});
</script>
</html>