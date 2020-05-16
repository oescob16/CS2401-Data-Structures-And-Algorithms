import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class Week2MWTest {

	/*
	 * maxTriple([1, 2, 3]) → 3
	 * maxTriple([1, 5, 3]) → 5
	 * maxTriple([5, 2, 3]) → 5
	 */

	@Test
	public void testMaxTriple1() {
		Week2MW sol = new Week2MW();
		int[] A = {1,2,3};
		assertEquals(3, sol.maxTriple(A)); 
	}

	@Test
	public void testMaxTriple2() {
		Week2MW sol = new Week2MW();
		int[] A = {1,5,3};
		assertEquals(5, sol.maxTriple(A)); 
	}

	@Test
	public void testMaxTriple3() {
		Week2MW sol = new Week2MW();
		int[] A = {5,2,3};
		assertEquals(5, sol.maxTriple(A)); 
	}

	/*
	 * squirrelPlay(70, false) → true
	 * squirrelPlay(95, false) → false
	 * squirrelPlay(95, true) → true
	 */

	@Test
	public void testSquirrelPlay1() {
		Week2MW sol = new Week2MW();
		assertEquals(true, sol.squirrelPlay(70, false)); 
	}

	@Test
	public void testSquirrelPlay2() {
		Week2MW sol = new Week2MW();
		assertEquals(false, sol.squirrelPlay(95, false)); 
	}

	@Test
	public void testSquirrelPlay3() {
		Week2MW sol = new Week2MW();
		assertEquals(true, sol.squirrelPlay(95, true)); 
	}

	/*
	 * maxMod5(2, 3) → 3
	 * maxMod5(6, 2) → 6
	 * maxMod5(3, 2) → 3
	 */

	@Test
	public void testMaxMod51() {
		Week2MW sol = new Week2MW();
		assertEquals(3, sol.maxMod5(2,3)); 
	}

	@Test
	public void testMaxMod52() {
		Week2MW sol = new Week2MW();
		assertEquals(6, sol.maxMod5(6,2)); 
	}

	@Test
	public void testMaxMod53() {
		Week2MW sol = new Week2MW();
		assertEquals(3, sol.maxMod5(3,2)); 
	}

	/*
	 * specialEleven(22) → true
	 * specialEleven(23) → true
	 * specialEleven(24) → false
	 */

	@Test
	public void testSpecialEleven1() {
		Week2MW sol = new Week2MW();
		assertEquals(true, sol.specialEleven(22)); 
	}

	@Test
	public void testSpecialEleven2() {
		Week2MW sol = new Week2MW();
		assertEquals(true, sol.specialEleven(23)); 
	}

	@Test
	public void testSpecialEleven3() {
		Week2MW sol = new Week2MW();
		assertEquals(false, sol.specialEleven(24)); 
	}

	/*
	 * prefixAgain("abXYabc", 1) → true
	 * prefixAgain("abXYabc", 2) → true
	 * prefixAgain("abXYabc", 3) → false
	 */

	@Test
	public void testPrefixAgain1() {
		Week2MW sol = new Week2MW();
		assertEquals(true,sol.prefixAgain("abXYabc", 1));
	}

	@Test
	public void testPrefixAgain2() {
		Week2MW sol = new Week2MW();
		assertEquals(true,sol.prefixAgain("abXYabc", 2));
	}

	@Test
	public void testPrefixAgain3() {
		Week2MW sol = new Week2MW();
		assertEquals(false,sol.prefixAgain("abXYabc", 3));
	}

	/*
	 * oneTwo("abc") → "bca"
	 * oneTwo("tca") → "cat"
	 * oneTwo("tcagdo") → "catdog"
	 */

	@Test
	public void testOneTwo1() {
		Week2MW sol = new Week2MW();
		assertEquals("bca",sol.oneTwo("abc"));
	}

	@Test
	public void testOneTwo2() {
		Week2MW sol = new Week2MW();
		assertEquals("cat",sol.oneTwo("tca"));
	}

	@Test
	public void testOneTwo3() {
		Week2MW sol = new Week2MW();
		assertEquals("catdog",sol.oneTwo("tcagdo"));
	}
	
	/*
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * withoutString("Hello there", "x") → "Hello there"
	 */

	@Test
	public void testWithoutString1() {
		Week2MW sol = new Week2MW();
		assertEquals("He there",sol.withoutString("Hello there", "llo"));
	}

	@Test
	public void testWithoutString2() {
		Week2MW sol = new Week2MW();
		assertEquals("Hllo thr",sol.withoutString("Hello there", "e"));
	}

	@Test
	public void testWithoutString3() {
		Week2MW sol = new Week2MW();
		assertEquals("Hello there",sol.withoutString("Hello there", "x"));
	}

	/*
	 * sumDigits("aa1bc2d3") → 6
	 * sumDigits("aa11b33") → 8
	 * sumDigits("Chocolate") → 0
	 */

	@Test
	public void testSumDigits1() {
		Week2MW sol = new Week2MW();
		assertEquals(6,sol.sumDigits("aa1bc2d3"));
	}

	@Test
	public void testSumDigits2() {
		Week2MW sol = new Week2MW();
		assertEquals(8,sol.sumDigits("aa11b33"));
	}

	@Test
	public void testSumDigits3() {
		Week2MW sol = new Week2MW();
		assertEquals(0,sol.sumDigits("Chocolate"));
	}

}
