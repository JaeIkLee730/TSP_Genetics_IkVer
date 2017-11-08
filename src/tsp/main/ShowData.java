package tsp.main ;

import tsp.generation.* ;
import java.awt.* ;
import java.util.* ;

public class ShowData{

	public void showAll( Generation gen ){

		System.out.println("<Path weight>");

		for( int i=0; i<gen.getPaths().size(); i++ ){
	
			System.out.println("Path " + (i+1) + " : " + gen.getPaths().get(i).getPathWeight() );

		}
		
		System.out.println("minimum path weight : " + gen.getMinPW() );

		System.out.println("sum of path weight : " + gen.getSumOPW() );
		
	}

	public void showSumMin( Generation gen, boolean showMin, boolean showSum ) {

		if( showMin )
			System.out.println("minimum path weight : " + gen.getMinPW() );

		if( showSum )
	        System.out.println("sum of path weight : " + gen.getSumOPW() );

	}

}
