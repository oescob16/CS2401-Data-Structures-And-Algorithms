import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestWithJUnitTester {

    /*	------------------------     Test Suite of the method withoutTen       ------------------------				*/

    /* Test 1 for withoutTen */
        //Will the method work if there is not a 10?
        //Yes, it does work for any input value

        @Test
        public void withoutTenTest1(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] myInput = {1, 2, 1, 2};
            int[] expectedVal = {1, 2, 1, 2};

            assertArrayEquals(expectedVal, compute.withoutTen(myInput));
        }

    /* Test 2 for withoutTen */
        //Will this method work even if there is not a null value?
        //Ys, it does work.

        @Test
        public void withoutTenTest2(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] simpleArray = {1,2,10,4,10};

            assertNotNull(compute.withoutTen(simpleArray));
        }

    /* Test 3 for withoutTen */
        //Will this method work if the values are negative?
        //Yes, it does works.

        @Test
        public void withoutTenTest3(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] negativeVal = {-10, 10, -1};
            int[] expectedVal = {-10,-1,0};

            assertArrayEquals(expectedVal, compute.withoutTen(negativeVal));
        }

    /* Test 4 for withoutTen */
        //Will this method work if the array is empty?
        //

        @Test
        public void withoutTenTest4(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] emptyArray = compute.withoutTen(new int[]{});
            int[] expectedVal = {};

            assertArrayEquals(expectedVal, emptyArray);
        }

    /* Test 5 for withoutTen */
        //Will the method work if it only has 10's?
        //Yes, it does work

        @Test
        public void withoutTenTest5(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] arrayOfTens = {10, 10, 10, 10, 10};
            int[] expectedVal = {0, 0, 0, 0, 0};

            assertArrayEquals(expectedVal, compute.withoutTen(arrayOfTens));

        }

    /*	------------------------        Test Suite of the method bigArray       ------------------------			*/

    /* Test 1 for bigArray */
        //Will this method work if it has a big input?
        //Yes, it does work

        @Test
        public void bigArrayTest1(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] bigInput = compute.bigArray(6);
            int[] expectedVal = {1, 1, 2, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6};

            assertArrayEquals(expectedVal, bigInput);
        }

    /* Test 2 for bigArray */
        //Will there be a null value along the bigArray method?
        //No, therefore, the test evaluates to true

        @Test
        public void bigArrayTest2(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] notNull = compute.bigArray(10);

            assertNotNull(notNull);
        }

    /* Test 3 for bigArray */
        //What will happen if we put a zero as a parameter? Will the method still work?
        //Surprisingly, it did work.

        @Test
        public void bigArrayTest3(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] zeroParam = compute.bigArray(0);
            int[] expectedVal = {};

            assertArrayEquals(expectedVal, zeroParam);
        }

    /* Test 4 for bigArray */
        //What will happen if we put a negative value as the parameter? Will the method work?
        //Surprisingly, it worked.

        @Test
        public void bigArrayTest4(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] negativeParam = compute.bigArray(-1);
            int[] expectedVal = {};

            assertArrayEquals(negativeParam, expectedVal);
        }

    /* Test 5 for bigArray */
        //What will happen if the parameter contains an integer division?
        //It works.
        @Test
        public void bigArrayTest5(){
            TestWithJUnit compute = new TestWithJUnit();

            int[] emptyArray = compute.bigArray(3/2);
            int[] expectedVal = {1};

            assertArrayEquals(expectedVal, emptyArray);
        }

}