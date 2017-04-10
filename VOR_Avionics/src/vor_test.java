import static org.junit.Assert.*;

import org.junit.Test;

public class vor_test {

	//@Test
	public void testInterRadial() {
		vor_main test1 = new vor_main();
		
		/*
		 * Tests that should be valid inputs for Intercepted Radial.
		 */
		test1.setInterRadial(100);
		assertEquals(100, test1.getInterRadial());
		
		test1.setInterRadial(359);
		assertEquals(359, test1.getInterRadial());
		
		test1.setInterRadial(0);
		assertEquals(0, test1.getInterRadial());
		
		test1.setInterRadial(-1);
		assertEquals(-1, test1.getInterRadial());
		
		/*
		 * Tests that should not be valid inputs for Intercepted Radial.
		 */
		test1.setInterRadial(400);
		assertNotEquals(400, test1.getInterRadial());
		
		test1.setInterRadial(360);
		assertNotEquals(360, test1.getInterRadial());
		
		
		/*
		 * Since last two tests failed, Intercepted Radial should be set to -1.
		 */
		assertEquals(-1, test1.getInterRadial());
	}
	
	@Test
	public void testDesiredRadial() {
		vor_main test1 = new vor_main();
		
		/*
		 * Tests that should be valid inputs for Intercepted Radial.
		 */
		test1.setDesiredRadial(100);
		assertEquals(100, test1.getDesiredRadial());
		
		test1.setDesiredRadial(359);
		assertEquals(359, test1.getDesiredRadial());
		
		test1.setDesiredRadial(0);
		assertEquals(0, test1.getDesiredRadial());
		
		/*
		 * Tests that should not be valid inputs for Intercepted Radial.
		 */
		test1.setDesiredRadial(400);
		assertNotEquals(400, test1.getDesiredRadial());
		
		test1.setDesiredRadial(360);
		assertNotEquals(360, test1.getDesiredRadial());
		
		test1.setDesiredRadial(-1);
		assertNotEquals(-1, test1.getDesiredRadial());

		assertEquals(0, test1.getDesiredRadial());
	}
	
	@Test
	public void testBooleanToFrom() {
		
	}
	
	@Test
	public void testDirection() {
		
	}
}
