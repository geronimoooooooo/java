	BufferedReader br;
	OutputStreamWriter wr;
	String response_txt;
	try
	{
	    URL url = new URL("http://ispacevm22.researchstudio.at/geoserver/geofence_sbg/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=geofence_sbg:geofence_sbg&maxFeatures=50&outputFormat=text/xml;%20subtype=gml/3.2");
	    URLConnection conn = url.openConnection();
	    conn.setDoOutput(true);
	    wr = new OutputStreamWriter(conn.getOutputStream());
	    wr.flush();

	    // Get the response
	    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;

			StringBuilder strBuilder = new StringBuilder();

			while((line = br.readLine()) != null){
				strBuilder.append(line);
				//System.out.println(line);
			}
			response_txt = strBuilder.toString();
	}
	catch (Exception e) {
			System.out.println(e.toString());
	    }
