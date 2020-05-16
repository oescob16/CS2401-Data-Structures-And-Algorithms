/*
CS 2401AT9 - Dr. Ceberio
Oswaldo Escobedo
Luis Jimenez
Javier Ontiveros
*/

public class sortOfSorting{

  public static int findMaxVal(int[] nums, int rest, int currIndex)
  {    
    for(int j = rest - 1; j >= 0; j--)
    {
      if(nums[j] > nums[currIndex])
        currIndex = j;
    }    
    return currIndex;
  }

  public static int findMinVal(int[] nums, int rest, int currIndex)
  {
    for(int j = rest - 1; j >= 0; j--)
    {
      if(nums[j] < nums[currIndex])
        currIndex = j;
    }
    return currIndex;
  }

  public static void swapElements(int[] swapArray, int currentIndex, int swapIndex)
  {    
    int temp = swapArray[currentIndex];
    swapArray[currentIndex] = swapArray[swapIndex];
    swapArray[swapIndex] = temp;
  }

  public static void selectionSort(int[] arr)
  {  
    boolean isLarge = true;

    for(int i = arr.length - 1; i >= 0; i--)
    {
      int index = i;

      if(isLarge)
      {
        index = findMaxVal(arr, i, index);
      }
      else
      {
        index = findMinVal(arr, i, index);
      }
      swapElements(arr, i, index);
      isLarge = !isLarge;
    }
  }

  public static void main(String[] args)
  {
    
    int[] numbers = {3, 1, 5, 9, 2, 4, 7};
    selectionSort(numbers);

    for(int i = 0; i < numbers.length; i++)
	{
      System.out.print(numbers[i] + " ");
    }
  }
}