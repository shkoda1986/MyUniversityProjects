var prixEtext = 0.0;
var prixRtext = 0.0;

document.addEventListener("DOMContentLoaded", function(){
/*initialization des variables*/
var photoE = document.getElementById("imgE");
var photoR = document.getElementById("imgR");
var prixE = document.getElementById("X");
var prixR= document.getElementById("Y");	
var subtotal = document.getElementById("sousTotal");
var tax = document.getElementById("taxes");
var total = document.getElementById("total");
/*creation des objects*/
var vide = new objectResto("Vide", "images/vide.jpg", 0.00,"rien" );
var escargot = new objectResto("Escargot", "images/escargot.jpg", 4.95,"entree" );
var lasagne = new objectResto("Lasagne", "images/lasagne.jpg", 9.95,"repas" );
var salade = new objectResto("Salade", "images/salade.jpg", 5.95,"entree" );
var spaghetti = new objectResto("Spaghetti", "images/spaghetti.jpg", 8.95,"repas" );
//table des objects
var arr = [vide, salade, escargot, lasagne, spaghetti];
//fonction pour changer les images corespondant le plat choisi
var changeObject = function(){
 
    if(this.value =='1' && this.name == 'entree'){
		prixEtext = arr[0].prix;
		photoE.src = arr[0].photo;
		prixE.innerText = prixEtext.toFixed(2) + '$';
	}
	if(this.value =='1' && this.name == 'repas'){
		prixRtext = arr[0].prix;
		photoR.src = arr[0].photo;
		prixR.innerText = prixEtext.toFixed(2) + '$';
	}
	if(this.name == 'entree' && this.value == 2){
		  prixEtext = arr[1].prix;
		  photoE.src = arr[1].photo;
		  prixE.innerText = prixEtext.toFixed(2) + '$';
		 
	}
	if(this.name == 'entree' && this.value == 3){
		 photoE.src = arr[2].photo;
		 prixEtext = arr[2].prix;
		 prixE.innerText = prixEtext.toFixed(2) + '$';
	}
    if(this.name == 'repas' && this.value == 2){
		 photoR.src = arr[4].photo;
		 prixRtext = arr[4].prix;
		 prixR.innerText = prixRtext.toFixed(2) + '$';
	}
	if(this.name == 'repas' && this.value == 3){
		 photoR.src = arr[3].photo;
		 prixRtext = arr[3].prix;
		 prixR.innerText = prixRtext.toFixed(2) + '$';
	}
		subtotal.innerText = (prixEtext+prixRtext).toFixed(2) + '$';
		tax.innerText = ((prixEtext+prixRtext)*0.15).toFixed(2) + '$';
		total.innerText = ((prixEtext+prixRtext)*(1 + 0.15)).toFixed(2) + '$';
};
//fonction pour appeller les changements
var selects = document.querySelectorAll(".choose");
for (var i = 0; i < selects.length; i++) {
    selects[i].onchange = changeObject;
}

});
//fonction pour remplir select
function creationOption() {
    nameE = document.getElementById("entree");
    nameE.innerHTML='<option value="1">Choisir...</option><option value="2">Salade</option><option value="3">Escargot</option>';
    nameR = document.getElementById("repas");
    nameR.innerHTML='<option value="1">Choisir...</option><option value="2">Spaghetti</option><option value="3">Lasagne</option>';
      }

//constructeur des objects
function objectResto(name, photo, prix, sorte) {
  this.name = name;
  this.photo = photo;
  this.prix = prix;
  this.sorte = sorte;
}