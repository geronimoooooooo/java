int i = Integer.parseInt(req.getParameter("num1"));
int j = Integer.parseInt(req.getParameter("num2");
int k= i+j;
PrintWriter out = res.getWriter();
out.println("Result is"+k);
#################################################################################
