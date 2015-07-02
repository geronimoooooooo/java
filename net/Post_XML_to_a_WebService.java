http://alexrogan.com/?p=41
ein vollständiges code example
-----------------------------------

public void sendPOST2Webservice(String urlService, String msg){
		msg= new ReaderWriter().readTextFileWithServletsAsStream("gor.xml");
		System.out.println(msg);
		//urlService="http://ispacevm30.researchstudio.at/sos41/service";
		urlService="http://ispacevm30.researchstudio.at/focus/service"; 
		String charset = "UTF-8";
		OutputStreamWriter writer = null;
		HttpURLConnection con = null;
		
		try {
			URL url = new URL(urlService);	
			con = (HttpURLConnection)url.openConnection();
			con.setDoOutput(true); //triggers POST
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("accept-charset", charset);
			con.setRequestProperty("Content-Type", "application/soap+xml");
			
						
			writer = new OutputStreamWriter(con.getOutputStream());
			writer.write(msg); //send POST data string
			writer.flush();
			writer.close();
			
			//get response from the web service
			//InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String response_txt ="";
			String line ="";
			StringBuilder strBuilder = new StringBuilder();
				
			while((line= br.readLine())!=null){
					strBuilder.append(line);
				}
			response_txt = strBuilder.toString();
			br.close();
			//System.out.println("response_txt: \n"+response_txt);
			PrettyPrinter.prettyFormat(response_txt);
			
		} catch (Exception e) {
		}finally{
			System.out.println("this is finally in sendPOST2Webservice:");
			if(writer!=null){
				try{
					writer.close();
				}catch(IOException ex){
					
				}
			}	
			if(con!=null){
				try{
					con.disconnect();
				}catch(Exception ex){
				}
			}	
		}
	}
-----------------------------------
