$(document).ready(function(){
	$('span[name="delete"]').click(remove);
});

function remove(){
	var tr = $(this).parents('tr');
	var clientId = tr.find('td.user-id').text();
    $( "#dialog-delete" ).dialog({
        resizable: false,
        height:300,
        modal: true,
        buttons: {
            "Borrar": function() {
            	var s = '<form action="/elefante/user/delete" method="POST">'; 
            		s += '<input type="hidden" name="oid" value="' 
            	        + clientId 
            	        + '" /> </form>'; 
            	var $form = $(s).appendTo('body'); 
            	$form.submit(); 
                $( this ).dialog( "close" );
            },
            "Cancelar": function() {
                $( this ).dialog( "close" );
            }
        }
    });
}