package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Selection{

	private final int half = 50 ;

	public Selection(){}

	public ArrayList<Path> selection( ArrayList<Path> pathList ){

	// pathList now have totally 200 paths

		ArrayList<Path> pathListTemp = new ArrayList<Path>() ;

		ArrayList<Path> pathListTempSub = new ArrayList<Path>() ;

		Integer [] randNum = new Integer[half] ;

		Integer listSize = pathList.size() ;

	//	Arrays.sort( pathList ) ;

	    Collections.sort( pathList, new Comparator<Path>() {

    	    public int compare ( Path arg1, Path arg2 ){

        	    if( arg1.getPathWeight() < arg2.getPathWeight() )
            	    return 1 ;
           		else if( arg1.getPathWeight() > arg2.getPathWeight() )
           		    return -1 ;
				else 
               		return 0 ;

      		}
   		});

		for( int i=listSize-1; i>=listSize-half; i-- ){

			pathListTemp.add(pathList.get(i)) ;

		}

/*
    	for( int i=0; i<pathList.size(); i++){
            System.out.print("path " + (i+1) + " : ") ;
            System.out.println(pathList.get(i).getPathWeight() );
        }
*/
		randNum = randNumForSel(listSize);

		for( int i=0; i<50; i++ ){

			pathListTemp.add( pathList.get(randNum[i]) ) ;

		}
/*
		for( int i=0; i<pathListTemp.size(); i++){
			System.out.print("path " + (i+1) + " : ") ;
			System.out.println(pathListTemp.get(i).getPathWeight() );
		}
*/

		return pathListTemp ;

	}

    private Integer [] randNumForSel( int ls ){

        Integer [] randNum = new Integer[half] ;

        for(int i = 0; i < half; i++){

            randNum[i] = (int)(Math.random()*(ls-half)) ;
            // random element-index

            // avoid the same index number
            for(int j = 0; j < i; j++){

                if( randNum[i] == randNum[j] ) {
                    i-- ;
                    break;
                }

            }

        }

        return randNum ;

    }

}
