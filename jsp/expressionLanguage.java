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
