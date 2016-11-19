<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Comisiones</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/static/Style.css" media="screen" />

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
<body ng-app="app">
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">
	        <img alt="Brand" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQoqFHxX1SRTRrU6vLie92-cPmfJvR5g5bpdZ8Y6uAaHZVS2LGk">
	      </a>
	    </div>
	  </div>
	</nav>
	<h1>VENTAS</h1>
  <div class="container grid">
		<div class="row grid-header">
			<div class="col-sm-2">Factura</div>
			<div class="col-sm-2">cliente</div>
			<div class="col-sm-2">Total</div>
			<div class="col-sm-2">Vendedor</div>
			<div class="col-sm-2">Fecha</div>
			<div class="col-sm-2"></div>
		</div>
		<c:set var="sum" value="0" />
		<c:set var="name" value="0" />
		<c:forEach items="${ventas}" var="item">
		<div class="row">
			<div class="col-sm-2" id="Id">${item.ID_Venta}</div>
			<div class="col-sm-2">${item.cliente}</div>
			<c:forEach items="${item.detalleventa}" var="item2">
				<c:set var="sum" value="${sum + item2.totalParcial}" />
				</c:forEach>
				<div class="col-sm-2">${sum}</div>
				<div class="col-sm-2">${item.vendedor}</div>	
				<div class="col-sm-2">${item.getFecha()}</div>
			<div class="col-sm-2"><a id="" href="${pageContext.request.contextPath}/${item.ID_Venta}">Ver Detalle</a></div>
			</div>			
			</c:forEach>
		</div>
	<input type="button" value="Calcular Comisiones" class="btn btn-success" Style="margin-left:80px" onClick="window.location = ${pageContext.request.contextPath}/Calcular">
	<p> ${pageContext.request.contextPath}/Calcular</p>
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
<script type="text/javascript"> var pageContext = '<%= request.getContextPath() %>';</script>
<script type="text/javascript"> console.log('<%= request.getContextPath() %>');</script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/app.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/PepeController.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/static/FormController.js"></script>


</html>
