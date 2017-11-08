package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;
import java.io.* ;
import org.apache.commons.configuration.* ;
import org.apache.commons.lang.* ;

public class CrossOver{

    private PropertiesConfiguration config ;

	public CrossOver(){}
	public CrossOver( PropertiesConfiguration config ){
		this.config = config ;
	}

	// which two are participating?
	public Path [] crossOver( ArrayList<Path> pathList, Integer[][] wd){
	
		// how many element would be selected at the first time
		final int CONUM = config.getInt("Cross_Over_Num");
        final int numOfCity = config.getInt("number_of_cities") ;
		final int howMany = config.getInt("how_many_is_corssOver_half") ;

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

	private boolean isNotExist( Integer [] pathTemp, Integer n ){

		final int howMany = config.getInt("how_many_is_corssOver_half") ;
		boolean notExist = true ;

		for( int i=0; i<howMany; i++){
			if( pathTemp[i] == n ){
				notExist = false ;
			}
		}
		
		return notExist ;
	}	
}
