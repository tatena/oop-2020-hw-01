
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	private HashMap <T, HashSet<T>> notAllowed;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		notAllowed = new HashMap<>();
		Iterator it = rules.iterator();
		Object curr;
		if (!it.hasNext())
			return;
		Object next = it.next();
		while (it.hasNext()) {
			curr = next;
			next = it.next();
			if (curr!= null && next != null) {
				if (notAllowed.containsKey(curr)) {
					notAllowed.get(curr).add((T) next);
				} else {
					HashSet<T> newSet = new HashSet<>();
					newSet.add((T)next);
					notAllowed.put((T)curr, newSet);
				}
			}
		}
	}

	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		 if (notAllowed.containsKey(elem))
			return notAllowed.get(elem);
		 else
		 	return Collections.emptySet();
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		if (list.isEmpty())
			return;
		int index = 0;
		Object curr = list.get(index);
		Object next;
		while (index < list.size()-1) {
			next =list.get(index+1);
			if (noFollow((T)curr).contains(next)) {
				list.remove(index+1);
			} else {
				curr = next;
				index++;
			}
		}
	}

}
