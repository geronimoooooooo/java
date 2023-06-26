 <tr>
    <td class="tg-f2ue">Name-Ort-ZRID</td>
    <td class="tg-z2zr"> 
    <select name="name-ort" size="1" onchange="changeFunc(value)" >
    	<c:forEach items="${list_nameOrtZrid}" var="name" varStatus="status">
  			<option value="${name}">${name}</option>
		</c:forEach>
      		<option selected="selected">Heino</option>
      		<option>Heino2</option>
    </select> 
     <select name="_name-ort">
   <%  for(int i = 0; i < list_namesOrt.size(); i++) {
           String option = (String)list_namesOrt.get(i);
   %>
   <option value="<%= option %>"><%= option %></option>
   <% } %>
   </select>
    </td>
  </tr>
##############################################################################################
<!-- if elseif else -->
<c:choose>
   <c:when test="${s.getLastRequestDate()==null}">else if</c:when> 
   <c:when test="${Database.hasError==false}">if</c:when> 
   <c:otherwise>else</c:otherwise>   
</c:choose>
##############################################################################################
<%
 pageContext.setAttribute("stations", KlimaApp.station);
%>      
<c:forEach items="${pageScope.stations}" var="station">
  <tr>
    <td><c:out value="${station.nummer}"/></td>
    <td>${station.name}</td>					
    <td>${station.vonTime}</td>
    <td><span class="badge badge-pill bg-success"><c:out value="${'Success'}"/></span></td>					
  </tr>
</c:forEach>
##############################################################################################
##############################################################################################
##############################################################################################
##############################################################################################
##############################################################################################
