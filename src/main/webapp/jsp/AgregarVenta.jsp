<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COMISIONES POR VENDEDOR</title>
<script src="http://dl.dropbox.com/u/76575397/jQuery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    var MaxInputs       = 8; //Número Maximo de Campos
    var contenedor       = $("#contenedor"); //ID del contenedor
    var AddButton       = $("#agregarCampo"); //ID del Botón Agregar

    //var x = número de campos existentes en el contenedor
    var x = $("#contenedor div").length + 1;
    var FieldCount = x-1; //para el seguimiento de los campos

    $(AddButton).click(function (e) {
        if(x <= MaxInputs) //max input box allowed
        {
            FieldCount++;//<div><input type="text" name="mitexto[]" id="campo_'+ FieldCount +'" placeholder="Texto '+ FieldCount +'"/><a href="#" class="eliminar">&times;</a></div>
            //agregar campo <div class="form-group"> <input type="email" class="form-control" id="campo_'+ FieldCount +'" placeholder="Texto '+ FieldCount +'"/> </div> <div class="form-group"> <input type="password" class="form-control" id="campo_'+ FieldCount +'" placeholder="Texto '+ FieldCount +'"> <a href="#" class="eliminar">&times;</a> </div> </div>
            $(contenedor).append('<form:select path="Role_Usuario" class="selectpicker" data-style="btn-primary" ><c:forEach var="item" items="${productos}"><form:option  path="Role_Usuario" value="${item.getDescripcion}"><c:out value="${item.getDescripcion()}" /></form:option></c:forEach></form:select></div>');
            x++; //text box increment
        }
        return false;
    });

    $("body").on("click",".eliminar", function(e){ //click en eliminar campo
        if( x > 1 ) {
            $(this).parent('div').remove(); //eliminar el campo
            x--;
        }
        return false;
    });
});</script>
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
	<h1>Agregar Venta</h1>
	
<!-- 
	<div class="container grid">
		<div class="row grid-header">
		<c:forEach items="${Vendedores}" var="item">
			<div class="col-sm-2">${item.usuario}</div>
			<div class="col-sm-2">${item.usuario}</div>
			<div class="col-sm-2">${item.usuario}</div>
			</c:forEach>
		</div> -->
		<div class="container">
	<a id="agregarCampo" class="btn btn-info" href="#">Agregar Campo</a>	
	<form class="form-inline" role="form">
	<div id="contenedor">
		
	</div>
		<button type="submit" class="btn btn-default">Entrar</button>
	</form>

	</div>

	<div class="form-group">
									


</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script> 
</html>