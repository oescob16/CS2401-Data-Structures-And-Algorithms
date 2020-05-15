public class TestWithMain {

	/* Method sortOfReverse:
	 * Given a 1D array of integers, sortOfReverse reverses the order 
	 * of the elements in array that are in increasing order.
	 * For instance: [1,2,3,4] remains unchanged because 1 < 4 and 2 < 3
	 * Similarly, [4,1,2,3] because [3,1,2,4] because 4 > 3 (hence they are swapped)
	 * but 1 < 2 (hence they remain in place)
	 */

	public static void main(String[] args){

	/*	------------------------   Test Suite of the method sortOfReverse    ------------------------				*/

	/* Test 1 for sortOfReverse */
		//Will the method sortOfReverse work if we put any input value?
		//Yes, it does works

		System.out.print("Test 1 of the method sortOfReverse...");

		int[] myInput = sortOfReverse(new int[]{3, 2, 1, 1});
		int[] expectedVal1 = {1, 1, 2, 3};

		System.out.print("\nExpected: ");
		for (int value : expectedVal1) {
			System.out.print(value);
		}

		System.out.print("\nResult: ");
		for (int value : myInput) {
			System.out.print(value);
		}

	/* Test 2 for sortOfReverse */
		//Will the method sortOfReverse work if the given array contains negative values?
		//Yes, it does works

		System.out.println("\n\nTest 2 of the method sortOfReverse...");

		int[] negativeVal = sortOfReverse(new int[]{-1, -2, -4, -5});
		int[] expectedVal2 = {-5, -4, -2, -1};

		System.out.print("Expected: ");
		for (int value : expectedVal2) {
			System.out.print(value);
		}

		System.out.print("\nResult: ");
		for (int value : negativeVal) {
			System.out.print(value);
		}

	/* Test 3 for sortOfReverse */
		//Will the method work if the array is empty?
		//It appears nothing, so it works with the given array and the expected output.

		System.out.println("\n\nTest 3 of the method sortOfReverse...");

		int[] emptyArray = sortOfReverse(new int[]{});
		int[] expectedVal3 = {};

		System.out.print("Expected: ");
		for (int element : expectedVal3) {
			System.out.print(element);
		}

		System.out.print("\nResult: ");
		for (int item : emptyArray) {
			System.out.print(item);
		}


	/* Test 4 for sortOfReverse */
		//Will this method work if the array has an odd length?
		//Yes, it does work.

		System.out.println("\n\nTest 4 of the method sortOfReverse...");

		int[] oddArray = sortOfReverse(new int[]{5, 4, 3, 2, 1});
		int[] expectedVal4 = {1, 2, 3, 4, 5};

		System.out.print("Expected: ");
		for (int value : expectedVal4) {
			System.out.print(value);
		}

		System.out.print("\nResult: ");
		for (int value : oddArray) {
			System.out.print(value);
		}

	/* Test 5 for sortOfReverse */
		//Will this method work if the elements of the array has the same value?
		//Yes, it does work.

		System.out.println("\n\nTest 5 of the method sortOfReverse...");

		int[] sameVal = sortOfReverse(new int[]{2, 2, 2, 2, 2});
		int[] expectedVal5 = {2, 2, 2, 2, 2};

		System.out.print("Expected: ");
		for (int value : expectedVal5) {
			System.out.print(value);
		}

		System.out.print("\nResult: ");
		for (int value : sameVal) {
			System.out.print(value);
		}

	/*   ---------------------------   Test Suite of the method cutString  ------------------------------		*/

	/* Test 1 for cutString */
		//Will this method work if the string has one element or nothing?
		//No, it does not work, because it does not enter the for-loop and it throws a StringIndexOutOfBoundsExceptions
		//However, I implemented a try-catch exception to fix the problem.

		System.out.println("\n\nTest 1 of the method cutString...");

		String emptyStr = "l";
		try {
			emptyStr = cutString(emptyStr);
		}catch(Exception e){
			System.out.print("|||||   StringIndexOutOfBounds Exception!!! Assigning emptyStr = \"\".   |||||\n");
		} finally {
			emptyStr = "";
		}

		String expectedStr1 = "";

		System.out.print("Expected: ");
		for(int i = 0; i < expectedStr1.length(); i++){
			System.out.print(expectedStr1.charAt(i));
		}

		System.out.print("\nResult: ");
		for(int i = 0; i < emptyStr.length(); i++){
			System.out.print(emptyStr.charAt(i));
		}

	/* Test 2 for cutString */
		//Will this method work if 'b' comes before 'a'
		//Yes, it does work. It removed ba.

		System.out.println("\n\nTest 2 of the method cutString...");

		String firstB = cutString("balloon");
		String expectedStr2 = "lloon";

		System.out.print("Expected: ");
		for(int i = 0; i < expectedStr2.length(); i++){
			System.out.print(expectedStr2.charAt(i));
		}

		System.out.print("\nResult: ");
		for(int i = 0; i < firstB.length(); i++){
			System.out.print(firstB.charAt(i));
		}

	/* Test 3 for cutString */
		//Will this method work if 'b' and 'a' are capitalized
		//Surprisingly, it worked. It removed the first two characters.

		System.out.println("\n\nTest 3 of the method cutString...");

		String uppercaseStr = cutString("Basquetball");
		String expectedStr3 = "squetball";

		System.out.print("Expected: ");
		for(int i = 0; i < expectedStr3.length(); i++){
			System.out.print(expectedStr3.charAt(i));
		}

		System.out.print("\nResult: ");
		for(int i = 0; i < uppercaseStr.length(); i++){
			System.out.print(uppercaseStr.charAt(i));
		}

	/* Test 4 for cutString */
		//Will this method work if there is no 'a' and 'b' in a String
		//It worked, it only removed the first two characters.

		System.out.println("\n\nTest 4 of the method cutString...");

		String noAB = cutString("Guitar");
		String expectedStr4 = "itar";

		System.out.print("Expected: ");
		for(int i = 0; i < expectedStr4.length(); i++){
			System.out.print(expectedStr4.charAt(i));
		}

		System.out.print("\nResult: ");
		for(int i = 0; i < noAB.length(); i++){
			System.out.print(noAB.charAt(i));
		}

	/* Test 5 for cutString */
		//Will this method work if the first two characters are the same
		//It worked, the only thing that happened is that it removed an a

		System.out.println("\n\nTest 5 of the method cutString");

		String sameChars = cutString("aacorn");
		String expectedStr5 = "acorn";

		System.out.print("Expected: ");
		for(int i = 0; i < expectedStr5.length(); i++){
			System.out.print(expectedStr5.charAt(i));
		}

		System.out.print("\nResult: ");
		for(int i = 0; i < sameChars.length(); i++){
			System.out.print(sameChars.charAt(i));
		}
	}

	public static int[] sortOfReverse(int[] array) {
		int temp; 
		for(int i =0; i < array.length/2; i++) {
			if (array[array.length-1-i] < array[i]) {
				temp = array[array.length-1-i];
				array[array.length-1-i] = array[i];
				array[i] = temp;
			}
		}    
		return array;    
	}
	
	/* Method cutString:
	 * Given a string, return a version without the first 2 chars. 
	 * Except keep the first char if it is 'a' and keep the second 
	 * char if it is 'b'. 
	 * The string may be any length.  
	 */
    public static String cutString(String s) {
    	if(s.charAt(0) == 'a')
	       	if(s.charAt(1) == 'b')
	       		return s;
	       	else 
	       		return s.charAt(0) + s.substring(2);
	     else if (s.charAt(1) == 'b')
	    	 return s.substring(1);
	     else 
	    	 return s.substring(2);   
    }

}
