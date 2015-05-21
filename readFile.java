private List<String> readFile(String filename) throws Exception
{
    String line = null;
    List<String> records = new ArrayList<String>();
 
    // wrap a BufferedReader around FileReader
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
 
    // use the readLine method of the BufferedReader to read one line at a time.
    // the readLine method returns null when there is nothing else to read.
    while ((line = bufferedReader.readLine()) != null)
    {
        records.add(line);
    }
   
    // close the BufferedReader when we're done
    bufferedReader.close();
    return records;
}
------------------------------------------
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
-----------------------------------------------------------------------------
URL url = new URL(theUrl);
URLConnection urlConnection = url.openConnection();
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
 
String line;
while ((line = bufferedReader.readLine()) != null)
{
    content.append(line + "\n");
}
bufferedReader.close();
---------------------------------
Read input from console

System.out.print("Enter your name: ");
 
        //  open up standard input, and buffer it
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 
        // use the readLine method of the BufferedReader class
        // to get whatever line the user types in:
        userName = bufferedReader.readLine();
        System.out.println("Thanks for the name, " + userName);
------------------------------------------------------
