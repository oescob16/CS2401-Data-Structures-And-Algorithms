import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*; 

public class IslandTester {

    // We start to test my code with a simple input, to know
    // if my algorithm can solve the task assigned to us.
    @Test
    void testIsland1(){
        int[] peaks = {3, 1, 3, 1, 5};
        assertEquals(4, IslandTesting.gettingWater(peaks));    //The method returned the expected value.
    }

    // We then proceed to test my algorithm by putting zeroes (this one's
    // representing the ground) as values.
    @Test
    void testIsland2(){
        int[] peaks = {3, 0, 0, 2, 1, 2};
        assertEquals(5, IslandTesting.gettingWater(peaks));    // Surprisingly, the algorithm handled having 0 values.
    }

    // Then we test with an empty array, this meaning that no such island exists.
    @Test
    void testIsland3(){
        int[] peaks = {};
        assertEquals(0, IslandTesting.gettingWater(peaks));    // The algorithm returned the expected value.
    }

    // We start to test biggest inputs, with the purpose to know if
    // my code can handle such inputs.
    @Test
    void testIsland4(){
        int[] peaks = {100, 1, 1, 1, 100, 2, 2, 2, 100};
        assertEquals(591, IslandTesting.gettingWater(peaks));  // The algorithm can handle big inputs. It worked.
    }

    // I got a little creative here, so now we are testing with
    // negative numbers, this numbers represents that there is a hole
    // on the island.
    @Test
    void testIsland5(){
        int[] peaks = {3, -1, 5, 1, 4};
        assertEquals(7, IslandTesting.gettingWater(peaks));    // I never expected that my algorithm could handle
    }                                                            // negative values, but it did.

    // Here we test the possibility that the island exists but has no peaks in it, only ground.
    @Test
    void testIsland6(){
        int[] peaks = {0, 0, 0, 0, 0};
        assertEquals(0, IslandTesting.gettingWater(peaks));    // The method returned the expected value.
    }


}
