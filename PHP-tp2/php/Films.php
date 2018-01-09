<!--
Auteur: Tatsiana Shkoda
Matricule: 20025283
IFT 1147-A
TP 2
La date de création:18/06/2016
-->
<script language="javascript" src="..\js\JS.js"></script>
<link rel="stylesheet" href="..\css\CSS.css">
<?php

class Film{

private $numFilm;
private $titre;
private $realisateur;
private $categorie;
private $duree;
private $prix;
private $empl_image;

//function __construct(){};
function __construct($numFilm, $titre, $realisateur, $categorie, $duree, $prix, $empl_image){
$this->setNumFilm($numFilm);
$this->setTitre($titre);
$this->setRealisateur($realisateur);
$this->setCategorie($categorie);
$this->setDuree($duree);
$this->setPrix($prix);
$this->setEmpl_image($empl_image);
}


function getNumFilm(){
 return $this->numFilm;
}
function getTitre(){
 return $this->titre;
}
function getRealisateur(){
 return $this->realisateur;
}
function getCategorie(){
 return $this->categorie;
}
function getDuree(){
 return $this->duree;
}
function getPrix(){
 return $this->prix;
}
function getEmpl_image(){
 return $this->empl_image;
}


function setNumFilm($numFilm){
$this->numFilm=$numFilm;
}
function setTitre($titre){
$this->titre=$titre;
}
function setRealisateur($realisateur){
$this->realisateur=$realisateur;
}
function setCategorie($categorie){
$this->categorie=$categorie;
}
function setDuree($duree){
$this->duree=$duree;
}
function setPrix($prix){
$this->prix=$prix;
}
function setEmpl_image($empl_image){
$this->empl_image=$empl_image;
}

public function __toString()
{
    return "<br>"."<img src=../images/".$this->empl_image."/>"."</br>"."<br>".$this->titre."</br>"."<br>".$this->realisateur."</br>"."<br>".$this->prix." CAD </br>";
    
    /*return "<br>La filme cherche:</br> <br>Numero du film: ".$this->numFilm."</br>"."<br>Titre du film: ".$this->titre."</br>". 
    "<br>Realisateur: ".$this->realisateur."</br>"."<br>Categorie: ".$this->categorie."</br>"."<br>La duration: ".$this->duree." min. 
    </br>"."<br>Le prix: ".$this->prix." CAD </br>"."<br>"."<img src=\images\".$this->empl_image."/>"."</br>";*/
}
}?>
