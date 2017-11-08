package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;
import org.apache.commons.configuration.* ;
import org.apache.commons.lang.* ;

public class Mutation{

	private static final int numOfCity = 48 ;
	private PropertiesConfiguration config ;
	private int howMany = (int)(Math.random()*(numOfCity-3))+3;
	 	// n : how many node will be relocated - random
		// numOfCity-3 : 0-45 range + 3 -> 3-48 range
		// avoid the case howMany is not enough

	public Mutation(){}
	public Mutation( PropertiesConfiguration config ){
		this.config = config ;
	}

	public Path [] mutation( ArrayList<Path> paths, Integer [][] wd ){

		final int MUNUM = config.getInt( "Mutation_Num" ) ;
		final int CONUM = config.getInt( "Cross_Over_Num" ); 

		Path [] pathListTemp = new Path[40] ;

		Integer [] arr = new Integer[numOfCity] ;
		// arr will get new sequence and set new Path  

		Integer [] randNum = new Integer[howMany] ;
		// which element will be mutated


		for( int i=0; i<MUNUM; i++ ) {

			randNum = randNumForMut() ;
			// the element determined randomly

	//		System.out.println(" Mut ing 2 ");
			arr = arrElemSwp( paths.get(CONUM + i).getSequence(), randNum ) ;	

	//		System.out.println(" Mut ing 3 ");
		
			Path path = new Path() ;

			path.setPath( arr, wd ) ;

			pathListTemp[i] = path;

		}

		return pathListTemp ;

	}

	private Integer [] randNumForMut(){

		Integer [] randNum = new Integer[howMany] ;

		for(int i = 0; i < howMany; i++){
			
			randNum[i] = (int)(Math.random()*(numOfCity));	
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

	private Integer [] arrElemSwp( Integer [] pathArr, Integer [] randNum ){

		Integer tempSwp = 0 ;
		
		tempSwp = pathArr[ randNum[0] ];

		for( int i=0; i<howMany-1; i++)
			pathArr[ randNum[i] ] = pathArr[ randNum[i+1] ] ;

		pathArr[ randNum[howMany-1] ] = tempSwp ;

		return pathArr ;		

	}

}
