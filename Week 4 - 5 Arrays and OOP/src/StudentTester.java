import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTester {


    //In this test the student got 10 extra credit in assignment number 1, can the method handle this arithmetic function?
    @Test
    public void hasExtraCredit(){

        Student test1 = new Student();

        test1.setGrades(new int[]{90+10, 70, 100, 87, 0, 100});

        double expectedOutput = 457.0/6;

        assertEquals(expectedOutput, test1.average());
    }

    //In this edge case we are trying to know if the method can handle an array of grades with no elements.
    @Test
    public void isEmpty(){

        Student test2 = new Student();
        test2.setGrades(new int[]{});

        double expectedOutput = 0.0;

        assertEquals(expectedOutput, test2.average());
        //As expected, the test went wrong, why? Because if we have an empty array, that means it has nothing,
        //in other words, it is null. One (and I include myself) would take that empty array as an equivalent to being zero.
        //However, java does not handle this case as we think.
    }

    //In this test case we are testing if the method averageW is working properly
    @Test
    public void isWithWeightWorking(){

        Student weightTester = new Student();
        weightTester.setGrades(new int[]{90, 0, 80, 85, 95, 105});
        int[] weights = {2, 1, 1, 2, 3, 1};

        double expectedGrade = 82.0;

        assertEquals(expectedGrade, weightTester.averageW(weights));
    }
}
