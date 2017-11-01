package tsp.main;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class Main{

    private static final int numOfCity = 48;

	public static void main( String[] args ){

		String str = "" ;

		Integer[][] weightData = new Integer[numOfCity][numOfCity] ;

		ArrayList<Generation> genList = new ArrayList<Generation>();
		
		try{

			str = ( ReadFile.read(args[0]) );

			weightData = ReadFile.toArr(str) ;

			Sequences sequences = new Sequences();

			sequences.setSequence( weightData ) ;

			Generation generation = new Generation() ;

			generation.setGeneration( sequences, weightData );
		   	/*for( int i=0; i<GV.numOfCity; i++ ){

				for( int j=0; j<GV.numOfCity; j++)
					System.out.print(arr[i][j] + " ") ;

				System.out.println();

			}*/

		
		}catch(Exception e){

			System.out.println("File Name Error");

		}

	}

}
