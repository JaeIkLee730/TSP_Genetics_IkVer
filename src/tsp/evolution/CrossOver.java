package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class CrossOver{

	private final int howMany = 20 ;
	// how many element would be selected at the first time
	private final int CONUM = 40 ;
	private final int numOfCity = 48 ;

	public CrossOver(){}

	// which two are participating?
	public Path [] crossOver( ArrayList<Path> pathList, Integer[][] wd){
		
		Path [] pathListTemp = new Path[CONUM] ;
		Integer [] randNum = new Integer[howMany] ;
		Integer [] pathTemp = new Integer[numOfCity] ;

		RandOrder rnd = new RandOrder() ;

		for( int i=0; i<CONUM; i++ ){
		
			randNum = Arrays.copyOf( rnd.randOrder(numOfCity,howMany), howMany ) ;
			
			for( int j=0; j<howMany; j++ ){				
				pathTemp[j] = pathList.get(i).getSequence( randNum[j] ) ;	
			}
       
			ArrayList<Integer> order = new ArrayList<Integer>() ;

			for(int j=0; j<numOfCity; j++ ){

				if( isNotExist(pathTemp, pathList.get(i+1).getSequence(j)) )
					order.add( pathList.get(i+1).getSequence(j) );

			}
			
			for(int j=0; j<order.size(); j++ )
				pathTemp[howMany+j] = order.get(j) ;	
			
			Path path = new Path(pathTemp) ;
			path.setPath(wd) ;
			pathListTemp[i] = path ;

		}

		return pathListTemp ;

	}


/*
	private Integer [] randNumForCo(){

        Integer [] randNum = new Integer[howMany] ;

        for(int i = 0; i < howMany; i++){
   
            randNum[i] = (int)(Math.random()*(numOfCity));
	        System.out.println("randNum : " + randNum[i]) ;

            // random element-index

            // avoid the same index number
            for(int j = 0; j < i; j++){

                if( randNum[i] == randNum[j] ) {
                    i-- ;
                    break;
                }

            }

        }
       	System.out.println("~randNum()") ;

        return randNum ;

    }
*/


	private boolean isNotExist( Integer [] pathTemp, Integer n ){

		boolean notExist = true ;

		for( int i=0; i<howMany; i++){
			if( pathTemp[i] == n ){
				notExist = false ;
			}
		}
		
		return notExist ;
	}	
}
