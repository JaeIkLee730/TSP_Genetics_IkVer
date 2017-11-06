package tsp.main;

import tsp.gui.* ;
import tsp.generation.* ;
import tsp.evolution.* ;
import java.awt.* ;
import java.util.* ;
import java.io.* ;
import org.apache.commons.configuration.* ;
import org.apache.commons.lang.* ;


public class Main{

//	static Configuration config = new PropertiesConfiguration(configFilePath) ;

//	static Properties prop = new Properties();

//	static FileInputStream fis = new FileInputStream("config.properties");

	static PropertiesConfiguration config ; 
    static String configFilePath = "config.properties" ;

	public static void main( String[] args ) {

//		prop.load(fis);
//		fis.close();
//		prop.list(System.out); // 서울의수도=서울에수도가어디있어

		config(configFilePath) ;  // read config file into Pr-config- object

   		final int numOfCity = config.getInt("number_of_cities") ;
		final int evolveTimes = config.getInt("how_many_time_evolves") ;

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
			seqList.add(sequences) ;

			// the first generation
            Generation generation = new Generation() ;     
            generation.setGeneration( sequences );
            genList.add(generation) ;

            sdc.showSumMin( generation ) ;          

			// start evolution
			for( int i=0; i<evolveTimes; i++ ){
	
				Sequences newSq = new Sequences() ;
				newSq = ev.evolute( seqList.get(i), weightData ) ;
				seqList.add(newSq) ;
				System.out.println(" evolution " + i);

				// does it disappears when it gets out of the block?
				
				Generation generation2 = new Generation() ;
				generation.setGeneration( newSq );
				genList.add(generation) ;				

				sdc.showSumMin( genList.get(i) ) ;			
	
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
