import static org.junit.Assert.*;
import org.junit.Test;

public class vor_test {

	@Test
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
	
	@Test
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
		assertEquals("Right", test4.getBearing());

		
		/**
		 * Tests an Intercepted radial that is lower than the Desired radial.
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(90);
		test4.setDeflection();
		
		assertEquals(-45, test4.getDeflection());
		assertEquals("Left", test4.getBearing());

		/**
		 * Tests an a Desired radial that is close to 360
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(359);
		test4.setDeflection();
		
		assertEquals(46, test4.getDeflection());	
		assertEquals("Right", test4.getBearing());

		/*
		 * Tests a Desired radial that is greater than 180 + Inter radial
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(226);
		test4.setDeflection();
		
		assertEquals(179, test4.getDeflection());
		assertEquals("Right", test4.getBearing());

		/*
		 * Tests a Desired radial that is Less than 180 + Inter radial
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(224);
		test4.setDeflection();
		
		assertEquals(-179, test4.getDeflection());
		assertEquals("Left", test4.getBearing());

		/*
		 * Tests a desired radial that is opposite of intercepted radial.
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(225);
		test4.setDeflection();
		
		assertEquals(-180, test4.getDeflection());
		assertEquals("Center", test4.getBearing());
		
		/*
		 * Tests a desired radial that is equal to intercepted radial.
		 */
		test4.setInterRadial(45);
		test4.setDesiredRadial(45);
		test4.setDeflection();
		
