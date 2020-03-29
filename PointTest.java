import junit.framework.TestCase;

// Provided testing for simple Point class.

public class PointTest extends TestCase {
	public void test1() {
		// test basic x/y/shift behavior
		Point p = new Point(1, 2);
		assertEquals("1.0 2.0", p.toString());
		assertEquals(1.0, p.getX());
		assertEquals(2.0, p.getY());
		Point p2 = p.shiftedPoint(10, -10);
		assertEquals(11.0, p2.getX());
		assertEquals(-8.0, p2.getY());
	}
	
	public void test2() {
		// test distance() and equals()
		Point p1 = new Point(1, 1);
		assertEquals("1.0 1.0", p1.toString());
		Point p2 = new Point(1, 4);
		Point p3 = new Point(4, 1);
		String s = "blaa";
		assertEquals(false, p2.equals(s));
		assertEquals(false, p2.equals(p3));
		assertEquals(false, p2.equals(p1));
		assertEquals("1.0 4.0", p2.toString());
		assertEquals(3.0, p1.distance(p2));
		assertEquals(3.0, p2.distance(p1));
		assertFalse(p1.equals(p2));
		assertTrue(p1.equals(new Point(p1)));
		assertEquals(p1, p2.shiftedPoint(0, -3));
	}


}
