<#include "header.ftl">
<@header "clients" />
<script src="/elefante/js/clients.js"></script>
	<!-- end #header -->
	<div id="page">
		<div class="table-block">
			<#if error?? >
				<div class="error-block">
					No se puede borrar porque esta siendo usado por un proyecto.			
				</div>
			</#if>
			<div>
				<a class="red-button" href="/elefante/client/addclient">Nuevo Cliente</a>
			</div>
			<table id="box-table-a">
			    <thead>
			    	<tr>
			        	<th scope="col">ID</th>
			            <th scope="col">Nombre</th>
			            <th scope="col">Direcci&oacute;n</th>
			            <th scope="col">Email</th>
				        <th scope="col">Tel</th>
			            <th style="min-width: 37px;" scope="col">Tel 2</th>
			            <th scope="col">Descripci&oacute;n</th>
			            <th style="min-width: 51px;" scope="col"></th>
	
			        </tr>
			    </thead>
			    <tbody>
					<#list clients as client>
				    	<tr>
				        	<td class="client-id">${client.id}</td>
				            <td>${client.name}</td>
				            <td>${client.address}</td>
				            <td>${client.email}</td>
				            <td>${client.tel}</td>
				            <td>${client.tel2}</td>
				            <td>${client.description}</td>
				            <td name="actions">
				            	<span name="edit"><img src="/elefante/images/edit.png"/></span>
				            	<span name="delete"><img src="/elefante/images/delete.png"/></span>
				            	<span id="dialog-delete" class="hide">Borrar cliente?</span>
				            </td>
				        </tr>
					</#list>
			    </tbody>
			</table> 
		</div>
	</div>
	
	
<#include "footer.ftl">