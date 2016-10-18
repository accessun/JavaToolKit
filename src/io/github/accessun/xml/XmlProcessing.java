package io.github.accessun.xml;

import java.io.ByteArrayOutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.junit.Test;

public class XmlProcessing {

    public String generateXml() {
        ByteArrayOutputStream os = null;
        XMLOutputFactory factory = null;
        XMLStreamWriter writer = null;
        try {
            os = new ByteArrayOutputStream();
            factory = XMLOutputFactory.newInstance();
            writer = factory.createXMLStreamWriter(os);
            writer.writeStartDocument("UTF-8", "1.0");
            
            writer.writeStartElement("Root");
            
            writer.writeStartElement("MyTag");
            writer.writeAttribute("client", "webbrowser");
            writer.writeCharacters("Servlet");
            writer.writeEndElement();
            
            writer.writeEmptyElement("attr");
            writer.writeAttribute("processor", "JSON");
            
            writer.writeEmptyElement("attr");
            writer.writeAttribute("dest", "browser");
            
            writer.writeStartElement("MyTag");
            writer.writeAttribute("client", "webbrowser");
            writer.writeCData("<data></data>");
            writer.writeEndElement();
            
            writer.writeEndElement(); // close Root
            
            writer.flush();
            
            return os.toString();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
        
        return null;
    }
    
    @Test
    public void testGenerateXml() {
        System.out.println(generateXml());
    }
    
}
