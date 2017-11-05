package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Evolution{


	private final int numOfCity = 48 ;

	private final int CONUM = 40 ;
	private final int MUNUM = 20 ;
	private final int IMMNUM = 40 ;
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

		ArrayList<Path> pathList = new ArrayList<Path>() ;
		Path [] pathListTemp = new Path[40] ;

		// crossOver : two random paths cross
		// 40 sets of two random paths needed
		// input : "prevSq"
		
		pathListTemp = Arrays.copyOf( co.crossOver(sq.getPaths(),wd), CONUM ) ;
		for( int i=0; i<CONUM; i++ )
			pathList.add( pathListTemp[i] ) ;
		// new 40 paths from cross over

		pathListTemp = Arrays.copyOf( mu.mutation(sq.getPaths(),wd), MUNUM ) ;
		for( int i=0; i<MUNUM; i++ )
			pathList.add( pathListTemp[i] ) ;
		// new 20 paths from mutation

		pathListTemp = Arrays.copyOf( imm.immigration(wd), IMMNUM ) ;
		for( int i=0; i<IMMNUM; i++ )
			pathList.add( pathListTemp[i] ) ;
		// new 40 paths from immigration

		for( int i=0; i<prevSq.getPaths().size(); i++)
			pathList.add( prevSq.getPaths().get(i) ) ;
		// totally we have 200 paths

		newSq.setSequence( (sel.selection( pathList )) ) ;
		// select top 50 paths and random 50 paths 

		return newSq ;
		
	}
	

}
