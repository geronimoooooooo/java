	/**
	 * Used to create/load a DocumentXML from a string_xml.
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Document stringToDocument(String xml) throws Exception
	{
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return builder.parse(is);
	}
----------------------------------------------------------------------------------------------------------
StringBuilder xmlStringBuilder = new StringBuilder();
xmlStringBuilder.append("<?xml version = "1.0"?> <class> </class>");
ByteArrayInputStream input =  new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
Document doc = builder.parse(input);
----------------------------------------------------------------------------------------------------------
        DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(strXmlRecords));

        Document doc = db.parse(is);
----------------------------------------------------------------------------------------------------------
//http://www.rgagnon.com/javadetails/java-0573.html

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;

public class ParseXMLString {

  public static void main(String arg[]) {
     String xmlRecords =
      "<data>" +
      " <employee>" +
      "   <name>John</name>" +
      "   <title>Manager</title>" +
      " </employee>" +
      " <employee>" +
      "   <name>Sara</name>" +
      "   <title>Clerk</title>" +
      " </employee>" +
      "</data>";

    try {
        DocumentBuilderFactory dbf =
            DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlRecords));

        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("employee");

        // iterate the employees
        for (int i = 0; i < nodes.getLength(); i++) {
           Element element = (Element) nodes.item(i);

           NodeList name = element.getElementsByTagName("name");
           Element line = (Element) name.item(0);
           System.out.println("Name: " + getCharacterDataFromElement(line));

           NodeList title = element.getElementsByTagName("title");
           line = (Element) title.item(0);
           System.out.println("Title: " + getCharacterDataFromElement(line));
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    /*
    output :
        Name: John
        Title: Manager
        Name: Sara
        Title: Clerk
    */    
    
  }

  public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
       CharacterData cd = (CharacterData) child;
       return cd.getData();
    }
    return "?";
  }
}
