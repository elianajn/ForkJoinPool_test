import java.util.*;
import java.util.Arrays;


public class sortTest {

	private int array[];
   
	public sortTest(int[] array) {
		this.array = array;
	}
 
    private void sort()
    {
    	if (array.length > 1){
	    	int[] left = Arrays.copyOfRange(array, 0, array.length/2);
	    	int[] right =Arrays.copyOfRange(array, array.length/2, array.length);
	    
	        //Sort each half recursively
	        sortTest leftSort = new sortTest(left);
	        leftSort.sort();
	        sortTest rightSort = new sortTest(right);
	        rightSort.sort();
	        //Merge both halves together, overwriting to original array
	        merge(left, right, array);
    	}
    }
     
    private static void merge(int[] left, int[] right, int[] result) 
    {
        //Index Position in first array - starting with first element
        int iFirst = 0;
         
        //Index Position in second array - starting with first element
        int iSecond = 0;
         
        //Index Position in merged array - starting with first position
        int iMerged = 0;
         
        //Compare elements at iFirst and iSecond, 
        //and move smaller element at iMerged
        while (iFirst < left.length && iSecond < right.length) 
        {
            if (left[iFirst]< right[iSecond])
            {
                result[iMerged] = left[iFirst];
                iFirst++;
            } 
            else
            {
                result[iMerged] = right[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(left, iFirst, result, iMerged, left.length - iFirst);
        System.arraycopy(right, iSecond, result, iMerged, right.length - iSecond);
    
       
    }
    public static void main(String[] args){ 
    	int[] n = { 2, 6, 3, 5, 1 };
    	sortTest sorter = new sortTest(n);
    	long start = System.currentTimeMillis();
		
    	sorter.sort();
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + 
	            (end - start) + " milliseconds");
    	System.out.println(Arrays.toString(n));
    }

}
