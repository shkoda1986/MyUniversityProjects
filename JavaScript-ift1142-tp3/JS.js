/*Travail fait par Tatsiana Shkoda 20025283*/
//initialization des tables format JSON
var  tabProduits = [
	{"code":1, "nom":"The 300 Spartans", "description":"Film historique", "prix":"20.99", "image":"images/11.jpg"},
	{"code":2, "nom":"The Notebook", "description":"Film mélodramatique", "prix":"30.99", "image":"images/12.jpg"},
	{"code":3, "nom":"Happy Feet", "description":"Dessin animé", "prix":"22.99", "image":"images/13.jpg"},
	{"code":4, "nom":"Just Go With It", "description":"Comédie", "prix":"28.99", "image":"images/14.jpg"},
	
]
//methode pour cree la liste des produits
window.onload = 
function what(){
	var liste = document.getElementById("crime");
	var table = document.createElement('table');
	var checkbox = document.createElement('input');
	    checkbox.type = "checkbox";
		checkbox.name = "name";
		checkbox.value = "value";
		
	liste.appendChild(table);
	for (var i in tabProduits){
		checkbox.id = tabProduits[i].code;
		var	th = document.createElement('th');
			th.appendChild(checkbox);
			table.appendChild(th);
			var tr = document.createElement('tr');
			th.innerHTML+="<tr>" +"</br>" + "<img src=" + tabProduits[i].image +">" + "</br>"+tabProduits[i].nom + "</br>" + tabProduits[i].prix+ " CAD" + "</br>" + "</tr>";
						
	}
};
//fonction onclick pour ajouter a panier
function ajouter_panier(){
	var i = 1, sum =0;
	for(i; i <= tabProduits.length; i++){
		if(document.getElementById(""+i).checked) {
			sum+= parseFloat(tabProduits[i-1].prix);
		}
	}
	if(sum == 0) alert("Vouz devez choisir un ou plus produits!");
	else
	alert("Votre achates totales: " + sum + " CAD");
	
}
//fonction pour generer la date de mise a jour
function getDate()
{
    var date = new Date();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
	var day = date.getDate();
	var month = date.getMonth();
	var year = date.getFullYear();
   
    if(seconds < 10)
    {
        seconds = '0' + seconds;
    }
	
    document.getElementById('timedisplay').innerHTML = day + '/' + month + '/' + year+ '  ' +hours + ':' + minutes;
}
setInterval(getDate, 0);
//fonction pour valider la forme	
	function validateForm() {
    var lastName = document.forms["myForm"]["nom"].value;
	var firstName = document.forms["myForm"]["prenom"].value;
	var tel = document.forms["myForm"]["tel"].value;
	var mail = document.forms["myForm"]["courriel"].value;
	var city = document.forms["myForm"]["ville"].value;
	var zipCode = document.forms["myForm"]["codp"].value;
	
    if (lastName == "" || firstName == "" || tel == "" || mail == "" || city == "" || zipCode == "") {
        alert("Remplissez toutes les champs");
        return false;
    } else {
		window.open('mailto:' + mail+ '?subject=Courriel ete envoye&body=Salut');
	  	}
}
