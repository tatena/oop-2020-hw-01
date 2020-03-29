// TabooTest.java
// Taboo class tests -- nothing provided.

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TabooTest extends TestCase {
    //handouts no nulls - strings
    public void testNoFollow1() {
        List<String> ls = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<>(ls);
        HashSet<String> res = new HashSet<>();

        assertEquals(res, taboo.noFollow("z"));

        assertEquals(res, taboo.noFollow("b"));

        res.addAll(Arrays.asList("b", "c"));
        assertEquals(res, taboo.noFollow("a"));

        res.clear();
        res.add("a");
        assertEquals(res, taboo.noFollow("c"));
    }

    //handouts with null - strings
    public void testNoFollow2() {
        List<String> ls = Arrays.asList("a", "b", null, "c", "d");
        Taboo<String> taboo = new Taboo<>(ls);
        HashSet<String> res = new HashSet<>();

        assertEquals(res, taboo.noFollow("b"));

        assertEquals(res, taboo.noFollow("d"));

        res.add("b");
        assertEquals(res, taboo.noFollow("a"));

        res.clear();
        res.add("d");
        assertEquals(res, taboo.noFollow("c"));
    }

    //strings
    public void testNoFollow3() {
        List<String> ls = Arrays.asList("a", "b", "c", null, "a", "c", "d", "a", "d", null, "a", "z", "c", "l");
        Taboo<String> taboo = new Taboo<>(ls);
        HashSet<String> res = new HashSet<>();

        assertEquals(res, taboo.noFollow("l"));

        res.addAll(Arrays.asList("z", "d", "c", "b"));
        assertEquals(res, taboo.noFollow("a"));

        res.clear();
        res.add("c");
        assertEquals(res, taboo.noFollow("b"));

        res.clear();
        res.addAll(Arrays.asList("d", "l"));
        assertEquals(res, taboo.noFollow("c"));

        res.clear();
        res.add("a");
        assertEquals(res, taboo.noFollow("d"));

        res.clear();
        res.add("c");
        assertEquals(res, taboo.noFollow("z"));
    }

    //empty test
    public void testNoFollow4() {
        List<String> ls = Arrays.asList();
        Taboo<String> taboo = new Taboo<>(ls);
        HashSet<String> res = new HashSet<>();

        assertEquals(res, taboo.noFollow("l"));
    }

    //weird nulls - ints
    public void testNoFollow5() {
        List<Integer> ls = Arrays.asList(null, 1, null, null, 1, 2, 3, null, 4, 1, 5, null);
        Taboo<Integer> taboo = new Taboo<>(ls);
        HashSet<Integer> res = new HashSet<>();

        assertEquals(res, taboo.noFollow(3));

        assertEquals(res, taboo.noFollow(5));

        assertEquals(res, taboo.noFollow(9));

        res.add(3);
        assertEquals(res, taboo.noFollow(2));

        res.clear();
        res.add(1);
        assertEquals(res, taboo.noFollow(4));

        res.clear();
        res.addAll(Arrays.asList(2, 5));
        assertEquals(res, taboo.noFollow(1));

    }

    //strings
    public void testReduce1() {
        List<String> ls = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<>(ls);
        List<String> red = new ArrayList<>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        taboo.reduce(red);
        List<String> res = Arrays.asList("a", "x", "c");

        assertEquals(res, red);
    }

    //empty
    public void testReduce2() {
        ArrayList<String> ls = new ArrayList<>();
        ls.addAll(Arrays.asList("a", "c", "a", "b", "g"));
        Taboo<String> taboo = new Taboo<>(ls);
        List<String> red = new ArrayList<>();
        taboo.reduce(red);
        List<String> res = Arrays.asList();

        assertEquals(res, red);
    }

    //integers
    public void testReduce3() {
        ArrayList<Integer> ls = new ArrayList<>();
        ls.addAll(Arrays.asList(1, 2, null, 3, 4, 6, null, 8, 9, 7, 1, 3, 2, 1, 5));
        Taboo<Integer> taboo = new Taboo<>(ls);
        ArrayList<Integer> red = new ArrayList<>(Arrays.asList(1,3,5,2,7,8,9,1,2,3,4,5));
        taboo.reduce(red);
        List<Integer> res = new ArrayList<>(Arrays.asList(1,7,8,1,4,5));

        assertEquals(res, red);
    }

    //one elem
    public void testReduce4() {
        ArrayList<String> ls = new ArrayList<>();
        ls.addAll(Arrays.asList("a", "c", "a", "b", "g"));
        Taboo<String> taboo = new Taboo<>(ls);
        List<String> red = new ArrayList<>(Arrays.asList("a"));
        taboo.reduce(red);
        List<String> res = Arrays.asList("a");

        assertEquals(res, red);
    }
}