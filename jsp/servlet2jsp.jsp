<input formaction="/tstp2sos/ConfigurationHandler" formmethod="POST" type="submit" value="Save Configuration"/>
<input id="urlTstpGetZeitreihen" name="urlTstpGetZeitreihen" size="65" placeholder="Tstp URL for GetAllZeitreihen" value= "${urlTstpGetZeitreihen}"/> 
  <tr>
    <td class="tg-f2ue"><a href="/tstp2sos/services">Status active InsertObservation services</a></td>
    
  </tr>

<%@page import="utility.DateTimeHelper"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//System.out.println("text in insert-observation.jsp:"+ request.getParameter("_name-ort"));
Date date = new Date();
String currentDate = DateTimeHelper.date2String_T_Z_Format(date);
String von_backInTime = DateTimeHelper.getTimeXXXHoursBackInTime(2);
%>
io.java file
	String _urlSOS = Configuration.url2SosDefault;				
	request.setAttribute("_urlSOS", _urlSOS);
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/io");
	rd.forward(request, response);

io.jsp
	<label for="_urlSOS" id="_urlSOS" type="text" name="_urlSOS" class="configFileClass" >${_urlSOS} </label>

<%
	 // New location to be redirected
	 String site = new String("http://www.photofuntoos.com");
	 response.setStatus(response.SC_MOVED_TEMPORARILY);
	 response.setHeader("Location", site); 
%>
<%
    // Set refresh, autoload time as 5 seconds
    response.setIntHeader("Refresh", 5);
%>
<body>
	<% out.println("Today's date-time: "+java.util.Calendar.getInstance().getTime()); %>
</body>

<html><body>
  <%@ page import = "torstenhorn.meinpackage.*" %>
  <%
    String s1 = request.getParameter( "EingabeZahl" );
    if( null != s1 )
      out.println( "Das Quadrat von '" + s1 + "' ist: '" + MeineBean.meineFunktion( s1 ) + "'." );


Programmierbeispiel: Alle Formulardaten anzeigen: https://www.torsten-horn.de/techdocs/jsp-grundlagen.htm

 <body>  
	<%= "Welcome "+request.getParameter("uname")+" Email : "+request.getParameter("Email")%>  
</body>

//Servlet Syntax
PrintWriter out=response.getWriter();
 //JSP Syntax
<%out.print(“Welcome to W3adda.com);%>
	
	
index.jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <body>  
        <form action="Welcome.jsp">  
            <pre>
        	    <input type="submit" value="Click"><br/>  
			</pre>
        </form>  
    </body>  
</html>  
	
	3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		 xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
    
	<servlet>  
        <servlet-name>Mine</servlet-name>  
        <jsp-file>/Welcome.jsp</jsp-file>  
   <init-param>  
        <param-name>SiteNameConfig</param-name>  
        <param-value>w3adda.com</param-value>  
    </init-param>   
    </servlet> 
  
    <servlet-mapping>  
        <servlet-name>Mine</servlet-name>  
        <url-pattern>/Welcome</url-pattern>  
    </servlet-mapping>  
    
    <context-param>  
        <param-name>SiteNameApp</param-name>  
        <param-value>w3adda.com</param-value>  
    </context-param>  
    <session-config>
        <session-timeout>
            30
        </session-timeout>
    </session-config>
</web-app>
	
	  <body>  
        <%
            String siteName = application.getInitParameter("SiteNameApp");
            out.print("Welcome " + siteName);
			String siteName = config.getInitParameter("SiteNameConfig");
            out.print("Welcome " + siteName);
