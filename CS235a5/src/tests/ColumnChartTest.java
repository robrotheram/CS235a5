import cs235a5.ColumnChart;
import cs235a5.Visualiser;
import static org.junit.Assert.*;

import org.junit.Test;


public class ColumnChartTest {


	@Test
	public void testSetName() {
		ColumnChart c = new ColumnChart();
		
		Visualiser.SetChartTitle("Test");
		c.SetName();
		assertEquals("Result","Test",c.GetName());
		
	}
	@Test
	public void testSetXAxis() {
		ColumnChart c = new ColumnChart();
		
		Visualiser.SetXLabel("XTest");
		c.SetXAxis();
		assertEquals("Result","XTest",c.GetXLabel());
	}

	@Test
	public void testSetYAxis() {
		ColumnChart c = new ColumnChart();
		
		Visualiser.SetYLabel("YTest");
		c.SetYAxis();
		assertEquals("Result","YTest",c.GetYLabel());
	}

	@Test
	public void testDescription() {
		ColumnChart c = new ColumnChart();
		Visualiser.SetDescription("Test Description");
		c.SetDescription();
		assertEquals("Result","Test Description",c.GetDescription());
		
	}

	



}
