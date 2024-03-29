https://www.baeldung.com/java-lang-processbuilder-api
EXAMPLES 
++ https://www.geeksforgeeks.org/java-lang-processbuilder-class-java/
++ https://mkyong.com/java/java-processbuilder-examples/

+ Process execute operating system commands
+ ProcessBuilder um operating system Prozesse zu kreieren und konfigurieren
+ Man kann "Execute a shell command from Java code"
+ Before JDK 5.0, the only way to create a process and execute it was to use Runtime.exec() method.
  
Process process = new ProcessBuilder("java", "-version").start();

ProcessBuilder processBuilder = new ProcessBuilder();    
Process process = processBuilder.start();

processBuilder.command("/bin/bash", "-c", "echo $GREETING");
Process process = processBuilder.start();
-------------------------------------------------------------
+ ruft die Windows-Eingabeaufforderung (MS-DOS) auf und
+ kopiert die .xml-Datei in eine gleichnamige .dat-Datei
  
try {	
	String[] cmd = { "cmd.exe", "/c", "copy", fileinStr, fileoutStr };
	Runtime.getRuntime().exec( cmd );	
}
catch (Exception e) {
	System.out.println( "Es ist folgender Fehler aufgetreten: \n" + e );
}
------------------------------------------------------------------------
