<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>VENDEDORES</h1>
	  <div class="container grid">
		<div class="row grid-header">
			<div class="col-sm-3">Descripcion</div>
			<div class="col-sm-1">minimo</div>
			<div class="col-sm-1">maximo</div>
			<div class="col-sm-2">Porcentaje</div>
			<div class="col-sm-2">valor</div>
			<div class="col-sm-2">close_date</div>
			<div class="col-sm-1">tipo</div>
		</div>
		<c:forEach items="${Comision}" var="item">
		<div class="row">
			<div class="col-sm-3" id="Id">${item.getDescripcion()}</div>
			<div class="col-sm-1">${item.getMinimo()}</div>
			<div class="col-sm-1">${item.getMaximo()}</div>
			<div class="col-sm-2">${item.getPorcentaje()}</div>
			<div class="col-sm-2">${item.getValor()}</div>
			<div class="col-sm-2">${item.getClose_date()}</div>
			<div class="col-sm-1">${item.getTipo()}</div>
			</div>			
			</c:forEach>
		</div>
		</br>
  <div class="container grid">
		<div class="row grid-header">
			<div class="col-sm-2">Producto</div>
			<div class="col-sm-2">Precio Unitario</div>
			<div class="col-sm-2">Cantidad</div>
			<div class="col-sm-2">SubTotal</div>
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
		<input type="button" value="Ventas" class="btn btn-success" Style="margin-left:80px" onClick="window.location = ${pageContext.request.contextPath}/">
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</html>