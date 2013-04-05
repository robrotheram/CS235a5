/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Robert
 */
public class Main {
    public static void main(String[] args){
      
        if((args.length==1)&&(args[0].equals("-t"))){
     
                StartTestsUI();
            
        }else{
            StartProgramUI();
        }
        
        
    }
    public static void StartProgramUI(){
        System.out.println("Starting Main Program");
         java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new cs235a5.VisualiserGUI().setVisible(true);
            }
        });
    }
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
