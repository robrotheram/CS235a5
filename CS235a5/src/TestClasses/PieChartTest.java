package TestClasses;

import cs235a5.PieChart;
import cs235a5.Visualisation;
import static org.junit.Assert.*;

import org.junit.Test;


public class PieChartTest {

	
	@Test
	public void testSetName() {
		PieChart p = new PieChart();
		Visualisation.SetChartTitle("Test Title");
		p.SetName();
		assertEquals("Result","Test Title",p.GetName());
	}

	

	@Test
	public void testDescription() {
		PieChart p = new PieChart();
		Visualisation.SetDescription("Test Description");
		p.SetDescription();
		assertEquals("Result","Test Description",p.GetDescription());
	}

	

}
