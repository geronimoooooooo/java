+ Weiterleiten aus einem Servlet doGet() zu einem anderen Servlet doGet()
RequestDispatcher rd = getServletContext().getRequestDispatcher("/insert");
rd.forward(request, response);

String param = request.getParameter("p");		
if(param.equals("2")){
  RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
	rd.forward(request, response);
} else{		}
-----------------------------------------------
${pageContext.request.requestURL} -- http://localhost:8080/geo-websocket/start.jsp 
${pageContext.request.requestURI} -- /geo-websocket/start.jsp 
${pageContext.request.contextPath} -- /geo-websocket 
${pageContext.request.serverName} -- localhost 
${pageContext.request.localPort} -- 8080 
${pageContext.request.scheme} -- http 
<a href="geofence">${base_href}geofence</a> liefert http://localhost:8080/geo-websocket/geofence
<a href=${pageContext.request.contextPath}/geofence>${base_href}geofence</a> liefert http://localhost:8080/geo-websocket/geofence
-----------------------------------------------
<%
System.out.println("inside scriptlet java gibt es nur 'request' aber kein 'pageContext'");
System.out.println(request.getRequestURL()); http://localhost:8080/npbg-klima/ok.jsp
System.out.println(request.getRequestURI()); /npbg-klima/ok.jsp
System.out.println(request.getContextPath()); /npbg-klima
%>

<a href="<%=request.getRequestURL() %>">=request.getRequestURL()</a><br> http://localhost:8080/npbg-klima/ok.jsp
<a href="<%=request.getRequestURI() %>">=request.getRequestURI()</a><br> http://localhost:8080/npbg-klima/ok.jsp
<a href="<%=request.getContextPath() %>">=request.getContextPath()</a><br> http://localhost:8080/npbg-klima
<a href="${pageContext.request.requestURL}">pageContext.request.requestURL</a><br> http://localhost:8080/npbg-klima/ok.jsp
<a href="${pageContext.request.requestURI}">pageContext.request.requestURI</a><br> http://localhost:8080/npbg-klima/ok.jsp
<a href="${pageContext.request.contextPath}">pageContext.request.contextPath</a><br> http://localhost:8080/npbg-klima/
<br>
<a href ="${pageContext.request.contextPath}/stationen">{pageContext.request.contextPath}/stationen</a> http://localhost:8080/npbg-klima/stationen
<br>
<label>pageContext.request.requestURL: ${pageContext.request.requestURL}</label><br> http://localhost:8080/npbg-klima/ok.jsp
<label>pageContext.request.requestURI: ${pageContext.request.requestURI}</label><br> /npbg-klima/ok.jsp
<label>pageContext.request.contextPath: ${pageContext.request.contextPath}</label><br> /npbg-klima

------------------------------------------------------------------------------------------------
gets the absolute path for a file
ServletContext sc = this.getServletContext();
String path = sc.getRealPath("/WEB-INF/file.txt");
------------------------------------------------------------------------------------------------
Aus: http://localhost:8080/geo-websocket/start.jsp  wird: ws://localhost:8080/geo-websocket/start.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="url_default" value="${pageContext.request.requestURL}"/>
<c:set var="url_replace_http" value="${fn:replace(url_default,'http', 'ws')}" />
<c:set var="url_replace_https" value="${fn:replace(url_replace_http,'https', 'ws')}" />
<c:set var="url_final_ws" value="${url_replace_https}" />

-----------------------------------------------

Get base URL: http://localhost:8080/geo-websocket/
http://localhost:8080/geo-websocket/start.jsp  - /geo-websocket/start.jsp + /geo-websocket = http://localhost:8080/geo-websocket/

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="base_href" value ="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/"/>

<head>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
</head>

${base_href}geofence = http://localhost:8080/geo-websocket/geofence
im <a href="">hier steht dann schon der inhalt, welcher im head base href berechnet wurde
 -----------------------------------------
 <%=request.getContextPath()%>/help/page/help.htm 
 --------------------------------------------
##############################################################################################
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<c:set var="url_default" value="${pageContext.request.requestURL}"/>
<c:set var="url_replace_http" value="${fn:replace(url_default,'http', 'ws')}" />
<c:set var="url_replace_https" value="${fn:replace(url_replace_http,'https', 'ws')}" />
<c:set var="url_final_ws" value="${url_replace_https}" />
<c:set var="base_href" value ="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSockets</title>
</head>
<body>

Um einem WebSocket Chatraumt beizutreten, den Chatnamen zur base WebSocket URL anhängen.
<br><br>
An die folgende Adresse werden Daten zum WebSocket geschickt: ws://ispacevm20.researchstudio.at/geo-websocket/<b>'chatname'</b> <br>
<br>
Chaträume befinden sich unter folgender Adresse: ${base_href}<b>'chatname'</b> <br> 
<p>
<b>Verfügbare WebSocket chats:</b>
<ul>
<li>/geofence
	<ul>
	<li><a href="geofence">${base_href}geofence</a></li>
	<li>WebSocket Adresse: ${url_final_ws}geofence</li>
	<li>Chatraum Adresse: <a href=${pageContext.request.contextPath}/geofence>${base_href}geofence</a></li>
	</ul>
</li>
<li>/chat_unloading</li>
<li>/iridium</li>
</ul>

<p>Final String : ${url_final_ws}</p>
<script src="https://gist.github.com/geronimoooooooo/a916893a267fbd2b2701.js"></script>

</body>
</html>


Um einem WebSocket Chatraumt beizutreten, den Chatnamen zur base WebSocket URL anhängen. 

 An die folgende Adresse werden Daten zum WebSocket geschickt: ws://localhost:8080/geo-websocket/'chatname' 

 Chaträume befinden sich unter folgender Adresse: http://localhost:8080/geo-websocket/'chatname' 

Verfügbare WebSocket chats: 
•/geofence ◦WebSocket Adresse: ws://localhost:8080/geo-websocket/geofence
◦Chatraum Adresse: http://localhost:8080/geo-websocket/geofence

•/chat_unloading
•/iridium

##############################################################################################
Wenn mit RequestDispatcher.forward() weiterleitet, um den Link von der Seite zu bekommen wo 
request.getAttribute("javax.servlet.forward.request_uri")
${requestScope['javax.servlet.forward.request_uri']}


