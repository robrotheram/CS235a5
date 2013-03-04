import cs235a5.ErrorHandling;
import static org.junit.Assert.*;

import org.junit.Test;


public class ErrorHandlingTest {

	@Test
	public void testIOOpenException() {
		ErrorHandling e = new ErrorHandling();
		assertTrue("Result" , e.IOOpenException());
	}

	@Test
	public void testIOCloseException() {
		ErrorHandling e = new ErrorHandling();
		assertTrue("Result" , e.IOCloseException());
	}

	@Test
	public void testNoFileError() {
		ErrorHandling e = new ErrorHandling();
		assertTrue("Result" , e.NoFileError());
	}

	@Test
	public void testChartError() {
		ErrorHandling e = new ErrorHandling();
		assertTrue("Result" , e.ChartError());
	}

}