		assertEquals(0, test4.getDeflection());
		assertEquals("Center", test4.getBearing());
	}
	
	@Test
	public void testDirection() {
		vor_main test5 = new vor_main();
		
		/*
		 * Checking deflection angles that are within 90 degrees, should be TO
		 */
		test5.setInterRadial(45);
		test5.setDesiredRadial(0);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("TO", test5.getDirection());
		
		test5.setInterRadial(45);
		test5.setDesiredRadial(90);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("TO", test5.getDirection());
		
		test5.setInterRadial(45);
		test5.setDesiredRadial(359);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("TO", test5.getDirection());
		
		/*
		 * Test that checks equal radials, should be TO
		 */
		test5.setInterRadial(45);
		test5.setDesiredRadial(45);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("TO", test5.getDirection());
		
		/*
		 * Checking deflection angles that are outside 90 degrees, should be FROM
		 */
		test5.setInterRadial(45);
		test5.setDesiredRadial(314);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("FROM", test5.getDirection());
		
		test5.setInterRadial(45);
		test5.setDesiredRadial(136);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("FROM", test5.getDirection());
		
		test5.setInterRadial(45);
		test5.setDesiredRadial(300);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("FROM", test5.getDirection());
		
		test5.setInterRadial(45);
		test5.setDesiredRadial(200);
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("FROM", test5.getDirection());
		
		/*
		 * Tests that check 90 degree radial, plane is abeam the station.
		 */
		test5.setInterRadial(45);
		test5.setDesiredRadial(135); // +90 degree radial
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("ABEAM", test5.getDirection());
		
		test5.setInterRadial(45);
		test5.setDesiredRadial(315); //-90 degree radial
		test5.setDeflection();
		test5.setDirection();
			
		assertEquals("ABEAM", test5.getDirection());
		
	}
	
	@Test
	public void testSignal() {
		vor_main test6 = new vor_main();
		
		/*
		 * Tests that check signals for deflections not equal to 90 degrees
		 */
		test6.setInterRadial(45);
		test6.setDesiredRadial(0);
		test6.setDeflection();
		test6.setDirection();
		test6.setSignal();
			
		assertEquals("GOOD", test6.getSignal());
		
		test6.setInterRadial(45);
		test6.setDesiredRadial(90);
		test6.setDeflection();
		test6.setDirection();
		test6.setSignal();
			
		assertEquals("GOOD", test6.getSignal());
		
		/*
		 * Test that check signal for deflection that is -1 degree from 90 
		 */
		test6.setInterRadial(45);
		test6.setDesiredRadial(314);
		test6.setDeflection();
		test6.setDirection();
		test6.setSignal();
			
		assertEquals("BAD", test6.getSignal());
		
		/*
		 * Test that check signal for deflection that is +1 degree from 90 
		 */		
		test6.setInterRadial(45);
		test6.setDesiredRadial(136);
		test6.setDeflection();
		test6.setDirection();
		test6.setSignal();
			
		assertEquals("BAD", test6.getSignal());
		
		/*
		 * Test that check signal for deflection that is equal to 90 
		 */
		test6.setInterRadial(45);
		test6.setDesiredRadial(135);
		test6.setDeflection();
		test6.setDirection();
		test6.setSignal();
			
		assertEquals("BAD", test6.getSignal());
		
		/*
		 * Test that check signal for a negative intercepted radial, represents BAD 
		 */
		test6.setInterRadial(-45);
		test6.setDesiredRadial(135);
		test6.setDeflection();
		test6.setDirection();
		test6.setSignal();
			
		assertEquals("BAD", test6.getSignal());
	}
	
	@Test
	public void testFull() {
		vor_main test7 = new vor_main();
		
		/*
		 * Full test for Desired radial that is greater
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(90);
		test7.setDeflection();
		test7.setToFrom("Yes");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(90, test7.getDesiredRadial());
		assertEquals(-45, test7.getDeflection());
		assertEquals(true, test7.getToFrom());
		assertEquals("TO", test7.getDirection());
		assertEquals("Left", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());

		/*
		 * Full test for Desired radial that is lesser
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(0);
		test7.setDeflection();
		test7.setToFrom("Yes");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(0, test7.getDesiredRadial());
		assertEquals(45, test7.getDeflection());
		assertEquals(true, test7.getToFrom());
		assertEquals("TO", test7.getDirection());
		assertEquals("Right", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());

		/*
		 * Full test for Desired radial that is equal
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(45);
		test7.setDeflection();
		test7.setToFrom("Yes");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(45, test7.getDesiredRadial());
		assertEquals(0, test7.getDeflection());
		assertEquals(true, test7.getToFrom());
		assertEquals("TO", test7.getDirection());
		assertEquals("Center", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());
		
		/*
		 * Full test for Desired radial that is equal to opposite 180 radial
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(225);
		test7.setDeflection();
		test7.setToFrom("No");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(225, test7.getDesiredRadial());
		assertEquals(-180, test7.getDeflection());
		assertEquals(false, test7.getToFrom());
		assertEquals("FROM", test7.getDirection());
		assertEquals("Center", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());
		
		/*
		 * Full test for Desired radial that is close to greater limit
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(359);
		test7.setDeflection();
		test7.setToFrom("Yes");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(359, test7.getDesiredRadial());
		assertEquals(46, test7.getDeflection());
		assertEquals(true, test7.getToFrom());
		assertEquals("TO", test7.getDirection());
		assertEquals("Right", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());
		
		/*
		 * Full test for Intercepted radial that is close to greater limit
		 */
		test7.setInterRadial(359);
		test7.setDesiredRadial(45);
		test7.setDeflection();
		test7.setToFrom("Yes");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(359, test7.getInterRadial());
		assertEquals(45, test7.getDesiredRadial());
		assertEquals(-46, test7.getDeflection());
		assertEquals(true, test7.getToFrom());
		assertEquals("TO", test7.getDirection());
		assertEquals("Left", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());
		
		/*
		 * Full test for Desired radial that is close to opposite 180 radial
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(226);
		test7.setDeflection();
		test7.setToFrom("No");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(226, test7.getDesiredRadial());
		assertEquals(179, test7.getDeflection());
		assertEquals(false, test7.getToFrom());
		assertEquals("FROM", test7.getDirection());
		assertEquals("Right", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());
		
		/*
		 * Full test for Desired radial that is close to opposite 180 radial
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(224);
		test7.setDeflection();
		test7.setToFrom("No");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(224, test7.getDesiredRadial());
		assertEquals(-179, test7.getDeflection());
		assertEquals(false, test7.getToFrom());
		assertEquals("FROM", test7.getDirection());
		assertEquals("Left", test7.getBearing());
		assertEquals("GOOD", test7.getSignal());
		
		/*
		 * Full tests for Desired radial that is equal to 90 degree radial
		 */
		test7.setInterRadial(45);
		test7.setDesiredRadial(135);
		test7.setDeflection();
		test7.setToFrom("Yes");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(135, test7.getDesiredRadial());
		assertEquals(-90, test7.getDeflection());
		assertEquals(true, test7.getToFrom());
		assertEquals("ABEAM", test7.getDirection());
		assertEquals("Left", test7.getBearing());
		assertEquals("BAD", test7.getSignal());
		
		test7.setInterRadial(45);
		test7.setDesiredRadial(315);
		test7.setDeflection();
		test7.setToFrom("No");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(45, test7.getInterRadial());
		assertEquals(315, test7.getDesiredRadial());
		assertEquals(90, test7.getDeflection());
		assertEquals(false, test7.getToFrom());
		assertEquals("ABEAM", test7.getDirection());
		assertEquals("Right", test7.getBearing());
		assertEquals("BAD", test7.getSignal());
		
		/*
		 * Full test for Intercepted radial that is negative (indicates BAD signal)
		 * Program will NOT print out these values except that the Signal is BAD
		 */
		test7.setInterRadial(-300);
		test7.setDesiredRadial(45);
		test7.setDeflection();
		test7.setToFrom("No");
		test7.setDirection();
		test7.setSignal();
		
		assertEquals(-300, test7.getInterRadial());
		assertEquals(45, test7.getDesiredRadial());
		assertEquals(15, test7.getDeflection());
		assertEquals(false, test7.getToFrom());
		assertEquals("TO", test7.getDirection());
		assertEquals("Right", test7.getBearing());
		assertEquals("BAD", test7.getSignal());
	}
}
