/*
Auteur: Tatsiana Shkoda
Matricule: 20025283
IFT 1147-A
TP 2
La date de création:18/06/2016
*/
function valider()
{
var numFilm = document.getElementById('numFilm').value;
var titre = document.getElementById('titre').value;
var realisateur = document.getElementById('realisateur').value;
var categorie = document.getElementById('categorie').value;
var duree = document.getElementById('duree').value;
var prix = document.getElementById('prix').value;
var empl_image = document.getElementById('empl_image').value;

if(numFilm == "" || titre == "" || realisateur == "" || categorie == "" ||
    duree == "" || prix == "" || empl_image == "" ){
alert("Vous n'avez pas rempli toutes les champs !");
return false;
}
enregistrerFilm.submit();//envoyer les données au serveur
}

function retirer()
{
 retirerFilm.submit();//envoyer les données au serveur
}

function modifier()
{
	
 modifierFilm.submit();//envoyer les données au serveur
}


function lister()
{
 listerFilm.submit();//envoyer les données au serveur
}

