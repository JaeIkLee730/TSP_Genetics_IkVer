package tsp.main;

import tsp.gui.* ;
import tsp.generation.* ;
import tsp.evolution.* ;
import java.awt.* ;
import java.util.* ;

public class Main{

    private static final int numOfCity = 48;

	public static void main( String[] args ){

		String str = "" ;

		Integer[][] weightData = new Integer[numOfCity][numOfCity] ;

		ArrayList<Sequences> seqList = new ArrayList<Sequences>() ;

		ArrayList<Generation> genList = new ArrayList<Generation>() ;		
		ShowDataCli sdc = new ShowDataCli();		
		
		Evolution ev = new Evolution() ;		

		ShowHistogram sh = new ShowHistogram();

		try{

			str = ( ReadFile.read(args[0]) );

			weightData = ReadFile.toArr(str) ;

			Sequences sequences = new Sequences();
			sequences.setSequence( weightData ) ;
			// seqList.add(sequences) ;

			// the first generation
            Generation generation = new Generation() ;     
            generation.setGeneration( sequences );
            genList.add(generation) ;

            sdc.showSumMin( generation ) ;          

			// start evolution
			for( int i=0; i<100; i++ ){
				
				Sequences advancedSq = new Sequences() ;
				advancedSq = ev.evolute( sequences, weightData ) ;
				System.out.println(" evolution " + i);

				// does it disappears when it gets out of the block?
				
				Generation generation2 = new Generation() ;
				generation.setGeneration( advancedSq );
				genList.add(generation) ;				

				sdc.showSumMin( genList.get(i) ) ;			
	
			}

			sh.show(genList) ;

		}catch(Exception e){

			System.out.println("File Name Error");

		}

	}

}
