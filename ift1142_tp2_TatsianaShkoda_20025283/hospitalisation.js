/*Travail fait par Tatsiana Shkoda 20025283*/
//initialization des tables format JSON
var  tabPatients = [
	{"dossier":1, "nom":"Leger", "prenom":"Emile", "naissence":"26 mars 1917", "sexe":"M"},
	{"dossier":2, "nom":"Bernard", "prenom":"Marie", "naissence":"3 fevrier 1946", "sexe":"F"},
	{"dossier":3, "nom":"Chartrand", "prenom":"Guy", "naissence":"5 avril 1959", "sexe":"M"},
	{"dossier":4, "nom":"Cote", "prenom":"Andre", "naissence":"2 septembre 1978", "sexe":"M"},
	{"dossier":5, "nom":"Lavoie", "prenom":"Carole", "naissence":"4 novombre 1973", "sexe":"F"},
	{"dossier":6, "nom":"Martin", "prenom":"Diane", "naissence":"2 decembre 1965", "sexe":"F"},
	{"dossier":7, "nom":"Lacroix", "prenom":"Pauline", "naissence":"25 janvier 1956", "sexe":"F"},
	{"dossier":8, "nom":"St-Jean", "prenom":"Arthur", "naissence":"7 octobre 1912", "sexe":"M"},
	{"dossier":9, "nom":"Bechard", "prenom":"Marc", "naissence":"8 aout 1980", "sexe":"M"},
	{"dossier":10, "nom":"Chartrand", "prenom":"Mario", "naissence":"23 juillet 1943", "sexe":"M"},
]

var  tabEtablissements = [
	{"etablissement":1234, "nom":"Centre hospitalier Sud", "adresse":"1234 boul.Sud,Montreal,QC", "codePostal":"H2M 3W6", "telephone":"(514)121-1234"},
	{"etablissement":2346, "nom":"Hopital Nord", "adresse":"7562 rue du Souvenir, Nordville,QC", "codePostal":"J4K 2ZS", "telephone":"(450)222-3333"},
	{"etablissement":3980, "nom":"Hopital Centre", "adresse":"4637 boul.de l'Eglise,Montreal,QC", "codePostal":"H3J 4K8", "telephone":"(554)123-5678"},
	{"etablissement":4177, "nom":"Centre hospitalier Est", "adresse":"12 rue Bernard,Repentigny,QC", "codePostal":"J6R 3K5", "telephone":"(450)589-2345"},
	{"etablissement":7306, "nom":"Hopital du salut", "adresse":"11 rue de la Redemption, St-Basile,QC", "codePostal":"J8H 2D4", "telephone":"(450)345-6789"},
	{"etablissement":8895, "nom":"Dernier recours", "adresse":"999 rue St-Pierre,Longueuil,QC", "codePostal":"J7E 3J5", "telephone":"(450)555-6741"},
]

