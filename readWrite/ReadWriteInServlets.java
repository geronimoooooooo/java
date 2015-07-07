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
