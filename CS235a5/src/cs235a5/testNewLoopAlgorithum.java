/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Robert
 */
public class testNewLoopAlgorithum {
  private static ArrayList<String> foundElements;
  
  private static ArrayList<String[]> chartData = new ArrayList<String[]>();
  
  public static void main (String[] args){
      
      File f = new File("/Users/Robert/Desktop/coal.csv");
      DataSet m_db = new DataSet();
      CSVReader csv = new CSVReader(m_db,f,",");
      csv.ParseFile();

      if(csv.ParseFile()){
        int size = 0;
        int sum = 0;
        int pos = 0;
        int j= 0;
        int xPosition = 0;
        int yPosition = 4;

        DataCell preVal = m_db.GetCell(0, 0);
        foundElements  = new ArrayList<String>();
        
        
        for(int i= 0; i < m_db.GetNumOfRows()-1; i++ ){
            
            if(!isUnique(m_db.GetCell(xPosition, i).toString())){
                for(j = pos; j < m_db.GetNumOfRows()-1; j++ ){
                    if(preVal.toString().equals(m_db.GetCell(xPosition, j).toString())){
                        
                        
                        System.out.println("DatatType= :"+m_db.GetCell(xPosition, j).GetDataType());
                        //Check if datatype is a number
                        if(m_db.GetCell(xPosition, j).GetDataType()==DataType.INTEGER){
                            sum += m_db.GetCell(yPosition, j).GetInteger();  
                        }else if(m_db.GetCell(xPosition, j).GetDataType()==DataType.DOUBLE){
                            sum += m_db.GetCell(yPosition, j).GetDouble(); 
                        }
                    }
                }
                foundElements.add(m_db.GetCell(xPosition, i).toString());
                
                //Add to chart dataSet
                String[] temp = {m_db.GetCell(xPosition, i).toString(),Integer.toString(sum)};
                chartData.add(temp); 
                
                
                System.out.println("Make Chart"+("j = "+m_db.GetCell(xPosition, i).toString()));    
                preVal = m_db.GetCell(xPosition, i++);
                sum=0;//
                pos++;	            
                }
            }
        }  
    System.out.println();
    System.out.println();       
    System.out.println("---------------- output --------------------");
    
    for (int i = 0; i<chartData.size(); i++){
         System.out.println("Poisition: "+i+" From ChatDataSet:  "+chartData.get(i)[0]+"   |   "+chartData.get(i)[1]);
    }
}

	 private static boolean isUnique(String val){
		 boolean found = false;
		 for (int i = 0; i<foundElements.size(); i++){
			 
			 if(val.equals(foundElements.get(i))){
				 found = true;
                                 System.out.print(foundElements.get(i));
				 break;
			 }
			 
		 }
                  System.out.println();
		 return found;
	 }
}