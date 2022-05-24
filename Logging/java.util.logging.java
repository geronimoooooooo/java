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
