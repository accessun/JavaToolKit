package io.github.accessun.xml;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.junit.Test;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

public class XmlProcessing {
    
    // Reference
    // http://stackoverflow.com/questions/5059224/which-is-the-best-library-for-xml-parsing-in-java
    // http://stackoverflow.com/questions/216894/get-an-outputstream-into-a-string
    public String generateXml() {
        ByteArrayOutputStream os = null;
        XMLOutputFactory factory = null;
        XMLStreamWriter writer = null;
        try {
            os = new ByteArrayOutputStream();
            factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter(os);
            writer = new IndentingXMLStreamWriter(writer); // output formatted XML
            
            writer.writeStartDocument("UTF-8", "1.0");
            
            writer.writeStartElement("struts");
            
            writer.writeStartElement("constant");
            writer.writeAttribute("name", "struts.ui.theme");
            writer.writeAttribute("value", "simple");
            writer.writeEndElement();
            
            writer.writeStartElement("package");
            writer.writeAttribute("name", "default");
            writer.writeAttribute("namespace", "/");
            writer.writeAttribute("extends", "struts-default");
            
            writer.writeStartElement("mytag");
            writer.writeAttribute("client", "webbrowser");
            writer.writeCharacters("Servlet");
            writer.writeEndElement();
            
            writer.writeStartElement("mytag");
            writer.writeAttribute("client", "webbrowser");
            writer.writeCData("<data></data>");
            writer.writeEndElement();
            
            writer.writeEmptyElement("attr");
            writer.writeAttribute("processor", "JSON");
            
            writer.writeEmptyElement("attr");
            writer.writeAttribute("dest", "browser");
            
            
            writer.writeEndElement(); // close package tag
            writer.writeEndElement(); // close struts tag
            
            writer.flush();
            
            return os.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
    
    @Test
    public void testGenerateXml() {
        System.out.println(generateXml());
    }
    
}
