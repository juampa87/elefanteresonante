<html>
	<body>
		<#list users as user>
			<form action="delete" method="POST">
				${user.username}  
				<input type="hidden" name="oid" value="${user.id}"></input>
				<input type="submit" value="eliminar"></input>
			</form><br/>
		</#list>
	</body>
</html>