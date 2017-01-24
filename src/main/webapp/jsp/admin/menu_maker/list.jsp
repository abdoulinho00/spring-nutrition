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

		
			<div class="panel panel-default">
				<div class="panel-heading">
					Menu Items
				</div>
				<div class="panel-body">
					here we list all the menu items you have <a href="${url}admin/menu/add">Click here to add a menu item</a>
				</div>
			</div>
			<div class="panel-group" id="listMenuItems">
				<c:if test="${fn:length(menuItems)>0}">
					<c:set var="pagination" value="5" />
					<c:forEach items="${menuItems}" var="item" varStatus="loop">
						<c:set var="mode" value="" />
						<c:if test="${loop.index >= pagination}">
							<c:set var="mode" value="hidden" />
						</c:if>						
						<div class="panel panel-default ${mode}">
							<div class="panel-heading">
								<div class="pull-left">${item.name }</div> 
								<div class=" pull-right">
									<a href="${url}admin/menu/add?id=${item.id}"><span class="glyphicon glyphicon-pencil" title="Edit"></span></a>
									<a href="${url}admin/menu/remove?id=${item.id}" onclick="return confirm('Are you sure you want to delete?');"><span class="glyphicon glyphicon-trash" title="Delete"></span></a>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-10">
										<p>${item.description }</p>
										<p>${item.content }</p>
									</div>
									<div class="col-md-2 ">
										<ul class="list-unstyled">
											<li><span class="glyphicon glyphicon-triangle-right"></span>  Calories : ${item.calories }</li>
											<li><span class="glyphicon glyphicon-triangle-right"></span>  Proteins : ${item.proteins }</li>
											<li><span class="glyphicon glyphicon-triangle-right"></span>  Carbs : ${item.carbs }</li>
											<li><span class="glyphicon glyphicon-triangle-right"></span>  Fat : ${item.fat }</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<nav aria-label="Page navigation" id="paginationNavBar" class="text-center">
						<ul class="pagination">
					    	<li>
					      		<a href="#" aria-label="Previous" onclick="paginate(currentPage -1)">
					        		<span aria-hidden="true">&laquo;</span>
					      		</a>
					    	</li>
					    	
					    	<c:set var="pageNumber" value="${fn:length(menuItems)/(pagination*1.0)}" />
					    	<fmt:formatNumber value='${pageNumber+(1-(pageNumber%1))%1}' type="number" pattern="#" var="pages"/>
					    	<c:forEach begin="1" end='${pages}' varStatus="loop">
					    		<li><a href="#" onclick="paginate(this.innerHTML)">${loop.index}</a></li>
					    	</c:forEach>
						    <li>
						      <a href="#" aria-label="Next" onclick="paginate(currentPage +1)">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
					  </ul>
					</nav>
					
				</c:if>
			</div>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>


<script>
	var currentPage =1;
	function paginate(page){
		var pages= ${pages}		
		if(page >0 && page <= pages){
			currentPage  = page;
			var pagination = ${pagination} ;
			var items = $("#listMenuItems > div");
			for(i=0; i< items.length;i++){
				if(i>= pagination*(currentPage -1) && i<= pagination*currentPage -1){
					items[i].className =  "panel panel-default" ; 
					
				}
				else{
					items[i].className ="hidden"
						
				}
			}
		}
		
	}
	
</script>
</body>


</html>