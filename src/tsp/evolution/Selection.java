package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Selection{

	private final int randSel = 30 ;

	private final int topSel = 70 ;

	public Selection(){}

	public ArrayList<Path> selection( ArrayList<Path> pathList ){
		
	// pathList now have totally 200 paths

		ArrayList<Path> pathListTemp = new ArrayList<Path>() ;

		Integer [] randNum = new Integer[randSel] ;

		Integer listSize = pathList.size() ;

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

		// top n of list
		for( int i=listSize-1; i>=listSize-topSel; i-- ){

			pathListTemp.add(pathList.get(i)) ;

		}
		
		RandOrder rnd = new RandOrder() ;

		randNum = Arrays.copyOf( rnd.randOrder(listSize-topSel, randSel), randSel );

		for( int i=0; i<randSel; i++ ){

			pathListTemp.add( pathList.get(randNum[i]) ) ;

		}

		return pathListTemp ;

	}

}
