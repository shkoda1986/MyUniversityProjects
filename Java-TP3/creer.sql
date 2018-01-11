-- auteur Tatsiana Shkoda
-- Matricule: 20025283
-- TP3: Bibliographie (partie 3)
-- 
-- Dans ce fichier vous trouverez les instructions SQL pour 
-- créer les 2 tables  nécessaires pour traiter les livres et  les auteurs
--
-- login="shkodata"
-- passwd="zWU2T7NcfN+g_M"
-- access to DB : use shkodata_test;

-- comme j'ai deja utilisé ce BDD pour tester ma application
-- vous devez supprimer les tables Auteur et Livre avant de faire la creation

-- les instructions pour supprimer les tables Auteur et Livre

DROP TABLE Auteur;
DROP TABLE Livre;


-- Creation des tables

-- Table Auteur
-----------------------

CREATE TABLE  Auteur
(
 Nom varchar(40),
 Code int(3),
 Pays varchar(30),
 primary key(Code)
);

-- Table Livre
-----------------------

CREATE TABLE  Livre
(
 Nom varchar(40),
 codeLivre int(3),
 codeAuteur int(3),
 Categorie varchar(30),
 nbPages int(5),
 Prix double(5,2),
 primary key(codeLivre)
);