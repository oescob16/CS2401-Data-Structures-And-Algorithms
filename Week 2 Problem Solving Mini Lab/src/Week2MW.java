public class Week2MW {
    public Week2MW() {}

    /************** 15-POINT PROBLEMS *****************************************/

    /* maxTriple method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public static int maxTriple(int[] A) {

        if(A.length % 2 == 1){

            int firstVal = A[0];
            int middleVal = A[1];
            int lastVal = A[A.length - 1];

            if((firstVal > lastVal) && (firstVal > middleVal)){
                return firstVal;
            }

            else if((middleVal > firstVal) && (middleVal > lastVal)){
                return middleVal;
            }

            else
                return lastVal;
        }
        return -1;
    }

    /* squirrelPlay method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public static boolean squirrelPlay(int n, boolean b) {

        if((n <= 90 && n >= 60) && !b){
            return true;
        }

        if((n <= 100 && n >= 60) && b){
            return true;
        }

        return false;
    }

    /* maxMod method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public static int maxMod5(int n1, int n2) {

        if(n1 > n2){

            if((n1 % 5) == (n2 % 5)){
                return n2;
            }
            return n1;
        }

        else if(n2 > n1){

            if((n1 % 5) == (n2 % 5)){
                return n1;
            }
            return n2;
        }

        return 0;
    }

    /* specialEleven method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public static boolean specialEleven(int n) {

        if(((n % 11) == 0) || ((n % 11) == 0 + 1)){
            return true;
        }

        return false;
    }

    /************** 12-POINT PROBLEMS *****************************************/

    /* prefixAgain method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public  boolean prefixAgain(String s, int n) {
        String prefix = s.substring(0,n);
        for(int i = n; i < s.length()-n; i++){
            if(s.substring(i,n+i).equals(prefix)) {
                return true;
            }
        }
        return false;
    }

    /* oneTwo method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public static String oneTwo(String s) {
        String newStr = "";
        for(int i = 0; i < s.length()-2; i += 3){
            newStr = newStr + s.substring(i+1,i+3) + s.charAt(i);
        }
        return newStr;
    }


    /************** 8-POINT PROBLEMS  *****************************************/

    /* withoutString method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public  String withoutString(String s1, String s2) {
        return s1.replace(s2,"");
    }


    /* sumDigits method:
     * A dummy stub is provided to you for this method.
     * Modify it below so that it meets the requirement of your lab description.
     */
    public  int sumDigits(String s) {
        int count = 0;
        for(int i = 0; i < s.length();i++){
            char character = s.charAt(i);
            if(Character.isDigit(character)){
                count += Integer.parseInt(String.valueOf(character));
            }
        }
        return count;
    }

}
