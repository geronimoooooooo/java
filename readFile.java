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
