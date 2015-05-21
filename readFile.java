
Es geht darum, wie man ein statisches file/xml im Tomcat lesen kann
doGet(){
response.getWriter().print("Das ist readfile");
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
------------------------------------------------------------------------------------------------------
String filePath ="resources/file.xml";
			
			File file = new File("resources/file.xml");
			   try {
				List<String> lines = Files.readAllLines(Paths.get(filePath),Charset.defaultCharset());
				String text = lines.toString();
				System.out.println(text);
				
				
				File file2 = new File(filePath);
				FileReader fileReader = new FileReader(file2);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					stringBuffer.append(line);
					stringBuffer.append("\n");
				}
				fileReader.close();
				System.out.println("Contents of file:");
				System.out.println(stringBuffer.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
---------------------------------------------------------------
http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
try with resources; closes file automatically
try (BufferedReader br = new BufferedReader(new FileReader("C:\\testing.txt")))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} 
