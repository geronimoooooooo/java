package servlets2jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scheduler.JobDescription;
import utility.TextFiles;

/**
 * Used to handle all active InsertObservation services.
 */
@WebServlet(
		description = "Servlet is used to process data concerning active InsertObservation services. After its completion, the user is forwarded to services.jsp", 
		urlPatterns = {"/services"
		})
public class Services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Services() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Used to compute all registered zrid/procedures and all active InsertObservation services 
	 * (check if file available) calls services.jsp.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobDescription jobd = new JobDescription();
		ArrayList<String> list_jobs = jobd._showAllJobs();
		TextFiles.classLoaderPath = this.getClass().getClassLoader().getResource("").getPath();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		//out.println("this is doPOST from Services: " + TextFiles.classLoaderPath );

		ArrayList<String> list_ofFileNames=TextFiles.getActiveInsertObservationServices();
/*		for(String s: list_ofFileNames){
			out.println(s+"<br>");
	}*/
		   // Set its title
	    String title = "Active Services";
	    out.println("<HTML>");
	    out.println("<HEAD>");
	    out.println("<TITLE>" + title + "</TITLE>");
	    out.println("</HEAD>");

	    // Start on the body
	    out.println("<BODY>");
	    out.println("<br><br><br><br><div align=\"center\">"+
	    		"<a href=\"/tstp2sos/\"><img src=\"img/sensorIQS_Logo_01.jpg\" alt=\"Logo\""+
	    		"></a></div><br>");
	    out.println("<p>");
	    out.println("This site lists all active InsertObservation services.<br>");
	    out.println("Every active InsertObservation service has its own configuration file."+
	    "\nThose files might be stored in e.g. C:/tomcat/webapps/tstp2sos/WEB-INF/classes/resources/insert_observation_services/<br>");
	    out.println("That file is simultaneously created with the InsertObservation service.");
	    out.println("</p>");
	    // Make a centered table
	    out.println("<form  enctype=\"application/x-www-form-urlencoded\" action=\"/tstp2sos/services\" method=\"POST\"");
	    out.println("<CENTER>");
	    out.println("<TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=70%>");

	    // First row
	    out.println("<TR>");
	    out.println("<TD COLSPAN=3><CENTER><B>");
	    out.println("<FONT SIZE=+2>Active Services</FONT>");
	    out.println("</B></CENTER></TD>");

	    out.println("<TD><CENTEr>");

	    out.println("</CENTER></TD>");

	    out.println("<TD COLSPAN=2><CENTER><B><FONT SIZE=+2>");

	    out.println("</FONT></B></CENTER></TD>");
	    out.println("</TR>");

	    // Second row
	    out.println("<TR>");
	    out.println("<TD COLSPAN=2><CENTER><B><FONT SIZE=+1>");
	    out.println("Content Filler");
	    out.println("</FONT></B></CENTER></TD>");
/*
	    out.println("<TD><CENTER><B><FONT SIZE=+1>");
	    out.println("Hi");
	    out.println("</FONT></B></CENTER></TD>");
*/
	    out.println("<TD><CENTER><B><FONT SIZE=+1>");
	    //out.println("ColumnName");
	    out.println("</FONT></B></CENTER></TD>");
	    out.println("</TR>");

	    // Daily forecast rows
	    for (int i = 0; i < list_jobs.size(); i++) {
	      out.println("<TR>");
	      out.println("<TD>&nbsp;<FONT SIZE=+1>");
	      out.println(list_jobs.get(i));
	      out.println("</FONT></TD>");
	      /*
	      out.println("<TD><CENTER>");
	      out.println("<IMG WIDTH=48 HEIGHT=35 SRC=\"" + list_ofFileNames.get(i) + "\">");
	      out.println("</CENTER></TD>");
	      */
	      out.println("<TD><CENTER><FONT SIZE=+1>");
	      out.println(list_jobs.get(i));
	      out.println("</FONT></CENTER></TD>");
	      out.println("<TD><CENTER><FONT SIZE=+1>");
	      out.println("<input type=\"submit\" name=\""+ list_jobs.get(i)+"\" value=\"Delete\" onclick=\"/tstp2sos/services\" />");
	      out.println("</FONT></CENTER></TD>");
	      out.println("</TR>");
	    }
	    
	    //if list is not empty, display button
	    if(list_jobs.size()>=1){
	    	 out.println("<TR>");
		      out.println("<TD>&nbsp;<FONT SIZE=+1>");
		     
		      out.println("</FONT></TD>");
		      /*
		      out.println("<TD><CENTER>");
		      out.println("<IMG WIDTH=48 HEIGHT=35 SRC=\"" + list_ofFileNames.get(i) + "\">");
		      out.println("</CENTER></TD>");
		      */
		      out.println("<TD><CENTER><FONT SIZE=+1>");
		     
		      out.println("</FONT></CENTER></TD>");
		      out.println("<TD><CENTER><FONT SIZE=+1>");
		      out.println("<input type=\"submit\" name=\"stop_all_jobs\" value=\"stop_all_jobs\" onclick=\"/tstp2sos/services\" />");
		      out.println("</FONT></CENTER></TD>");
		      out.println("</TR>");
	    	
	    }

	    // Close the still-open tags
	    out.println("</TABLE>");
	    out.println("</CENTER>");
	    out.println("</form>");
	    out.println("Active services/jobs: "+list_jobs.size());
	    
	    
	    
	    
	    out.println("<br><br>#####################################################################<br><br>");
	    
	    
	    out.println("<form  enctype=\"application/x-www-form-urlencoded\" action=\"/tstp2sos/services\" method=\"POST\"");
	    out.println("<CENTER>");
	    out.println("<TABLE BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=70%>");

	    // First row
	    out.println("<TR>");
	    out.println("<TD COLSPAN=3><CENTER><B>");
	    out.println("<FONT SIZE=+2>Available InsertObservation configuration files</FONT>");
	    out.println("</B></CENTER></TD>");

	    out.println("<TD><CENTEr>");

	    out.println("</CENTER></TD>");

	    out.println("<TD COLSPAN=2><CENTER><B><FONT SIZE=+2>");

	    out.println("</FONT></B></CENTER></TD>");
	    out.println("</TR>");

	    // Second row
	    out.println("<TR>");
	    out.println("<TD COLSPAN=2><CENTER><B><FONT SIZE=+1>");
	    out.println("Content Filler");
	    out.println("</FONT></B></CENTER></TD>");
