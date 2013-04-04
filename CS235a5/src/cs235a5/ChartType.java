/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs235a5;

/**
 *
 * @author Robert
 */
public enum ChartType {
    BARCHART("BarChart"),PIECHART("PieChart"),LINECHART("LineChart");
    
    private String Type;
    
    private ChartType(String s) {
        Type = s;
    }
    
    
}
