<!--
<html>
	<body>
		
			<form action="/elefante/app/project/addproject"  method="POST" accept-charset="UTF-8">
				name: <input type="text" name="name"><br>
				reference_number: <input type="text" name="referenceNumber"><br>
				responsable:
				<select name="responsable" tabindex="4">
					<#list users as user>
						<option value="${user.id}">${user.username}</option>
					</#list>
				</select><br>	
				client: 
				<select name="client" tabindex="4">
					<#list clients as client>
						<option value="${client.id}">${client.name}</option>
					</#list>
				</select><br>
				product:<input type="text" name="product"><br>
				service:
				<select name="service" tabindex="4">
					<#list services as service>
						<option value="${service}">${service}</option>
					</#list>
				</select><br>
				total:	
				<input type="text" name="total"><br>
				state:
				<select name="state" tabindex="4">
					<#list states as state>
						<option value="${state}">${state}</option>
					</#list>
				</select><br>
				description:<input type="text" name="description"><br>		
				<input type="submit" value="Submit">
			</form>
		
	</body>
</html>
-->

<#include "header.ftl">
<@header "none"/>
<script src="/elefante/js/addproject.js"></script>
	<!-- end #header -->
	<div id="page">
		<div class="principal-form-block form-block">
			<form action=<#if !project??> "/elefante/app/project/addproject" <#else> "/elefante/app/project/edit" </#if>  method="POST" accept-charset="UTF-8" >
				<#if project??> <input type="hidden" name="id" value="${project.id}" /></#if>
				<ul>
			        <li>
			        	<label for="name">Cliente:</label>
			        	<select name="client" id="client">
				        	<#list clients as client>
								<option value="${client.id}" <#if project?? && project.client==client.id></#if> >${client.name}</option>
							</#list>
			            </select>
			        </li>
			        
			        <li>
			        	<label for="product">Producto:</label>
			            <input type="text" size="40" id="product" name="product" <#if project??> value="${project.product}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="responsable">Responsable:</label>
			        	<select name="responsable" id="responsable">
				        	<#list users as user>
								<option value="${user.id}" <#if project?? && project.responsable==user.id>selected="selected"</#if> >${user.username}</option>
							</#list>
			            </select>
			        </li>
			        <li>
			        	<label for="service">Servicio:</label>
			            <select id="service" name="service" tabindex="4">
							<#list services as service>
								<option value="${service}" <#if project?? && project.service==service>selected="selected"</#if>  >${service}</option>
							</#list>
						</select>
			        </li>
			        
			        <li>
			        	<label for="state">Estado:</label>
			            <select id="state" name="state" tabindex="4">
							<#list states as state>
								<option value="${state}" <#if project?? && project.state==state>selected="selected"</#if> >${state}</option>
							</#list>
						</select>
			        </li>
			        
			        <li>
			        	<label for="costs">Costos:</label>
			        	<span>
			            	<input type="text" size="30" id="cost-description" />
						</span>
						<span>
			            	<input type="text" size="10" id="cost-amount" />
						</span>
						<span id="add-cost">
							<img src="/elefante/images/add.png"/>
						</span>
						<div id="costs-block">
							<#if project?? && project.costs??>
								<#list project.costs as cost>
									<div name="item">
										<span class="item-description">
											${cost.description}
										</span>
										<span class="item-amount">
											${cost.description}
										</span>
										<span name="delete">
											<img src="/elefante/images/delete.png"/>
										</span>
										<input type="hidden" name="costs" value="${cost.description}-${cost.description}"></input>
									</div>	
								</#list>
							</#if>
						</div>
					</li>
					
					<li>
			        	<label for="costs">Cargos:</label>
			        	<span>
			            	<input type="text" size="30" id="charge-description" />
						</span>
						<span>
			            	<input type="text" size="10" id="charge-amount" />
						</span>
						<span id="add-charge">
							<img src="/elefante/images/add.png"/>
						</span>
						<div id="charges-block">
							<#if project?? && project.charges??>
								<#list project.charges as charge>
									<div name="item">
										<span class="item-description">
											${charge.description}
										</span>
										<span class="item-amount">
											${charge.description}
										</span>
										<span name="delete">
											<img src="/elefante/images/delete.png"/>
										</span>
										<input type="hidden" name="charges" value="${charge.description}-${charge.description}"></input>
									</div>	
								</#list>
							</#if>
						</div>
					</li>
					
					
					<li>
			        	<label for="description">Descripci&oacute;n:</label>
			            <textarea cols="50" rows="5" id="description" name="description" ><#if project??>${project.description}</#if></textarea>
					</li>
					
				
			        <!--
			        
			        <li>
			        	<label for="tel2">Tel&eacute;fono Secundario:</label>
			            <input type="text" size="40" id="tel2" name="tel2" <#if client??> value="${client.tel2}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="description">Descripci&oacute;n:</label>
			            <textarea cols="50" rows="5" id="description" name="description" ><#if client??>${client.description}</#if></textarea>
					</li>
					-->
				</ul>
				
			    <p>
			        <button type="submit" class="action"><#if !client??>Aceptar<#else>Guardar</#if></button>
			    </p>
			    
			</form>
		</div>
	</div>
	<!-- end #page --> 
	
<#include "footer.ftl">

