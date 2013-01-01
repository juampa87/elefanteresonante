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
			<form action="/elefante/app/user/adduser"   method="POST" accept-charset="UTF-8" >
				<ul>
			        <li>
			        	<label for="name">Nombre de usuario:</label>
			            <input type="text" size="40" id="username" name="username"/>
			        </li>
			        
				</ul>
				
			    <p>
			        <button type="submit" class="action">Aceptar</button>
			    </p>
			    
			</form>
		</div>
	</div>
	<!-- end #page --> 
	
<#include "footer.ftl">
