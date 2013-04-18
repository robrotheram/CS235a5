/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inBeta;

import cs235a5.CSVReader;
import cs235a5.DataCell;
import cs235a5.DataSet;
import cs235a5.DataType;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Robert
 */
public class testAlg {
    
    private ArrayList<String> m_foundElements = new ArrayList<String>();
    private ArrayList<int[]> dataset = new ArrayList<int[]>();
    
    
    public testAlg(int xPos, int yPos){
         String  p = System.getProperty("user.dir")+"/rrf.csv";
         File f = new File(p);
         DataSet db = new DataSet();
         new CSVReader(db,f,",").ParseFile();
       
         
         
        int size = 0;
        int sum = 0;
        int pos = 0;
        int j = 0;        
        DataCell preVal =db.GetCell(0, 0);
        
        
        for(int i= 0; i < db.GetNumOfRows()-1; i++ ){

            if(!isUnique(db.GetCell(xPos, i).toString())){
                for(j = pos; j < db.GetNumOfRows()-1; j++ ){
                   //System.out.println("loop");
                    if(preVal.toString().equals(db.GetCell(xPos, j).toString())){
                       //System.out.println("loop");
                        if((db.GetCell(xPos, j).GetDataType()==DataType.INTEGER)||((db.GetCell(xPos, j).GetDataType()==DataType.DOUBLE))){
                            sum += db.GetCell(yPos, j).GetDouble();  
                            System.out.println("sum = "+sum+" | at postition"+db.GetCell(xPos, j).GetDouble());
                        }
                    }  
                }
                
                m_foundElements.add(db.GetCell(xPos, i).toString());

                //Add to chart dataSet
                
                dataset.add(new int[]{sum,preVal.GetInteger()});



                preVal = db.GetCell(xPos, i++);
                sum=0;//
                pos++;             
                }
            }
        for(j = pos; j < db.GetNumOfRows()-1; j++ ){
            if(m_foundElements.get(m_foundElements.size()-1).equals(db.GetCell(xPos, j).toString())){
                 if((db.GetCell(xPos, j).GetDataType()==DataType.INTEGER)||((db.GetCell(xPos, j).GetDataType()==DataType.DOUBLE))){
                    sum += db.GetCell(yPos, j).GetDouble();  
                 }
            }
        }
        dataset.add(new int[]{sum,preVal.GetInteger()});
        outUV();
        out();
         
    }
    
    private  boolean isUnique(String val){
		 boolean found = false;
		 for (int i = 0; i< m_foundElements.size(); i++){
			 
			 if(val.equals( m_foundElements.get(i))){
				 found = true;
                                 
				 break;
			 }
			 
		 }
                  System.out.println();
		 return found;
    } 
    
    public void out(){
        for(int i =0; i<dataset.size();i++){
            int[] ds = dataset.get(i);
            System.out.println("Y Value:"+ds[1]+" | X Value:"+ds[0]);
        }
    }
    
    public void outUV(){
        for(int i =0; i<m_foundElements.size();i++){
            String ds = m_foundElements.get(i);
            System.out.println("New values :"+ds);
        }
    }
    
    public static void main(String[] args){
        testAlg t = new testAlg(0,4);
        
    }
}
