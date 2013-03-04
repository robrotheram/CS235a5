import cs235a5.dataSet;
import static org.junit.Assert.*;

import org.junit.Test;


public class dataSetTest {

	@Test
	public void testGetHeaders() {
		dataSet ds = new dataSet();
		ds.AddData("imperfectData.csv");
		assertNotNull("Result",ds.GetHeaders());
	}

	@Test
	public void testGetData() {
		dataSet ds = new dataSet();
		ds.AddData("imperfectData.csv");
		assertNotNull("Result",ds.GetData());
	}
	

}
