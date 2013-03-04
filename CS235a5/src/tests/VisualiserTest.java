import cs235a5.Visualiser;
import static org.junit.Assert.*;

import org.junit.Test;


public class VisualiserTest {

	@Test
	public void testGetChartTitle() {
		
		Visualiser.SetChartTitle("TitleTest");
		assertEquals("Result", "TitleTest", Visualiser.GetChartTitle() );

	}

	@Test
	public void testGetXLabel() {
		
		Visualiser.SetXLabel("XTest");
		assertEquals("Result", "XTest", Visualiser.GetXLabel() );
	
	}

	@Test
	public void testGetYLabel() {
		
		Visualiser.SetYLabel("YTest");
		assertEquals("Result", "YTest", Visualiser.GetYLabel() );
		
	}

	@Test
	public void testGetScale() {
		
		int ScaleTest = 5;
		Visualiser.SetScale(ScaleTest);
		assertEquals("Result", 5, Visualiser.GetScale() );
		
	}

	@Test
	public void testGetAuthor() {
		
		Visualiser.SetAuthor("AuthorTest");
		assertEquals("Result", "AuthorTest", Visualiser.GetAuthor() );
	}

	@Test
	public void testGetDescription() {
		
		Visualiser.SetDescription("DescriptionTest");
		assertEquals("Result", "DescriptionTest", Visualiser.GetDescription() );
		
	}
	
	@Test
	public void testGetColourLight() {
		
		Visualiser.SetColour("Light");
		assertEquals("Result", "Light", Visualiser.GetColourScheme() );
		
	}
	
	@Test
	public void testGetColourGreyscale() {
		
		Visualiser.SetColour("Greyscale");
		assertEquals("Result", "Greyscale", Visualiser.GetColourScheme() );
		
	}
	
	@Test
	public void testGetColourDefault() {
		
		Visualiser.SetColour("ColourTest");
		assertEquals("Result", "Default", Visualiser.GetColourScheme() );
		
	}

}
