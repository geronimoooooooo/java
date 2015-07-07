http://stackoverflow.com/questions/2308188/getresourceasstream-vs-fileinputstream

getResourceAsStream is the right way to do it for web apps (as you already learned).
getResourceAsStream() will load a file path relative from your application's classpath.

The reason is that reading from the file system cannot work if you package your web app in a WAR. 
This is the proper way to package a web app. 
It's portable that way, because you aren't dependent on an absolute file path or 
the location where your app server is installed.
You don't want to hardcode or guess the absolute path in Java (web)applications. 
That's only portability trouble (i.e. it runs in system X, but not in system Y). 
The normal practice is to place those kind of resources in the classpath, 
or to add its full path to the classpath (in an IDE like Eclipse that's the src folder and
the "build path" respectively). This way you can grab them with help of the 
ClassLoader by  ClassLoader#getResource() or ClassLoader#getResourceAsStream(). 
It is able to locate files relative to the "root" of the classpath, as you by coincidence figured out. 
In webapplications (or any other application which uses multiple classloaders) it's recommend 
to use the ClassLoader as returned by Thread.currentThread().getContextClassLoader() for this.
-------------------------------------------------------
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
