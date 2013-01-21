<#include "header.ftl">
<@header "projects" />
<script src="/elefante/js/projects.js"></script>
	<!-- end #header -->
	<div id="page">
		<div class="table-block">
			<#if error?? >
				<div class="error-block">
								
				</div>
			</#if>
			<div>
				<a class="red-button" href="/elefante/project/addproject">Nuevo Proyecto</a>
			</div>
			<table id="box-table-a">
			    <thead>
			    	<tr>
			        	
			            <th scope="col">N.Ref</th>
				        <th scope="col">Creaci&oacute;n</th>
			            <th scope="col">Responsable</th>
			            <th scope="col">N.Fact</th>
			            <th scope="col">Cliente</th>
			            <th scope="col">Producto</th>
			            <th scope="col">Servicio</th>
			            <th scope="col">Total</th>
			            <th scope="col">Estado</th>
			            <th scope="col"></th>
			        </tr>
			    </thead>
			    <tbody>
					<#list projects as project>
				    	<tr>
				        	<td class="project-id hide">${project.id}</td>
				            <td style="width:55px">${project.referenceNumber}</td>
				            <td>${project.creationDate?string("dd-MM-yyyy")}</td>
				            <td>${project.responsable.username}</td>
				            <td style="max-width: 200px;word-wrap: break-word;"><#if project.billNumber??>${project.billNumber}<#else>-</#if></td>
				            <td>${project.client.name}</td>
				            <td "max-width: 200px;word-wrap: break-word;">${project.product}</td>
				            <td>${project.service.toString()}</td>
				            <td>${project.total?string("0.00")}</td>
				            <td class="${project.state.toString()}" >${project.state.toString()}</td>
				            <td name="actions">
				            	<span name="edit"><img src="/elefante/images/edit.png"/></span>
				            	<span name="delete"><img src="/elefante/images/delete.png"/></span>
				            	<#--<span name="add"><img src="/elefante/images/add.png"/></span>-->
				            	<span id="dialog-delete" class="hide">Borrar projecto?</span>
				            </td>
				        </tr>
					</#list>
			    </tbody>
			</table> 
			<div>
				<form class="search-block form-block" action="/elefante/project/projects">
					<span>
						<select name="state" tabindex="4">
							<option value="">Todos</option>
							<#list states as state>
								<option value="${state}" <#if stateParam?? && state.toString() == stateParam>selected="selected"</#if>>${state}</option>
							</#list>
						</select>
					</span>
					<span>
					<select name="responsable" tabindex="4">
						<option value="">Todos</option>
						<#list users as user>
							<option value="${user.id}" <#if responsableParam?? && user.id == responsableParam>selected="selected"</#if> >${user.username}</option>
						</#list>
					</select>
					</span>
					<span>
						<select name="client" tabindex="4">
							<option value="">Todos</option>
							<#list clients as client>
								<option value="${client.id}" <#if clientParam?? && client.id == clientParam>selected="selected"</#if>>${client.name}</option>
							</#list>
						</select>
					</span>
					<span>
					<select name="service" tabindex="4">
						<option value="">Todos</option>
						<#list services as service>
							<option value="${service}" <#if serviceParam?? && service == serviceParam>selected="selected"</#if> >${service}</option>
						</#list>
					</select>
					</span>
					<input type="submit"  value="Filtrar"></input>
				</form>
			</div>
		</div>
	</div>
	
	
<#include "footer.ftl">
