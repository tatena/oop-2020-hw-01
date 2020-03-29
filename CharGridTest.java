
// Test cases for CharGrid -- a few basic tests are provided.

import junit.framework.TestCase;

public class CharGridTest extends TestCase {
	
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}

	//empty grid
	public void testCharArea3() {
		char[][] grid = new char[][] {

		};
		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('a'));
		assertEquals(0, cg.charArea('b'));
		assertEquals(0, cg.charArea('c'));
	}

	// chars not in grid
	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(0, cg.charArea('z'));
		assertEquals(0, cg.charArea('p'));
		assertEquals(0, cg.charArea('j'));
	}

	// Area equals whole grid
	public void testCharArea5(){
		char[][] grid = new char[][] {
				{'c', 'a', 'b'},
				{'b', 'a', 'b'},
				{'c', 'b', 'c'}
		};

		CharGrid cg = new CharGrid(grid);

		assertEquals(9, cg.charArea('b'));
		assertEquals(9, cg.charArea('b'));
		assertEquals(9, cg.charArea('b'));
	}

	// test from handouts
	public void testPlus0() {
		char[][] grid = new char[][] {
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
				{'z', 'z', 'z', 'z', ' ', 'y', 'z', 'z', 'z'},
				{' ', 'p', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(2, cg.countPlus());
	}

	// One large plus
	public void testPlus1() {
		char[][] grid = new char[][] {
				{'c', 'a', 'd'},
				{'a', 'a', 'a'},
				{' ', 'a', 'c'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	//small plus in grid
	public void testPlus2() {
		char[][] grid = new char[][] {
				{'c', 'a', 'd', 'd'},
				{'a', 'a', 'a', 'h'},
				{' ', 'a', 'c', 'f'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(1, cg.countPlus());
	}

	// no plus
	public void testPlus3() {
		char[][] grid = new char[][] {
				{'c', 'a', 'd', 'd'},
				{'a', 'j', 'a', 'h'},
				{' ', 'a', 'c', 'f'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}

	//pluses with no interception
	//pluses with ' ', '1', 'b' (upper right corner), '0'
	public void testPlus4() {
		char[][] grid = new char[][] {
				{'b', ' ', ' ', 'b', 'b', 'b'},
				{' ', ' ', ' ', 'b', 'b', 'b'},
				{'b', ' ', 'l', '1', 'b', 'b'},
				{'b', 'l', 'l', 'l', '0', 'b'},
				{'b', 'b', 'l', '0', '0', '0'},
				{'b', 'b', 'b', '0', '0', 'b'}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(4, cg.countPlus());
	}

	//pluses with no interception larger grid
	//pluses with 'a', ' ', '5', '4', '3', '2'
	public void testPlus5() {
		char[][] grid = new char[][] {
				{' ', ' ', 'a', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'a', '1', '1', ' ', ' ', ' '},
				{'a', 'a', 'a', 'a', 'a', ' ', ' ', ' '},
				{' ', ' ', 'a', 'a', ' ', ' ', '1', ' '},
				{' ', '6', 'a', 'a', 'a', '5', ' ', ' '},
				{'6', '6', '6', 'a', ' ', '5', ' ', ' '},
				{' ', '6', ' ', '5', '5', '5', '5', '5'},
				{' ', '6', '7', ' ', ' ', '5', ' ', ' '},
				{'7', '7', '7', '7', '7', '5', ' ', ' '},
				{' ', ' ', '7', '4', ' ', ' ', ' ', ' '},
				{' ', '3', '4', '4', '4', ' ', '2', ' '},
				{'3', '3', '3', '4', ' ', '2', '2', '2'},
				{' ', '3', ' ', ' ', ' ', ' ', '2', ' '}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(6, cg.countPlus());
	}

	//pluses with interception
	//pluses with 'a', ' ', '5', '4', '3', '2'
	public void testPlus6() {
		char[][] grid = new char[][] {
				{' ', ' ', ' ', '1', ' ', '1', ' ', ' ', '1', ' '},
				{' ', ' ', '1', '1', '1', '1', ' ', '1', '1', '1'},
				{' ', ' ', ' ', '1', ' ', '1', ' ', ' ', '1', ' '},
				{'1', '1', '1', '1', '1', '1', '1', ' ', ' ', ' '},
				{' ', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
				{' ', ' ', ' ', '1', ' ', '1', ' ', ' ', ' ', ' '},
				{' ', ' ', ' ', '1', ' ', '1', ' ', ' ', ' ', ' '},
				{' ', ' ', '1', ' ', ' ', '1', '1', ' ', ' ', ' '},
				{' ', ' ', ' ', ' ', ' ', '1', '1', '1', ' ', ' '},
				{' ', '1', ' ', ' ', ' ', ' ', '1', '1', '1', ' '},
				{'1', '1', '1', ' ', ' ', ' ', ' ', '1', ' ', ' '},
				{' ', '1', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(6, cg.countPlus());
	}
	//empty grid
	public void testPlus7() {
		char[][] grid = new char[][] {
		};
		CharGrid cg = new CharGrid(grid);
		assertEquals(0, cg.countPlus());
	}
}
