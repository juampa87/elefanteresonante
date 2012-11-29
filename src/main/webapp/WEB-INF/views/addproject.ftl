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