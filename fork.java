import java.util.concurrent.*;
import java.util.Arrays;

public class fork{
	
	public static void main(String[] args){
		ForkJoinPool pool = new ForkJoinPool();
		createArray arr = new createArray();
		int[] ints = arr.generate(1000);
		mergesort sort = new mergesort(ints);
		sort.compute();
		long start = System.currentTimeMillis();
		pool.invoke(sort);
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + 
	            (end - start) + " milliseconds");
		System.out.println(Arrays.toString(ints));
	}
	

}
