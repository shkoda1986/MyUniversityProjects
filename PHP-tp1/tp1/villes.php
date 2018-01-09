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
<body>
 
  <!--L'entête-->
        <header>
                
            <h1>Informations Météorologiques</h1>
                
	<?php
	setlocale(LC_TIME, "fr_FR");//pour afficher en français
	 //foncthion pour afficher la date et l'heure 
	echo strftime("<h2>Le %A %d %B %Y - %k:%M:%S</h2>");
	?>
        </header>

    <hr class = 'style'/>

     <?php

  $ville= $_GET['ville'];
  //si le ville n'est pas choisir
  if($ville==null)
  {
        echo "<h3 class='red'>Il fault choisir la ville</h3>";
  }
 else {
      $ville=explode(",",$ville);//methode pour separer la ville
      $ville[1]=trim($ville[1]);
   
       echo '<h3>'.$ville[0].'</h3>';
       
  $line = "http://www-desi.iro.umontreal.ca/~shkodata/ift1147/tp1/1Qaz3Edc5Tgb/$ville[0].txt";

  $line = file($line.$ville[1]);//pour lire le fichier et fair un tableau
    //verifier si le fichier existe
    if(!$line)
    {
    echo "<p class='red'>Le fichier est introuvable</p>";
    }
    else {
    
    
//les valeurs
     $info = " ";
     $temp = " ";
     $humid = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     $vent = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
     $desc = " ";
	 
	 
    for($i=0;$i<sizeof($line);$i++)
   {
       $ligne=$line[$i];
	   $ligne=explode(":",$ligne);
	   
       if(stripos($ligne[0],"info")!==false)//Recherche la position de la première occurrence dans une chaîne
                {
           $info=$ligne[1];
           $info=trim($info);//pour supprimer les espaces
           $img=$info.".gif";
                }
         else if(stripos($ligne[0],"temp")!== false)
                {
            $temp="Température:".$ligne[1];
                      }
					  
      else if(stripos($ligne[0],"humidite")!==false)
                {
            $humid="Humidité:".$ligne[1];
                      }
       else if(stripos($ligne[0],"vent")!==false){
            $vent="Vent:".$ligne[1];
                      }
					  
       else if(stripos($ligne[0],"desc")!==false){
           $desc=$ligne[1];
                      }
   }
   
   //on fait le tableau
   echo"<table border='3'>";    
   echo"<tr><td colspan='3'><img alt='$info' src='images/$img'/><br/>$info</td></tr>";
   echo"<tr><td> $temp</td><td>$humid</td><td>$vent</td></tr>";
   echo"<tr><td colspan='3'>$desc</td></tr>";
   echo"</table>";
     
 }
}
  ?>

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