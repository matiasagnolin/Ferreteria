$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
function recuperarFila(idfila) {
	console.log('aaa');
	var elTableRow = document.getElementById(idfila);
	var elTableCells = elTableRow.getElementsByTagName("td");
	
	document.getElementById("Descripcion").value=elTableCells[0].innerHTML;
	    document.getElementById("Minimo").value=elTableCells[1].innerHTML;
	    document.getElementById("Maximo").value=elTableCells[2].innerHTML;
	    document.getElementById("Porcentaje").value=elTableCells[3].innerHTML;
	    document.getElementById("Valor").value=elTableCells[4].innerHTML;
	    document.getElementById("Close_date").value=elTableCells[5].innerHTML;
	    document.getElementById("tipo").value=elTableCells[6].innerHTML;
	    
	    if(elTableCells[6].innerHTML==2)
	    	{
	    	document.getElementById("Close_date").disabled = true;
	    	document.getElementById("Maximo").disable = false;
	    	document.getElementById("Minimo").disable = false;
	    	document.getElementById("Valor").disabled = false;
	    	document.getElementById("Porcentaje").disabled = true;
	    	}
	    else if(elTableCells[6].innerHTML==1)
	    {
	    	document.getElementById("Close_date").disabled = true;
	    	document.getElementById("Maximo").disabled = true;
	    	document.getElementById("Minimo").disabled = true;
	    	document.getElementById("Valor").disabled = true;
	    	document.getElementById("Porcentaje").disabled = false;
	    }else{	    
	    	document.getElementById("Close_date").disabled = false;
	    	document.getElementById("Maximo").disabled = true;
	    	document.getElementById("Minimo").disabled = true;
	    	document.getElementById("Valor").disabled = false;
	    	document.getElementById("Porcentaje").disabled = true;
    	}
	}

