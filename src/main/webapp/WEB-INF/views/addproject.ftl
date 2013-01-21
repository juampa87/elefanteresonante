<#include "header.ftl">
<@header "none"/>
<script src="/elefante/js/addproject.1.js"></script>
	<!-- end #header -->
	<div id="page">
		<div class="principal-form-block form-block">
			<div class="error-block <#if !errors??>hide </#if>">
				<#if errors??>
					<#list errors as error>
						${error.message} <br/>
					</#list>
				</#if>
			</div>
			
			
			<form action=<#if !edit??> "/elefante/project/addproject" <#else> "/elefante/project/edit" </#if>  method="POST" accept-charset="UTF-8" onsubmit="return validateForm()"  >
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
			        	<div id="costs-block">
			        		<div class="costs-head">
				        		<span>Servicios</span>
				        		<span class="amount">Importe</span>
			        		</div>
			        		<div id="costs-list">
								<#assign x = 0>
				        		<#if project?? && project.costs??>
					        		<#assign x = project.costs?size>
					        		<#list project.costs as cost>
							        	<div name="item">
								        	<span>
								            	<input type="text" size="25" name="item-description" value="${cost.description}" />
											</span>
											<span>
								            	<input type="text" size="10" name="item-amount" value="${cost.ammount?c}" />
											</span>
											
										</div>
									</#list>
								</#if>
								
								<#assign remain = 5-x >
								
								<#if remain &gt; 0>
									<#list 1..remain as i>
										<div name="item">
								        	<span>
								            	<input type="text" size="25" name="item-description" />
											</span>
											<span>
								            	<input type="text" size="10" name="item-amount" />
											</span>
										</div>
									</#list>  
								</#if>
							</div>
							<span id="add-cost">
								<img src="/elefante/images/add.png"/>
							</span>
							
						</div>
						<div id="charges-block">
							<div class="charges-head">
				        		<span>Gastos</span>
				        		<span class="amount">Importe</span>
			        		</div>
							<div id="charges-list">
								<#assign y = 0>
				        		<#if project?? && project.charges??>
					        		<#assign y = project.charges?size>
					        		<#list project.charges as charge>
							        	<div name="item">
								        	<span>
								            	<input type="text" size="25" name="item-description" value="${charge.description}" />
											</span>
											<span>
								            	<input type="text" size="10" name="item-amount" value="${charge.ammount?c}" />
											</span>
											
										</div>
									</#list>
								</#if>
								
								<#assign remain2 = 5-y >
								
								<#if remain2 &gt; 0>
									<#list 1..remain2 as j>
										<div name="item">
								        	<span>
								            	<input type="text" size="25" name="item-description" />
											</span>
											<span>
								            	<input type="text" size="10" name="item-amount" />
											</span>
										</div>
									</#list>  
								</#if>
							</div>
							<span id="add-charge">
								<img src="/elefante/images/add.png"/>
							</span>
						</div>
					</li>
					<div class="clearThis"></div>		
					
					
					<li>
			        	<label for="description">Descripci&oacute;n:</label>
			            <textarea cols="50" rows="5" id="description" name="description" ><#if project?? && project.description??>${project.description}</#if></textarea>
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

