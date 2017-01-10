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

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<div class="panel panel-default ">
						<div class="panel-body">
							<p>Afin de calculer notre "poids idéal", on peut utiliser plusieurs formules de calculs, nous retiendrons ici les principales :
							(cliquez sur le titre de la formule pour y accéder directement)</p>
							<ul>
							<li><a href="#monnerot">Formule de Monnerot-Dumaine</a></li>
							<li><a href="#Creff">Formule de Creff</a></li>
							<li><a href="#">Indice de Masse Corporelle (IMC)</a></li>
							<li><a href="#">Formule de Lorentz</a></li>
							</ul>	
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="panel panel-default" id="monnerot">
						<div class="panel-heading">
							1. Formule de Monnerot-Dumaine				
						</div>
						<div class="panel-body">
							<p>Ce calcul est à titre purement indicatif. L'ossature et la masse musculaire sont prises en compte dans cette formule, via la circonférence du poignet, afin d'obtenir un résultat plus proche de la realité. C'est certainement le calcul le plus "réaliste".</p>
							
						</div>
					</div>
				</div>
			
				<div class="col-md-3">
					<div class="panel panel-default" id="Creff">
						<div class="panel-heading">
							2. Formule de Creff			
						</div>
						<div class="panel-body">
							<p>Ce calcul est à titre purement indicatif. Il "améliore" la formule de Lorentz, en incluant la notion de morphologie.</p>
							
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-default" id="Creff">
						<div class="panel-heading">
							3. Indice de Masse Corporelle (IMC)			
						</div>
						<div class="panel-body">
							<p>Ce calcul est à titre purement indicatif. Il "améliore" la formule de Lorentz, en incluant la notion de morphologie.</p>
							
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-default" id="Creff">
						<div class="panel-heading">
							4. Formule de Lorentz			
						</div>
						<div class="panel-body">
							<p>Ce calcul est à titre purement indicatif. Il "améliore" la formule de Lorentz, en incluant la notion de morphologie.</p>
							
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<form class="form-horizontal" id="form">
					<div class="form-group ">
						<label class="control-label col-md-2 " for="height">Votre taille:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="email" placeholder="Enter email">
					    </div>
					
						<label class="control-label col-md-2" for="height">tour de poignet:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="email" placeholder="Enter email">
					    </div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 " for="height">Age:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="email" placeholder="Enter email">
					    </div>
						<label class="control-label col-md-2 " for="height">Poids:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="email" placeholder="Enter email">
					    </div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 " for="height">Morphologie:</label>
						<div class="col-md-2">
					      Radio button
					    </div>
						<label class="control-label col-md-2 " for="height">Sexe:</label>
						<div class="col-md-2">
					      Radio button
					    </div>
						
					</div>
					<div class="col-md-12 center-block">
    					<button type="button" id="singlebutton"  onclick="calculate();" class="btn btn-primary center-block">
        					Calculate
   						</button>
					</div>
				</form>
			</div>
		</div>
		
		<%@ include file="/jsp/layout/footer.jspf"%>
	</div> 
</body>

<script>
	$("#form input").change(calculate);
	
	function calculate(){
		//alert("coucou");
		var height = 1;
		var weight;
		var gender;
		var morphology;
		var wrist;
		var age;
		//for each combination call the right function
	}
	function IMC(height, weight){
		
	}
	
	function lorentz(){}
</script>
</html>