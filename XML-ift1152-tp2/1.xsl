<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
   
   
    <!-- pour generee une sortie HTML-->
    <xsl:output
        method="html"
        indent="yes"
        encoding="utf-8" />
    
    
  <!-- regle XSLT pour noeud racine-->  
    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></meta>
                <title> Tp2 - IFT1152</title>
                <link href="tp2.css" rel="stylesheet"></link>
            </head>
            <body>
                 <header>
                        <h1> Travail pratique 2 - IFT1152 </h1>
                   </header>
                <main>
                   
                    
                    <!--traiter des enfants du noeud courant et changer l'ordre-->
                    <table>
                        <xsl:copy>
                            <xsl:apply-templates select="geospatialdata/dataInfo" />
                            <xsl:apply-templates select="geospatialdata/spatialRepresentationInfo" />
                            <xsl:apply-templates select="geospatialdata/distributionInfo" />
                         </xsl:copy>
                    </table>
                </main>
                <footer> Tous droits réservés © Shkoda Tatsiana - Hiver 2016</footer>
            </body>
        </html>
    </xsl:template>
    
 
    
   <!--regle XSLT--> 
    <xsl:template match="dataInfo">
    
        <!--titre-->    
        <h2>
            <xsl:value-of select="title" />
        </h2>
        
        
        
        <tr><th colspan="2"> Métadonnées </th></tr>
       
       
        <tr>
            <th>Titre abrégé</th>
            <td>
                <xsl:value-of select="alternateTitle" />
            </td>
        </tr>
        
        
        
        <tr>
            <th> Description </th>
            <td>
                <xsl:value-of select="description" />
            </td>
        </tr>
       
       
       
        <tr>
            <th>Sujets</th>
            <td>
                <!--Iteration pour faire la list -->
                <ul>
                    <xsl:for-each select="keywords/keyword" >
                        <li> <xsl:value-of select="." /></li>
                    </xsl:for-each>
                </ul>
            </td>
        </tr>
        
        
        
        <tr>
            <th>Auteur </th>
            <td>
                <xsl:value-of select="responsibleOrganisation/organisationName" />   
            </td>
        </tr>
        
    </xsl:template>
    
    
    
   <!-- regle XSLT--> 
    <xsl:template match="spatialRepresentationInfo">
      
        <tr><th colspan="2"> Données géospatiales </th></tr>
     
     
     <!--instruction conditionnelle multiple pour choisir le bon type de representation spatiale-->
        <tr>
            <th>Type de représentation spatiale</th>
            <td><xsl:choose>
                <xsl:when test="type = 'grid'">matricielle</xsl:when>
                <xsl:otherwise>vectorielle</xsl:otherwise>
            </xsl:choose></td>
        </tr>
       
       
        <tr>
            <th> Nombre d'objets géometriques </th>
            <td><xsl:for-each select="referenceSystemIdentifier" >
                 <xsl:value-of select="." /><br/>
            </xsl:for-each>
            </td>
            
        </tr><br/>
        
        
      <!--Instruction conditionnelle-->
            <xsl:if test="geometricObjects != ''"> 
                <tr>
                <th> Identifiant du système de référence </th>
                <td>
                    <xsl:value-of select="geometricObjects/count" />
                    (<xsl:value-of select="geometricObjects/type" />)
                </td>
            </tr>
            </xsl:if>
           
           
        <!--instruction conditionnelle multiple pour choisir le bon image et instruction conditionnelle
        pour verifier s'il existe l'element "legend"-->
        <xsl:if test="//legend">
        <xsl:choose>
            <xsl:when test=" contains(legend/@img,'fiche2')"> 
                <tr>
                    <th> Légende </th>
                    <td>
                        <img src="legends/fiche2.png" ></img>
                    </td>
                </tr>
            </xsl:when>
            <xsl:otherwise>
                <tr>
                    <th> Légende </th>
                    <td>
                        <img src="legends/fiche4.png" ></img>
                    </td>
                </tr>
            </xsl:otherwise>
        </xsl:choose>
            </xsl:if>
        
        
        
        <tr>
            <th> Échelles (dénominateur) </th>
            <td><xsl:value-of select="scale" /></td>
        </tr>
        
        
        
    <!-- instruction conditionnelle -->    
            <xsl:if test="resolutionDistance != ''"> 
        <tr>
            <th>Distance au sol</th>
            <td>
                <xsl:value-of select="resolutionDistance"/>
                <xsl:value-of select="resolutionDistance/@unit"/>
               </td>
        </tr>
            </xsl:if>
      
       
       
        <tr>
            <th>Étendue temporelle</th>
            <td> de <xsl:value-of select="temporalExtent/begin" /> à <xsl:value-of select="temporalExtent/end" /></td>
        </tr>
        
        
        
        <!--instruction conditionnelle multiple pour choisir le bon image-->
        <tr>
            <th>Boîte géographique</th>
            
            <xsl:choose>
                <xsl:when test=" contains(preview/@url,'fiche1')"> 
            <td> <img src="previews/fiche1.png" ></img> </td>
                </xsl:when>
                <xsl:when test=" contains(preview/@url,'fiche2')"> 
                    <td> <img src="previews/fiche2.png" ></img> </td>
                </xsl:when>
                <xsl:when test=" contains(preview/@url,'fiche3')"> 
                    <td> <img src="previews/fiche3.png" ></img> </td>
                </xsl:when>
                <xsl:otherwise>
                    <td> <img src="previews/fiche4.png" ></img> </td>
                </xsl:otherwise>
            </xsl:choose>
                       
        </tr>
    </xsl:template>  
    
    
    
    <!--derniere regle XSLT-->
    <xsl:template match="distributionInfo">
      
        <tr><th colspan="2"> Contact </th></tr>
       
        
        <tr>
            <td colspan="2">
                <xsl:value-of select="distributionOrganisation/organisationName" /><br/>
               
               Tél. <xsl:value-of select="distributionOrganisation/phone/voice" /><br/>
                Fax <xsl:value-of select="distributionOrganisation/phone/facsimile" /><br/>
                            
                <xsl:value-of select="distributionOrganisation/address" /><br/>
                <xsl:value-of select="distributionOrganisation/city" />
                <xsl:value-of select="distributionOrganisation/province" />
                <xsl:value-of select="distributionOrganisation/postalCode" /><br/>
                <xsl:value-of select="distributionOrganisation/country" /><br/>
                
                <!-- on fait une hyperlien e-mail address-->
                <a href="mailto:{distributionOrganisation/electronicMailAddress}">
                    <xsl:value-of select="distributionOrganisation/electronicMailAddress"/>
                </a>                
            </td>
        </tr>
        
    </xsl:template>
   
</xsl:stylesheet>