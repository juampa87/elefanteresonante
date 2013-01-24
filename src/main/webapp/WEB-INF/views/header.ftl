
	
<#macro header selected>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Elefante</title>
	<link href='http://fonts.googleapis.com/css?family=Oswald:400,300' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Abel|Satisfy' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="/elefante/css/style.3.css"/>
	<link rel="stylesheet" href="/elefante/css/smoothness/jquery-ui-1.9.2.custom.min.css"/>
	<script src="/elefante/js/jquery-1.8.3.min.js"></script>
	<script src="/elefante/js/jquery-ui-1.9.2.custom.min.js"></script>
	</head>
	<body>
	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header" class="container">
				<div id="logo">
					<h1><a href="#">Elefante</a></h1>
				</div>
				<div id="menu">
					<ul>
						<li <#if selected=="projects">class="current_page_item"</#if>><a href="/elefante/project/projects?state=EN_PROCESO&responsable=&client=&service=&orderField=DATE&order=ASC">Proyectos </a></li>
						<li <#if selected=="users">class="current_page_item"</#if>><a href="/elefante/user/users">Usuarios </a></li>
						<li <#if selected=="clients">class="current_page_item"</#if>><a href="/elefante/client/clients">Clientes </a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- end #header -->
</#macro>