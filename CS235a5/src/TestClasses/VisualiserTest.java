package TestClasses;

import cs235a5.Visualisation;
import static org.junit.Assert.*;

import org.junit.Test;


public class VisualiserTest {

	@Test
	public void testGetChartTitle() {
		
		Visualisation.SetChartTitle("TitleTest");
		assertEquals("Result", "TitleTest", Visualisation.GetChartTitle() );

	}

	@Test
	public void testGetXLabel() {
		
		Visualisation.SetXLabel("XTest");
		assertEquals("Result", "XTest", Visualisation.GetXLabel() );
	
	}

	@Test
	public void testGetYLabel() {
		
		Visualisation.SetYLabel("YTest");
		assertEquals("Result", "YTest", Visualisation.GetYLabel() );
		
	}

	@Test
	public void testGetScale() {
		
		int ScaleTest = 5;
		Visualisation.SetScale(ScaleTest);
		assertEquals("Result", 5, Visualisation.GetScale() );
		
	}

	@Test
	public void testGetAuthor() {
		
		Visualisation.SetAuthor("AuthorTest");
		assertEquals("Result", "AuthorTest", Visualisation.GetAuthor() );
	}

	@Test
	public void testGetDescription() {
		
		Visualisation.SetDescription("DescriptionTest");
		assertEquals("Result", "DescriptionTest", Visualisation.GetDescription() );
		
	}
	
	@Test
	public void testGetColourLight() {
		
		Visualisation.SetColour("Light");
		assertEquals("Result", "Light", Visualisation.GetColourScheme() );
		
	}
	
	@Test
	public void testGetColourGreyscale() {
		
		Visualisation.SetColour("Greyscale");
		assertEquals("Result", "Greyscale", Visualisation.GetColourScheme() );
		
	}
	
	@Test
	public void testGetColourDefault() {
		
		Visualisation.SetColour("ColourTest");
		assertEquals("Result", "Default", Visualisation.GetColourScheme() );
		
	}

}
