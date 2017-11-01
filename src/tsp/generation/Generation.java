package tsp.generation ;

import java.awt.* ;
import java.util.* ;

public class Generation{

	protected ArrayList<Path> paths = new ArrayList<Path>();

	protected Integer Weight = 0;

	public Generation(){}

	public Generation( Sequences sq ){

		paths = sq.getPaths();

	}

	public void setGeneration( Integer[][] wd){

	}

	public void setGeneration( Sequences sq, Integer[][] wd ){

		paths = sq.getPaths();		

	}

}
