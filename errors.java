Errorhandling:
http://www.tutorialspoint.com/servlets/servlets-exception-handling.htm
http://www.jguru.com/faq/view.jsp?EID=1347
http://www.jsptutorial.org/content/errorHandling

request.getAttribute("javax.servlet.error.servlet_name");
Errorcodes: https://tomcat.apache.org/tomcat-7.0-doc/servletapi/constant-values.html
-------------------------------
SOS
-------------------------------
Ein uom bei InsertSensor.xml wird vom SOS nicht akzeptiert.
<ows:Exception exceptionCode="InvalidRequest" locator="string value 'cm ü.PNP' does not match pattern for UomSymbol in namespace http://www.opengis.net/swe/1.0.1">
----------------------------------------

XML
-------------------------------------------
sehr häufiger Fehler wenn man versucht einen String einzulesen, es wird aber eine URI bzw. InputStream erwartet
Document document = dbuilder.parse(xml_org);

java.net.MalformedURLException: no protocol:
--------------------------------
Wenn man versucht einen leeren xmlString zu  Document document = dbuilder.parse(xml_org);
Auch wenn man einen Stream irgendwo nutzen möchte und dieser aber schon genutzt wurde.

[Fatal Error] :1:1: Vorzeitiges Dateiende.
org.xml.sax.SAXParseException; lineNumber: 1; columnNumber: 1; Vorzeitiges Dateiende.
--------------------------------
Content is not allowed in Prolog.

Einfach mal die ersten paar Zeichen löschen und neu schreiben. Dann sollte gehen.
--------------------------------

Tomcat:
Server Tomcat v8.0 Server at localhost failed to start.
Da ist ein fehler in der web.xml. Ein / könnte irgendwo fehlen.
-------------------------------------
Abfrage zum SOS/Adresse hingeschickt, aber bei der Adresse gibt es gar keinen service
[Fatal Error] :1:966: Elementtyp "HR" muss mit dem entsprechenden Endtag "</HR>" beendet werden.
org.xml.sax.SAXParseException; lineNumber: 1; columnNumber: 966; Elementtyp "HR" muss mit dem entsprechenden Endtag "</HR>" beendet werden.

#################################################################
Bei Tomcat: Das Servlet/File gibt es nicht, welches im web.xml eingetragen wurde, dass beim StartUp des servers auch mit
ausgeführt werden soll. Einfach den Namen der Datei dort richtig angeben.

INFORMATION: Marking servlet LoadOnStartUp as unavailable
Okt 29, 2015 12:09:04 PM org.apache.catalina.core.StandardContext loadOnStartup
SCHWERWIEGEND: Servlet /tstp2sos threw load() exception
java.lang.ClassNotFoundException: utility.LoadOnStartUp
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1702)
	at org.apache.catalina.loader.WebappClassLoader.loadClass(WebappClassLoader.java:1547)

  <servlet>
    <servlet-name>LoadOnStartAppConfiguration</servlet-name>
    <servlet-class>utility.LoadOnStartAppConfiguration</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
	#################################################################
	
	##########################
	
	##########################
	
	##############################################################################
	
	
	
	
	##########################
	##########################
	##########################
	##########################
