<html>
	<body>
		<#list projects as project>
			<form action="delete" method="POST">
				${project.id}  </br>
				${project.name}  </br>
				${project.referenceNumber}  </br>
				${project.creationDate}  </br>
				${project.responsable.username}  </br>
				${project.client.name}  </br>
				${project.product}  </br>
				${project.service}  </br>
				${project.total}  </br>
				${project.state}  </br>
				${project.description}  </br>
				
				<input type="hidden" name="oid" value="${project.id}"></input>
				<input type="submit" value="eliminar"></input>
			</form><br/>
		</#list>
	</body>
</html>