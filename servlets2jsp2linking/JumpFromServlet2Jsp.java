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
