package main;

import java.awt.* ;
import java.util.* ;

public class Main{

	public static void main( String[] args ){

		String str = "" ;

		Integer[][] arr = new Integer[GV.numOfCity][GV.numOfCity] ;

		try{

			str = ( ReadFile.read(args[0]) );

			arr = ReadFile.toArr(str) ;

			for( int i=0; i<GV.numOfCity; i++ ){

				for( int j=0; j<GV.numOfCity; j++)
					System.out.print(arr[i][j] + " ") ;

				System.out.println();

			}

		
		}catch(Exception e){

			System.out.println("File Name Error");

		}

	}

}
