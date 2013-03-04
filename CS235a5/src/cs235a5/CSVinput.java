package cs235a5;

/**
 * \file:  CSVinput.java
 * \author:  Chris Waszczuk
 * \date:  3/01/2013
 *
 * \Brief: Reads the file and creates a string that is 
 * easier for the dataSet class to read
 *
 */
import java.io.*;

import javax.swing.JOptionPane;
// unit tests
public class CSVinput {
	
	/** Buffered reader for input file
	*/
	private BufferedReader m_input;
	
	/** String for output of the CSV file
	*/
	String output = "";
	
	/** Constructor for the error handling class
	*/
	ErrorHandling err = new ErrorHandling();
	
	/** Reads data after CSV has been opened into a string
	    @return String Output
		@return JOptionPane
	*/
	private boolean dataStorage(){
		try{
			String dataRow = m_input.readLine();  
			while (dataRow != null){
				output += dataRow;
				output += "/";
				dataRow = m_input.readLine();
			}
		} catch (IOException e){
			err.IOOpenException();
			return false;
		}
		return true;	
	}


	/** Reads the CSV file
	@return String fileName
	@return JOptionPane
	*/
	public boolean SetInput(String fileName){
		try {		
			 m_input = new BufferedReader(new FileReader(fileName));
			 dataStorage();
			 CloseInputFile();
		} catch (FileNotFoundException fileNotFoundException) {
			err.IOOpenException();
	        return false;
		}
		return true;
	}
	
	/**Closes the input file
	@return String fileName
	@return JOptionPane
	*/
	private boolean CloseInputFile(){
		if (m_input != null)
			try {	
				m_input.close();
			} catch (IOException ioException) {
				err.IOCloseException();
		        return false;
			}
		return true;
	}
	
	/** Public class to return the data
	@return String output
	*/
	public String GetData() {
		return output;
	}
}
