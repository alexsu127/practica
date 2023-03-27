// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("Terms");
var btn_ar = document.getElementById("Terms_ar");
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}
btn_ar.onclick = function() {
  modal.style.display = "block";
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

// Get the modal
var modal2 = document.getElementById("ModalButton");


// Get the <span> element that closes the modal
var span2 = document.getElementsByClassName("close")[1];

// When the user clicks on <span> (x), close the modal
span2.onclick = function() {
  modal2.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal2) {
    modal2.style.display = "none";
  }
}

function popUp(){
    
  if(!document.getElementById("subscribe").checked){
 
  document.getElementById("ModalButton").style.display = 'block';
  document.form.submit(); return false;
  }
}

function arabchange(){ var input = document.getElementById("language") ;
  input.value = "ar";
}

function frchange(){ var input = document.getElementById("language");
    input.value = "fr";
}



