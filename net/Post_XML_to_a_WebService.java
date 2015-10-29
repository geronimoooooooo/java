http://alexrogan.com/?p=41
ein vollständiges code example
-----------------------------------
public String sendPOST2Webservice(String urlService, String msg){
		//msg= TextFiles.readTextFileWithServletsAsStream_UTF8("InsertSensor.xml");
		//System.out.println("msg2send: "+msg);
			
		//urlService="http://ispacevm30.researchstudio.at/focus/service"; 
		String charset = "UTF-8";
		OutputStreamWriter writer = null;
		HttpURLConnection con = null;
		String response_txt ="";
		InputStream iss = null;
		
		try {
			//byte [] bray = msg.getBytes("UTF-8");
			//msg = new String(bray);
			
			URL url = new URL(urlService);
			con = (HttpURLConnection)url.openConnection();
			con.setDoOutput(true); //triggers POST
			con.setDoInput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("accept-charset", charset);
			//con.setRequestProperty("Content-Type", "application/soap+xml");
			con.setRequestProperty("Content-Type", "application/soap+xml;charset=UTF-8");
			
			//
			writer = new OutputStreamWriter(con.getOutputStream(), charset);
			writer.write(msg); //send POST data string		
			//System.out.println("this is sendPOST2Webservice: "+msg);
			writer.flush();
			writer.close();
			Boolean error = false;
			BufferedReader br = null;
			
			if(con.getResponseCode()==200){
			//get response from the web service
			//InputStream is = con.getInputStream();
				
				//macht aus &%/ Fehlern ein ganz normales ü
				br = new BufferedReader(new InputStreamReader(con.getInputStream(),charset));
			}else{
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(),charset));
				error = true;
			}
			
			String line ="";
			StringBuilder strBuilder = new StringBuilder();
						
			while((line= br.readLine())!=null){
					strBuilder.append(line);
				}
			response_txt = strBuilder.toString();

			if(error){
			System.out.println("networking: Response_txt: "+TextFiles.prettyPrintXMLString2Console(response_txt, "", 2));
			}
			br.close();			
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			//System.out.println("this is finally in sendPOST2Webservice:");
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
		return response_txt;
	}
-----------------------------------
