<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">

    <xsl:output method="html" indent="yes" encoding="utf-8"/>
   
    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
                <title> Tp3 - IFT1152</title>
                <link href="geodata.css" rel="stylesheet"/>
            </head>
            <body>
                <header>
                    <h1> Travail pratique 3 - IFT1152 </h1>
                </header>
                <div id="container">
                    <nav>
                        <div>
                            <h2>Par ordre alphabétique</h2>
                            <ul>
                                
                                <xsl:for-each select="//geospatialdata"  >
                                    <xsl:sort   select="dataInfo/alternateTitle"/>
                                       <li><a href="#{@id}"><xsl:value-of select="dataInfo/alternateTitle"/></a></li>
                                </xsl:for-each>
                                
                            </ul>
                        </div>
                        <div>
                            <h2>Par type</h2>
                            <h3> Matriciel </h3>
                            <ul>
                                <xsl:for-each select="//geospatialdata"  >
                                    <xsl:sort select="dataInfo/alternateTitle"/>
                                    <xsl:if test=".//type = 'grid'">
                                    <li><a href="#{@id}"><xsl:value-of select="dataInfo/alternateTitle"/></a></li></xsl:if>
                                </xsl:for-each>
                            </ul>
                            <h3>Vectoriel</h3>
                            <ul>
                                <xsl:for-each select="//geospatialdata"  >
                                    <xsl:sort   select="dataInfo/alternateTitle"/>
                                     <xsl:if test=".//type = 'vector'">
                                    <li><a href="#{@id}"><xsl:value-of select="dataInfo/alternateTitle"/></a></li></xsl:if>
                                 </xsl:for-each>
                            </ul>
                        </div>
                    </nav>
                    <main>
                            <xsl:for-each select="//geospatialdata" >
                                <div>
                                <h2><xsl:attribute name="id" select = "@id">
                                </xsl:attribute><xsl:value-of select="dataInfo/alternateTitle"/></h2>
                                    <div><img src="{spatialRepresentationInfo/preview/@url}"></img></div>
                                </div>
                            </xsl:for-each>
                    </main>
                </div>
                <footer> Tous droits réservés © Shkoda Tatsiana - Hiver 2016 </footer>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"/>
                <script src="toggle.js"/>
            </body>
        </html>
    </xsl:template>
  
</xsl:stylesheet>


    
