<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMISIONES POR VENDEDOR</title>


	<!-- Jquery -->
	
	<style type="text/css">
		.grid{
			margin-bottom: 20px;
		}
		.row:nth-child(even) {background-color: #f2f2f2}
		
		.grid-header{
			background-color: #69bf6c;
    		color: white;
		}
		.navbar-brand img{
			width: 27px;
		}
		.add-pet{
			max-width: 500px;
		}
	</style>
</head>
<body>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        <img alt="Brand" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQoqFHxX1SRTRrU6vLie92-cPmfJvR5g5bpdZ8Y6uAaHZVS2LGk">
	      </a>
	    </div>
	  </div>
	</nav>
<h1>Comisiones por vendedor</h1>

  <div class="container grid">
		<div class="row grid-header">
			<div class="col-sm-2">Nombre</div>
			<div class="col-sm-2">Usuario</div>
			<div class="col-sm-2">Cantidad de ventas</div>
			<div class="col-sm-2">Comision a cobrar</div>
		</div>
		<c:forEach items="${Vendedores}" var="item">
		<div class="row">
			<div class="col-sm-2" id="Id">${item.getNombre_Persona()}</div>
			<div class="col-sm-2">${item.usuario}</div>
			<div class="col-sm-2">${item.getCantVentas()}</div>
			<div class="col-sm-2">${item.getComision()}</div>
			</div>			
			</c:forEach>
		</div>
		<form  id="Calcular" action="${pageContext.request.contextPath}/Home" >
		<input type="submit" value="Ventas" class="btn btn-success" Style="margin-left:80px">
		</form>

</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	
	<!-- AngularJS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
		
	<!-- Complementos JS para Bootstrap -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-route.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-route.js"></script>

</html>