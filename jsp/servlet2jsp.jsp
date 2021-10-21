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
