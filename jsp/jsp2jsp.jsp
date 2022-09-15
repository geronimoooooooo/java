<form action="action.jsp"> 
  <select name="productId"> 
    <option value="1">MyExamCloud</option> 
    <option value="2">ExamBoat</option> 
    <option value="3">Test Generator Lab</option> 
  </select> 
  <input type="submit" value="Submit"> 
</form> 
 
// action.jsp 
<% 
String productSelected = request.getParameter("productId"); 
%> 
