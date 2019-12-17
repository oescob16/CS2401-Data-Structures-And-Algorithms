import java.util.*;

public class Island {

    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in);

        int[] heightOfDirt = generatorOfDirtBars();
        int water = gettingWater(heightOfDirt);
        System.out.print("\nVolume of Water is: " + water + "\n");


        System.out.print("Do you want to see its visual representation? [Y/N]: ");
        char userIn = scnr.next().charAt(0);

        System.out.println();

        switch(userIn){
            case 'Y':
            case 'y':
                visualRepresentation(heightOfDirt);
            break;

            default:
            break;

        }
    }

    //Should I get the length and height from the user input or by using Math.random() ?
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

        //Scanners to let the user have the option to choose the length
        System.out.print("\nType the length you want the island to be: ");
        int inputLength = scnr.nextInt();

        if((inputLength <= 0)){
            inputLength = invalidSizeAndHeight(inputLength, "length");
        }

        System.out.print("Type the height you want the island to be: ");
        int inputHeight = scnr.nextInt();

        if(inputHeight <= 0){
            inputHeight = invalidSizeAndHeight(inputHeight, "height");
        }

        int[] populatingIsland = new int[inputLength];

        for(int i = 0; i < populatingIsland.length; i++){
            populatingIsland[i] = (int) Math.ceil(Math.random() * inputHeight);
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

    //Is necessary to create this method or should I erase it?
    public static void visualRepresentation(int[] island){

        int maxPeak = findMaxPeak(island);
        int[][] islandIn2D = island2D(island, maxPeak);

        for(int i = 0; i < islandIn2D.length; i++){
            for(int j = 0; j < islandIn2D[i].length; j++){
                if(islandIn2D[i][j] == 0){
                    System.out.print("  ");
                }
                else {
                    System.out.print(islandIn2D[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //Should I do the same with this one?
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

    //The same of this one?
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
