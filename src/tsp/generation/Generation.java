package tsp.generation ;

import java.awt.* ;
import java.util.* ;

public class Generation{

	protected ArrayList<Path> paths = new ArrayList<Path>();

	protected Integer sumOfPathWeight = 0;

	protected Integer minPathWeight = 0;

	public Generation(){}

	public Generation( Sequences sq ){

		paths = sq.getPaths();

	}

	public void setGeneration( Sequences sq ){

		paths = sq.getPaths() ;		
		setSumOPW() ;	
		findMinPW() ;
	}

	private void setSumOPW(){

		Integer temp = 0 ;

		for( int i=0; i<paths.size(); i++ )
			temp += paths.get(i).getPathWeight();

		sumOfPathWeight = temp;

	}

	private void findMinPW(){

		Integer minTemp = paths.get(0).getPathWeight() ;

		for( int i=0; i<paths.size(); i++ ){

			if( minTemp > paths.get(i).getPathWeight() )
				minTemp = paths.get(i).getPathWeight() ;
		
		}

		minPathWeight = minTemp ;

	}

	public ArrayList<Path> getPaths(){

		return paths ;

	}

    public Integer getSumOPW(){

		return sumOfPathWeight ;

	}

	public Integer getMinPW(){

		return minPathWeight ;

	}
}
