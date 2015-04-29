<soapenv:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
xmlns:a="http://fu" 
xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
xmlns:ser="http://services.web.post.list.com">
	<soapenv:Header>
		<authInfo xsi:type="soap:authentication" xmlns:soap="http://list.com/services/SoapRequestProcessor">
			<!--You may enter the following 2 items in any order-->
			<username xsi:type="xsd:string">dfasf@google.com</username>
			<password xsi:type="xsd:string">PfasdfRem91</password>
			<a:test>hi</a:test>
		</authInfo>
	</soapenv:Header>
</soapenv:Envelope>


import java.io.StringReader;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Tester {

    public static void main(String[] args) throws Exception {
        String xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:a=\"http://fu\" xmlns:ser=\"http://services.web.post.list.com\"><soapenv:Header><authInfo xsi:type=\"soap:authentication\" xmlns:soap=\"http://list.com/services/SoapRequestProcessor\"><!--You may enter the following 2 items in any order--><username xsi:type=\"xsd:string\">dfasf@google.com</username><password xsi:type=\"xsd:string\">PfasdfRem91</password> <a:test>hi</a:test></authInfo></soapenv:Header></soapenv:Envelope>";
        System.out.println(xml);
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {

            @Override
            public Iterator getPrefixes(String arg0) {
                return null;
            }

            @Override
            public String getPrefix(String arg0) {
                return null;
            }

            @Override
            public String getNamespaceURI(String arg0) {
                if("soapenv".equals(arg0)) {
                    return "http://schemas.xmlsoap.org/soap/envelope/";
                }else if("a".equals(arg0)){
                	return"http://fu";
                }
                return null;
            }
        });
        // XPath Query for showing all nodes value

        try {
            XPathExpression expr = xpath.compile("/soapenv:Envelope/soapenv:Header/authInfo/password");
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            System.out.println(nodes.item(0).getTextContent());
            System.out.println("Got " + nodes.getLength() + " nodes");
            
            XPathExpression expr2 = xpath.compile("/soapenv:Envelope/soapenv:Header/authInfo/a:test");
            Object result2 = expr2.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes2 = (NodeList) result2;
            System.out.println(nodes2.item(0).getTextContent());
            System.out.println("Got " + nodes2.getLength() + " nodes");
            // System.out.println(nodes.item(0).getNodeValue());
        } catch (Exception E) {
            System.out.println(E);
        }

    }
}
