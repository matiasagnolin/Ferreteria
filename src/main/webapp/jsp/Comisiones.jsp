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
	<style type="text/css"> 
 
table {cursor: pointer} 
 
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
	<h1>Comisiones</h1>

		<table class="table table-hover">
    <thead>
      <tr>
        <th>Descripcion</th>
		<th>minimo</th>
		<th>maximo</th>
		<th>Porcentaje</th>
		<th>valor</th>
		<th>close_date</th>
		<th>tipo</th>
	</tr>
    </thead>
    <tbody>
    <c:forEach items="${Comision}" var="item">
      <tr  id="${item.getDescripcion()}" onclick="recuperarFila(this.id)" >
        <td>${item.getDescripcion()}</td>
        <td>${item.getMinimo()}</td>
        <td>${item.getMaximo()}</td>
        <td>${item.getPorcentaje()}</td>
        <td>${item.getValor()}</td>
        <td>${item.getClose_date()}</td>
        <td>${item.getTipo()}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  
  <form:form class="form-inline"  action="${pageContext.request.contextPath}/ActualizarComision" method="post"  modelAttribute="command" >
  <div class="form-group">
    <form:input path="Descripcion" type="hidden" class="form-control" id="Descripcion" name="descripcion" />
    </div>
  <div class="form-group">
  <form:label path="minimo">minimo</form:label> 
    <form:input path="minimo" type="text" class="form-control" id="Minimo" name="Minimo" />
  </div>
  <div class="form-group">
  <form:label path="maximo">maximo</form:label>
    <form:input path="maximo" type="text" class="form-control" id="Maximo"  name="Maximo" />
  </div>
  <div class="form-group">
  <form:label path="Porcentaje">Porcentaje</form:label>
    <form:input  path="Porcentaje" type="text" class="form-control" id="Porcentaje" name="Porcentaje" />
  </div>
  <div class="form-group">
  <form:label path="valor">valor</form:label>
    <form:input path="valor" type="text" class="form-control" id="Valor" name="Valor" />
  </div>
    <form:input path="create_date" type="hidden" class="form-control" id="create_date" name="create_date" />
  <div class="form-group">
  <form:label path="close_date">close_date</form:label>
    <form:input path="close_date" type="text" class="form-control" id="Close_date" name="Close_date" />
  </div>
  <form:input path="tipo" type="hidden" class="form-control" id="tipo" name="tipo" />
  </br>
  </br>
  <input style="margin-left: 500px"type="submit" class="btn btn-primary btn-lg" value="ACTUALIZAR">
</form:form>
  <form  id="Calcular" action="${pageContext.request.contextPath}/Home" >
		<input type="submit" value="Ventas" class="btn btn-success" Style="margin-left:80px">
		</form>
  <!-- 
		<h1>Vendedores</h1>
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
		
		
		 -->

		
		
		
		
		
		
		
		
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script type="text/javascript" src="static/javascript.js"></script>
</html>