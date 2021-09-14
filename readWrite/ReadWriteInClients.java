Gelesen/gestartet wird immer vom root Ordner.
------------------------------
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
ReadByteArray

byte[] bytes = new byte[1024];
//write data into byte array...

InputStream input = new ByteArrayInputStream(bytes);

//read first byte
int data = input.read();
while(data != -1) {
    //do something with data

    //read next byte
    data = input.read();
}
-------------------------------------------------------------------
readFileNamesInDirectory

http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder

File folder = new File("your/path");
File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
      }
    }
-------------------------------------------------------------------
File fileOutput;
PrintWriter pw;
//file in the same folder als your eclipse.exe
fileOutput = new File("directory_file.dat");
pw = new PrintWriter(fileOutput);
pw.print("some text");
pw.close();
-------------------------------------------------------------------
