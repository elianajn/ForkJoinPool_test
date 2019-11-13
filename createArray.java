import java.util.Random;

public class createArray{
	
	public int[] generate(int size){
		Random rd = new Random(); // creating Random object
	      int[] arr = new int[size];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(); // storing random integers in an array
	      }
	      return arr;
	}
}