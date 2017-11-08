package tsp.main;

import tsp.gui.* ;
import tsp.generation.* ;
import tsp.evolution.* ;
import java.awt.* ;
import java.util.* ;
import java.io.* ;
import org.apache.commons.configuration.* ;
import org.apache.commons.lang.* ;
import org.apache.commons.cli.* ;

public class Main{

	static PropertiesConfiguration config ; 
    static String configFilePath = "config.properties" ;

    static boolean isToShowMin = true ;
    static boolean isToShowSumMin = true ;

	public static void main( String[] args ) {

        Options options = new Options() ; // commons.cli.Options, 

        options.addOption("m", "min", false, "min weight") ;
        // shortly "-c", fully "--min"
        options.addOption("s", "sum", false, "sum of weight") ;

        CommandLineParser parser = new DefaultParser() ;  // parse the commandline argument
        CommandLine cmd = null ;      // setting about which option we got

        try {
            cmd = parser.parse(options, args) ;
            if (cmd.hasOption("m"))      // display the statistics
                isToShowMin = true ;
            if (cmd.hasOption("s"))
				isToShowSumMin = true ;
        }
        catch (ParseException e) {
            System.err.println(e) ;
            System.exit(1) ;
        }

		config(configFilePath) ;  // read config file into Pr-config- object

   		final int numOfCity = config.getInt("number_of_cities") ;
		final int evolveTimes = config.getInt("how_many_time_evolves") ;

		String str = "" ;

		Integer[][] weightData = new Integer[numOfCity][numOfCity] ;

		ArrayList<Sequences> seqList = new ArrayList<Sequences>() ;

		ArrayList<Generation> genList = new ArrayList<Generation>() ;		
		ShowData sdc= new ShowData();		
		
		Evolution ev = new Evolution( config ) ;		

		ShowHistogram sh = new ShowHistogram();

		try{

			str = ( ReadFile.read(args[0]) );

			weightData = ReadFile.toArr(str) ;

			Sequences sequences = new Sequences();
			sequences.setSequence( weightData ) ;
			seqList.add(sequences) ;

			// the first generation
            Generation generation = new Generation() ;     
            generation.setGeneration( sequences );
            genList.add(generation) ;

            sdc.showSumMin( generation, isToShowMin, isToShowSumMin ) ;          

			// start evolution
			for( int i=0; i<evolveTimes; i++ ){
	
				Sequences newSq = new Sequences() ;
				newSq = ev.evolute( seqList.get(i), weightData ) ;
				seqList.add(newSq) ;

				// does it disappears when it gets out of the block?
				
				Generation generation2 = new Generation() ;
				generation.setGeneration( newSq );
				genList.add(generation) ;				

				if( i%100==0 ){
					sdc.showSumMin( genList.get(i), isToShowMin, isToShowSumMin ) ;			
				//	System.out.println(" evolution " + i );
				}

			}

//			sh.show(genList) ;

		}catch(Exception e){

			System.out.println("File Name Error");

		}

	}

	public static void config(String fpath) {

		try {
			config = new PropertiesConfiguration(fpath) ;
		
		}catch (ConfigurationException e) {

			System.err.println(e) ;
			System.exit(1) ;

		}

	}



}
