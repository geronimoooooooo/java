
-----------------------------------
-----------------------------------
-----------------------------------
 <tr>
    <td class="tg-f2ue">Station Name-Ort</td>
    	<td class="tg-z2zr">
       	<select name="name-ort" size="1" onchange="changeFunc(value)" >
    	<c:forEach items="${list_namesOrt}" var="name" varStatus="status">
  			<option value="${name}">${name}</option>
		</c:forEach>
      		<option selected="selected">1</option>
      		<option>2</option>
    	</select>       
  	</td>
  </tr>
-----------------------------------
Wenn das Projekt und der Ordner "tstp2sos" heißen
<input formaction="/tstp2sos/send-get-zeitreihen" formmethod="POST" type="submit" value="Get All Time Series"/>
<a href ="stationen.jsp">stationen</a>
-----------------------------------
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet upload</title>");  
out.println("</head>");
out.println("<body>");
out.println("<p>Hier wird versucht file upzuloaden.</p>"); 
out.println("</body>");
out.println("</html>");
-----------------------------------
List<City> cities = CityService.getAllCities();        
request.setAttribute("cities", cities);        

RequestDispatcher rd = getServletContext().getRequestDispatcher("/stationen.jsp");
rd.forward(request, response);
request.getRequestDispatcher("stationen.jsp").forward(request, response);
-----------------------------------
<div id="createService" class="row" style="margin-right: 15px;">
	<div class="c_container_inner">
		<div class="form-group ">
			<div class="col-sm-12 input-group">
				<button type="submit" id="createService"
					formaction="<%=request.getContextPath()%>/CreateServiceHandler"
					formmethod="POST" class="btn btn-primary pull-right">Create Service</button>
			</div>
		</div>
	</div>
</div>
-----------------------------------
Logger logger = (Logger) LoggerFactory.getLogger(getClass().getName()+".class");
-----------------------------------
if(request.getParameter("check_activate_sos") == null){
    //checkbox not checked
request.getParameter("urlYucca").trim();
-----------------------------------
String procedureName = request.getParameter("procedureName").split(" ")[1];
proc.metadata.list_phenomena.forEach((e)->list_obsPropFromProcedure.add(e.title));
loggerStatic.debug(new Object(){}.getClass().getEnclosingMethod().getName()+"(): "+ orTest.thingName);
Instant time = Instant.now();
List<String> list_phenomena = Arrays.asList(request.getParameterValues("obs_property"));
-----------------------------------
Send your data with a POST method to: <a href=${pageContext.request.requestURL}service>${pageContext.request.requestURL}service</a>.
http://localhost:8080/focusgeofence_160728/service.  

<meta http-equiv="refresh" content="2; url=${pageContext.request.contextPath}/services">

<a href=${pageContext.request.contextPath}>
	
<td align="right">  <input formaction="<%=request.getContextPath()%>/ConfigurationHandler" formmethod="POST" type="submit" value="Save Configuration"/> </td>   
	/focusgeofence_160728/ConfigurationHandler
-----------------------------------
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

------
 <% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %><br>
------
<a href = "session_second.jsp">Next Page</a>
------
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
-------------------------------------
//takes all elements from the form
Map<String, String[]> map_ParameterFromForm = request.getParameterMap();
-------------------------------------
  <tr>    
    <%if(active_urlWithinGeofenceWfsService){ %>
    <td>There is already a service running!<br/> Do you want to stop it?</td>
    <td align="right">  <input formaction="<%=request.getContextPath()%>/websocketHandler" formmethod="POST" type="submit" value="Stop active Service"/> </td>
                    <%}else{ %>
    <td></td>
    <td align="right">  <input formaction="<%=request.getContextPath()%>/websocketHandler" formmethod="POST" type="submit" value="Start Service"/> </td>                
                    <%} %>
  </tr>  
-------------------------------------
