// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal btn.onclick =  
function doFunction(a) {
    modal.style.display = "block";
    var x = document.getElementsByTagName("input");
    for (var i = 0; i < x.length;i++) {
        if(x[i].name==a)
        	document.getElementById("hidden_valor").value=x[i].value;
    }
    alert(document.getElementById("hidden_valor").value);
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    
    
}