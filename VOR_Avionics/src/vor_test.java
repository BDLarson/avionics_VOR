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
	
	//@Test
	public void testDesiredRadial() {
		vor_main test2 = new vor_main();
		
		/*
		 * Tests that should be valid inputs for Intercepted Radial.
		 */
		test2.setDesiredRadial(100);
		assertEquals(100, test2.getDesiredRadial());
		
		test2.setDesiredRadial(359);
		assertEquals(359, test2.getDesiredRadial());
		
		test2.setDesiredRadial(0);
		assertEquals(0, test2.getDesiredRadial());
		
		/*
		 * Tests that should not be valid inputs for Intercepted Radial.
		 */
		test2.setDesiredRadial(400);
		assertNotEquals(400, test2.getDesiredRadial());
		
		test2.setDesiredRadial(360);
		assertNotEquals(360, test2.getDesiredRadial());
		
		test2.setDesiredRadial(-1);
		assertNotEquals(-1, test2.getDesiredRadial());

		assertEquals(0, test2.getDesiredRadial());
	}
	
	//@Test
	public void testBooleanToFrom() {
		vor_main test3 = new vor_main();
		
		/*
		 * Tests should set To/From to True.
		 */
		test3.setToFrom("yes");
		assertTrue(test3.getToFrom());
		
		test3.setToFrom("Yes");
		assertTrue(test3.getToFrom());

		/*
		 * Tests should set To/From to False.
		 */
		test3.setToFrom("no");
		assertFalse(test3.getToFrom());

		test3.setToFrom("No");
		assertFalse(test3.getToFrom());

		/*
		 * Tests should fail to set To/From to True.
		 */
		test3.setToFrom("badtest");
		assertFalse(test3.getToFrom());
		
		test3.setToFrom("12345");
		assertFalse(test3.getToFrom());
	}
	
	@Test
	public void testDeflection() {
		vor_main test4 = new vor_main();
		
		/**
		 * Tests an Intercepted radial that is higher than the Desired radial.
		 */		
		test4.setInterRadial(45);
		test4.setDesiredRadial(0);
		test4.setDeflection();
		
		assertEquals(45, test4.getDeflection());
		
		
		/**
		 * Tests an Intercepted radial that is lower than the Desired radial.
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(90);
		test4.setDeflection();
		
		assertEquals(-45, test4.getDeflection());

		/**
		 * Tests an a Desired radial that is close to 360
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(359);
		test4.setDeflection();
		
		assertEquals(46, test4.getDeflection());	
		
		/*
		 * Tests a Desired radial that is greater than 180 + Inter radial
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(226);
		test4.setDeflection();
		
		assertEquals(179, test4.getDeflection());
		
		/*
		 * Tests a Desired radial that is Less than 180 + Inter radial
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(224);
		test4.setDeflection();
		
		assertEquals(-179, test4.getDeflection());
	}
	
	@Test
	public void testDirection() {
		vor_main test5 = new vor_main();
		
	}
	
	@Test
	public void testSignal() {
		
	}
}
