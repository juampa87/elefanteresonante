<#include "header.ftl">
<@header "users" />
<script src="/elefante/js/users.js"></script>
	<!-- end #header -->
	<div id="page">
		<div class="table-block">
			<#if error?? >
				<div class="error-block">
					No se puede borrar porque esta siendo usado por un proyecto.			
				</div>
			</#if>
			<div>
				<a class="red-button" href="/elefante/app/user/adduser">Nuevo Usuario</a>
			</div>
			<table id="box-table-a">
			    <thead>
			    	<tr>
			        	<th scope="col">ID</th>
			            <th scope="col">Username</th>
			            <th style="min-width: 51px;" scope="col"></th>
			        </tr>
			    </thead>
			    <tbody>
					<#list users as user>
				    	<tr>
				        	<td class="user-id">${user.id}</td>
				            <td>${user.username}</td>
				            <td name="actions">
				            	<span name="delete"><img src="/elefante/images/delete.png"/></span>
				            	<span id="dialog-delete" class="hide">Borrar usuario?</span>
				            </td>
				        </tr>
					</#list>
			    </tbody>
			</table> 
		</div>
	</div>
	
	
<#include "footer.ftl">