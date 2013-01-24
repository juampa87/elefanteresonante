$(document)
		.ready(
				function() {
					$("#add-cost").click(
							function() {
								//Ahora armamos lo que se ve en la pantalla					
								var htmlTpl='<div name="item"><span><input type="text" size="25" name="item-description" /></span><span><input type="text" size="10" name="item-amount" /></span></div>';
								$("#costs-list").append(htmlTpl);
							});
					
					$("#add-charge").click(
							function() {
								//Ahora armamos lo que se ve en la pantalla					
								var htmlTpl='<div name="item"><span><input type="text" size="25" name="item-description" /></span><span><input type="text" size="10" name="item-amount" /></span></div>';
								$("#charges-list").append(htmlTpl);
							});
					
				});

function validateForm(){
	$('.error-block').empty();
	$('.error-block').hide();
	var costs = $('#costs-list div[name="item"]');
	var costsValidation=validateItems(costs);
	var charges = $('#charges-list div[name="item"]');
	var chargesValidation=validateItems(charges);
	
	
	if(!costsValidation || !chargesValidation){
		$('.error-block').append("Se debe llenar el campo descripcion y el campo importe de los costos y cargos. El importe debe ser un numero");
		$('.error-block').show();
		$('html, body').animate({scrollTop: '0px'}, 300);
		return false;
	}
	
	addHiddenInputs(costs,"costs");
	addHiddenInputs(charges,"charges");
}

function validateItems(items){
	var validateOk = true;
	items.each(function(i){
		var description = $(this).find('input[name="item-description"]').val();
		var amount = $(this).find('input[name="item-amount"]').val();
		if(description && $.trim(description) !="" || (amount && $.trim(amount) !="")){
			if(!description || $.trim(description) =="" || !amount || $.trim(amount) =="" ||!isANumber(amount) ){
				validateOk=false;
				return false;
			}
		}
	});
	return validateOk;
}

function addHiddenInputs(items,where){
	items.each(function(i){
		var value = "";
		var description = $(this).find('input[name="item-description"]').val();
		var amount = $(this).find('input[name="item-amount"]').val();
		//no verificamos todo porq ya se valida en la funcion validateItems
		if(description && $.trim(description)!=""){
			value=value.concat(description + "-").concat(amount+ "-");
			//Ahora armamos lo que se ve en la pantalla					
			var htmlTpl='<input type="hidden" name="'+where+'" value="'+description+'-'+amount+'"></input>';
			$("#"+where+"-block").append(htmlTpl);			
		}
		
	});
}

function isANumber(number){
	return $.isNumeric(number);
}