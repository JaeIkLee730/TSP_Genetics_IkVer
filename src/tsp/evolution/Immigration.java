package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Immigration{

	private final int IMMNUM = 40 ;

	public Immigration(){}

	public Path [] immigration( Integer[][] wd ){

		Path [] pathList = new Path[IMMNUM] ;
			
		Sequences subSq = new Sequences();

		subSq.setSequence( wd, IMMNUM ) ;	
	
		for( int i=0; i<IMMNUM; i++ )
			pathList[i] = subSq.getPaths().get(i) ;
		
		return pathList ;

	}

}
