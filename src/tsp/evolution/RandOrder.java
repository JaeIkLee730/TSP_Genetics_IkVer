package tsp.evolution ;

import java.util.* ;
import java.awt.* ;
import java.util.concurrent.ThreadLocalRandom ;


public class RandOrder{

	private final int maxLeng = 200 ;

//	private ArrayList<Integer> enumNum = new ArrayList<Integer>() ;

	public RandOrder(){}

	public Integer [] randOrder( int range, int leng ){

		Integer [] enumNum = new Integer[range] ;

		for(int i=0; i<range; i++)
			enumNum[i] = i;
		
		return Arrays.copyOf( shuffleArray(enumNum, leng), leng ) ;

//		Collections.shuffle(enumNum);

	}

	private Integer[] shuffleArray( Integer [] arr, int leng )
  	{
    // If running on Java 6 or older, use `new Random()` on RHS here
    	Random rnd = ThreadLocalRandom.current();

    	for (int i=0; i < leng; i++){
	      	int index = rnd.nextInt(arr.length);
  	    // Simple swap
  		   	int a = arr[index];
  	    	arr[index] = arr[i];
  	    	arr[i] = a;
		}

		Integer [] temp = new Integer[leng] ;

		temp = Arrays.copyOf(arr, leng) ;	

		return temp ;	

  	}


}
