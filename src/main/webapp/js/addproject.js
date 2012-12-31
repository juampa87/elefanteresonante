$(document)
		.ready(
				function() {
					$('#costs-block span[name="delete"], #charges-block span[name="delete"] ').live('click', removeItem);
					$("#add-cost").click(
									function() {

										var description = $(
												"#cost-description")
												.val();
										var amount =$(
												"#cost-amount")
												.val();
											
					
										//Hay from y to en el rango
										if((description && $.trim(description) !="")&&(amount && $.trim(amount) !="" && isANumber(amount))){
											var value = "";
											value=value.concat(description + "-").concat(amount+ "-");
											//Ahora armamos lo que se ve en la pantalla					
											var htmlTpl='<div name="item"><span class="item-description">'+description+'</span><span class="item-amount">'+amount+'</span>	<span name="delete"><img src="/elefante/images/delete.png"/></span><input type="hidden" name="costs" value="'+description+'-'+amount+'"></input></div>';
											
											$("#costs-block").append(htmlTpl);
											
																					
										}
										
									});
					
					$("#add-charge").click(
							function() {

								var description = $(
										"#charge-description")
										.val();
								var amount =$(
										"#charge-amount")
										.val();
									
			
								//Hay from y to en el rango
								if((description && $.trim(description) !="")&&(amount && $.trim(amount) !=""&& isANumber(amount))){
									var value = "";
									value=value.concat(description + "-").concat(amount+ "-");
									//Ahora armamos lo que se ve en la pantalla					
									var htmlTpl='<div name="item"><span class="item-description">'+description+'</span><span class="item-amount">'+amount+'</span>	<span name="delete"><img src="/elefante/images/delete.png"/></span><input type="hidden" name="charges" value="'+description+'-'+amount+'"></input></div>';
									
									$("#charges-block").append(htmlTpl);
									
																			
								}
								
							});
					
					function removeItem(){
						var me = $(this),
						el = me.parents('div[name="item"]');
						el.remove();
					}
					
					function isANumber(number){
						return (Math.floor(number) == number && $.isNumeric(number));
					}
				});