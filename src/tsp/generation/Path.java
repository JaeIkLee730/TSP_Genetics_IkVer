package tsp.generation ;

import java.awt.* ;
import java.util.* ;

public class Path{

    private static final int numOfCity = 48;

	protected Integer[] nodeSequence = new Integer[numOfCity];

	protected Integer pathWeight = 0;
	// constructor
	public Path(){}

	public Path( Integer [] arr ){

		nodeSequence = arr ;

	}

	public void setPath( Integer[][] wd ){

		setPathWeight(wd) ;

	}

	public void setPath( Integer [] arr ){

		nodeSequence = arr ;

	}

	public void setPath( Integer [] arr, Integer[][] wd ){

		nodeSequence = arr;
	
		setPathWeight(wd);
	
	}

	public Integer [] getSequence(){

		return nodeSequence ;

	}

	private void setPathWeight( Integer[][] wd ){

		for( int i=0; i<numOfCity-1; i++ ){
	
			pathWeight += wd[ nodeSequence[i] ][ nodeSequence[i+1] ] ;	

		}

	}

	public Integer getPathWeight(){

		return pathWeight;

	}

	public int compareTo( Path arg ){
	
		if( pathWeight > arg.getPathWeight() )
			return 1 ;
		else if ( pathWeight < arg.getPathWeight() )
			return -1 ;
		else
			return 0 ;

	}

}
