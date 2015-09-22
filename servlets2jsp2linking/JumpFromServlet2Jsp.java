protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Setting some attributes
        Person person = new Employee();
        person.setName("Pankajjjjj");
        person.setAge(20);
         
        UtilityHelper u = new UtilityHelper();
        u.readFileNamesInDirectory();
        ArrayList<String> list_names = u.getListOfNames();
        System.out.println(list_names.size());
       // request.setAttribute("person", person);
        request.setAttribute("list_names", list_names);
         
        Employee emp = new Employee();
        Address add = new Address();
        add.setAddress("India");
        emp.setAddress(add);
        emp.setId(1);
        emp.setName("Pankaj Kumar");
         
        HttpSession session = request.getSession();
        session.setAttribute("employee", emp);
         
        response.addCookie(new Cookie("User.Cookie","Tomcat User"));
        getServletContext().setAttribute("User.Cookie","Tomcat User");
         
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
	}
-------------------------------------------------------------------------------------------
	Call another servlet
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/services");
	rd.forward(request, response);
-------------------------------------------------------------------------------------------	    
	String redirectURL = "http://examples.javacodegeeks.com/";
        response.sendRedirect(redirectURL);
-------------------------------------------------------------------------------------------	    

	String url2SosDefault = TextFiles.read1SimpleJsonValue("web_app_config.json", "url2sos_default");
 	String executeInsertObservationServicesOnStartUp = TextFiles.read1SimpleJsonValue("web_app_config.json", "executeInsertObservationServicesOnStartUp");	         
	         
	request.setAttribute("url2SosDefault", url2SosDefault);
 	//in .jsp value="${executeInsertObservationServicesOnStartUp}"
        request.setAttribute("executeInsertObservationServicesOnStartUp", executeInsertObservationServicesOnStartUp);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/configuration.jsp");
        rd.forward(request, response);	
        
        <input id="_loadIOServices" type="text" name="_loadIOServices" size="65" placeholder="provide a url for GetCapabilities" 
    value="${executeInsertObservationServicesOnStartUp}"  />

-------------------------------------------------------------------------------------------
  <servlet>
    <servlet-name>is</servlet-name>
    <jsp-file>/insert-sensor.jsp</jsp-file>
  </servlet>
  <servlet-mapping>
    <servlet-name>is</servlet-name>
    <url-pattern>/is</url-pattern>
  </servlet-mapping>
  -------------------------------------------------------------------------------------------
<td><input type="button" name="edit" value="Edit" onclick="location.href='edit.jsp?id=<%=rs.getString(1)%>'; "></td>

<td><input type="button" name="delete" value="Delete" onclick="location.href='/Registrationform/DeleteServlet?id=<%=rs.getString(1)%>'; "></td>
-------------------------------------------------------------------------------------------
