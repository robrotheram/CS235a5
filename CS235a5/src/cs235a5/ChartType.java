package cs235a5;
/** @brief a enum that defines the charts being used

    Defined the chart enumeration
    @author Robert Fletcher
    @date April 2013
    @file ChartType
    */
public enum ChartType {
    BARCHART("BarChart"),PIECHART("PieChart"),LINECHART("LineChart"),
    AREACHART("AreaChart"),BUBBLECHART("BubbleChart"),SCATTERPLOTCHART("Scatter Plot"),POLARCHART("Polar Chart");
    
    private String Type;
    
    /** Sets up the enumeration 
     * Sets up the enumeration that will define the chart that is currently being used
     * 
     * @param String the value of the enumeration
     */
    private ChartType(String s) {
        Type = s;
    } 
    
}
