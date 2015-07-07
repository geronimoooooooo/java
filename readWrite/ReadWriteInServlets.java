Bei Servlets: css2.css in den ordner src/resources abstellen
try 
(BufferedReader br = new BufferedReader(new InputStreamReader(
Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/css2.css"))))

-------------------------------------------------------

InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/css.css");
		InputStreamReader isr = new InputStreamReader(input);
		BufferedReader reader = new BufferedReader(isr);
		
		try (BufferedReader br = new BufferedReader(isr))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				response.getWriter().print(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
-------------------------------------------------------
BufferedReader br = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/resources/file.json")));
		String text ="";
		String currentLine ="";
		StringBuilder sb = new StringBuilder();
		while((currentLine=br.readLine())!=null){
			sb.append(currentLine);
		}
		text = sb.toString();
		System.out.println(text);
-------------------------------------------------------
Assuming that aFile.txt is in the root of your application, you should be able to open the stream using the servlet context:

<% java.io.InputStream in = application.getResourceAsStream("/aFile.txt"); %>
-------------------------------------------------------
json_beacon.json muss sich im gleichen Ordner wie das Servlet befinden.

BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("json_beacon.json")));
-------------------------------------------------------
