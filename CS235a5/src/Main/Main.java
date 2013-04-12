/*! \mainpage CS235 Visuliser Documnetation
 *
 * \section intro_sec Introduction
 *
 * This Program will beable to Load data from a CSV File and display it in a 
 * table. You will also be able to make a number of charts from the dataset
 * <br>
 * Project Authors
 * <ul>
 * <li>Robert Fletcher</li>
 * <li>Kerry Tolhurst</li>
 * <li>William Bray</li>
 * <li>William Jones</li>
 * <li>Alex McDonough</li>
 * <li>Wyler Gu</li>
 * <li>Zhenjie Mu</li>
 * </ul>
 *
 * \section install_sec Installation
 *
 * \subsection step1 Step 1: Download the zip file
 * \subsection step2 Step 2: Extract the zip file
 * \subsection step3 Step 3: Run the GroupMSAplication.jar
 * \subsection step4 Step 4: In the terminal add the argument '-t' to launch the
 * debug UI
 *  
 *
 */




package Main;
/** @brief This main class for the program

   This class checks the arguments sent to the program to see if it is to be 
   * launched in debug mode
    @author Robert Fletcher
    @file main.java
    @date April 2013
    */
public class Main {
    /**
     * This class check to see what arguments have benn entered and checks them
     * to see if the user wants the program to launch the datavisuliser UI or 
     * the debug UI
     * @param String[] arguments given to the program
     */
    public static void main(String[] args){  
        if((args.length==1)&&(args[0].equals("-t"))){
                StartTestsUI();
        }else{
            StartProgramUI();
        }
        
        
    }
    
    /**
     * Static method to launch the Data Visualizer IO in a runnable object
     */
    public static void StartProgramUI(){
        System.out.println("Starting Main Program");
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               // new cs235a5.VisualiserGUI().setVisible(true);
            }
        });
    }
    /**
     * Static method to launch the Data Visualizer Debug UI IO in a runnable 
     * object
     */
    
    
    public static void StartTestsUI(){
        System.out.println("Starting Debug Program");
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestUI.TestingUI().setVisible(true);
            }
        });
    }
    
}
