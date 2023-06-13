Die logging.properties Datei muss im lokalen Porjektordner im root folder sein
src/main/java
+ handlerFolder
+ mainLogicFolder
+logging.properties

The Java logging APIs (java.util.logging) default loads logging.properties in the $JAVA_HOME/jre/lib/ (Java 8 and before); for Java 9 and above, the logging.properties file moved to $JAVA_HOME/conf.
  
 https://mkyong.com/logging/how-to-load-logging-properties-for-java-util-logging/
  https://javabeginners.de/Allgemeines/Logging/Logging_mit_Properties-Datei.php
https://www.logicbig.com/tutorials/core-java-tutorial/logging/loading-properties.html
https://www.digitalocean.com/community/tutorials/logger-in-java-logging-example

NOCH LESEN:
+ https://www.journaldev.com/977/logger-in-java-logging-example
+ https://stackoverflow.com/questions/9457976/java-logging-where-is-my-log-file
+ https://stackoverflow.com/questions/43284004/where-does-the-java-util-logging-log-file-or-output-go
+ https://stackoverflow.com/questions/5950557/good-examples-using-java-util-logging
+ https://www.vogella.com/tutorials/Logging/article.html
+ https://javabeginners.de/Allgemeines/Logging/Einfaches_Logging.php
+ https://examples.javacodegeeks.com/category/core-java/util/logging/
+ https://sematext.com/blog/java-logging/
+ https://www.delftstack.com/de/howto/java/java-log/
+ https://owlcation.com/stem/Java-Examples-Logging-with-FileHandler-and-SimpleFormatter
+ https://www.geeksforgeeks.org/logger-entering-method-in-java-with-examples/
+ https://stackoverflow.com/questions/10442664/logger-and-filehandler-in-java

+ http://www.javased.com/?api=java.util.logging.FileHandler
+ https://www.programcreek.com/java-api-examples/?api=java.util.logging.FileHandler
+ https://www.tabnine.com/code/java/classes/java.util.logging.FileHandler
+ https://sematext.com/blog/java-logging/#toc-logging-in-java-how-to-log-using-the-java-logging-api-7


ALLES WAS MAN FÜR DEN START BRAUCHT: https://examples.javacodegeeks.com/core-java/util/logging/java-util-logging-example/
https://jenkov.com/tutorials/java-logging/logger.html
https://javabeginners.de/Allgemeines/Logging/Logging_mit_Properties-Datei.php
https://mkyong.com/logging/logging-properties-example/


---------------------------------
java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());
logger.info("This is an info message");
logger.severe("This is an error message"); // == ERROR
logger.fine("Here is a debug message");
---------------------------------
FileHandler fileHandler = new FileHandler("status.log");
fileHandler  = new FileHandler("./javacodegeeks.log"); //root directory of project
fileHandler = new FileHandler("src/main/resources/MyLogFile.txt"); //relative path
logger.addHandler(fileHandler);
---------------------------------
  package com.sematext.blog.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaUtilsLogging {
  private static Logger LOGGER = Logger.getLogger(JavaUtilsLogging.class.getName());

  public static void main(String[] args) {
    LOGGER.log(Level.INFO, "Hello world!");
  }
}
---------------------------------
Where is your logging.properties file located? It should be available in the root of the classpath. As a sanity check, what does the following code print?

System.out.println(getClass().getClassLoader().getResource("logging.properties"));
  If the code is in a static context, use
System.out.println(ClassName.class.getClassLoader().getResource("logging.properties"));
---------------------------------
---------------------------------
---------------------------------
---------------------------------
public class ExampleHandler extends Handler {
  @Override
  public void publish(LogRecord logRecord) {
    System.out.println(String.format("Log level: %s, message: %s",
        logRecord.getLevel().toString(), logRecord.getMessage()));
  }

  @Override
  public void flush() {
  }

  @Override
  public void close() throws SecurityException {
  }
}
------------------------------------------
