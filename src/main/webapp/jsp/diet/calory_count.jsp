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
							<p>Formule : </p>
							<p class="hidden">Result : <span id="monnerot_result"></span></p>
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
							<p>Formule : </p>
							<p class="hidden">Result : <span id="creff_result"></span></p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-default" id="Creff">
						<div class="panel-heading">
							3. Indice de Masse Corporelle (IMC)			
						</div>
						<div class="panel-body">
							<p>Ce calcul est à titre purement indicatif. Seuls le poids et la taille sont pris en compte, ce qui rend le résultat moins proche de la réalité, en comparaison des formules précédentes.</p>
							<p>Formule  :</p>
							<p class="hidden">Result : <span id="imc_result"></span><br/> Description : <span id="imc_description"></span></p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-default" id="lorentz">
						<div class="panel-heading">
							4. Formule de Lorentz			
						</div>
						<div class="panel-body">
							<p>Ce calcul est à titre purement indicatif, il prend en compte uniquement la taille et le sexe.</p>
							<p class="formule">Formule : </p>
							<p class="hidden"> Result : <span id="lorentz_result"></span></p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<form class="form-horizontal" id="form">
					<div class="form-group ">
						<label class="control-label col-md-2 " for="height">Votre taille:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="height" placeholder="175">
					    </div>
					
						<label class="control-label col-md-2" for="wrist">tour de poignet:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="wrist" placeholder="25">
					    </div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 " for="age">Age:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="age" placeholder="33">
					    </div>
						<label class="control-label col-md-2 " for="weight">Poids:</label>
						<div class="col-md-2">
					      <input type="text" class="form-control" id="weight" placeholder="70.5">
					    </div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-2 " for="morphology">Morphologie:</label>
						<div class="col-md-2">
					    	<label class="radio-inline"><input type="radio" value="small" name="morphology">Mince</label>
					    	<label class="radio-inline"><input type="radio" value="normal" name="morphology">Normale</label>
					    	<label class="radio-inline"><input type="radio" value="large" name="morphology">Large</label>
					    </div>
						<label class="control-label col-md-2 " for="height">Gender:</label>
						<div class="col-md-2">
					    	<label class="radio-inline"><input type="radio" value="M" name="gender">Male</label>
					    	<label class="radio-inline"><input type="radio" value="F" name="gender">Female</label>
					    </div>
						
					</div>
					<div class="col-md-12 center-block">
    					<button type="button" id="singlebutton"  onclick="calculate();" class="btn btn-default center-block">
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
		var height = $("#height").val();
		var weight= $("#weight").val();
		var gender = $("input[name='gender']:checked").val();;
		var morphology = $("input[name='morphology']:checked").val();
		var wrist = $("#wrist").val();
		var age = $("#age").val();
		
		var lorentz_result = lorentz(height , gender);
		$("#lorentz_result").text(lorentz_result);
		$("#lorentz_result").parent().attr('class','');
		
		
		var creff_result = creff(age , height , morphology);
		$("#creff_result").text(creff_result);
		$("#creff_result").parent().attr('class','');
		
		
		var imc_result = IMC( height , weight);
		$("#imc_result").text(imc_result[0]);
		$("#imc_description").text(imc_result[1]);
		$("#imc_result").parent().attr('class','');
		
		var monnerot_result = monnerot(height,wrist);
		$("#monnerot_result").text(monnerot_result);
		$("#monnerot_result").parent().attr('class','');
	}
	function IMC(height, weight){
		if($.isNumeric(height)){
			height = parseInt(height)/100.;
			if($.isNumeric(weight)){
				weight = parseFloat(weight);
				var imc = weight /(height*height);
				imc= imc.toFixed(2);
				if(imc < 19.5){
					return [imc , "holly molly you should eat more"];
				}
				else if(imc <25){
					return [imc , "Great ,keep it up"];
				}
				else if(imc <30){
					return [imc , "You are fat"];
				}
				else{
					return [imc , "Stop eating and exercise you fat f**k"];
				}
			}
			else{
				return ["Weight should be a number", "No description"];
			}
		}
		else{
			return ["Height should be a number", "No description"];
		}
	}
	
	function lorentz(taille , gender){
		var a ;
		if(gender=="M"){
			a = 4.;
		}
		else if(gender == "F"){
			a = 2.5;
		}
		else{
			return "Not recognized gender";
		}
		
		if($.isNumeric(taille)){
			taille = parseInt(taille);
			var result  = (taille - 100) - ((taille - 150) / a);
			return result.toFixed(2);
		}
		else{
			return "The height you entered is not a number";
		}
	}
	
	function creff(age, height, morphology){
		if(morphology == "small"){
			coeff = 0.9;
		}
		else if(morphology == "normal"){
			coeff = 1;
		}
		else if(morphology == "large"){
			coeff = 1.1;
		}
		else {
			return "Undefined morphology" ; 
		}
		
		if($.isNumeric(height) && $.isNumeric(age)){
			height = parseInt(height);
			age = parseInt(age);
			var result =  (height - 100 + age / 10. ) * coeff ; 
			return result.toFixed(2);
		}
		else {
			return "Enter number values for height and age";
		} 
	}
	function monnerot(height , wrist){
		if($.isNumeric(height) && $.isNumeric(wrist)){
			height = parseInt(height);
			wrist = parseFloat(wrist);
			var result = (height -100 + (4*wrist))/2 ;
			return result;
		}
		else{
			return "Invalid height or wrist values" ;
		}
	}
</script>
</html>