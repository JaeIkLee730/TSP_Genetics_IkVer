package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Evolution{

	public Evolution(){}

	public Sequences evolute( Sequences sq ){

		Sequences prevSq = new Sequences() ;
		Sequences newSq = new Sequences() ;
			
		CrossOver co = new CrossOver() ;
 		Mutation mu = new Mutation() ;
		Immigration imm = new Immigration() ;
		Selection sel = new Selection() ;

		prevSq = sq;

		ArrayList<Path> pathList = new ArrayList<Path>() ;

		for( int i=0; i<40; i++ )
			pathList.add( co.crossOver( sq.getPaths().get(i)) ) ;

		for( int i=40; i<60; i++ )
			pathList.add( mu.mutation(sq.getPaths().get(i)) ) ;

		for( int i=60; i<100; i++ )
			pathList.add( imm.immigration(sq.getPaths().get(i)) ) ;

		for( int i=0; i<prevSq.getPaths().size(); i++)
			pathList.add( prevSq.getPaths().get(i) ) ;

		newSq.setSequence( sel.selection( pathList ) ) ;

		return newSq ;
		
	}
	

}
