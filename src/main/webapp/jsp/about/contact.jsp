<%@ include file="/jsp/layout/init.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact us</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='shortcut icon'
	href='${pageContext.request.contextPath}/favicon.ico'
	type='image/x-icon' />

<%@ include file="/jsp/layout/meta.jspf"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
    <style>
      #map-container { height: 300px }
    </style>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="/jsp/layout/banner-header.jspf"%>
		<div class="row">
			<div class="col-md-4 ">
				<ul class="list-group">
					<li class="list-group-item active"><strong>Physician name</strong> : John Doe</li>
					<li class="list-group-item"><strong>Affiliated clinic</strong> : Clinic C#</li>
					<li class="list-group-item"><strong>Open Hours</strong> : 08h - 15h00</li>
					<li class="list-group-item">Closed On weekends</li>
					<li class="list-group-item"><strong>Address </strong> : 4545 , Mc street Avenue , Derpinton, CA</li>
				</ul>
			</div>
	    	<div id="map-container" class="col-md-8 "></div>
	    </div>
	    
	    <%@ include file="/jsp/layout/footer.jspf"%>
	</div>
    <script src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyDmkDkxuojZNJydF_n0yVqZp7nepAMP__E"></script>
    <script>	
 
      function init_map() {
		var var_location = new google.maps.LatLng(45.4996114,-73.6415929);
 
        var var_mapoptions = {
          center: var_location,
          zoom: 15
        };
 
		var var_marker = new google.maps.Marker({
			position: var_location,
			map: var_map,
			title:"Venice"});
 
        var var_map = new google.maps.Map(document.getElementById("map-container"),
            var_mapoptions);
 
		var_marker.setMap(var_map);	
 
      }
 
      google.maps.event.addDomListener(window, 'load', init_map);
 
    </script>
</body>
</html>