package blackBoxTestFiles;

public class BlackBoxBasicMetricFile 
{
	public static void bubbleSort(int[] array) 
	{
	    // Loop through the array, starting from the beginning
	    for (int i = 0; i < array.length; i++) 
	    {
	        // Loop through the array again, starting from the end
	        for (int j = array.length - 1; j > i; j--) 
	        {
	            // If the current element is greater than the next element, swap them
	            if (array[j] < array[j - 1]) 
	            {
	                int temp = array[j];
	                array[j] = array[j - 1];
	                array[j - 1] = temp;
	            }
	        }
	    }
	}
}
