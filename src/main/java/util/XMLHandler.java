package util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLHandler {
    public static Document parse(String fileName) {
        File file = new File(fileName);
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        
        dbFactory = DocumentBuilderFactory.newInstance();
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(file);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        return doc;
    }
    
    public static NodeList getElements(String fileName, String tag) {
        Document doc = parse(fileName);
        NodeList nList = doc.getElementsByTagName(tag);
        return nList;
    }
    
    
}
