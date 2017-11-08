package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;
import org.apache.commons.configuration.* ;
import org.apache.commons.lang.* ;

public class Evolution{


	private static final int numOfCity = 48 ;
    private PropertiesConfiguration config ;

	// constructor
	public Evolution(){}
	public Evolution( PropertiesConfiguration config ){
		this.config = config ;
	}

	public Sequences evolute( Sequences sq, Integer [][] wd ){

	 	final int CONUM = config.getInt( "Cross_Over_Num" ) ;
	 	final int MUNUM = config.getInt( "Mutation_Num" ) ;
	 	final int IMMNUM = config.getInt( "Immigration_Num" ) ;

		Sequences prevSq = new Sequences() ;
		Sequences newSq = new Sequences() ;

		CrossOver co = new CrossOver( config ) ;
		Mutation mu = new Mutation( config ) ;
		Immigration imm = new Immigration( config ) ;
		Selection sel = new Selection( config ) ;

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
		
//		ArrayList<Path> selectedPaths = new ArrayList<Path>() ;
//		selectedPaths = sel.selection(pathList) ;
//		Collections.shuffle( selectedPaths ) ;

//		newSq.setSequence( selectedPaths ) ;
		// select top 50 paths and random 50 paths 

		newSq.setSequence( sel.selection(pathList) ) ;
		return newSq ;
		
	}
	

}
