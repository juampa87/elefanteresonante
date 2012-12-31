<#include "header.ftl">
<@header "none"/>
	<!-- end #header -->
	<div id="page">
		<div class="principal-form-block form-block">
			<#if errors??>
				<div class="error-block">
					<#list errors as error>
						${error.message}
					</#list>
				</div>
			</#if>
			<form action=<#if !edit??> "/elefante/app/client/addclient" <#else> "/elefante/app/client/edit" </#if>  method="POST" accept-charset="UTF-8" >
				<#if client?? && edit??> <input type="hidden" name="id" value="${client.id}" /></#if>
				<ul>
			        <li>
			        	<label for="name">Nombre:</label>
			            <input type="text" size="40" id="name" name="name" <#if client??> value="${client.name}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="address">Direcci&oacute;n:</label>
			            <input type="text" size="40" id="address" name="address" <#if client??> value="${client.address}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="email">Email:</label>
			            <input type="email" size="40" id="email" name="email" <#if client??> value="${client.email}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="tel">Tel&eacute;fono:</label>
			            <input type="text" size="40" id="tel" name="tel" <#if client??> value="${client.tel}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="tel2">Tel&eacute;fono Secundario:</label>
			            <input type="text" size="40" id="tel2" name="tel2" <#if client??> value="${client.tel2}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="description">Descripci&oacute;n:</label>
			            <textarea cols="50" rows="5" id="description" name="description" ><#if client??>${client.description}</#if></textarea>
					</li>
				</ul>
				
			    <p>
			        <button type="submit" class="action"><#if !edit??>Aceptar<#else>Guardar</#if></button>
			    </p>
			    
			</form>
		</div>
	</div>
	<!-- end #page --> 
	
<#include "footer.ftl">
