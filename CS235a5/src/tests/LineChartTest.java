import cs235a5.LineChart;
import cs235a5.Visualisation;
import static org.junit.Assert.*;

import org.junit.Test;


public class LineChartTest {

	@Test
	public void testGetXLabel() {
		
		LineChart l = new LineChart();
		
		Visualisation.SetXLabel("XLabelTest");
		l.SetXAxis();
		//assertEquals("Result", "XLabelTest", l.GetXLabel());
		
	}

	@Test
	public void testGetYLabel() {
		
		LineChart l = new LineChart();
		
		Visualisation.SetYLabel("YLabelTest");
		l.SetYAxis();
		//assertEquals("Result", "YLabelTest", l.GetYLabel());
		
	}

	@Test
	public void testGetName() {
		
		LineChart l = new LineChart();
		
		Visualisation.SetChartTitle("TitleTest");
		l.SetName();
		//assertEquals("Result", "TitleTest", l.GetName());
	}

}
