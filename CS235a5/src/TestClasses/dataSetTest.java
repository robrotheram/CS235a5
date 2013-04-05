package TestClasses;

import cs235a5.DataSet;
import static org.junit.Assert.*;

import org.junit.Test;


public class dataSetTest {

	@Test
	public void testGetHeaders() {
		DataSet ds = new DataSet();
		ds.AddData("imperfectData.csv");
		assertNotNull("Result",ds.GetHeaders());
	}

	@Test
	public void testGetData() {
		DataSet ds = new DataSet();
		ds.AddData("imperfectData.csv");
		assertNotNull("Result",ds.GetData());
	}
	

}
