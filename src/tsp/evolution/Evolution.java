package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Evolution{

	// constructor
	public Evolution(){}

	public Sequences evolute( Sequences sq, Integer [][] wd ){

		Sequences prevSq = new Sequences() ;
		Sequences newSq = new Sequences() ;
			
		CrossOver co = new CrossOver() ;
 		Mutation mu = new Mutation() ;
		Immigration imm = new Immigration() ;
		Selection sel = new Selection() ;

		prevSq = sq;
		// 

		ArrayList<Path> pathList = new ArrayList<Path>() ;
		Path [] pathListTemp = new Path[40] ;

		// crossOver : two random paths cross
		// 40 sets of two random paths needed
		// input : "prevSq"
	//	for( int i=0; i<40; i++ )
		// pathList.add( co.crossOver( sq.getPaths().get(i)) ) ;
		// new 40 paths from cross over

		pathListTemp = mu.mutation( sq.getPaths(), wd ) ;
		for( int i=0; i<20; i++ )
			pathList.add( pathListTemp[i] ) ;
		// new 20 paths from mutation

//		pathListTemp = imm.immigration( sq.getPaths(), wd ) ;
		// TODO constructor
//		for( int i=60; i<100; i++ )
//			pathList.add( imm.immigration(sq.getPaths().get(i)) ) ;
		// new 40 paths from immigration

		for( int i=0; i<prevSq.getPaths().size(); i++)
			pathList.add( prevSq.getPaths().get(i) ) ;
		// totally we have 200 paths

		newSq.setSequence( (sel.selection( pathList )) ) ;
		// select top 50 paths and random 50 paths 

		return newSq ;
		
	}
	

}
