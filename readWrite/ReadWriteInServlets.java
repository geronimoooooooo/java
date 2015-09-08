http://stackoverflow.com/questions/2797162/getresourceasstream-is-always-returning-null; von Pascal Thivent lesen
http://stackoverflow.com/questions/2308188/getresourceasstream-vs-fileinputstream

getResourceAsStream is the right way to do it for web apps (as you already learned).
getResourceAsStream() will load a file path relative from your application's classpath. 
ALLES was sich schon im src/ befindet, kann einfach dann geladen werden.

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
Liest nur wenn im classpath bei src/         /reasources/css.css
BufferedReader br = new BufferedReader(new InputStreamReader(
			Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/css.css")));
-------------------------------------------------------
json_beacon.json muss sich im gleichen Ordner wie das Servlet befinden.

BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("json_beacon.json")));
-------------------------------------------------------
muss im /WEB-INF/ sein
BufferedReader br = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/resources/file.json")));
-------------------------------------------------------
Der Befehl: this.getClass().getClassLoader().getResource("").getPath();
liefert folgenden Pfad: C:\java_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\sensoriqs\WEB-INF\classes\
-------------------------------------------------------
	String path = getServletContext().getRealPath("");
	//liefert, wenn im Tomcat läuft
	//C:\Program Files\Apache Software Foundation\Tomcat 8.0\webapps\sensoriqs\
-------------------------------------------------------
Wenn man aus dem WEB-INF lesen will:
BufferedReader br = new BufferedReader(new InputStreamReader(getServletContext().getResourceAsStream("/WEB-INF/resources/file.json")));

WENN MAN AUS DEM RESOURCES ORDNER LESEN WILL:
BufferedReader br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/css.css")));
-------------------------------------------------------
TextUtility.classLoaderPath = this.getClass().getClassLoader().getResource("").getPath();
TextUtility.print("SendGetZeitreihenHandler Pfad: "+this.getClass().getClassLoader().getResource("").getPath());

ERGEBNIS: SendGetZeitreihenHandler Pfad: 
/C:/java_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/sensoriqs/WEB-INF/classes/
-------------------------------------------------------
in doGet:
TextFiles.classLoaderPath = this.getClass().getClassLoader().getResource("").getPath();
out.println("this is doGet from getZeitreihen." + TextFiles.classLoaderPath );
Ergebnis: this is doGet from getZeitreihen./C:/tomcat/webapps/tstp2sos/WEB-INF/classes/
-------------------------------------------------------
public static String setClassLoaderPath(){
	classLoaderPath = TextFiles.class.getClassLoader().getResource("").getPath();
	return classLoaderPath; 
	///C:/tomcat/webapps/tstp2sos/WEB-INF/classes/
}
-------------------------------------------------------
in index.jsp
String path = session.getServletContext().getRealPath("/resources");
System.out.println("From index.jsp: "+path); 
InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/zeitreihen_ort.txt");
out.print(path);
//C:\java_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\tstp2sos\resources
-------------------------------------------------------
 Wenn man hier mit Servlet etwas rauslesen möchte: src/main/webapp/pdf/
+ Use the absolute path (this is appropriate, if you store the PDF outside of your webapp)
+ Use getRealPath() (this should be suitable for your use case; PDFs are part of webapp):
	
	File pdfFolder =  new File(req.getSession().getServletContext().getRealPath("/pdf"));
-------------------------------------------------------
read string to BufferedReader
String s= ...; // your String
StringReader sr= new StringReader(s); // wrap your String
BufferedReader br= new BufferedReader(sr); // wrap your StringReader

-------------------------------------------------------
garantieren, dass der String msg auch wirklich UTF-8 ist
byte [] bray = msg.getBytes("UTF-8");
msg = new String(bray);
-------------------------------------------------------
-------------------------------------------------------
-------------------------------------------------------
-------------------------------------------------------
-------------------------------------------------------
-------------------------------------------------------
