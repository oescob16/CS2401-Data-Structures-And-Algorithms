public class W12MW12 {

	public W12MW12() {}
	
	/************** METHODS TO COMPLETE *****************************************/
	
   /* maxMod5:	
	* A dummy stub is provided to you for this method. 
    * Modify it below so that it meets the requirement of your lab description.
    */
	public int maxMod5(int a, int b) {

		// If a and b are equal, then return 0
		if(a == b) { return 0; }

		// We create two variables to store the remainders of a and b
		int remainderOfA = a % 5;
		int remainderOfB = b % 5;

		// If their remainders are equal, then return the minimum value
		if((a % 5) == (b % 5)){
			return Math.min(a, b);
		}

		// Else it will return the largest value
		return Math.max(a, b);
	}
	

	/* repeatFront:	
	 * A dummy stub is provided to you for this method. 
	 * Modify it below so that it meets the requirement of your lab description.
	 */
	public String repeatFront(String str, int num) {

		// If the string does not exist, then return nothing
		if(str.length() == 0){
			return "";
		}

		// Else, store a new string from its first character to its nth character
		str = str.substring(0, num);

		// return the current str plus the new str from its first character to its (n - 1)th character
		return str + repeatFront(str, num - 1);
	}
	
	/* canBalance:	
	 * A dummy stub is provided to you for this method. 
	 * Modify it below so that it meets the requirement of your lab description.
	 */
	public boolean canBalance(int[] array) {

		// If the length of the array is less than or equal to one, return false.
		// Because we need at least two numbers to compare its sides.
		if(array.length <= 1){
			return false;
		}

		// We create the variable first to store the sum values of the curr first side.
		int first = 0;
		// We create the variable second to store the sum values of the curr second side.
		int second;

		// The first for loop is sum the values of the first current side
		for(int i = 0; i < array.length; i++){
			// Proceed to sum the first side
			first += array[i];
			// Reset second
			second = 0;
			// Second for loop is to sum the values of the second current side
			for(int j = i + 1; j < array.length; j++){
				// Proceed to sum the second side
				second += array[j];
			}
			// If their sums are equals then return true
			if(first == second){
				return true;
			}
		}
		// Else return false
		return false;
	}
	
	/* array220:	
	 * A dummy stub is provided to you for this method. 
	 * Modify it below so that it meets the requirement of your lab description.
	 */
	public boolean array220(int[] array, int start) {

		// If the length of the array is less than or equal to one then return false. Because
		// we need at least two integers to compare the multiplication
		if(array.length <= 1){
			return false;
		}

		// If the index (start) is bigger than or equal than the length of the array
		// then return false, because the value of the index was not found in the array.
		if(start >= array.length){
			return false;
		}

		// We create a variable to store the multiplication of the current number times ten
		int timesTen = array[start] * 10;

		// A for loop to traverse the array in the current index number
		for(int i = start; i < array.length; i++){
			// If the current index number equals the current i number, then return true
			if(array[i] == timesTen){
				return true;
			}
		}

		// If not found, then call the method again, but increase the index by one
		return array220(array, start + 1);
	}

}
