<#include "header.ftl">
<@header "none"/>
<script src="/elefante/js/addproject.js"></script>
	<!-- end #header -->
	<div id="page">
		<div class="principal-form-block form-block">
			<#if errors??>
				<div class="error-block">
					<#list errors as error>
						${error.message} <br/>
					</#list>
				</div>
			</#if>
			
			<form action=<#if !edit??> "/elefante/project/addproject" <#else> "/elefante/project/edit" </#if>  method="POST" accept-charset="UTF-8" >
				<#if project?? && edit??> <input type="hidden" name="id" value="${project.id}" /></#if>
				<ul>
					<#if project?? && project.referenceNumber??>
						<li>
				        	<label for="refNumber">N Ref:</label>
				            <input type="text" size="40" id="refNumber" value="${project.referenceNumber}"  readonly="readonly" />
				        </li>
			        </#if>
			        <li>
			        	<label for="name">Cliente:</label>
			        	<select name="client" id="client">
				        	<#list clients as client>
								<option value="${client.id}" <#if project?? && project.client.id==client.id>selected="selected"</#if> >${client.name}</option>
							</#list>
			            </select>
			        </li>
			        
			        <li>
			        	<label for="product">Producto:</label>
			            <input type="text" size="40" id="product" name="product" class="required" <#if project??> value="${project.product}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="billNumber">N Factura:</label>
			            <input type="text" size="40" id="billNumber" name="billNumber" <#if project?? && project.billNumber??> value="${project.billNumber}"</#if> />
			        </li>
			        
			        <li>
			        	<label for="responsable">Responsable:</label>
			        	<select name="responsable" id="responsable">
				        	<#list users as user>
								<option value="${user.id}" <#if project?? && project.responsable.id==user.id>selected="selected"</#if> >${user.username}</option>
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
			        	<label for="costs">Servicios:</label>
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
											${cost.ammount?c}
										</span>
										<span name="delete">
											<img src="/elefante/images/delete.png"/>
										</span>
										<input type="hidden" name="costs" value="${cost.description}-${cost.ammount?c}"></input>
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
											${charge.ammount?c}
										</span>
										<span name="delete">
											<img src="/elefante/images/delete.png"/>
										</span>
										<input type="hidden" name="charges" value="${charge.description}-${charge.ammount?c}"></input>
									</div>	
								</#list>
							</#if>
						</div>
					</li>
					
					
					<li>
			        	<label for="description">Descripci&oacute;n:</label>
			            <textarea cols="50" rows="5" id="description" name="description" ><#if project??>${project.description}</#if></textarea>
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