/*
	    out.println("<TD><CENTER><B><FONT SIZE=+1>");
	    out.println("Hi");
	    out.println("</FONT></B></CENTER></TD>");
*/
	    out.println("<TD><CENTER><B><FONT SIZE=+1>");
	    //out.println("ColumnName");
	    out.println("</FONT></B></CENTER></TD>");
	    out.println("</TR>");

	    // Daily forecast rows
	    for (int i = 0; i < list_ofFileNames.size(); i++) {
	      out.println("<TR>");
	      out.println("<TD>&nbsp;<FONT SIZE=+1>");
	      out.println(list_ofFileNames.get(i));
	      out.println("</FONT></TD>");
	      /*
	      out.println("<TD><CENTER>");
	      out.println("<IMG WIDTH=48 HEIGHT=35 SRC=\"" + list_ofFileNames.get(i) + "\">");
	      out.println("</CENTER></TD>");
	      */
	      out.println("<TD><CENTER><FONT SIZE=+1>");
	      out.println(list_ofFileNames.get(i));
	      out.println("</FONT></CENTER></TD>");
	      out.println("<TD><CENTER><FONT SIZE=+1>");
	      out.println("<input type=\"submit\" name=\""+ list_ofFileNames.get(i)+"\" value=\"Delete\" onclick=\"/tstp2sos/services\" />");
	      out.println("</FONT></CENTER></TD>");
	      out.println("</TR>");
	    }
	    
	    if(list_ofFileNames.size()>=1){
	    	 out.println("<TR>");
		      out.println("<TD>&nbsp;<FONT SIZE=+1>");
		     
		      out.println("</FONT></TD>");
		      /*
		      out.println("<TD><CENTER>");
		      out.println("<IMG WIDTH=48 HEIGHT=35 SRC=\"" + list_ofFileNames.get(i) + "\">");
		      out.println("</CENTER></TD>");
		      */
		      out.println("<TD><CENTER><FONT SIZE=+1>");
		     
		      out.println("</FONT></CENTER></TD>");
		      out.println("<TD><CENTER><FONT SIZE=+1>");
		      out.println("<input type=\"submit\" name=\"delete_all_insert_observation\" value=\"Delete All Services\" onclick=\"/tstp2sos/services\" />");
		      out.println("</FONT></CENTER></TD>");
		      out.println("</TR>");
	    	
	    }

	    // Close the still-open tags
	    out.println("</TABLE>");
	    out.println("</CENTER>");
	    out.println("</form>");
	    out.println(" Available InsertObservation Service configuration files: "+list_ofFileNames.size());    
	    
	    
	    out.println("</BODY></HTML>");
//	    TextFiles.readJson("tstp2sos_config.json");
		/*ArrayList<String>list_registeredZrid = new ArrayList<String>();
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/services.jsp");
	    rd.forward(request, response); */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextFiles.classLoaderPath = this.getClass().getClassLoader().getResource("").getPath();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Enumeration<String> allPossibleButtons = request.getParameterNames();
		
		out.println("this is doPOST from Services: "+ TextFiles.classLoaderPath+"<br>");
		String paramName ="";
		while (allPossibleButtons.hasMoreElements()) {			
			            paramName = allPossibleButtons.nextElement();
			           
			            out.write("paramName: "+paramName+", ");			           
			            String[] paramValues = request.getParameterValues(paramName);
			            for (int i = 0; i < paramValues.length; i++) {
			                String paramValue = paramValues[i];
			                out.write("\t paramValue: " + paramValue);
			                out.write("\n");
			            }
			            out.write("<br>");	
			        }
		ArrayList<String> list_ofFileNames = TextFiles.getActiveInsertObservationServices();
				
		if(paramName.equals("delete_all_insert_observation")){			
			for (String s : list_ofFileNames) {
				TextFiles.deleteInsertObservationService(s);
				JobDescription job = new JobDescription();
				job._stopScheduler();
				}
		}else if(paramName.equals("stop_all_jobs")){
			new JobDescription()._stopScheduler();
		}else{
			TextFiles.deleteInsertObservationService(paramName);
		}		
		
	//	for (String s : list_ofFileNames) {
//			out.println(s);		}
	}

}
