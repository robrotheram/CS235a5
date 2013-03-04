package cs235a5;

/**
 * \file:  ErrorHandling.java
 * \author:  Chris Waszczuk
 * \date:  3/01/2013
 *
 * \Brief: An error handling class to give off error messages if code
 * fails a check
 *
 */
import javax.swing.*;
public class ErrorHandling {
	
		/**Error message if there is an error opening the file.
		 * @return JOptionPane
		 */
		public boolean IOOpenException(){
			JOptionPane.showMessageDialog(null,"Error opening file, please enter a valid file name.");
			return true;
		}
		/**Error message if there is an error closing the file.
		 * @return JOptionPane
		 */
		public boolean IOCloseException(){
			JOptionPane.showMessageDialog(null,"Error closing file.");
			return true;
		}		
		/** Error message if the user tries to draw without previously loading data.
		 * @return JOptionPane 
		 */
		public boolean NoFileError(){
			JOptionPane.showMessageDialog(null,"Please enter a file before drawing.");
			return true;
		}
		/** Error message if the PNG file won't write properly
		 * @return JOptionPane 
		 */
		public boolean ChartError(){
			JOptionPane.showMessageDialog(null,"Problem occurred while creating a chart");
			return true;

		}
		public boolean WrongType(){
			JOptionPane.showMessageDialog(null,"Please enter a file with the extension .csv");
			return true;
		}
}