var  tabHospitalisations = [
	{"codeEtablissement":1234, "noDossierPatient":5, "dateAdmission":"14-aout-00", "dateSortie":"14-aout-01", "specialite":"medecine"},
	{"codeEtablissement":1234, "noDossierPatient":10, "dateAdmission":"12-dec-92", "dateSortie":"12-dec-92", "specialite":"chirurgie"},
	{"codeEtablissement":2346, "noDossierPatient":8, "dateAdmission":"03-mars-03", "dateSortie":"05-mars-03", "specialite":"medecine"},
	{"codeEtablissement":2346, "noDossierPatient":1, "dateAdmission":"11-nov-97", "dateSortie":"12-nov-97", "specialite":"orthopedie"},
	{"codeEtablissement":2346, "noDossierPatient":3, "dateAdmission":"12-avr-95", "dateSortie":"30-avr-95", "specialite":"medecine"},
	{"codeEtablissement":3980, "noDossierPatient":5, "dateAdmission":"14-fevr-00", "dateSortie":"14-mars-00", "specialite":"medecine"},
	{"codeEtablissement":3980, "noDossierPatient":5, "dateAdmission":"01-janv-01", "dateSortie":"01-fevr-01", "specialite":"medecine"},
	{"codeEtablissement":3980, "noDossierPatient":9, "dateAdmission":"03-avr-95", "dateSortie":"08-avr-95", "specialite":"orthopedie"},
	{"codeEtablissement":3980, "noDossierPatient":7, "dateAdmission":"27-nov-99", "dateSortie":"04-dec-99", "specialite":"chirurgie"},
	{"codeEtablissement":3980,"noDossierPatient":10, "dateAdmission":"28-avr-97", "dateSortie":"05-mai-97", "specialite":"chirurgie"},
	{"codeEtablissement":4177,"noDossierPatient":3, "dateAdmission":"03-aout-01", "dateSortie":"05-dec-01", "specialite":"medecine"},
	{"codeEtablissement":4177,"noDossierPatient":3, "dateAdmission":"02-fevr-02", "dateSortie":"23-fevr-02", "specialite":"orthopedie"},
	{"codeEtablissement":7306,"noDossierPatient":2, "dateAdmission":"23-mai-98", "dateSortie":"27-mai-98", "specialite":"orthopedie"},
]
var dossier, nom, prenom, naissence, sexe, etablissement, adresse, codePostal, telephone;
//fonction onClick pour reagir a clicker sur les boutones
function divVisible(leDiv){
    //ici on peut faire visible ou non les tableux
	//il faut juste clicker 2 fois par une boutone
	if(document.getElementById(leDiv).style.visibility=='hidden')
	document.getElementById(leDiv).style.visibility='visible';
else document.getElementById(leDiv).style.visibility='hidden';
	
	switch(leDiv){
		case 'listePatients':
			document.getElementById('listeEtablissement').style.visibility='hidden';
			document.getElementById('listeHospitalisations').style.visibility='hidden';
			document.getElementById('formEtab').style.visibility='hidden';
			document.getElementById('codeEtab').style.visibility='hidden';
			afficheTabPatiants();
		break;
		case 'listeEtablissement':
			document.getElementById('listePatients').style.visibility='hidden';
			document.getElementById('listeHospitalisations').style.visibility='hidden';
			document.getElementById('formEtab').style.visibility='hidden';
			document.getElementById('codeEtab').style.visibility='hidden';
			afficheTabEtablissements();
		break;
		case 'listeHospitalisations':
			document.getElementById('listePatients').style.visibility='hidden';
			document.getElementById('listeEtablissement').style.visibility='hidden';
			document.getElementById('formEtab').style.visibility='hidden';
			document.getElementById('codeEtab').style.visibility='hidden';
			afficheTabHospitalisations();
		break;
		case 'formEtab':
			document.getElementById('listePatients').style.visibility='hidden';
			document.getElementById('listeEtablissement').style.visibility='hidden';
			document.getElementById('listeHospitalisations').style.visibility='hidden';
			document.getElementById('codeEtab').style.visibility='hidden';
			afficheSelect();
			var hideList = document.getElementById("opt");
			while (hideList.firstChild) {
			hideList.removeChild(hideList.firstChild);
			}
		break;
		case 'codeEtab':
			document.getElementById('listePatients').style.visibility='hidden';
			document.getElementById('listeEtablissement').style.visibility='hidden';
			document.getElementById('listeHospitalisations').style.visibility='hidden';
			document.getElementById('formEtab').style.visibility='hidden';
			var specialiteObj = document.getElementById('specialite');
			specialiteObj.style.display = "none"; 
			afficheSelectDeux();
			var hideList = document.getElementById("spec");
			while (hideList.firstChild) {
				hideList.removeChild(hideList.firstChild);
				}
		break;

	}
}

