$(document).ready(function(){
	$('span[name="delete"]').click(remove);
	$('span[name="edit"]').click(edit);
});

function remove(){
	var tr = $(this).parents('tr');
	var projectId = tr.find('td.project-id').text();
    $( "#dialog-delete" ).dialog({
        resizable: false,
        height:300,
        modal: true,
        buttons: {
            "Borrar": function() {
            	var s = '<form action="/elefante/project/delete" method="POST">'; 
            		s += '<input type="hidden" name="oid" value="' 
            	        + projectId 
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

function edit(){
	var tr = $(this).parents('tr');
	var projectId = tr.find('td.project-id').text();
	var s = '<form action="/elefante/project/edit" method="GET">'; 
	s += '<input type="hidden" name="oid" value="' 
        + projectId 
        + '" /> </form>'; 
	var $form = $(s).appendTo('body'); 
	$form.submit(); 
}