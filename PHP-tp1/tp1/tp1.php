<!--Auteur: Tatsiana Shkoda
	Matricule: 20025283
	IFT 1147-A
	La date de création:25/05/2016-->
<!DOCTYPE html>
<html lang="fr-ca">
    <head>
        <meta charset="utf-8">
        <title>Travail Pratique #1</title>

        <!--le CSS-->
        <link rel="stylesheet" href="CSS.css" />
        
    </head>
  
    <body >
        <!--L'entête-->
        <header>
                
            <h1>Informations Météorologiques</h1>
                
            <?php
	setlocale(LC_TIME, "fr_FR");//pour afficher en français
	 //foncthion pour afficher la date et l'heure 
	echo strftime("<h2>Le %A %d %B %Y - %k:%M:%S</h2>");
	echo "<br>";
	?>
                
        </header>

    <main>
         <form action="villes.php" method="get" name ="villes_form"> 
              <label for="ville">Choix de la ville</label>
             <select name="ville" id="ville" size = "3">
			 
			 <?php
			 //lire le fichier ville.txt
$fichier = fopen("villes.txt", "r") or exit("Fichier est introuvable!");

while(!feof($fichier))
{
$ligne= fgets($fichier);//pour lire une ligne
$tok = strtok($ligne, ":;");//pour separer le nom de ville
$i = 0;
while ($tok !== false) {
if($i == 0){
   $i = 1;}
   else
	   if($i == 1){
		    echo '<option value="' . $tok . '">' . $tok . '</option>' . "\n";// une liste déroulante
		   $i = 2;
	   }
	  
$tok = strtok(":;");
}
}
fclose($fichier);

?>
			 
      </select>
     <p><input type="submit" value="Afficher la météo" ></p> 
     
    </form>
       <?php
		if (!empty ($_GET['ville'])) {echo $_GET['ville'];};
     ?>
    </main>
        
        <!--Validation sur W3C et le logo HTML5-->
        <footer>
             <hr>
            <p>Travail fait par: Tatsiana Shkoda   Matricule: 20025283   Login:shkodata</p>
            <div>
            <a href="http://validator.w3.org/check/referer"><img src="images/html5.png"  width="64" height="64" alt="HTML5" title="HTML5"/></a>
            <a href="http://jigsaw.w3.org/css-validator/check/referer"><img src="images/css3.png"  width="64" height="64" alt="CSS3" title="CSS3"/></a>
            </div>
        </footer>
    </body>
</html>
  