//fonction pour afficher TabPatiants
function afficheTabPatiants(){
	var listePat = document.getElementById("listePatients");
	while (listePat.firstChild) {
      listePat.removeChild(listePat.firstChild);
		}
	var table = document.createElement('table');
	listePat.appendChild(table);
	var tr = document.createElement('tr');
	table.appendChild(tr);
	tr.innerHTML+="<th>"+ "Dossier"  + "</th>" + "<th>" + "Nom" + "</th>" + "<th>" + "Prenom" + "</th>" + "<th>" + "Date de Nessence" + "</th>" + "<th>" + "Sexe" + "</th>";
	for (var i in tabPatients){
			tr = document.createElement('tr');
			table.appendChild(tr);
			var th = document.createElement('th');
			tr.innerHTML+="<th>"+tabPatients[i].dossier + "</th>"+ "<th>"+tabPatients[i].nom + "</th>"+ "<th>"+tabPatients[i].prenom+ "</th>" + "<th>"+tabPatients[i].naissence+ "</th>" + "<th>"+tabPatients[i].sexe+ "</th>";	
	}
}
//fonction pour afficher TabEtablissments
function afficheTabEtablissements(){
	var listeEtabl = document.getElementById("listeEtablissement");
	while (listeEtabl.firstChild) {
      listeEtabl.removeChild(listeEtabl.firstChild);
		}
	var table = document.createElement('table');
	listeEtabl.appendChild(table);
	var tr = document.createElement('tr');
	table.appendChild(tr);
	tr.innerHTML+="<th>"+ "Etablissement"  + "</th>" + "<th>" + "Nom" + "</th>" + "<th>" + "Adresse" + "</th>" + "<th>" + "Code Postal" + "</th>" + "<th>" + "Telephone" + "</th>";
	for (var i in tabEtablissements){
			tr = document.createElement('tr');
			table.appendChild(tr);
			var th = document.createElement('th');
			tr.innerHTML+="<th>"+tabEtablissements[i].etablissement + "</th>"+ "<th>"+tabEtablissements[i].nom + "</th>"+ "<th>"+tabEtablissements[i].adresse+ "</th>" + "<th>"+tabEtablissements[i].codePostal+ "</th>" + "<th>"+tabEtablissements[i].telephone+ "</th>";	
	}
}
//fonction pour afficher TabHospitalisations
function afficheTabHospitalisations(){
var listeHosp = document.getElementById("listeHospitalisations");
	while (listeHosp.firstChild) {
      listeHosp.removeChild(listeHosp.firstChild);
    }
	var table = document.createElement('table');
	listeHosp.appendChild(table);
	var tr = document.createElement('tr');
	table.appendChild(tr);
	tr.innerHTML+="<th>"+ "Code"  + "</th>" + "<th>" + "Numero de dossier" + "</th>" + "<th>" + "Date Admission" + "</th>" + "<th>" + "Date Sortie" + "</th>" + "<th>" + "Specialite" + "</th>";
	for (var i in tabHospitalisations){
			tr = document.createElement('tr');
			table.appendChild(tr);
			var th = document.createElement('th');
			tr.innerHTML+="<th>"+tabHospitalisations[i].codeEtablissement + "</th>"+ "<th>"+tabHospitalisations[i].noDossierPatient + "</th>"+ "<th>"+tabHospitalisations[i].dateAdmission+ "</th>" + "<th>"+tabHospitalisations[i].dateSortie+ "</th>" + "<th>"+tabHospitalisations[i].specialite+ "</th>";	
	}
}
//fonction qui affiche Select
function afficheSelect(){
	var patientObj = document.getElementById('etablissement');
	while (patientObj.firstChild) {
      patientObj.removeChild(patientObj.firstChild);
    }
	var patientLen = tabPatients.length;
	var selLen = patientObj.options.length;
	var lastPatient = "";
	patientObj.options[0] = new Option ("Choisissez dossier");
		selLen ++;
	for (var i=1; i <= patientLen; i++) {
        var t = tabPatients[i-1];
        
		if (lastPatient != t.dossier) {
			
            patientObj.options[selLen++] = new Option(t.dossier);
            lastPatient = t.dossier;
        }
    }

}
//fonction qui affiche une liste hospitalisations par patiants selon la critere choisi
function remplirTabPatient(dossierChoisi){

var hideList = document.getElementById("opt");

	while (hideList.firstChild) {
      hideList.removeChild(hideList.firstChild);
    }
	var table = document.createElement('table');
	hideList.appendChild(table);
	var tr = document.createElement('tr');
	table.appendChild(tr);
	tr.innerHTML+="<th>"+ "Dossier"  + "</th>" + "<th>" + "Nom" + "</th>" + "<th>" + "Prenom" + "</th>" + "<th>" + "Date de Nessence" + "</th>" + "<th>" + "Sexe" + "</th>";
	for (var i in tabPatients){
			tr = document.createElement('tr');
			table.appendChild(tr);
			var th = document.createElement('th');
			if (tabPatients[i].dossier == dossierChoisi.value)
			tr.innerHTML+="<th>"+tabPatients[i].dossier + "</th>"+ "<th>"+tabPatients[i].nom + "</th>"+ "<th>"+tabPatients[i].prenom+ "</th>" + "<th>"+tabPatients[i].naissence+ "</th>" + "<th>"+tabPatients[i].sexe+ "</th>";	
	}
	dossierChoisi.selectedIndex = 0;
}
//fonction qui affiche le select par code Establissment
function afficheSelectDeux(){
	var etabObj = document.getElementById('codeEtablissement');
	while (etabObj.firstChild) {
      etabObj.removeChild(etabObj.firstChild);
    }
	
	var etabLen = tabEtablissements.length;
	var selLen = etabObj.options.length;
	var lastEtab = "";
	etabObj.options[0] = new Option ("Choisissez code");
		selLen ++;
	for (var i=1; i <= etabLen; i++) {
        var t =  tabEtablissements[i-1];
        if (lastEtab != t.etablissement) {
            etabObj.options[selLen ++] = new Option(t.etablissement);
            lastEtab = t.etablissement;
        }
    }
}
//fonction qui affiche le select par specialite
function onchangeSelect() {
	var hideSpec = document.getElementById('specialiteSel');
	while (hideSpec.firstChild) {
      hideSpec.removeChild(hideSpec.firstChild);
    }
	var codeEtablObj = document.getElementById('codeEtablissement');
    var specialiteObj = document.getElementById('specialite');
    var currentCode = codeEtablObj.value;
    if (currentCode == "") {
        specialiteObj.style.display = "none"; 
    } else {
        var specialitelSelObj = document.getElementById('specialiteSel');
      
        var hospLen = tabHospitalisations.length; 
        var selLen = specialitelSelObj.options.length;
        specialitelSelObj.options[0] = new Option ("Choisissez specialite");
		selLen ++;
		for (var i=0; i < hospLen; i++) {
            var t = tabHospitalisations[i];
			var e = tabEtablissements;	
			if (currentCode == t.codeEtablissement && specialitelSelObj.options[selLen-1].value != t.specialite){
				specialitelSelObj.options[selLen ++] = new Option(t.specialite);
				}
				
			 }
        specialiteObj.style.display = "block"; 
    }
}
//fonction qui affiche une liste des patiants par etablissment et par specialite selon les criteres choisis
function remplirTable2(specialiteChoisi){
	var codeEtablObj = document.getElementById('codeEtablissement');
	var specialiteBesoin = specialiteChoisi.value;
	var codeEtablBesoin = codeEtablObj.value;
	var t = document.getElementById("spec");
	while (t.firstChild) {
      t.removeChild(t.firstChild);
    }

	var table = document.createElement('table');
	t.appendChild(table);
	var tr = document.createElement('tr');
	table.appendChild(tr);
	tr.innerHTML+="<th>"+ "Code"  + "</th>" + "<th>" + "Numero de dossier" + "</th>" + "<th>" + "Date Admission" + "</th>" + "<th>" + "Date Sortie" + "</th>" + "<th>" + "Specialite" + "</th>";
	for (var i in tabHospitalisations){
			tr = document.createElement('tr');
			table.appendChild(tr);
			var th = document.createElement('th');
			if (tabHospitalisations[i].codeEtablissement == codeEtablBesoin && tabHospitalisations[i].specialite == specialiteBesoin)
			tr.innerHTML+="<th>"+tabHospitalisations[i].codeEtablissement + "</th>"+ "<th>"+tabHospitalisations[i].noDossierPatient + "</th>"+ "<th>"+tabHospitalisations[i].dateAdmission+ "</th>" + "<th>"+tabHospitalisations[i].dateSortie+ "</th>" + "<th>"+tabHospitalisations[i].specialite+ "</th>";	
	}
	
}