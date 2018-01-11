$(document).ready(     
    function () {    
        
        /* Toutes les cartes sont cachées lors du chargement initial */        
        $("main div div").hide();
        
        /* Événement de cliquer sur les titres de cartes dans la section principale */
        $("main div h2").click(toggleContent1);
 
        /* Événement de cliquer sur les titres de cartes dans la section de navigation */
        $("nav li a").click(toggleContent2);

        
    }
);

/* Pour afficher/cacher lorsqu'on clique sur le titre de la carte dans la section principale */
function toggleContent1() {
  var id = $(this).attr("id");   
  $("#" + id + " +   div").toggle();    
}


/* Pour afficher/cacher lorsqu'on clique sur le titre de la carte dans la section principale */
function toggleContent2() {
  var id = $(this).attr("href");   
  $(id + " +   div").toggle();    
}