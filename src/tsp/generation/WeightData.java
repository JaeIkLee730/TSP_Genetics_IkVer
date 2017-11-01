package tsp.generation ;

import java.awt.* ;
import java.util.* ;
		
public class WeightData{

	public static final int numOfCity = 48 ;

	protected Integer [][] wd = new Integer[numOfCity][numOfCity] ;

	public WeightData(){}

	public WeightData( Integer[][] arr ){
		
		wd = arr ;
	
	}  

	public void setWd( Integer[][] arr ){

		wd = arr ;

	}

	public Integer[][] getWd(){

		return wd ;

	}

	public Integer getElement( int a, int b ){

		return wd[a][b] ;
	
	}

}
