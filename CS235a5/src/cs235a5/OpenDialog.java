
package cs235a5;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/** @brief This class is used to open a file

    This class gets the user to select a file, the program will then read it and
    * add the charts to the tabPannel
    * classes
    @author Robert Fletcher
    @file TabPannel.java
    @date April 2013
    */

public class OpenDialog {
    /**
     * Class Constructor 
     * @param DataSet the programs dataSet
     * @param TabPannel The programs TabPannel
     */
    public OpenDialog(DataSet db, TabPannel tp){
        if(!setDataSet(db)){
            System.out.println("SaveDialog.SetDataSet()-Failed to"
                    + " set the DataSet");
        }
        if(!setTabPannel(tp)){
            System.out.println("SaveDialog.SetTabPannel()-Failed to"
                    + " set the DataSet");
        }
    }
    
    /**
     * Sets the DataSet for the class
     * @param DataSet db
     * @return boolean True if set Correctly
     */
    private boolean setDataSet(DataSet db){
        m_db = db;
        return true;
    }
    /**
     * Sets the Memory reference to the Programs TabPanel
     * @param TabPannel 
     * @return boolean True if set Correctly
     */
    private boolean setTabPannel(TabPannel tp){
        m_tp = tp;
        return true;
    
    }
    
   /**
    * Gets the File the user wants to open.
    * @return File - The File the program will read.
    */ 
    private File getOpenFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(
        "XML Files Only", "xml"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
         
        }else{
            return null;
        }
    }
    
   
    /**
     * XML Parser, will read through the XML file and make replace the old 
     * DataSet and fill the tabPanel with new charts
     * @return boolean True if parsed with no errors
     */
    public boolean ReadFile(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = getOpenFile();
            //File file = new File("/Users/Robert/Desktop/save.xml");
            boolean parse = false;
            if (file.exists()) {
                  Document doc = db.parse(file);
                  Element docEle = doc.getDocumentElement();
                  
                  NodeList studentList = docEle.getElementsByTagName("Data");
                  
                  if (studentList != null && studentList.getLength() > 0) {
                      for (int i = 0; i < studentList.getLength(); i++) {
                          Node node = studentList.item(i);
                          if (node.getNodeType() == Node.ELEMENT_NODE) {
                              
                              Element e = (Element) node;
                              NodeList nodeList =
                                      
                                      e.getElementsByTagName("Date");
                              System.out.println("Data: " + nodeList.item(0)
                                      .getChildNodes().item(0).getNodeValue());

                              nodeList = e.getElementsByTagName("File");
                              String url = nodeList.item(0).getChildNodes()
                                      .item(0).getNodeValue();
                              CSVReader r = new CSVReader(
                                                            m_db, 
                                                            new File(url),
                                                            ",");
                              
                              if(r.ParseFile()){
                                   parse = true;
                              }
                          }
                      }
                  }
                  if(parse){
                    studentList = docEle.getElementsByTagName("Chart");
                    System.out.println("Total Charts: " 
                            + studentList.getLength());
                    
                    if (studentList != null && studentList.getLength() > 0) {
                        System.err.println("Error 1");
                        for (int i = 0; i < studentList.getLength(); i++) {
                            System.err.println("Error 2");
                            Node node = studentList.item(i);
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                System.err.println("Error 3");
                                Element e = (Element) node;
                                NodeList nodeList = 
                                        e.getElementsByTagName("ChartType");
                                String type = 
                       nodeList.item(0).getChildNodes().item(0).getNodeValue();
                                System.out.println(type);
                                nodeList = e.getElementsByTagName("XColumn");
                                int x = Integer.parseInt
                     (nodeList.item(0).getChildNodes().item(0).getNodeValue());

                                nodeList = e.getElementsByTagName("YColumn");
                                int y = Integer.parseInt
                     (nodeList.item(0).getChildNodes().item(0).getNodeValue());

                                nodeList = e.getElementsByTagName("ChartTitle");
                                String title =
                    nodeList.item(0).getChildNodes().item(0).getNodeValue();
                                
                                nodeList = e.getElementsByTagName("Author");
                                String author =
                    nodeList.item(0).getChildNodes().item(0).getNodeValue();
                                
                                nodeList = e.getElementsByTagName("Desc");
                                String desc =
                    nodeList.item(0).getChildNodes().item(0).getNodeValue();

                                nodeList = e.getElementsByTagName("Color");
                                int c = nodeList.getLength();
                                Color[] clrArr = new Color[c];
                             for(int j = 0; j <c; j++){
                                String[] rgbStr =
            nodeList.item(j).getChildNodes().item(0).getNodeValue().split(",");
                                
                                int red = Integer.parseInt(rgbStr[RED]);
                                int green = Integer.parseInt(rgbStr[GREEN]);
                                int blue = Integer.parseInt(rgbStr[BLUE]);
                                clrArr[j] =  new Color(red,green,blue);
                                
                            }
                            //addChart(type,x,y,title,author,desc,clrArr);
                             

                            }
                            
                        }
                    }
                   return true; 
                  }
              }else{
                  System.err.println("FNF: ");
                  return false; 
              }
        } catch (SAXException ex) {
            return false; 
        } catch (IOException ex) {
           return false; 
        } catch (ParserConfigurationException ex) {
            return false; 
            
        }
        return false;
    }
    /**
     * Adds the chart with the parameters given from the file to the TabPannel 
     * @param ChartType Type of Chart
     * @param int x axis column Position from the DataSet
     * @param int y axis column Position from the DataSet
     * @param String Chart Title
     * @param String Chart Author
     * @param String Chart Description
     * @param Color[] Array of Colors used in the ColourMap for the Chart  
     */
    private void addChart(String ct,
            int x, int y,
            String title,
            String author, 
            String desc, 
            Color[] clrs){
        
       if(ct.equals(ChartType.BARCHART.toString())){
           ColumnChart c = new ColumnChart(
                   m_db,
                   x,
                   y,
                   title,
                   m_tp.getBounds(),
                   new ColourMap(clrs),
                   author,
                   desc);
           
           c.SetChartType(ChartType.BARCHART);
           //m_tp.AddTab(title, c);
       }
        
        
    }
    
    
    
    
    private DataSet m_db;
    private TabPannel m_tp;
    private final int RED = 0;
    private final int GREEN = 1;
    private final int BLUE = 2;
    
}
