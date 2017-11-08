package tsp.evolution ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;
import org.apache.commons.configuration.* ;
import org.apache.commons.lang.* ;

public class Immigration{

	private PropertiesConfiguration config ;

	public Immigration(){}
	public Immigration( PropertiesConfiguration config ){
		this.config = config ;	
	}

	public Path [] immigration( Integer[][] wd ){

		final int IMMNUM = config.getInt( "Immigration_Num" ) ;

		Path [] pathList = new Path[IMMNUM] ;
			
		Sequences subSq = new Sequences();

		subSq.setSequence( wd, IMMNUM ) ;	
	
		for( int i=0; i<IMMNUM; i++ )
			pathList[i] = subSq.getPaths().get(i) ;
		
		return pathList ;

	}

}
