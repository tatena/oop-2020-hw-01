import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T, Integer> occurrences = new HashMap<T, Integer>();
		fillMap(a, occurrences, 1);
		fillMap(b, occurrences, -1);
		Iterator it = occurrences.keySet().iterator();
		int res = 0;
		while (it.hasNext()) {
			if (occurrences.get(it.next()) == 0)
				res++;
		}
		return res;
	}

	private static <T> void fillMap(Collection<T> col, HashMap<T, Integer> occurrences, int i) {
		Iterator it = col.iterator();
		Object key;
		Integer value;
		while (it.hasNext()) {
			value = i;
			key = it.next();
			if(occurrences.containsKey((T)key))
				value = occurrences.get((T)key) + i;
			occurrences.put((T)key, value);
		}
	}
}
