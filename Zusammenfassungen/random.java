+ Jedes Servlet extends HttpServlet
+ Listener statt init() von load-on-startup Servlet
+ Instant time;
+ PrintWriter out = response.getWriter(); out.println("website");
+ response.getWriter().append("Served at: ").append(request.getContextPath());
+ response.getWriter().append("Served at: ").append(request.getRequestURL());
