package cs235a5;


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert
 */
public class xmlTest {
    
 public void getAllUserNames() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File((this.getClass().getResource("save.xml").getPath()));
            if (file.exists()) {
                Document doc = db.parse(file);
                Element docEle = doc.getDocumentElement();
 
                // Print root element of the document
                System.out.println("Root element of the document: "
                        + docEle.getNodeName());
           
                
                NodeList studentList = docEle.getElementsByTagName("Data");
                System.out.println("Total Data: " + studentList.getLength());
                if (studentList != null && studentList.getLength() > 0) {
                    for (int i = 0; i < studentList.getLength(); i++) {
                        Node node = studentList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("=====================");
                            Element e = (Element) node;
                            NodeList nodeList = e.getElementsByTagName("Date");
                            System.out.println("Data: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
 
                            nodeList = e.getElementsByTagName("File");
                            System.out.println("Urls to File: "+ nodeList.item(0).getChildNodes().item(0).getNodeValue());
                        }
                    }
                }
                
                studentList = docEle.getElementsByTagName("Chart");
                System.out.println("Total Charts: " + studentList.getLength());
                if (studentList != null && studentList.getLength() > 0) {
                    for (int i = 0; i < studentList.getLength(); i++) {
                        Node node = studentList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("=====================");
                            Element e = (Element) node;
                            NodeList nodeList = e.getElementsByTagName("ChartType");
                            System.out.println("Type: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
 
                            nodeList = e.getElementsByTagName("XColumn");
                            System.out.println("X coloumn pos: "+ nodeList.item(0).getChildNodes().item(0).getNodeValue());
 
                            nodeList = e.getElementsByTagName("YColumn");
                            System.out.println("Ycoulumn pos: "+nodeList.item(0).getChildNodes().item(0).getNodeValue());
                            
                            nodeList = e.getElementsByTagName("ChartTitle");
                            System.out.println("Title: " + nodeList.item(0).getChildNodes().item(0).getNodeValue());
                            
                             System.out.println("Scheeme: ");
                             nodeList = e.getElementsByTagName("Color");
                             int c = nodeList.getLength();
                             for(int j = 0; j <c; j++){
                                System.out.println("Color "+j+": " + nodeList.item(j).getChildNodes().item(0).getNodeValue());
                            }
                            
                        }
                    }
                }
            }else{
                System.err.println("FNF: ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
 
 
 
 
 
 
 
 
    public static void main(String[] args) {
         
        xmlTest parser = new xmlTest ();
        
        parser.getAllUserNames();
        //System.out.println(url);
    }
    
    
    
    
}


  
	
  