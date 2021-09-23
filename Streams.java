Hier findet man alle möglichen Stream Examples:
https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
---------------------------------------------------------------------------
Streams... sequence of data
byte stream (base abstract class InputStream and OutputStream)
    or 
character stream (base abstract class Reader and Writer)



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
