import java.util.*;
import java.util.concurrent.*;
 

public class mergesort extends RecursiveAction 
{

	
	
	private static final long serialVersionUID = 1L;
	private int array[];
   
	public mergesort(int[] array) {
		this.array = array;
	}
  
	@Override
    protected void compute()
    {
		if (array.length > 1){
	    	int[] left = Arrays.copyOfRange(array, 0, array.length/2);
	    	int[] right =Arrays.copyOfRange(array, array.length/2, array.length);
	    
	        //Sort each half recursively
	        RecursiveAction leftSort = new mergesort(left);
	        RecursiveAction rightSort = new mergesort(right);
	        
	        invokeAll(leftSort, rightSort);
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

}
