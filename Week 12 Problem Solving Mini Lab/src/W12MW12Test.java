import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class W12MW12Test {

	/*
	 * maxMod5(2, 3) → 3
	 * maxMod5(6, 2) → 6
	 * maxMod5(3, 2) → 3
	 */

	@Test
	public void testMaxMod51() {
		W12MW12 sol = new W12MW12();
		assertEquals(3, sol.maxMod5(2,3)); 
	}

	@Test
	public void testMaxMod52() {
		W12MW12 sol = new W12MW12();
		assertEquals(6, sol.maxMod5(6,2)); 
	}

	@Test
	public void testMaxMod53() {
		W12MW12 sol = new W12MW12();
		assertEquals(3, sol.maxMod5(3,2)); 
	}

	/*
	 * repeatFront("Chocolate", 4) → "ChocChoChC"
	 * repeatFront("Chocolate", 3) → "ChoChC"
	 * repeatFront("Ice Cream", 2) → "IcI"
	 */

	@Test
	public void testRepeatFront1() {
		W12MW12 sol = new W12MW12();
		assertEquals("ChocChoChC",sol.repeatFront("Chocolate", 4));
	}

	@Test
	public void testRepeatFront2() {
		W12MW12 sol = new W12MW12();
		assertEquals("ChoChC",sol.repeatFront("Chocolate", 3));
	}

	@Test
	public void testRepeatFront3() {
		W12MW12 sol = new W12MW12();
		assertEquals("IcI",sol.repeatFront("Ice Cream", 2));
	}

	/*
	 * canBalance([1, 1, 1, 2, 1]) → true
	 * canBalance([2, 1, 1, 2, 1]) → false
	 * canBalance([10, 10]) → true
	 */
	
	@Test
	public void testCanBalance1() {
		W12MW12 sol = new W12MW12();
		int[] A = {1,1,1,2,1};
		assertEquals(true,sol.canBalance(A));
	}

	@Test
	public void testCanBalance2() {
		W12MW12 sol = new W12MW12();
		int[] A = {2,1,1,2,1};
		assertEquals(false,sol.canBalance(A));
	}

	@Test
	public void testCanBalance3() {
		W12MW12 sol = new W12MW12();
		int[] A = {10,10};
		assertEquals(true,sol.canBalance(A));
	}

	/*
	 * array220([1, 2, 20], 0) → true
	 * array220([3, 30], 0) → true
	 * array220([3], 0) → false
	 */
	
	@Test
	public void testArray2201() {
		W12MW12 sol = new W12MW12();
		int[] A = {1,2,20};
		assertEquals(true,sol.array220(A,0));
	}

	@Test
	public void testArray2202() {
		W12MW12 sol = new W12MW12();
		int[] A = {3,30};
		assertEquals(true,sol.array220(A,0));
	}

	@Test
	public void testArray2203() {
		W12MW12 sol = new W12MW12();
		int[] A = {3};
		assertEquals(false,sol.array220(A,0));
	}

}
