
package cs235a5;
/** @brief a enum that defines the charts being used

    Defined the chart enumeration
    @author Robert Fletcher
    @date April 2013
    @file ChartType
    */
public enum ChartType {
    BARCHART("BarChart"),PIECHART("PieChart"),LINECHART("LineChart"),AREACHART("AreaChart");
    
    private String Type;
    
    /**
     * Sets up the enumeration 
     * @param String the value of the enumeration
     */
    private ChartType(String s) {
        Type = s;
    }
    
    
}
