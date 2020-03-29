import junit.framework.TestCase;

import java.util.*;

public class AppearancesTest extends TestCase {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(b, a));
	}
	
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
	}

	//empty
	public void testSameCount3() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList();
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList()));
	}

	//strings
	public void testSameCount4() {
		// basic List<String> cases
		List<String> a = Arrays.asList("a", "b", "b", "c", "d", "", "", "e", "f", "f", "f", "f");
		assertEquals(3, Appearances.sameCount(a, Arrays.asList("a", "", "", "c", "c", "e")));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList("b", "b", "", "c", "f", "f")));
		assertEquals(7, Appearances.sameCount(a, Arrays.asList("a", "b", "b", "c", "d", "", "", "e", "f", "f", "f", "f")));
	}
}
