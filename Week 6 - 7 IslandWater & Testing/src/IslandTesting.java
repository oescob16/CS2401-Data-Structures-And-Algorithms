import java.util.*;

public class IslandTesting {

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);

        System.out.print("How many times you want to test the method gettingWater? ");
        int input = scnr.nextInt();

        int[] heightOfDirt;
        long start;
        long end = 0;

        for(int i = 0; i < input; i++) {
            heightOfDirt = generatorOfDirtBars();

            start = System.currentTimeMillis();
            int water = gettingWater(heightOfDirt);
            end += System.currentTimeMillis() - start;
        }

        System.out.print("Average time is: "  + (double)end/input + " ms");      

        System.out.println();
    }

    public static int invalidSizeAndHeight(int wrongInput, String sizeOrHeight){

        Scanner scnr = new Scanner(System.in);
        boolean wrongAnswer = true;
        int newInput = 0;

        while(wrongAnswer){

            System.out.print("\nWrong input!\n");
            System.out.print("Type the " + sizeOrHeight + " you want the island to be: ");
            newInput = scnr.nextInt();

            if(newInput > 0){
                wrongAnswer = false;
            }
        }
        return newInput;
    }

    public static int[] generatorOfDirtBars(){

        Scanner scnr = new Scanner(System.in);

        int inputSize = (int) Math.ceil(Math.random() * 10000);

        int[] populatingIsland = new int[inputSize];

        for(int i = 0; i < populatingIsland.length; i++){
            populatingIsland[i] = (int) Math.ceil(Math.random() * 10000);
        }
        return populatingIsland;
    }

    public static int gettingWater(int[] island){

        if(island.length < 3){
            return 0;
        }

        int waterCollected = 0;
        int possibleWater = 0;

        int left = island[0];
        int right = island[island.length - 1];

        int[] maxBarLeft = new int[island.length];
        int[] maxBarRight = new int[island.length];                    

        for(int i = 1; i < island.length; i++) {

            if(island[i] < left){
                maxBarLeft[i] = left;
            } else{
                left = island[i];
            }

            if(island[island.length - 1 - i] < right)
            {
                maxBarRight[island.length - 1 - i] = right;
            } else{
                right = island[island.length - 1 - i];
            }
        }


        for(int i = 0; i < island.length; i++){

            if( (maxBarLeft[i] != 0 ) && (maxBarRight[i] != 0) )
            {
                if(maxBarLeft[i] < maxBarRight[i])
                {
                    possibleWater = maxBarLeft[i];
                } else{
                    possibleWater = maxBarRight[i];
                }
                waterCollected += possibleWater - island[i];
            }
        }

        return waterCollected;
    }
    
    public static int[][] island2D(int[] island1D, int maxPeak){

        int[][] imageIsland = new int[maxPeak][island1D.length];
        int unitBar = 1;
        int emptySpace = 0;

        for(int i = imageIsland[0].length - 1; i >= 0; i--)
        {
            for(int j = imageIsland.length - 1; j >= 0; j--)
            {
                if(island1D[i] > 0) {
                    imageIsland[j][i] = unitBar;
                    island1D[i]--;
                } else{
                    imageIsland[j][i] = emptySpace;
                }
            }
        }
        return imageIsland;
    }

    public static int findMaxPeak(int[] bars)
    {
        int largestPeak = Integer.MIN_VALUE;

        for(int i = 0; i < bars.length; i++)
        {
            if(bars[i] > largestPeak)
                largestPeak = bars[i];
        }
        return largestPeak;
    }
}
