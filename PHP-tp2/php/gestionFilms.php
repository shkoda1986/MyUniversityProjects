 <!--
Auteur: Tatsiana Shkoda
Matricule: 20025283
IFT 1147-A
TP 2
La date de création:18/06/2016
-->
<script language="javascript" src="..\js\JS.js"> </script>
 <link rel="stylesheet" href="..\css\CSS.css" />
 <?php
require_once("Films.php");

$tabFilms = array();
function enregistrerF()
{
	
	$numFilm = $_POST['numFilm'];
	$titre = $_POST['titre'];
	$realisateur = $_POST['realisateur'];
	$categorie = $_POST['categorie'];
	$duree = $_POST['duree'];
	$prix = $_POST['prix'];
	$empl_image = $_POST['empl_image'];
	$ligne=$numFilm.";".$titre.";".$realisateur.";".$categorie.";".$duree.";".$prix.";".$empl_image."\r\n";
	$f = fopen("../txt/films.txt", "a+");
	
	fputs($f, $ligne); 
	fclose($f);
	echo 'Le film a ete enregistrer!';
}

function retirerF()
{
	$num=trim($_POST['numFilm']);
	global $tabFilms;
	$fic=fopen("../txt/films.txt","r");
	$ligne=fgets($fic);
	while (!feof($fic)){
	$numFilm = strtok($ligne,";");
	$titre = strtok(";");
	$realisateur = strtok(";");
	$categorie = strtok(";");
	$duree = strtok(";");
	$prix = strtok(";");
	$empl_image = strtok("\t");

	$tabFilms[]= new Film($numFilm,$titre,$realisateur,$categorie,$duree,$prix,$empl_image);
	$ligne=fgets($fic);
	}
	fclose($fic);

	$taille=count($tabFilms);

	$j=0;
	for($i=0;$i<$taille;$i++)
	{ 
	if($tabFilms[$i]->getNumFilm()===$num)
	{
	echo $tabFilms[$i];
	$j=1;
	return $tabFilms[$i];}
	}
	if($j==0)
	{echo "Cette numero du film n'existe pas!";
	return null;}
	}
function supprimer($num){
	$tmp=fopen("../txt/tmp.txt","a");
	$fic=fopen("../txt/films.txt","r");
	$tab=array();
	$ligne=fgets($fic);
	fputs($tmp,$ligne);
	$ligne=fgets($fic);
	while(!feof($fic)){
		$tab=explode(";",$ligne);
		if($tab[0]!==$num)
		     fputs($tmp,$ligne);
		$ligne=fgets($fic);
	}//fin while
	fclose($fic);
	fclose($tmp);
	unlink("../txt/films.txt");
	rename("../txt/tmp.txt","../txt/films.txt");
}
function echange(){
	
	$film=retirerF();
	
	if ($film==null)
	    echo "<br><br>Cette numero du film introuvable<br><br>";
	else {
		echo "<form name=\"enregistrerFilm\" action=\"gestionFilms.php\" method=\"post\">\n"; 
		echo "   Numero du film : <input type=\"text\" id=\"numFilm\" name=\"numFilm\" value=\"".$film->getNumFilm()."\" readonly></br>\n"; 
		echo "   Titre : <input type=\"text\" id=\"titre\" name=\"titre\" value=\"".$film->getTitre()."\"></br>\n"; 
		echo "   Realisateur : <input type=\"text\" id=\"realisateur\" name=\"realisateur\" value=\"".$film->getRealisateur()."\"></br>\n"; 
		echo "   Categorie : <input type=\"text\" id=\"categorie\" name=\"categorie\" value=\"".$film->getCategorie()."\"></br>\n"; 
		echo "   Duree : <input type=\"text\" id=\"duree\" name=\"duree\" value=\"".$film->getDuree()."\"></br>\n"; 
		echo "   Prix :  <input type=\"text\" id=\"prix\" name=\"prix\" value=\"".$film->getPrix()."\"></br>\n";
		echo "   Emplacement de image de la pochette du film :  <input type=\"text\" id=\"empl_image\" name=\"empl_image\" value=\"".$film->getEmpl_image()."\"></br>\n";		
		echo "   \n"; 
		echo "   <input type=\"hidden\" name=\"action\" value=\"Modifier\">\n";
		echo "   <input type=\"hidden\" name=\"etat\" value=\"maj\">\n"; 	
		echo "   <input type=\"button\" value=\"Enregistrer\" onClick=\"valider();\">\n"; 
		echo "</form>\n";
	}
}
function listerF(){
	global $tabFilms;
	$fic=fopen("../txt/films.txt","r");
	$ligne=fgets($fic);
	while (!feof($fic)){
	$numFilm = strtok($ligne,";");
	$titre = strtok(";");
	$realisateur = strtok(";");
	$categorie = strtok(";");
	$duree = strtok(";");
	$prix = strtok(";");
	$empl_image = strtok("\t");

	$tabFilms[]= new Film($numFilm,$titre,$realisateur,$categorie,$duree,$prix,$empl_image);
	$ligne=fgets($fic);
	}
	fclose($fic);

	echo"<h1>Les Films</h1>";
	echo "<aside>";
	echo"<ul id = Action>Action</ul>";
	echo"<ul id = Drame>Drame et repertoire</ul>";
	echo"<ul id = Comedie>Comedie</ul>";
	echo"<ul id = Science-fiction>Science-fiction</ul>";
	echo"<ul id = Horreur>Horreur</ul>";
	echo"<ul id = Comedies musicales>Comedies musicales</ul>";
	echo"<ul id = Pour la famille>Pour la famille</ul></aside>";
	echo "<table>";		
	$taille=count($tabFilms);
	
	for($i=0;$i<$taille;$i++)
	{
		echo "<tr>";
		for($k = 0; $k<5; $k++){
		echo "<td>".$tabFilms[$i]."</td>";
		$i++;}
		$i--;
		echo "</tr>";
	
	}
	
	echo "</table>";
	echo "</body></html>";
}
$action=$_POST['action'];

switch($action){
	case "Enregistrer" :
		enregistrerF();
				
	break;
	case "Retirer" :
	     $numFilm=trim($_POST['numFilm']);
	     	$ff = retirerF();
		
	break;
	case "Modifier" :
		
		   $etat=$_POST['etat'];
		if ($etat=="Retirer")
			echange();
		else {
		    $num=$_POST['numFilm'];
			
			supprimer($num);
		    enregistrerF();
		   
		}
	break;	   
	case "Lister" :
	     
	     listerF();
	     
	   
		
	;
		
		   
}
echo "<br><br><p><a href=\"../index.html\">Retour a la page accueil</a></p>";

?>