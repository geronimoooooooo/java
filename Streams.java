Hier findet man alle möglichen Stream Examples:
https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
---------------------------------------------------------------------------
Stream to String https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java?rq=1
---------------------------------------------------------------------------
https://www.programiz.com/java-programming/printstream
to convert a byte to text, you need a character encoding scheme. Reader classes uses character encoding to decode bytes and return characters to caller.
Streams... sequence of data
byte stream (base abstract class InputStream and OutputStream)
    or 
character stream (base abstract class Reader and Writer)
InputStream accept byte，Reader accept character, In Java, one character = two bytes , and Reader use buffer,InputStream not use.
----
InputStreams are used to read bytes from a stream . It grabs the data byte by byte without performing any kind of translation. 
So they are useful for binary data such as images, video and serialized objects.   

FileInputStream read data(bytes) from a file
-----
abstract class Reader a)BufferedReader  b)InputStreamReader b2)FileReader c)StringReader
Reading any type of text.
InputStreamReader reads bytes from the input stream as characters. Bridge between byte streams and character streams.
    
OutputStreamWriter bridge between byte streams and character streams. converts its characters into bytes.
    
BufferedReader reads data (in characters) 
    
    InputStream.read() reads the next byte
    InputStreamReader.read() reads a single character
---------------------------------------------------------------------------

InputStream is = urlc.getInputStream();
    int c;
    while ((c = is.read()) != -1)
      System.out.print((char) c);
  }
---------------------------------------------------------------------------
BufferedReader br2 = new BufferedReader(new StringReader(response_txt));
---------------------------------------------------------------------------
---------------------------------------------------------------------------
---------------------------------------------------------------------------
---------------------------------------------------------------------------
