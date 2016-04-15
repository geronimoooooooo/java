protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    response.setContentType("text/xml");
    response.setHeader("Cache-Control", "no-cache");
    response.getWriter().write("<details>");
    response.getWriter().write("<firstName>"+firstName+"</firstName>");
    response.getWriter().write("<lastName>"+lastName+"</lastName>");
    response.getWriter().write("</details>");
}
