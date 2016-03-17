${pageContext.request.requestURL} -- http://localhost:8080/geo-websocket/start.jsp 
${pageContext.request.contextPath} -- /geo-websocket 
${pageContext.request.serverName} -- localhost 
${pageContext.request.localPort} -- 8080 
${pageContext.request.scheme} -- http 
${pageContext.request.requestURI} -- /geo-websocket/start.jsp 

-----------------------------------------------

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



