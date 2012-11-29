<html>
	<body>
		<#list clients as client>
			<form action="delete" method="POST">
				${client.id}  </br>
				${client.name}  </br>
				${client.address}  </br>
				${client.email}  </br>
				${client.tel}  </br>
				${client.tel2}  </br>
				${client.description}  </br>
				<input type="hidden" name="oid" value="${client.id}"></input>
				<input type="submit" value="eliminar"></input>
			</form><br/>
		</#list>
	</body>
</html>