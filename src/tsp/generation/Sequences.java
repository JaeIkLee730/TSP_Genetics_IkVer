package tsp.generation ;

import java.awt.* ;
import java.util.* ;

public class Sequences{

	private static final int numOfCity = 48;

	protected ArrayList<Path> paths = new ArrayList<Path>() ;
	// paths : consist of 100 paths

	public Sequences(){}

	public void setSequence( Integer[][] wd ){
			
		for(int i = 0;i<100; i++){
		// create 100 of paths	

			try{

				paths.add( randPath(numOfCity, wd) );		

			}catch(Exception e){

				e.printStackTrace();

			}
		}	

	}

    public void setSequence( Integer[][] wd, int n ){

        for(int i = 0;i<n; i++){
        // create n of paths  

            try{

                paths.add( randPath(numOfCity, wd) );

            }catch(Exception e){

                e.printStackTrace();

            }
        }

    }

	public void setSequence ( ArrayList<Path> pathList ){

		paths = pathList ;

	}

 	public void sequenceCat( Sequences arg ){

		for(int i=0; i<arg.getPaths().size(); i++ )
			paths.add( arg.getPaths().get(i) ) ;
	
	}

	public ArrayList<Path> getPaths(){
		
		return paths;

	}

	private Path randPath( int num, Integer[][] wd ) throws Exception{

		Integer[] randSequence = new Integer[num] ;	

		Path path = new Path();
	
		for(int i = 0; i < num; i++){

			randSequence[i] = (int)(Math.random()*(num));
			
			for(int j = 0; j < i; j++){

				if(randSequence[i] == randSequence[j]){
					i--;
					break;
				}

			}			

		}

		path.setPath(randSequence, wd) ;		

		return path;
	}

}
