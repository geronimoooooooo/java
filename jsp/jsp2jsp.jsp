WIE MAN DATEN VON EINER JSP ZU EINER ANDEREN .JSP BRINGT
https://www.quora.com/How-do-I-get-a-value-from-a-drop-down-list-in-JSP

<a href="another.jsp?itemId=${item.id}" /> 
than from another.jsp you can use below code to get the value which being passed from above JSP
request.getParameter("itemId");// this will return object which being passed from last JSP  
-----------------------------------------------------------------------
First Way : you can pass parameter as Query

http://quora.com/webapp/test.jsp?firstname=Anand 
Servlet/JSP side to get parameter value

if (request.getParameter("firstname") != null) { 
 out.println("Welcome "+request.getParameter("firstname")); 
} 
Second way : Using tab lib

<jsp:forward page="test.jsp" method="post">  
<jsp:param name="firstname" value="Anand" />  
<jsp:param name="lastname" value="Dwivedi" />  
</jsp:forward>  
test.jsp side get parameter like

String firtname=request.getParameter("firstname"); 
String lastname=request.getParameter("lastname"); 
Third way :

Using include

String path = "test.jsp?firstName=AnandDwivedi";  
RequestDispatcher rd = context.getRequestDispatcher(path); 
rd.include(request, response);  
test.jsp side

String firtname=request.getParameter(firstName);  
Fourth way

Using RequestDispatcher

String firstName="Anand"; 
RequestDispatcher rd = getServletContext().getRequestDispatcher("/test.jsp?firstName="+firstName); 
rd.forward(request, response); 
test.jsp side

 String firtname=request.getParameter(firstName)
---------------------------------------------------------------------------------------------

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
