import cs235a5.PieChart;
import cs235a5.Visualiser;
import static org.junit.Assert.*;

import org.junit.Test;


public class PieChartTest {

	
	@Test
	public void testSetName() {
		PieChart p = new PieChart();
		Visualiser.SetChartTitle("Test Title");
		p.SetName();
		assertEquals("Result","Test Title",p.GetName());
	}

	

	@Test
	public void testDescription() {
		PieChart p = new PieChart();
		Visualiser.SetDescription("Test Description");
		p.SetDescription();
		assertEquals("Result","Test Description",p.GetDescription());
	}

	

}
