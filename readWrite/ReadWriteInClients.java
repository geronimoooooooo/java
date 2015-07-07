String filePath ="resources/file.xml";
			
			File file = new File("resources/file.xml");
			   try {
				List<String> lines = Files.readAllLines(Paths.get(filePath),Charset.defaultCharset());
				String text = lines.toString();
				System.out.println(text);

				File file2 = new File(filePath);
				FileReader fileReader = new FileReader(file2);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuilder stringBuffer = new StringBuilder();
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
-------------------------------------------------------------------
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
-------------------------------------------------------------------
Read input from console

System.out.print("Enter your name: ");
 
        //  open up standard input, and buffer it
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 
        // use the readLine method of the BufferedReader class
        // to get whatever line the user types in:
        userName = bufferedReader.readLine();
        System.out.println("Thanks for the name, " + userName);
-------------------------------------------------------------------
